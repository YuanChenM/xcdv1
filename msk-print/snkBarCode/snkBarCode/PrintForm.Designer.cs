namespace snkBarCode
{
    partial class PrintForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.btnPrintSetting = new System.Windows.Forms.Button();
            this.btnClose = new System.Windows.Forms.Button();
            this.btnPrint = new System.Windows.Forms.Button();
            this.lblContent = new System.Windows.Forms.Label();
            this.btnFilePrint = new System.Windows.Forms.Button();
            this.btnUrlSetting = new System.Windows.Forms.Button();
            this.btnReadData = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // btnPrintSetting
            // 
            this.btnPrintSetting.Location = new System.Drawing.Point(26, 12);
            this.btnPrintSetting.Name = "btnPrintSetting";
            this.btnPrintSetting.Size = new System.Drawing.Size(100, 25);
            this.btnPrintSetting.TabIndex = 0;
            this.btnPrintSetting.Text = "打印设置";
            this.btnPrintSetting.UseVisualStyleBackColor = true;
            this.btnPrintSetting.Click += new System.EventHandler(this.btnPrintSetting_Click);
            // 
            // btnClose
            // 
            this.btnClose.Location = new System.Drawing.Point(26, 142);
            this.btnClose.Name = "btnClose";
            this.btnClose.Size = new System.Drawing.Size(100, 30);
            this.btnClose.TabIndex = 1;
            this.btnClose.Text = "关闭";
            this.btnClose.UseVisualStyleBackColor = true;
            this.btnClose.Click += new System.EventHandler(this.btnClose_Click);
            // 
            // btnPrint
            // 
            this.btnPrint.Location = new System.Drawing.Point(342, 142);
            this.btnPrint.Name = "btnPrint";
            this.btnPrint.Size = new System.Drawing.Size(100, 30);
            this.btnPrint.TabIndex = 2;
            this.btnPrint.Text = "打印";
            this.btnPrint.UseVisualStyleBackColor = true;
            this.btnPrint.Click += new System.EventHandler(this.btnPrint_Click);
            // 
            // lblContent
            // 
            this.lblContent.AutoSize = true;
            this.lblContent.Location = new System.Drawing.Point(105, 67);
            this.lblContent.Name = "lblContent";
            this.lblContent.Size = new System.Drawing.Size(0, 12);
            this.lblContent.TabIndex = 3;
            // 
            // btnFilePrint
            // 
            this.btnFilePrint.Location = new System.Drawing.Point(342, 104);
            this.btnFilePrint.Name = "btnFilePrint";
            this.btnFilePrint.Size = new System.Drawing.Size(100, 30);
            this.btnFilePrint.TabIndex = 4;
            this.btnFilePrint.Text = "数据文件打印";
            this.btnFilePrint.UseVisualStyleBackColor = true;
            this.btnFilePrint.Click += new System.EventHandler(this.btnFilePrint_Click);
            // 
            // btnUrlSetting
            // 
            this.btnUrlSetting.Location = new System.Drawing.Point(181, 12);
            this.btnUrlSetting.Name = "btnUrlSetting";
            this.btnUrlSetting.Size = new System.Drawing.Size(100, 25);
            this.btnUrlSetting.TabIndex = 5;
            this.btnUrlSetting.Text = "环境地址设置";
            this.btnUrlSetting.UseVisualStyleBackColor = true;
            this.btnUrlSetting.Click += new System.EventHandler(this.btnUrlSetting_Click);
            // 
            // btnReadData
            // 
            this.btnReadData.Location = new System.Drawing.Point(181, 142);
            this.btnReadData.Name = "btnReadData";
            this.btnReadData.Size = new System.Drawing.Size(100, 30);
            this.btnReadData.TabIndex = 6;
            this.btnReadData.Text = "查看数据";
            this.btnReadData.UseVisualStyleBackColor = true;
            this.btnReadData.Click += new System.EventHandler(this.btnReadData_Click);
            // 
            // PrintForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(477, 194);
            this.Controls.Add(this.btnReadData);
            this.Controls.Add(this.btnUrlSetting);
            this.Controls.Add(this.btnFilePrint);
            this.Controls.Add(this.lblContent);
            this.Controls.Add(this.btnPrint);
            this.Controls.Add(this.btnClose);
            this.Controls.Add(this.btnPrintSetting);
            this.Name = "PrintForm";
            this.Text = "PrintForm";
            this.Load += new System.EventHandler(this.PrintForm_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btnPrintSetting;
        private System.Windows.Forms.Button btnClose;
        private System.Windows.Forms.Button btnPrint;
        private System.Windows.Forms.Label lblContent;
        private System.Windows.Forms.Button btnFilePrint;
        private System.Windows.Forms.Button btnUrlSetting;
        private System.Windows.Forms.Button btnReadData;
    }
}