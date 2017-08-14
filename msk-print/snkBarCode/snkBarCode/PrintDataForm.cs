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
    public partial class PrintDataForm : Form
    {
        /// <summary>
        /// 需要打印的数据
        /// </summary>
        private List<BarCodeBean> _allDataList;
        /// <summary>
        /// 当页显示的数据
        /// </summary>
        private List<BarCodeBean> _displayList;

        private string _fileName;
        private int _totalDataCount;
        private int _totalPageCount;
        private int _pageSize;
        private int _pageNo;

        public PrintDataForm(string fileName, List<BarCodeBean> paramList)
        {
            InitializeComponent();
            _fileName = fileName;
            _allDataList = paramList;
        }

        private void PrintDataForm_Load(object sender, EventArgs e)
        {
            _pageSize = 20;
            _pageNo = 1;
            _totalDataCount = _allDataList.Count();
            _totalPageCount = _totalDataCount / _pageSize + 1;
            this.printDataGridView.AutoGenerateColumns = false;
            //this.printDataGridView.DataSource = _printDataList;
            if (_totalPageCount < 2)
            {
                this.btnPrevPage.Enabled = false;
                this.btnNextPage.Enabled = false;
                this.btnJump.Enabled = false;
            }
            Init();
        }

        private void Init()
        {
            if (_pageNo == 1)
            {
                this.btnPrevPage.Enabled = false;
            }
            else if (_pageNo == _totalPageCount)
            {
                this.btnNextPage.Enabled = false;
            }
            else
            {
                this.btnPrevPage.Enabled = true;
                this.btnNextPage.Enabled = true;
            }
            string strFoot;
            strFoot = "共" + _totalDataCount + "条记录，";
            strFoot += "当前第 " + _pageNo.ToString() + " / " + _totalPageCount + " 页";
            this.lblFoot.Text = strFoot;

            _displayList = new List<BarCodeBean>();
            int pageMin = (_pageNo - 1) * _pageSize;
            int pageMax = _pageNo * _pageSize;
            for (int i = pageMin; i < pageMax; i++)
            {
                if (i < _totalDataCount)
                {
                    _displayList.Add(_allDataList[i]);
                }
                else
                {
                    break;
                }
            }
            this.printDataGridView.DataSource = _displayList;
            this.printDataGridView.Refresh();
            this.txtPageNo.Text = _pageNo.ToString();
        }

        private void btnPrevPage_Click(object sender, EventArgs e)
        {
            _pageNo--;
            Init();
        }

        private void btnNextPage_Click(object sender, EventArgs e)
        {
            _pageNo++;
            Init();
        }

        private void btnClose_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnJump_Click(object sender, EventArgs e)
        {
            if (String.IsNullOrEmpty(this.txtPageNo.Text))
            {
                MessageBox.Show("请输入页码！");
            }
            else
            {
                try
                {
                    int pageNo = Convert.ToInt32(this.txtPageNo.Text);
                    if (pageNo < 1 || pageNo > _totalPageCount)
                    {
                        MessageBox.Show("请输入1到" + _totalPageCount.ToString() + "之间的页码！");
                    }
                    else
                    {
                        _pageNo = pageNo;
                        Init();
                    }
                }
                catch
                {
                    MessageBox.Show("请输入数字！");
                }
            }
        }

        private void SelectData(BarCodeBean bean)
        {
            bean.IsPrint = true;
        }
        private void btnSelectAll_Click(object sender, EventArgs e)
        {
            _displayList.ForEach(delegate(BarCodeBean bean) { bean.IsPrint = true; });
            this.printDataGridView.Refresh();
        }

        private void btnUnSelect_Click(object sender, EventArgs e)
        {
            _displayList.ForEach(delegate(BarCodeBean bean) { bean.IsPrint = false; });
            this.printDataGridView.Refresh();
        }

        private List<BarCodeBean> GetPrintData(List<BarCodeBean> list)
        {
            List<BarCodeBean> printDataList = new List<BarCodeBean>();
            foreach (BarCodeBean bean in list)
            {
                if (bean.IsPrint)
                {
                    printDataList.Add(bean);
                }
                else
                {
                    continue;
                }
            }
            return printDataList;
        }
        private void btnPrintCurrent_Click(object sender, EventArgs e)
        {
            List<BarCodeBean> printDataList = GetPrintData(_displayList);
            if (printDataList.Count > 0)
            {
                PrintManager pManager = new PrintManager(printDataList);
                pManager.DoPrint(_fileName);
            }
            else
            {
                MessageBox.Show("未选择打印内容！");
            }
        }

        private void btnPrintAll_Click(object sender, EventArgs e)
        {
            List<BarCodeBean> printDataList = GetPrintData(_allDataList);
            if (printDataList.Count > 0)
            {
                PrintManager pManager = new PrintManager(printDataList);
                pManager.DoPrint(_fileName);
            }
            else
            {
                MessageBox.Show("未选择打印内容！");
            }
        }
    }
}
