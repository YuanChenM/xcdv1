using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace snkBarCode
{
    static class Program
    {
        /// <summary>
        /// 应用程序的主入口点。
        /// </summary>
        [STAThread]
        static void Main(string[] args)
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);

            if (args.Length > 0)
            {
                string[] param = args[0].Split('&');
                if (param.Length >= 1)
                {
                    string str = param[1];
                    try
                    {
                        string total = param[2];
                        int totalCount = Convert.ToInt32(total);

                        if (String.IsNullOrEmpty(param[3]))
                        {
                            Application.Run(new PrintForm(str, totalCount));
                        }
                        else
                        {
                            string environment = param[3];
                            Application.Run(new PrintForm(str, totalCount, environment));
                        }
                    }
                    catch
                    {
                        Application.Run(new PrintForm(str));
                    }
                    
                    
                }
                else
                {
                    Application.Run(new PrintForm());
                }
            }
            else
            {
                Application.Run(new FilePrintForm());
            }
        }
    }
}
