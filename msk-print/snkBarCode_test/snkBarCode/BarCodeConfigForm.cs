using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;
using System.Web;
using System.Windows.Forms;
using System.Xml;

namespace snkBarCode
{
    public partial class BarCodeConfigForm : Form
    {
        private JObject paramData;
        //private JObject resultData;
        private List<JToken> printDataList;
        public BarCodeConfigForm(string[] args)
        {
            InitializeComponent();
            if (args.Length > 0)
            {

                string str = args[0].Split('&')[1];
                str = str.Replace("/", "");
                str = str.Replace("#", "\"");
                //this.lblParam.Text = str;
                this.paramData = JObject.Parse(str);
                this.lblParam.Text = this.paramData.ToString();
            }
            else
            {
                string str1 = "snkbarcode://123dss&{#siteCode#:#SNK#,#auth#:#test#,#loginId#:#hoperun#,#param#:{#printStart#:#1#,#printEnd#:#3#}}&";
                str1 = str1.Split('&')[1];
                str1 = str1.Replace("#", "\"");
                this.paramData = JObject.Parse(str1);
                this.lblParam.Text = this.paramData.ToString();
            }

        }

        private void btnPrint_Click(object sender, EventArgs e)
        {
            PrintService printService = new PrintService();
            printService.DocumentName = "testPrint";
            printService.UseDefaultPaper = false;
            printService.PaperWidth = int.Parse(this.txtPageWidth.Text);
            printService.PaperHeight = int.Parse(this.txtPageHeight.Text);
            printService.TotalCount = 2;
            printService.PageNo = 0;

            if (MessageBox.Show("是否要预览打印文档", "打印预览", MessageBoxButtons.YesNo) == DialogResult.Yes)
            {
                //开启操作系统的防锯齿功能
                this.printPreviewDialog1.UseAntiAlias = true;
                //设置要预览的文档
                this.printPreviewDialog1.Document = printService.GetPriner(this.DoPrint);
                //打开预览窗口
                printPreviewDialog1.ShowDialog();
            }
            else
            {
                //调用Print方法直接打印文档
                printService.Print(this.DoPrint);
            }
        }

        private void DoPrint(Graphics g, int count, ref bool a)
        {
            int pageLeft =  int.Parse(this.txtPageLeft.Text) * 4;
            int pageTop =  int.Parse(this.txtPageTop.Text) * 4;
            uint codeHeight = uint.Parse(this.txtBarCodeHeight.Text) * 4;
            int wordSize = int.Parse(this.txtWordSize.Text);
            int codeSize = int.Parse(this.txtCodeSize.Text);
            Font wordFont = new Font(this.txtWordType.Text, wordSize);
            Font wordFont2 = new Font(this.txtWordType.Text, wordSize + 2);
            Font codeFont = new Font(this.txtWordType.Text, codeSize);

            //通过GDI+绘制打印文档
            //g.DrawLine(new Pen(Color.Black, (float)3.00), 100, 185, 720, 185);

            g.DrawString(this.txtGrade.Text, wordFont2, Brushes.Black, pageLeft + 182, pageTop + 8);
            g.DrawString(this.txtBrand.Text, wordFont, Brushes.Black, pageLeft + 190, pageTop + 54);

            //产品名称
            g.DrawString("鸡大腿", wordFont, Brushes.Black, pageLeft + 35, pageTop + 54);
            //产品规格
            g.DrawString("58*39*10.5cm（9.5kg/1个）", wordFont, Brushes.Black, pageLeft + 35, pageTop + 77);
            //配料
            g.DrawString("酱油", wordFont, Brushes.Black, pageLeft + 35, pageTop + 101);

            //保质期
            g.DrawString("三个月", wordFont, Brushes.Black, pageLeft + 35, pageTop + 189);
            //产地
            g.DrawString("上海市浦东新区", wordFont, Brushes.Black, pageLeft + 190, pageTop + 167);
            //电话
            g.DrawString("021-88888888", wordFont, Brushes.Black, pageLeft + 190, pageTop + 192);
            //净含量
            g.DrawString("1580g", wordFont2, Brushes.Black, pageLeft + 35, pageTop + 230);

            BarCode barCode = new BarCode();
            barCode.ValueFont = codeFont;
            barCode.Height = codeHeight;
            barCode.ReadCode = this.txtReadCode.Text;
            System.Drawing.Bitmap imgBarCode = barCode.GetCodeImage(this.txtBarCode.Text, BarCode.Encode.Code128C);
            g.DrawImage(imgBarCode, pageLeft, pageTop + 255);
            g.DrawString(this.txtReadCode.Text, codeFont, Brushes.Black, pageLeft, pageTop + 258 + imgBarCode.Height);
        }

