using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Diagnostics;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using static System.Net.Mime.MediaTypeNames;

namespace PrintMain
{
    class Program
    {
        public static String downLoadPath = "";
        public static String bakUpPath = "";
        public static String btwPath = "";

        static void Main(string[] args)
        {

            try
            {

                string resourceDirectory = System.Environment.CurrentDirectory;
                String resourceFilePath = resourceDirectory + "\\resourcepath";
                StreamReader resourceSr = new StreamReader(resourceFilePath, Encoding.Default);
                string resourceSt = string.Empty;
                while (!resourceSr.EndOfStream)
                {
                    resourceSt = resourceSr.ReadLine();
                    String[] resourceSts = resourceSt.Split('=');
                    if (resourceSts[0].Equals("下载文件目录"))
                    {
                        Console.WriteLine(resourceSts[1]);
                        downLoadPath = resourceSts[1];
                    } else if (resourceSts[0].Equals("备份文件目录")) {
                        Console.WriteLine(resourceSts[1]);
                        bakUpPath = resourceSts[1];
                    } else if (resourceSts[0].Equals("btw文件目录")) {
                        Console.WriteLine(resourceSts[1]);
                        btwPath = resourceSts[1];
                    }
                }


                //WatcherStrat(@"D:\箱标签", "*.*");
                WatcherStrat(@downLoadPath, "*.*");
                Console.ReadKey();

            }
            catch (Exception ex)
            {
                Console.WriteLine("系统异常" + ex.Message);
            }
        }



        public static void print(String dataPath, BarTender.Format btFormat)
        {

            StreamReader sr = new StreamReader(dataPath, Encoding.Default);
            String breedName = "";
            String gradeName = "";
            String proLotNum = "";
            String productPirntNum = "";
            String line;
            String[] lines;
            while ((line = sr.ReadLine()) != null)
            {
                lines = line.Split('|');
                for (int i = 0; i < lines.Length; i++)
                {
                    //Console.WriteLine(lines[i]);
                    if (i == 0)
                    {
                        breedName = lines[i];
                    }
                    else if (i == 1)
                    {
                        gradeName = lines[i];
                    }
                    else if (i == 2)
                    {
                        proLotNum = lines[i];
                    }
                    else if (i == 3)
                    {
                        if (lines[i].Contains(","))
                        {                      //一页一页的打印，如2，3
                            String[] numArray = lines[i].Split(',');
                            for (int k = 0; k < numArray.Length; k++)
                            {
                                //Console.WriteLine(getPrintNum(numArray[k]));
                                productPirntNum = getPrintNum(numArray[k]);
                                btFormat.SetNamedSubStringValue("联合品牌名", breedName);
                                btFormat.SetNamedSubStringValue("产品等级", gradeName);
                                btFormat.SetNamedSubStringValue("条码", proLotNum + productPirntNum);
                                btFormat.PrintOut(false, false);
                                Thread.Sleep(1000);
                            }
                        }
                        else if (lines[i].Contains("-"))
                        {                                             //批量打印，如1-20         
                            String[] twoNumArray = lines[i].Split('-');
                            for (int k = int.Parse(twoNumArray[0]); k <= int.Parse(twoNumArray[1]); k++)
                            {
                                String numString = System.Convert.ToString(k);
                                //Console.WriteLine(getPrintNum(numString));
                                productPirntNum = getPrintNum(numString);
                                btFormat.SetNamedSubStringValue("联合品牌名", breedName);
                                btFormat.SetNamedSubStringValue("产品等级", gradeName);
                                btFormat.SetNamedSubStringValue("条码", proLotNum + productPirntNum);
                                btFormat.PrintOut(false, false);
                                Thread.Sleep(1000);
                            }
                        }
                        else {
                            String numString = System.Convert.ToString(lines[i]);
                            //Console.WriteLine(getPrintNum(numString));
                            productPirntNum = getPrintNum(numString);
                            btFormat.SetNamedSubStringValue("联合品牌名", breedName);
                            btFormat.SetNamedSubStringValue("产品等级", gradeName);
                            btFormat.SetNamedSubStringValue("条码", proLotNum + productPirntNum);
                            btFormat.PrintOut(false, false);                        
                            Thread.Sleep(1000);

                        }
                    }

                }

            }
            sr.Close();

        }



