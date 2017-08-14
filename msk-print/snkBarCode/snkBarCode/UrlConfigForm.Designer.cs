namespace snkBarCode
{
    partial class UrlConfigForm
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
            this.btnSave = new System.Windows.Forms.Button();
            this.btnReturn = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.txtTestUrl = new System.Windows.Forms.TextBox();
            this.txtUatUrl = new System.Windows.Forms.TextBox();
            this.txtProUrl = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // btnSave
            // 
            this.btnSave.Location = new System.Drawing.Point(91, 131);
            this.btnSave.Name = "btnSave";
            this.btnSave.Size = new System.Drawing.Size(100, 30);
            this.btnSave.TabIndex = 0;
            this.btnSave.Text = "保存";
            this.btnSave.UseVisualStyleBackColor = true;
            this.btnSave.Click += new System.EventHandler(this.btnSave_Click);
            // 
            // btnReturn
            // 
            this.btnReturn.Location = new System.Drawing.Point(308, 131);
            this.btnReturn.Name = "btnReturn";
            this.btnReturn.Size = new System.Drawing.Size(100, 30);
            this.btnReturn.TabIndex = 1;
            this.btnReturn.Text = "返回";
            this.btnReturn.UseVisualStyleBackColor = true;
            this.btnReturn.Click += new System.EventHandler(this.btnReturn_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(30, 25);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(71, 12);
            this.label1.TabIndex = 2;
            this.label1.Text = "测试环境Url";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(32, 61);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(65, 12);
            this.label2.TabIndex = 3;
            this.label2.Text = "UAT环境Url";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(32, 96);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(71, 12);
            this.label3.TabIndex = 4;
            this.label3.Text = "正式环境Url";
            // 
            // txtTestUrl
            // 
            this.txtTestUrl.Location = new System.Drawing.Point(114, 19);
            this.txtTestUrl.Name = "txtTestUrl";
            this.txtTestUrl.Size = new System.Drawing.Size(339, 21);
            this.txtTestUrl.TabIndex = 5;
            // 
            // txtUatUrl
            // 
            this.txtUatUrl.Location = new System.Drawing.Point(114, 56);
            this.txtUatUrl.Name = "txtUatUrl";
            this.txtUatUrl.Size = new System.Drawing.Size(339, 21);
            this.txtUatUrl.TabIndex = 6;
            // 
            // txtProUrl
            // 
            this.txtProUrl.Location = new System.Drawing.Point(114, 92);
            this.txtProUrl.Name = "txtProUrl";
            this.txtProUrl.Size = new System.Drawing.Size(339, 21);
            this.txtProUrl.TabIndex = 7;
            // 
            // UrlConfigForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(485, 173);
            this.Controls.Add(this.txtProUrl);
            this.Controls.Add(this.txtUatUrl);
            this.Controls.Add(this.txtTestUrl);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.btnReturn);
            this.Controls.Add(this.btnSave);
            this.Name = "UrlConfigForm";
            this.Text = "UrlConfigForm";
            this.Load += new System.EventHandler(this.UrlConfigForm_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btnSave;
        private System.Windows.Forms.Button btnReturn;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox txtTestUrl;
        private System.Windows.Forms.TextBox txtUatUrl;
        private System.Windows.Forms.TextBox txtProUrl;
    }
}