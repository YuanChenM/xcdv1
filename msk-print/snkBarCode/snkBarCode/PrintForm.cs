using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Configuration;
using Newtonsoft.Json.Linq;
using System.Net;
using System.IO;

namespace snkBarCode
{
    public partial class PrintForm : Form
    {
        /// <summary>
        /// 打印配置
        /// </summary>
        private PrintSetting _printSetting;
        /// <summary>
        /// 需要打印的数据
        /// </summary>
        private List<BarCodeBean> _printDataList;

        private int _printStart;
        private int _printEnd;
        private int _printCount;
        private string _barcodeId;
        private int _totalCount;
        private string _environmentUrl;

        /// <summary>
        /// 构造方法(参数有问题的情况)
        /// </summary>
        public PrintForm()
        {
            InitializeComponent();
            this.lblContent.Text = "传入参数不正确，无法取得打印数据！\n请尝试数据文件打印";

            this.btnFilePrint.Visible = true;
            this.btnPrint.Enabled = false;

            this.btnClose.Focus();
        }

        /// <summary>
        /// 构造方法
        /// </summary>
        /// <param name="barcodeId">打印ID</param>
        /// <param name="totalCount">打印数据总量</param>
        public PrintForm(string barcodeId, int totalCount)
        {
            InitializeComponent();
            _barcodeId = barcodeId;
            _totalCount = totalCount;
            _printSetting = PrintSetting.GetInstance();
            _environmentUrl = _printSetting.UrlEnvironmentTest;
        }

        /// <summary>
        /// 构造方法
        /// </summary>
        /// <param name="barcodeId">打印ID</param>
        /// <param name="totalCount">打印数据总量</param>
        public PrintForm(string barcodeId)
        {
            InitializeComponent();
            _barcodeId = barcodeId;
            _totalCount = 100;
            _printSetting = PrintSetting.GetInstance();
            _environmentUrl = _printSetting.UrlEnvironmentTest;
        }

        /// <summary>
        /// 构造方法
        /// </summary>
        /// <param name="barcodeId">打印ID</param>
        /// <param name="totalCount">打印数据总量</param>
        /// <param name="environment">环境区分</param>
        public PrintForm(string barcodeId, int totalCount, string environment)
        {
            InitializeComponent();
            _barcodeId = barcodeId;
            _totalCount = totalCount;
            _printSetting = PrintSetting.GetInstance();
            if (String.Equals(environment, "UAT"))
            {
                _environmentUrl = _printSetting.UrlEnvironmentUat;
            }
            else if (String.Equals(environment, "PROD"))
            {
                _environmentUrl = _printSetting.UrlEnvironmentPro;
            }
            else
            {
                _environmentUrl = _printSetting.UrlEnvironmentTest;
            }
        }

        /// <summary>
        /// 画面初始化
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void PrintForm_Load(object sender, EventArgs e)
        {
            initPrint();
        }

        /// <summary>
        /// 初始化
        /// </summary>
        private void initPrint()
        {
            _printStart = 1;
            _printCount = _printSetting.PrintCount;
            _printEnd = _printStart + _printCount - 1;

            bool result = this.SetPrintData();
            if (result)
            {
                this.btnFilePrint.Visible = false;
                this.btnReadData.Enabled = true;
                this.btnPrint.Enabled = true;
                this.btnPrint.Focus();
                this.lblContent.Text = "共" + _totalCount.ToString() + "个标签需要打印\n";
                if (_totalCount > _printEnd)
                {
                    this.lblContent.Text += "打印第" + _printStart.ToString() + "到" + _printEnd.ToString() + "个标签";
                }
                else
                {
                    this.lblContent.Text += "打印第" + _printStart.ToString() + "到" + _totalCount.ToString() + "个标签";
                    _printEnd = _totalCount;
                }
            }
            else
            {
                this.lblContent.Text = "传入参数不正确或无法取得打印数据！\n请尝试数据文件打印";
                this.btnFilePrint.Visible = true;
                this.btnReadData.Enabled = false;
                this.btnPrint.Enabled = false;
                this.btnClose.Focus();
            }
        }

