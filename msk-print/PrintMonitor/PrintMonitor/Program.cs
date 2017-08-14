using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace PrintMonitor
{
    class Program
    {
        static void Main(string[] args)
        {
            try
            {
                String monitorPath = "";
                string resourceDirectory = System.Environment.CurrentDirectory;
                String resourceFilePath = resourceDirectory + "\\resourcepath";
                StreamReader resourceSr = new StreamReader(resourceFilePath, Encoding.Default);
                string resourceSt = string.Empty;
                while (!resourceSr.EndOfStream)
                {
                    resourceSt = resourceSr.ReadLine();
                    String[] resourceSts = resourceSt.Split('=');
                    if (resourceSts[0].Equals("监控程序目录")) {
                        Console.WriteLine(resourceSts[1]);
                        monitorPath = resourceSts[1];
                    }
                }
                
                while (true)
                {

                    Boolean boolStart = false;
                    Process[] ps = Process.GetProcesses();
                    foreach (Process p in ps)
                    {
                        //Console.WriteLine(p.ProcessName);
                        if (p.ProcessName == "PrintMain")
                        {
                            boolStart = true;
                        }

                    }
                    Process process = new Process();
                    if (boolStart == false)
                    {
                        //process.StartInfo.FileName = "D:\\Documents\\Visual Studio 2015\\Projects\\PrintMain\\PrintMain\\bin\\Debug\\PrintMain.exe";
                        process.StartInfo.FileName = monitorPath+"\\PrintMain.exe";
                        process.Start();
                    }

                    Thread.Sleep(100);
                }
            }
            catch (Exception e)
            {
                Console.WriteLine("系统异常" + e.Message);
            }

        }
    }
}
