using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Newtonsoft.Json.Linq;
using System.Drawing;

namespace snkBarCode
{
    public class PrintManager
    {
        /// <summary>
        /// 打印配置
        /// </summary>
        private PrintSetting _printSetting;
        /// <summary>
        /// 打印服务
        /// </summary>
        private PrintService _printService;
        /// <summary>
        /// 需要打印的数据
        /// </summary>
        private List<BarCodeBean> _printDataList;

        /// <summary>
        /// 构造方法
        /// </summary>
        public PrintManager(List<BarCodeBean> dataList)
        {
            _printSetting = PrintSetting.GetInstance();
            _printDataList = dataList;
        }

        /// <summary>
        /// 打印
        /// </summary>
        /// <param name="docName">打印文档名称</param>
        public void DoPrint(string docName)
        {
            _printService = new PrintService();
            _printService.DocumentName = docName;
            _printService.UseDefaultPaper = false;
            _printService.PaperWidth = Convert.ToInt32(_printSetting.PaperWidth);
            _printService.PaperHeight = Convert.ToInt32(_printSetting.PaperHeight);
            _printService.TotalCount = _printDataList.Count();
            _printService.PageNo = 1;
            //调用Print方法直接打印文档
            _printService.Print(this.DrawContent);
        }

        /// <summary>
        /// 打印委托
        /// </summary>
        /// <param name="g">Graphics</param>
        /// <param name="num">打印第几条</param>
        /// <param name="a">是否继续打印</param>
        private void DrawContent(Graphics g, int num, ref bool a)
        {
            //获得打印数据
            if (num < 0)
            {
                return;
            }
            BarCodeBean barCodeBean = this._printDataList[num];

            //打印基本设置
            int pageLeft = Convert.ToInt32(_printSetting.PageLeft) * 4;
            int pageTop = Convert.ToInt32(_printSetting.PageTop) * 4;
            uint codeHeight = Convert.ToUInt32(_printSetting.BarCodeHeight) * 4;
            int wordSize = Convert.ToInt32(_printSetting.WordSize);
            int codeSize = Convert.ToInt32(_printSetting.BarCodeSize);
            Font wordFont = new Font(_printSetting.WordType, wordSize);
            Font wordFont2 = new Font(_printSetting.WordType, wordSize + 2);
            Font codeFont = new Font(_printSetting.WordType, codeSize);

            //画出打印内容
            g.DrawString(barCodeBean.Grade, wordFont2, Brushes.Black, pageLeft + 182, pageTop + 8);
            g.DrawString(barCodeBean.Brand, wordFont, Brushes.Black, pageLeft + 190, pageTop + 54);

            BarCode barCode = new BarCode();
            barCode.ValueFont = codeFont;
            barCode.Height = codeHeight;
            System.Drawing.Bitmap imgBarCode = barCode.GetCodeImage(barCodeBean.BarCode, BarCode.Encode.Code128C);
            g.DrawImage(imgBarCode, pageLeft, pageTop + 255);
            g.DrawString(barCodeBean.ReadCode, codeFont, Brushes.Black, pageLeft, pageTop + 258 + imgBarCode.Height);

        }
    }
}
