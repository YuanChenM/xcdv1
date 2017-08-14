using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace snkBarCode
{
    public class BarCodeBean
    {
        /// <summary>
        /// 行号
        /// </summary>
        private int rowNo;

        public int RowNo
        {
            get { return rowNo; }
            set { rowNo = value; }
        }

        /// <summary>
        /// 是否打印
        /// </summary>
        private bool isPrint;

        public bool IsPrint
        {
            get { return isPrint; }
            set { isPrint = value; }
        }

        /// <summary>
        /// 条码ID
        /// </summary>
        private string barcodeId;

        public string BarcodeId
        {
            get { return barcodeId; }
            set { barcodeId = value; }
        }
        /// <summary>
        /// 产品等级
        /// </summary>
        private string grade;

        public string Grade
        {
            get { return grade; }
            set { grade = value; }
        }
        /// <summary>
        /// 品牌
        /// </summary>
        private string brand;

        public string Brand
        {
            get { return brand; }
            set { brand = value; }
        }
        /// <summary>
        /// 条形码
        /// </summary>
        private string barCode;

        public string BarCode
        {
            get { return barCode; }
            set { barCode = value; }
        }
        /// <summary>
        /// 阅读码
        /// </summary>
        private string readCode;

        public string ReadCode
        {
            get { return readCode; }
            set { readCode = value; }
        }
    }
}
