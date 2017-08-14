using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Configuration;

namespace snkBarCode
{
    public class PrintSetting
    {
        private static PrintSetting instance;

        /// <summary>
        /// 程序运行时，创建一个静态只读的进程辅助对象
        /// </summary>
        private static readonly object _object = new object();

        /// <summary>
        /// 每次打印的数量
        /// </summary>
        private int printCount;

        public int PrintCount
        {
            get { return printCount; }
            set { printCount = value; }
        }

        /// <summary>
        /// 纸张高度
        /// </summary>
        private int paperWidth;

        public int PaperWidth
        {
            get { return paperWidth; }
            set { paperWidth = value; }
        }
        /// <summary>
        /// 纸张宽度
        /// </summary>
        private int paperHeight;

        public int PaperHeight
        {
            get { return paperHeight; }
            set { paperHeight = value; }
        }
        /// <summary>
        /// 页边距-左
        /// </summary>
        private int pageLeft;

        public int PageLeft
        {
            get { return pageLeft; }
            set { pageLeft = value; }
        }
        /// <summary>
        /// 页边距-顶
        /// </summary>
        private int pageTop;

        public int PageTop
        {
            get { return pageTop; }
            set { pageTop = value; }
        }
        /// <summary>
        /// 条码高度
        /// </summary>
        private int barCodeHeight;

        public int BarCodeHeight
        {
            get { return barCodeHeight; }
            set { barCodeHeight = value; }
        }
        /// <summary>
        /// 条码字号
        /// </summary>
        private int barCodeSize;

        public int BarCodeSize
        {
            get { return barCodeSize; }
            set { barCodeSize = value; }
        }
        /// <summary>
        /// 打印字号
        /// </summary>
        private int wordSize;

        public int WordSize
        {
            get { return wordSize; }
            set { wordSize = value; }
        }
        /// <summary>
        /// 打印字体
        /// </summary>
        private string wordType;

        public string WordType
        {
            get { return wordType; }
            set { wordType = value; }
        }

        /// <summary>
        /// 外部接口访问url
        /// </summary>
        private string urlRsBarcodeQuery;

        public string UrlRsBarcodeQuery
        {
            get { return urlRsBarcodeQuery; }
            set { urlRsBarcodeQuery = value; }
        }
        /// <summary>
        /// 测试环境url
        /// </summary>
        private string urlEnvironmentTest;

        public string UrlEnvironmentTest
        {
            get { return urlEnvironmentTest; }
            set { urlEnvironmentTest = value; }
        }
        /// <summary>
        /// uat环境url
        /// </summary>
        private string urlEnvironmentUat;

        public string UrlEnvironmentUat
        {
            get { return urlEnvironmentUat; }
            set { urlEnvironmentUat = value; }
        }
        /// <summary>
        /// 正式环境url
        /// </summary>
        private string urlEnvironmentPro;

        public string UrlEnvironmentPro
        {
            get { return urlEnvironmentPro; }
            set { urlEnvironmentPro = value; }
        }

        /// <summary>
        /// 构造方法私有，外键不能通过New类实例化此类
        /// </summary>
        private PrintSetting()
        {
            Configuration config = ConfigurationManager.OpenExeConfiguration(ConfigurationUserLevel.None);
            this.printCount = Convert.ToInt32(config.AppSettings.Settings["printCount"].Value);
            this.paperWidth = Convert.ToInt32(config.AppSettings.Settings["printPaperWidth"].Value);
            this.paperHeight = Convert.ToInt32(config.AppSettings.Settings["printPaperHeight"].Value);
            this.pageLeft = Convert.ToInt32(config.AppSettings.Settings["printPageLeft"].Value);
            this.pageTop = Convert.ToInt32(config.AppSettings.Settings["printPageTop"].Value);
            this.barCodeHeight = Convert.ToInt32(config.AppSettings.Settings["printBarCodeHeight"].Value);
            this.barCodeSize = Convert.ToInt32(config.AppSettings.Settings["printCodeSize"].Value);
            this.wordSize = Convert.ToInt32(config.AppSettings.Settings["printWordSize"].Value);
            this.wordType = Convert.ToString(config.AppSettings.Settings["printWordType"].Value);

            this.urlRsBarcodeQuery = Convert.ToString(config.AppSettings.Settings["urlRsBarcodeQuery"].Value);
            this.urlEnvironmentTest = Convert.ToString(config.AppSettings.Settings["urlEnvironmentTest"].Value);
            this.urlEnvironmentUat = Convert.ToString(config.AppSettings.Settings["urlEnvironmentUat"].Value);
            this.urlEnvironmentPro = Convert.ToString(config.AppSettings.Settings["urlEnvironmentPro"].Value);
        }

