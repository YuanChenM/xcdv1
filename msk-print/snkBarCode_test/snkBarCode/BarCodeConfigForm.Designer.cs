namespace snkBarCode
{
    partial class BarCodeConfigForm
    {
        /// <summary>
        /// 必需的设计器变量。
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// 清理所有正在使用的资源。
        /// </summary>
        /// <param name="disposing">如果应释放托管资源，为 true；否则为 false。</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows 窗体设计器生成的代码

        /// <summary>
        /// 设计器支持所需的方法 - 不要
        /// 使用代码编辑器修改此方法的内容。
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(BarCodeConfigForm));
            this.btnPrint = new System.Windows.Forms.Button();
            this.printPreviewDialog1 = new System.Windows.Forms.PrintPreviewDialog();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.txtPageHeight = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.txtPageWidth = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.txtPageLeft = new System.Windows.Forms.TextBox();
            this.txtPageTop = new System.Windows.Forms.TextBox();
            this.label8 = new System.Windows.Forms.Label();
            this.label9 = new System.Windows.Forms.Label();
            this.label10 = new System.Windows.Forms.Label();
            this.txtBrand = new System.Windows.Forms.TextBox();
            this.label11 = new System.Windows.Forms.Label();
            this.txtGrade = new System.Windows.Forms.TextBox();
            this.label12 = new System.Windows.Forms.Label();
            this.label13 = new System.Windows.Forms.Label();
            this.txtBarCode = new System.Windows.Forms.TextBox();
            this.txtReadCode = new System.Windows.Forms.TextBox();
            this.txtBarCodeHeight = new System.Windows.Forms.TextBox();
            this.label14 = new System.Windows.Forms.Label();
            this.label15 = new System.Windows.Forms.Label();
            this.label16 = new System.Windows.Forms.Label();
            this.label17 = new System.Windows.Forms.Label();
            this.txtWordType = new System.Windows.Forms.TextBox();
            this.label18 = new System.Windows.Forms.Label();
            this.txtWordSize = new System.Windows.Forms.TextBox();
            this.label19 = new System.Windows.Forms.Label();
            this.label20 = new System.Windows.Forms.Label();
            this.txtCodeSize = new System.Windows.Forms.TextBox();
            this.btnSnkPrint = new System.Windows.Forms.Button();
            this.lblParam = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // btnPrint
            // 
            this.btnPrint.Location = new System.Drawing.Point(253, 259);
            this.btnPrint.Name = "btnPrint";
            this.btnPrint.Size = new System.Drawing.Size(89, 23);
            this.btnPrint.TabIndex = 3;
            this.btnPrint.Text = "本地数据打印";
            this.btnPrint.UseVisualStyleBackColor = true;
            this.btnPrint.Click += new System.EventHandler(this.btnPrint_Click);
            // 
            // printPreviewDialog1
            // 
            this.printPreviewDialog1.AutoScrollMargin = new System.Drawing.Size(0, 0);
            this.printPreviewDialog1.AutoScrollMinSize = new System.Drawing.Size(0, 0);
            this.printPreviewDialog1.ClientSize = new System.Drawing.Size(400, 300);
            this.printPreviewDialog1.Enabled = true;
            this.printPreviewDialog1.Icon = ((System.Drawing.Icon)(resources.GetObject("printPreviewDialog1.Icon")));
            this.printPreviewDialog1.Name = "printPreviewDialog1";
            this.printPreviewDialog1.Visible = false;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("宋体", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.label1.Location = new System.Drawing.Point(12, 9);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(67, 14);
            this.label1.TabIndex = 4;
            this.label1.Text = "页面设置";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(13, 43);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(53, 12);
            this.label2.TabIndex = 5;
            this.label2.Text = "纸张高度";
            // 
            // txtPageHeight
            // 
            this.txtPageHeight.Location = new System.Drawing.Point(72, 33);
            this.txtPageHeight.Name = "txtPageHeight";
            this.txtPageHeight.Size = new System.Drawing.Size(100, 21);
            this.txtPageHeight.TabIndex = 6;
            this.txtPageHeight.Text = "100";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(13, 73);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(53, 12);
            this.label3.TabIndex = 7;
            this.label3.Text = "纸张宽度";
            // 
            // txtPageWidth
            // 
            this.txtPageWidth.Location = new System.Drawing.Point(72, 64);
            this.txtPageWidth.Name = "txtPageWidth";
            this.txtPageWidth.Size = new System.Drawing.Size(100, 21);
            this.txtPageWidth.TabIndex = 8;
            this.txtPageWidth.Text = "90";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(178, 42);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(17, 12);
            this.label4.TabIndex = 9;
            this.label4.Text = "mm";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(178, 73);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(17, 12);
            this.label5.TabIndex = 10;
            this.label5.Text = "mm";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(243, 42);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(59, 12);
            this.label6.TabIndex = 11;
            this.label6.Text = "页边距-左";
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(243, 73);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(59, 12);
            this.label7.TabIndex = 12;
            this.label7.Text = "页边距-顶";
            // 
            // txtPageLeft
            // 
            this.txtPageLeft.Location = new System.Drawing.Point(308, 33);
            this.txtPageLeft.Name = "txtPageLeft";
            this.txtPageLeft.Size = new System.Drawing.Size(100, 21);
            this.txtPageLeft.TabIndex = 13;
            this.txtPageLeft.Text = "10";
            // 
            // txtPageTop
            // 
            this.txtPageTop.Location = new System.Drawing.Point(308, 64);
            this.txtPageTop.Name = "txtPageTop";
            this.txtPageTop.Size = new System.Drawing.Size(100, 21);
            this.txtPageTop.TabIndex = 14;
            this.txtPageTop.Text = "10";
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(414, 43);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(17, 12);
            this.label8.TabIndex = 15;
            this.label8.Text = "mm";
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Location = new System.Drawing.Point(414, 73);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(17, 12);
            this.label9.TabIndex = 16;
            this.label9.Text = "mm";
            // 
            // label10
            // 
            this.label10.AutoSize = true;
            this.label10.Location = new System.Drawing.Point(37, 249);
            this.label10.Name = "label10";
            this.label10.Size = new System.Drawing.Size(29, 12);
            this.label10.TabIndex = 17;
            this.label10.Text = "品牌";
            // 
            // txtBrand
            // 
            this.txtBrand.Location = new System.Drawing.Point(72, 240);
            this.txtBrand.Name = "txtBrand";
            this.txtBrand.Size = new System.Drawing.Size(100, 21);
            this.txtBrand.TabIndex = 18;
            this.txtBrand.Text = "神农客";
            // 
            // label11
            // 
            this.label11.AutoSize = true;
            this.label11.Location = new System.Drawing.Point(13, 285);
            this.label11.Name = "label11";
            this.label11.Size = new System.Drawing.Size(53, 12);
            this.label11.TabIndex = 19;
            this.label11.Text = "产品等级";
            // 
            // txtGrade
            // 
            this.txtGrade.Location = new System.Drawing.Point(72, 276);
            this.txtGrade.Name = "txtGrade";
            this.txtGrade.Size = new System.Drawing.Size(100, 21);
            this.txtGrade.TabIndex = 20;
            this.txtGrade.Text = "A1";
            // 
            // label12
            // 
            this.label12.AutoSize = true;
            this.label12.Location = new System.Drawing.Point(37, 318);
            this.label12.Name = "label12";
            this.label12.Size = new System.Drawing.Size(29, 12);
            this.label12.TabIndex = 21;
            this.label12.Text = "条码";
            // 
            // label13
            // 
            this.label13.AutoSize = true;
            this.label13.Location = new System.Drawing.Point(25, 349);
            this.label13.Name = "label13";
            this.label13.Size = new System.Drawing.Size(41, 12);
            this.label13.TabIndex = 22;
            this.label13.Text = "阅读码";
            // 
            // txtBarCode
            // 
            this.txtBarCode.Location = new System.Drawing.Point(72, 309);
            this.txtBarCode.Name = "txtBarCode";
            this.txtBarCode.Size = new System.Drawing.Size(326, 21);
            this.txtBarCode.TabIndex = 23;
            this.txtBarCode.Text = "123456789012345678901234";
            // 
            // txtReadCode
            // 
            this.txtReadCode.Location = new System.Drawing.Point(72, 340);
            this.txtReadCode.Name = "txtReadCode";
            this.txtReadCode.Size = new System.Drawing.Size(326, 21);
            this.txtReadCode.TabIndex = 24;
            this.txtReadCode.Text = "12345678901234567890123456789012";
            // 
            // txtBarCodeHeight
            // 
            this.txtBarCodeHeight.Location = new System.Drawing.Point(72, 139);
            this.txtBarCodeHeight.Name = "txtBarCodeHeight";
            this.txtBarCodeHeight.Size = new System.Drawing.Size(100, 21);
            this.txtBarCodeHeight.TabIndex = 25;
            this.txtBarCodeHeight.Text = "16";
            // 
            // label14
            // 
            this.label14.AutoSize = true;
            this.label14.Location = new System.Drawing.Point(13, 148);
            this.label14.Name = "label14";
            this.label14.Size = new System.Drawing.Size(53, 12);
            this.label14.TabIndex = 26;
            this.label14.Text = "条码高度";
            // 
            // label15
            // 
            this.label15.AutoSize = true;
            this.label15.Font = new System.Drawing.Font("宋体", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.label15.Location = new System.Drawing.Point(12, 209);
            this.label15.Name = "label15";
            this.label15.Size = new System.Drawing.Size(67, 14);
            this.label15.TabIndex = 27;
            this.label15.Text = "打印内容";
            // 
            // label16
            // 
            this.label16.AutoSize = true;
            this.label16.Location = new System.Drawing.Point(178, 148);
            this.label16.Name = "label16";
            this.label16.Size = new System.Drawing.Size(17, 12);
            this.label16.TabIndex = 28;
            this.label16.Text = "mm";
            // 
            // label17
            // 
            this.label17.AutoSize = true;
            this.label17.Location = new System.Drawing.Point(13, 176);
            this.label17.Name = "label17";
            this.label17.Size = new System.Drawing.Size(53, 12);
            this.label17.TabIndex = 29;
            this.label17.Text = "打印字体";
            // 
            // txtWordType
            // 
            this.txtWordType.Location = new System.Drawing.Point(72, 167);
            this.txtWordType.Name = "txtWordType";
            this.txtWordType.Size = new System.Drawing.Size(100, 21);
            this.txtWordType.TabIndex = 30;
            this.txtWordType.Text = "宋体";
            // 
            // label18
            // 
            this.label18.AutoSize = true;
            this.label18.Location = new System.Drawing.Point(249, 176);
            this.label18.Name = "label18";
            this.label18.Size = new System.Drawing.Size(53, 12);
            this.label18.TabIndex = 31;
            this.label18.Text = "打印字号";
            // 
            // txtWordSize
            // 
            this.txtWordSize.Location = new System.Drawing.Point(308, 167);
            this.txtWordSize.Name = "txtWordSize";
            this.txtWordSize.Size = new System.Drawing.Size(100, 21);
            this.txtWordSize.TabIndex = 32;
            this.txtWordSize.Text = "11";
            // 
            // label19
            // 
            this.label19.AutoSize = true;
            this.label19.Font = new System.Drawing.Font("宋体", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.label19.Location = new System.Drawing.Point(12, 110);
            this.label19.Name = "label19";
            this.label19.Size = new System.Drawing.Size(67, 14);
            this.label19.TabIndex = 33;
            this.label19.Text = "打印格式";
            // 
            // label20
            // 
            this.label20.AutoSize = true;
            this.label20.Location = new System.Drawing.Point(251, 147);
            this.label20.Name = "label20";
            this.label20.Size = new System.Drawing.Size(53, 12);
            this.label20.TabIndex = 34;
            this.label20.Text = "条码字号";
            // 
            // txtCodeSize
            // 
            this.txtCodeSize.Location = new System.Drawing.Point(308, 138);
            this.txtCodeSize.Name = "txtCodeSize";
            this.txtCodeSize.Size = new System.Drawing.Size(100, 21);
            this.txtCodeSize.TabIndex = 35;
            this.txtCodeSize.Text = "9";
            // 
            // btnSnkPrint
            // 
            this.btnSnkPrint.Location = new System.Drawing.Point(356, 416);
            this.btnSnkPrint.Name = "btnSnkPrint";
            this.btnSnkPrint.Size = new System.Drawing.Size(75, 23);
            this.btnSnkPrint.TabIndex = 36;
            this.btnSnkPrint.Text = "打印";
            this.btnSnkPrint.UseVisualStyleBackColor = true;
            this.btnSnkPrint.Click += new System.EventHandler(this.button1_Click);
            // 
            // lblParam
            // 
            this.lblParam.AutoSize = true;
            this.lblParam.Location = new System.Drawing.Point(27, 401);
            this.lblParam.Name = "lblParam";
            this.lblParam.Size = new System.Drawing.Size(0, 12);
            this.lblParam.TabIndex = 37;
            // 
            // BarCodeConfigForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(449, 520);
            this.Controls.Add(this.lblParam);
            this.Controls.Add(this.btnSnkPrint);
            this.Controls.Add(this.txtCodeSize);
            this.Controls.Add(this.label20);
            this.Controls.Add(this.label19);
            this.Controls.Add(this.txtWordSize);
            this.Controls.Add(this.label18);
            this.Controls.Add(this.txtWordType);
            this.Controls.Add(this.label17);
            this.Controls.Add(this.label16);
            this.Controls.Add(this.label15);
            this.Controls.Add(this.label14);
            this.Controls.Add(this.txtBarCodeHeight);
            this.Controls.Add(this.txtReadCode);
            this.Controls.Add(this.txtBarCode);
            this.Controls.Add(this.label13);
            this.Controls.Add(this.label12);
            this.Controls.Add(this.txtGrade);
            this.Controls.Add(this.label11);
            this.Controls.Add(this.txtBrand);
            this.Controls.Add(this.label10);
            this.Controls.Add(this.label9);
            this.Controls.Add(this.label8);
            this.Controls.Add(this.txtPageTop);
            this.Controls.Add(this.txtPageLeft);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.txtPageWidth);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.txtPageHeight);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.btnPrint);
            this.Name = "BarCodeConfigForm";
            this.Text = "BarCodeConfigForm";
            this.Load += new System.EventHandler(this.BarCodeConfigForm_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btnPrint;
        private System.Windows.Forms.PrintPreviewDialog printPreviewDialog1;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox txtPageHeight;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox txtPageWidth;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.TextBox txtPageLeft;
        private System.Windows.Forms.TextBox txtPageTop;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.Label label10;
        private System.Windows.Forms.TextBox txtBrand;
        private System.Windows.Forms.Label label11;
        private System.Windows.Forms.TextBox txtGrade;
        private System.Windows.Forms.Label label12;
        private System.Windows.Forms.Label label13;
        private System.Windows.Forms.TextBox txtBarCode;
        private System.Windows.Forms.TextBox txtReadCode;
        private System.Windows.Forms.TextBox txtBarCodeHeight;
        private System.Windows.Forms.Label label14;
        private System.Windows.Forms.Label label15;
        private System.Windows.Forms.Label label16;
        private System.Windows.Forms.Label label17;
        private System.Windows.Forms.TextBox txtWordType;
        private System.Windows.Forms.Label label18;
        private System.Windows.Forms.TextBox txtWordSize;
        private System.Windows.Forms.Label label19;
        private System.Windows.Forms.Label label20;
        private System.Windows.Forms.TextBox txtCodeSize;
        private System.Windows.Forms.Button btnSnkPrint;
        private System.Windows.Forms.Label lblParam;
    }
}

