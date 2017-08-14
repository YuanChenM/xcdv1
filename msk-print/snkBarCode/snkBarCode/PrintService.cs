using System;
using System.Collections.Generic;
using System.Text;
using System.Drawing;
using System.Drawing.Printing;

namespace snkBarCode
{
    public class PrintService
    {
        /*页面打印委托*/
        public delegate void DoPrintDelegate(Graphics g, int count, ref bool HasMorePage);
        DoPrintDelegate DoPrint = null;

        private PrintDocument _printDoc = null;
        private bool _bUseDefaultPaperSetting = false;

        public PrintService()
        {
            _printDoc = new PrintDocument();
            _printDoc.PrintPage += new PrintPageEventHandler
                (this.OnPrintPage);

        }

        public void Dispose()
        {
            if (_printDoc != null) _printDoc.Dispose();
            _printDoc = null;

        }

        /*设置打印机名*/
        public string PrinterName
        {
            get { return _printDoc.PrinterSettings.PrinterName; }
            set { _printDoc.PrinterSettings.PrinterName = value; }
        }

        /*设置打印文档名*/
        public string DocumentName
        {
            get { return _printDoc.DocumentName; }
            set { _printDoc.DocumentName = value; }
        }

        private int totalCount;
        /*设置打印总页数*/
        public int TotalCount
        {
            get { return totalCount; }
            set { totalCount = value; }
        }

        private int pageNo;
        /*设置当前打印页数*/
        public int PageNo
        {
            get { return pageNo; }
            set { pageNo = value; }
        }

        /*设置是否使用缺省纸张*/
        public bool UseDefaultPaper
        {
            get { return _bUseDefaultPaperSetting; }
            set
            {
                _bUseDefaultPaperSetting = value;
                if (!_bUseDefaultPaperSetting)
                {
                    //如果不适用缺省纸张则创建一个自定义纸张，注意，必须使用这个版本的构造函数才是自定义的纸张
                    PaperSize ps = new PaperSize("Custom Size 1", 827, 1169);
                    //将缺省的纸张设置为新建的自定义纸张
                    _printDoc.DefaultPageSettings.PaperSize = ps;
                }
            }
        }

        /*纸张宽度 单位定义为毫米mm*/
        public float PaperWidth
        {
            get { return _printDoc.DefaultPageSettings.PaperSize.Width / 100f * 25.4f; }
            set
            {
                //注意，只有自定义纸张才能修改该属性，否则将导致异常
                if (_printDoc.DefaultPageSettings.PaperSize.Kind == PaperKind.Custom)
                    _printDoc.DefaultPageSettings.PaperSize.Width = (int)(value / 25.4 * 100);
            }
        }

        /*纸张高度 单位定义为毫米mm*/
        public float PaperHeight
        {
            get { return (int)_printDoc.PrinterSettings.DefaultPageSettings.PaperSize.Height / 100f * 25.4f; }
            set
            {
                //注意，只有自定义纸张才能修改该属性，否则将导致异常
                if (_printDoc.DefaultPageSettings.PaperSize.Kind == PaperKind.Custom)
                    _printDoc.DefaultPageSettings.PaperSize.Height = (int)(value / 25.4 * 100);
            }
        }

        /*页面打印*/
        private void OnPrintPage(object sender, PrintPageEventArgs ev)
        {

            //调用委托绘制打印内容
            if (DoPrint != null)
            {
                bool bHadMore = false;
                int count = this.pageNo - 1;
                DoPrint(ev.Graphics, count, ref bHadMore);
                if (this.pageNo < this.totalCount)
                {
                    ev.HasMorePages = true;
                    this.pageNo++;
                }
                else
                {
                    ev.HasMorePages = bHadMore;
                }
            }

        }

        /* 开始打印*/
        public void Print(DoPrintDelegate doPrint)
        {
            DoPrint = doPrint;
            this._printDoc.Print();
        }

        public PrintDocument GetPriner(DoPrintDelegate doPrint)
        {
            DoPrint = doPrint;
            return _printDoc;
        }
    }
}