        /// <summary>
        /// 此方法是本类实例的唯一全局访问点
        /// （双重加锁 Double-Check Locking）
        /// </summary>
        /// <returns></returns>
        public static PrintSetting GetInstance()
        {
            //先判断实例是否存在，不存在再加锁处理
            if (instance == null)
            {
                //在同一时刻加了锁的那部分程序只有一个线程可以进入，
                lock (_object)
                {
                    //如实例不存在，则New一个新实例，否则返回已有实例
                    if (instance == null)
                    {
                        instance = new PrintSetting();
                    }
                }
            }
            return instance;
        }

        public void Save()
        {
            //修改内存中数据
            Configuration config = ConfigurationManager.OpenExeConfiguration(ConfigurationUserLevel.None);
            config.AppSettings.Settings["printCount"].Value = this.printCount.ToString();
            config.AppSettings.Settings["printPaperWidth"].Value = this.paperWidth.ToString();
            config.AppSettings.Settings["printPaperHeight"].Value = this.paperHeight.ToString();
            config.AppSettings.Settings["printPageLeft"].Value = this.pageLeft.ToString();
            config.AppSettings.Settings["printPageTop"].Value = this.pageTop.ToString();
            config.AppSettings.Settings["printBarCodeHeight"].Value = this.barCodeHeight.ToString();
            config.AppSettings.Settings["printCodeSize"].Value = this.barCodeSize.ToString();
            config.AppSettings.Settings["printWordSize"].Value = this.wordSize.ToString();
            config.AppSettings.Settings["printWordType"].Value = this.wordType.ToString();

            config.Save(ConfigurationSaveMode.Full);

            //修改文件中数据
            SetValue("printCount", this.printCount.ToString());
            SetValue("printPaperWidth", this.paperWidth.ToString());
            SetValue("printPaperHeight", this.paperHeight.ToString());
            SetValue("printPageLeft", this.pageLeft.ToString());
            SetValue("printPageTop", this.pageTop.ToString());
            SetValue("printBarCodeHeight", this.barCodeHeight.ToString());
            SetValue("printCodeSize", this.barCodeSize.ToString());
            SetValue("printWordSize", this.wordSize.ToString());
            SetValue("printWordType", this.wordType.ToString());
        }

        public void SaveUrl()
        {
            //修改内存中数据
            Configuration config = ConfigurationManager.OpenExeConfiguration(ConfigurationUserLevel.None);
            config.AppSettings.Settings["urlEnvironmentTest"].Value = this.urlEnvironmentTest.ToString();
            config.AppSettings.Settings["urlEnvironmentUat"].Value = this.urlEnvironmentUat.ToString();
            config.AppSettings.Settings["urlEnvironmentPro"].Value = this.urlEnvironmentPro.ToString();

            config.Save(ConfigurationSaveMode.Full);

            SetValue("urlEnvironmentTest", this.urlEnvironmentTest.ToString());
            SetValue("urlEnvironmentUat", this.urlEnvironmentUat.ToString());
            SetValue("urlEnvironmentPro", this.urlEnvironmentPro.ToString());
        }

        /// <summary>
        /// SetValue
        /// </summary>
        /// <param name="AppKey">AppKey</param>
        /// <param name="AppValue">AppValue</param>
        public static void SetValue(string AppKey, string AppValue)
        {
            System.Xml.XmlDocument xDoc = new System.Xml.XmlDocument();
            xDoc.Load(System.Windows.Forms.Application.ExecutablePath + ".config");

            System.Xml.XmlNode xNode;
            System.Xml.XmlElement xElem1;
            System.Xml.XmlElement xElem2;
            xNode = xDoc.SelectSingleNode("//appSettings");

            xElem1 = (System.Xml.XmlElement)xNode.SelectSingleNode("//add[@key='" + AppKey + "']");
            if (xElem1 != null) xElem1.SetAttribute("value", AppValue);
            else
            {
                xElem2 = xDoc.CreateElement("add");
                xElem2.SetAttribute("key", AppKey);
                xElem2.SetAttribute("value", AppValue);
                xNode.AppendChild(xElem2);
            }
            xDoc.Save(System.Windows.Forms.Application.ExecutablePath + ".config");
        }
    }
}
