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
        /// <summary>
        /// 打印配置
        /// </summary>
        private PrintSetting _printSetting;

        public BarCodeConfigForm()
        {
            InitializeComponent();
        }

        private void BarCodeConfigForm_Load(object sender, EventArgs e)
        {
            _printSetting = PrintSetting.GetInstance();
            this.txtPrintCount.Text = _printSetting.PrintCount.ToString();
            this.txtPageWidth.Text = _printSetting.PaperWidth.ToString();
            this.txtPageHeight.Text = _printSetting.PaperHeight.ToString();
            this.txtPageLeft.Text = _printSetting.PageLeft.ToString();
            this.txtPageTop.Text = _printSetting.PageTop.ToString();
            this.txtBarCodeHeight.Text = _printSetting.BarCodeHeight.ToString();
            this.txtCodeSize.Text = _printSetting.BarCodeSize.ToString();
            this.txtWordSize.Text = _printSetting.WordSize.ToString();
            this.txtWordType.Text = _printSetting.WordType.ToString();
        }

        private void btnReturn_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnSave_Click(object sender, EventArgs e)
        {
            _printSetting.PrintCount = Convert.ToInt32(this.txtPrintCount.Text);
            _printSetting.PaperWidth = Convert.ToInt32(this.txtPageWidth.Text);
            _printSetting.PaperHeight = Convert.ToInt32(this.txtPageHeight.Text);
            _printSetting.PageLeft = Convert.ToInt32(this.txtPageLeft.Text);
            _printSetting.PageTop = Convert.ToInt32(this.txtPageTop.Text);
            _printSetting.BarCodeHeight = Convert.ToInt32(this.txtBarCodeHeight.Text);
            _printSetting.BarCodeSize = Convert.ToInt32(this.txtCodeSize.Text);
            _printSetting.WordSize = Convert.ToInt32(this.txtWordSize.Text);
            _printSetting.WordType = this.txtWordType.Text;
            _printSetting.Save();
            this.Close();
        }
    }
}