        /// <summary>
        /// 下一次打印
        /// </summary>
        private void SetPrintStartAndEnd()
        {
            if (_totalCount > _printEnd)
            {
                _printStart = _printStart + _printCount;
                _printEnd = _printStart + _printCount - 1;
            }
            else
            {
                _printStart = _printStart + _printCount;
                _printEnd = _totalCount;
            }
        }

        /// <summary>
        /// 根据参数从外部接口取得打印数据
        /// </summary>
        /// <returns></returns>
        private bool SetPrintData()
        {
            _printDataList = new List<BarCodeBean>();

            //取得请求参数
            JObject paramJson = GetParam();

            //设置请求地址
            string strURL = _environmentUrl + _printSetting.UrlRsBarcodeQuery;
            byte[] dataByte = Encoding.UTF8.GetBytes(paramJson.ToString());

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

            //获得结果
            JObject resultData = JObject.Parse(strResult);
            _printDataList = ConvertToList(resultData);
            if (_printDataList.Count > 0 && _printDataList.Count <= _totalCount)
            {
                return true;
            }
            return false;
        }

        /// <summary>
        /// json对象转为list对象
        /// </summary>
        /// <param name="jsonData">json对象</param>
        /// <returns>list对象</returns>
        private List<BarCodeBean> ConvertToList(JObject jsonData)
        {
            List<BarCodeBean> dataList = new List<BarCodeBean>();
            BarCodeBean bean;
            foreach (JToken jt in jsonData.GetValue("result").Children())
            {
                bean = new BarCodeBean();
                bean.BarcodeId = _barcodeId;
                bean.Grade = jt["grade"].ToString();
                bean.Brand = jt["brand"].ToString();
                bean.BarCode = jt["barcode"].ToString();
                bean.ReadCode = jt["readcode"].ToString();
                dataList.Add(bean);
            }
            return dataList;
        }

        /// <summary>
        /// 取得json类型的参数
        /// </summary>
        /// <returns></returns>
        private JObject GetParam()
        {
            string commParamStart = "{#siteCode#:#SNK#,#auth#:#test#,#loginId#:#hoperun#,#param#:{";
            string commParamEnd = "}}";
            string param = "#printStart#:#" + _printStart.ToString()
                         + "#,#printEnd#:#" + _printEnd.ToString()
                         + "#,#barcodeId#:#" + _barcodeId + "#";
            param = commParamStart + param + commParamEnd;
            param = param.Replace("#", "\"");
            return JObject.Parse(param);
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
        /// 关闭按钮点击事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnClose_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        /// <summary>
        /// 打印按钮点击事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnPrint_Click(object sender, EventArgs e)
        {
            if (_printDataList.Count > 0)
            {
                string fileName = _printDataList.FirstOrDefault().BarcodeId;
                PrintManager pManager = new PrintManager(_printDataList);
                pManager.DoPrint(fileName + "(" + _printStart.ToString() + "_" + _printEnd.ToString() + ")");
                SetPrintStartAndEnd();
            }
            else
            {
                MessageBox.Show("没有需要打印标签！");
            }

        }

        /// <summary>
        /// 文件打印按钮点击事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnFilePrint_Click(object sender, EventArgs e)
        {
            FilePrintForm filePrintForm = new FilePrintForm();
            filePrintForm.ShowDialog();
        }

        /// <summary>
        /// url设置按钮点击事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnUrlSetting_Click(object sender, EventArgs e)
        {
            UrlConfigForm urlConfigForm = new UrlConfigForm();
            urlConfigForm.ShowDialog();
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
                MessageBox.Show("没有数据！");
            }
            else
            {
                string fileName = _printDataList.FirstOrDefault().BarcodeId;
                PrintDataForm dataFrom = new PrintDataForm(fileName, _printDataList);
                dataFrom.ShowDialog();
            }
        }

    }
}
