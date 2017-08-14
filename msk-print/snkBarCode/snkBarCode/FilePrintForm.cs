using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace snkBarCode
{
    public partial class FilePrintForm : Form
    {
        private string _fileName;
        /// <summary>
        /// 需要打印的数据
        /// </summary>
        private List<BarCodeBean> _printDataList;

        public FilePrintForm()
        {
            InitializeComponent();
        }

        /// <summary>
        /// 页面初始化
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void FilePrintForm_Load(object sender, EventArgs e)
        {
            this.lblMessage.Text = "请点击【选择文件】按钮选择CSV文件！";
        }

        /// <summary>
        /// 选择文件按钮点击事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnSelectFile_Click(object sender, EventArgs e)
        {
            //初始化一个OpenFileDialog类
            OpenFileDialog fileDialog = new OpenFileDialog();
            //判断用户是否正确的选择了文件
            if (fileDialog.ShowDialog() == DialogResult.OK)
            {
                //获取用户选择文件的后缀名
                string extension = Path.GetExtension(fileDialog.FileName);
                //声明允许的后缀名
                string[] str = new string[] { ".csv" };
                if (!((IList)str).Contains(extension))
                {
                    MessageBox.Show("仅能上传csv格式的文件！");
                }
                else
                {
                    //获取用户选择的文件，并判断文件大小不能超过2000K，fileInfo.Length是以字节为单位的
                    FileInfo fileInfo = new FileInfo(fileDialog.FileName);
                    if (fileInfo.Length > 2097152)
                    {
                        MessageBox.Show("上传的文件不能大于2M");
                    }
                    else
                    {
                        List<String[]> list = CSVFileHelper.ReadCSV(fileInfo);

                        _printDataList = new List<BarCodeBean>();
                        BarCodeBean bean;
                        int rowNo = 1;
                        foreach (string[] data in list)
                        {
                            if (data.Length > 4)
                            {
                                bean = new BarCodeBean();
                                bean.RowNo = rowNo;
                                bean.BarcodeId = data[0].Replace("\"", "");
                                bean.BarCode = data[1].Replace("\"", "");
                                bool isNum = isBarCode(bean.BarCode);
                                if (!isNum)
                                {
                                    continue;
                                }
                                bean.ReadCode = data[2].Replace("\"", "");
                                bean.Brand = data[3].Replace("\"", "");
                                bean.Grade = data[4].Replace("\"", "");
                                _printDataList.Add(bean);
                                rowNo++;
                            }
                            else
                            {
                                continue;
                            }
                        }
                        this.lblMessage.Text = "文件已选择：\n";
                        this.lblMessage.Text += fileDialog.FileName;
                        this.lblMessage.Text += "\n";
                        this.lblMessage.Text += "共需打印 " + _printDataList.Count().ToString() + " 个标签！";

                        //设置名称
                        string strName = fileDialog.FileName.Split('\\').LastOrDefault().ToString();
                        _fileName = strName.Split('.').FirstOrDefault().ToString();
                    }
                }
            }
        }

        /// <summary>
        /// 关闭按钮点击事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnClose_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        /// <summary>
        /// 打印按钮
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnPrint_Click(object sender, EventArgs e)
        {
            if (String.IsNullOrEmpty(_fileName))
            {
                MessageBox.Show("请先选择文件！");
            }
            else
            {
                PrintManager pManager = new PrintManager(_printDataList);
                pManager.DoPrint(_fileName);
            }
        }

        /// <summary>
        /// 是否为barcode判断
        /// </summary>
        /// <param name="code"></param>
        /// <returns></returns>
        private bool isBarCode(string code)
        {
            if (code.Length != 24)
            {
                return false;
            }
            int result = 0;
            try
            {
                result = Convert.ToInt32(code.Substring(0, 8));
                result = Convert.ToInt32(code.Substring(8, 8));
                result = Convert.ToInt32(code.Substring(16, 8));
                return true;
            }
            catch
            {
                return false;
            }
        }

        /// <summary>
        /// 打印设置按钮点击事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnPrintSetting_Click(object sender, EventArgs e)
        {
            BarCodeConfigForm configForm = new BarCodeConfigForm();
            configForm.ShowDialog();
        }

        /// <summary>
        /// 查看数据按钮点击事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnReadData_Click(object sender, EventArgs e)
        {
            if (_printDataList == null || _printDataList.Count == 0)
            {
                MessageBox.Show("请先选择有效的文件！");
            }
            else
            {
                PrintDataForm dataFrom = new PrintDataForm(_fileName, _printDataList);
                dataFrom.ShowDialog();
            }
        }
    }
}