        public static String getPrintNum(String number)
        {
            if (number.Length == 1)
            {
                return "0000" + number;
            }
            else if (number.Length == 2)
            {
                return "000" + number;
            }
            else if (number.Length == 3)
            {
                return "00" + number;
            }
            else if (number.Length == 4)
            {
                return "0" + number;
            }
            else {
                return number;
            }

        }





        private static void WatcherStrat(string path, string filter)

        {

            FileSystemWatcher watcher = new FileSystemWatcher();       
            watcher.Path = path;
            watcher.Filter = filter;
            watcher.Changed += new FileSystemEventHandler(OnProcess);
            watcher.Created += new FileSystemEventHandler(OnProcess);
            watcher.Deleted += new FileSystemEventHandler(OnProcess);
            watcher.Renamed += new RenamedEventHandler(OnRenamed);
            watcher.EnableRaisingEvents = true;
            watcher.NotifyFilter = NotifyFilters.Attributes | NotifyFilters.CreationTime | NotifyFilters.DirectoryName | NotifyFilters.FileName | NotifyFilters.LastAccess
                                   | NotifyFilters.LastWrite | NotifyFilters.Security | NotifyFilters.Size;
            watcher.IncludeSubdirectories = true;

        }



        private static void OnProcess(object source, FileSystemEventArgs e)
        {
            if (e.ChangeType == WatcherChangeTypes.Created)
            {
                OnCreated(source, e);
            }
            /*
            else if (e.ChangeType == WatcherChangeTypes.Changed)
            {
                OnChanged(source, e);
            }
            else if (e.ChangeType == WatcherChangeTypes.Deleted)
            {
                OnDeleted(source, e);
            }*/

        }

        private static void OnCreated(object source, FileSystemEventArgs e)
        {
            //String tempPath = "D:\\箱标签\\箱标签.btw";
            String tempPath = btwPath+"\\箱标签.btw";
            BarTender.Application btApp;
            BarTender.Format btFormat;
            btApp = new BarTender.Application();
            btApp.Visible = false;
            btFormat = btApp.Formats.Open(@tempPath, false, "");
            print(e.FullPath, btFormat);
            btFormat.Close(BarTender.BtSaveOptions.btSaveChanges);
            btApp.Quit(BarTender.BtSaveOptions.btDoNotSaveChanges);
            //Console.WriteLine("文件新建事件处理逻辑 {0}  {1}  {2}", e.ChangeType, e.FullPath, e.Name);
            //Console.WriteLine(e.FullPath);
            //Console.WriteLine(e.Name);
            //File.Move(e.FullPath, "E" + e.FullPath.Substring(1));
            File.Move(downLoadPath+"\\"+e.Name, bakUpPath + "\\" + e.Name);
            File.Delete(e.FullPath);

        }

        private static void OnChanged(object source, FileSystemEventArgs e)
        {
            Console.WriteLine("文件改变事件处理逻辑{0}  {1}  {2}", e.ChangeType, e.FullPath, e.Name);
        }



        private static void OnDeleted(object source, FileSystemEventArgs e)
        {
            Console.WriteLine("文件删除事件处理逻辑{0}  {1}   {2}", e.ChangeType, e.FullPath, e.Name);
        }



        private static void OnRenamed(object source, RenamedEventArgs e)
        {
            Console.WriteLine("文件重命名事件处理逻辑{0}  {1}  {2}", e.ChangeType, e.FullPath, e.Name);
        }
    }

}