        private void BarCodeConfigForm_Load(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (String.IsNullOrEmpty(this.lblParam.Text))
            {
                return;
            }
            string strURL = "http://121.40.103.229:8080/msk-web/api/v1/ds/barcode/query";
            //string dataStr = "{\"siteCode\": \"SNK\",\"auth\": \"test\",\"loginId\": \"hoperun\",\"param\":{\"buyerId\": \"14025fc5-6b0d-4af0-9816-73816901aec8\"}}";
            //JObject obj = JObject.Parse(this.lblParam.Text);
            byte[] dataByte = Encoding.UTF8.GetBytes(this.paramData.ToString());

            //创建一个HTTP请求
            HttpWebRequest request = (HttpWebRequest)WebRequest.Create(strURL);

            //Post请求方式
            request.Method = "POST";

            //内容类型
            request.ContentType = "application/json;charset=UTF-8";

            //设置请求的ContentLength
            request.ContentLength = dataByte.Length;
            request.Timeout = 90000;

            //发送请求，获得请求流
            Stream writer = request.GetRequestStream();
            //将请求参数写入流
            writer.Write(dataByte, 0, dataByte.Length);
            //关闭请求流
            writer.Close();

            //获得响应流
            HttpWebResponse response = (HttpWebResponse)request.GetResponse();
            Stream streamReceive = response.GetResponseStream();
            Encoding encoding = Encoding.UTF8;

            StreamReader streamReader = new StreamReader(streamReceive, encoding);
            string strResult = streamReader.ReadToEnd();
            streamReceive.Dispose();
            streamReader.Dispose();

            JObject resultData = JObject.Parse(strResult);
            //this.resultData = JObject.Parse(strResult);
            PrintService printService = new PrintService();
            printService.DocumentName = "testPrint";
            printService.UseDefaultPaper = false;
            printService.PaperWidth = int.Parse(this.txtPageWidth.Text);
            printService.PaperHeight = int.Parse(this.txtPageHeight.Text);

            this.printDataList = new List<JToken>();
            foreach (JToken jt in resultData.GetValue("result").Children()){
                printDataList.Add(jt);
            }

            printService.TotalCount = this.printDataList.Count();
            printService.PageNo = 1;
            printService.Print(this.DoPrint2);
        }

        private void DoPrint2(Graphics g,int count, ref bool bHadMore)
        {
            if (count < 0)
            {
                return;
            }
            JToken printData = this.printDataList[count];

            int pageLeft = int.Parse(this.txtPageLeft.Text) * 4;
            int pageTop = int.Parse(this.txtPageTop.Text) * 4;
            uint codeHeight = uint.Parse(this.txtBarCodeHeight.Text) * 4;
            int wordSize = int.Parse(this.txtWordSize.Text);
            int codeSize = int.Parse(this.txtCodeSize.Text);
            Font wordFont = new Font(this.txtWordType.Text, wordSize);
            Font wordFont2 = new Font(this.txtWordType.Text, wordSize + 2);
            Font codeFont = new Font(this.txtWordType.Text, codeSize);


            g.DrawString(printData["grade"].ToString(), wordFont2, Brushes.Black, pageLeft + 182, pageTop + 8);
            g.DrawString(printData["brand"].ToString(), wordFont, Brushes.Black, pageLeft + 190, pageTop + 54);

            BarCode barCode = new BarCode();
            barCode.ValueFont = codeFont;
            barCode.Height = codeHeight;
            barCode.ReadCode = this.txtReadCode.Text;
            System.Drawing.Bitmap imgBarCode = barCode.GetCodeImage(printData["barcode"].ToString(), BarCode.Encode.Code128C);
            g.DrawImage(imgBarCode, pageLeft, pageTop + 255);
            g.DrawString(printData["readcode"].ToString(), codeFont, Brushes.Black, pageLeft, pageTop + 258 + imgBarCode.Height);

        }
    }
}
