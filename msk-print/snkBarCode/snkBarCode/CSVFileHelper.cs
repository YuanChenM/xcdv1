using System;
using System.Collections.Generic;
using System.Data;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace snkBarCode
{
    public class CSVFileHelper
    {
        /// <summary>
        /// 将DataTable中数据写入到CSV文件中
        /// </summary>
        /// <param name="dt">提供保存数据的DataTable</param>
        /// <param name="fileName">CSV的文件路径</param>
        public static void SaveCSV(DataTable dt, string fullPath)
        {
            FileInfo fi = new FileInfo(fullPath);
            if (!fi.Directory.Exists)
            {
                fi.Directory.Create();
            }
            FileStream fs = new FileStream(fullPath, System.IO.FileMode.Create, System.IO.FileAccess.Write);
            //StreamWriter sw = new StreamWriter(fs, System.Text.Encoding.Default);
            StreamWriter sw = new StreamWriter(fs, System.Text.Encoding.UTF8);
            string data = "";
            //写出列名称
            for (int i = 0; i < dt.Columns.Count; i++)
            {
                data += dt.Columns[i].ColumnName.ToString();
                if (i < dt.Columns.Count - 1)
                {
                    data += ",";
                }
            }
            sw.WriteLine(data);
            //写出各行数据
            for (int i = 0; i < dt.Rows.Count; i++)
            {
                data = "";
                for (int j = 0; j < dt.Columns.Count; j++)
                {
                    string str = dt.Rows[i][j].ToString();
                    str = str.Replace("\"", "\"\"");//替换英文冒号 英文冒号需要换成两个冒号
                    if (str.Contains(',') || str.Contains('"')
                        || str.Contains('\r') || str.Contains('\n')) //含逗号 冒号 换行符的需要放到引号中
                    {
                        str = string.Format("\"{0}\"", str);
                    }

                    data += str;
                    if (j < dt.Columns.Count - 1)
                    {
                        data += ",";
                    }
                }
                sw.WriteLine(data);
            }
            sw.Close();
            fs.Close();
            DialogResult result = MessageBox.Show("CSV文件保存成功！");
        }

        /// <summary>
        /// 将CSV文件的数据读取到List中
        /// </summary>
        /// <param name="fileName">CSV文件路径</param>
        /// <returns>返回读取了CSV数据的List</returns>
        public static List<string[]> ReadCSV(FileInfo fileInfo)
        {
            List<string[]> ls = new List<string[]>();
            StreamReader fileReader = fileInfo.OpenText();
            string strLine = "";
            while (strLine != null)
            {
                strLine = fileReader.ReadLine();
                if (strLine != null && strLine.Length > 0)
                {
                    ls.Add(strLine.Split(','));
                    //Debug.WriteLine(strLine);
                }
            }
            fileReader.Close();
            return ls;
        }

        /// <summary>
        /// 将CSV文件的数据读取到List中
        /// </summary>
        /// <param name="fileName">CSV文件路径</param>
        /// <returns>返回读取了CSV数据的List</returns>
        public static List<string[]> Read(string fullname)
        {
            var list = new List<string[]>();
            if (!File.Exists(fullname)) 
            {
                return list;
            } 
            var lines = File.ReadAllLines(fullname).Skip(1);
            var builder = new StringBuilder();
            foreach (var line in lines)
            {
                builder.Clear();
                var comma = false;
                var array = line.ToCharArray();
                var values = new List<string>();
                var length = array.Length - 1;
                var index = 0;
                while (index < length)
                {
                    var item = array[index++];
                    switch (item)
                    {
                        case ',':
                            if (comma)
                            {
                                builder.Append(item);
                            }
                            else
                            {
                                values.Add(builder.ToString());
                                builder.Clear();
                            }
                            break;
                        case '"':
                            comma = !comma;
                            break;
                        default:
                            builder.Append(item);
                            break;
                    }
                }
                var count = values.Count;
                if (count == 0) continue;
                list.Add(values.ToArray());
            }
            return list;
        }
    }
}
