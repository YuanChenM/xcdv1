using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace snkBarCode
{
    public partial class UrlConfigForm : Form
    {
        /// <summary>
        /// 打印配置
        /// </summary>
        private PrintSetting _printSetting;

        public UrlConfigForm()
        {
            InitializeComponent();
        }

        private void UrlConfigForm_Load(object sender, EventArgs e)
        {
            _printSetting = PrintSetting.GetInstance();
            this.txtTestUrl.Text = _printSetting.UrlEnvironmentTest;
            this.txtUatUrl.Text = _printSetting.UrlEnvironmentUat;
            this.txtProUrl.Text = _printSetting.UrlEnvironmentPro;
        }

        private void btnReturn_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnSave_Click(object sender, EventArgs e)
        {
            _printSetting.UrlEnvironmentTest = this.txtTestUrl.Text;
            _printSetting.UrlEnvironmentUat = this.txtUatUrl.Text;
            _printSetting.UrlEnvironmentPro = this.txtProUrl.Text;
            _printSetting.SaveUrl();
        }
    }
}
