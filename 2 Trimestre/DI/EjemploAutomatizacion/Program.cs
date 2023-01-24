using FlaUI.Core;
using FlaUI.Core.AutomationElements;
using FlaUI.Core.Capturing;
using FlaUI.Core.Conditions;
using FlaUI.Core.Definitions;
using FlaUI.Core.Input;
using FlaUI.UIA2;
using System.Diagnostics;

namespace EjemploAutomatizacion
{
    internal class Program
    {
        static void Main(string[] args)
        {
            using (var app = Application.Launch("notepad.exe"))
            {
                using (var automatizacion = new UIA2Automation())
                {
                    string texto = "No hay que ir para atrás ni para darse impulso - (Lao Tsé)";
                    var ventana = app.GetMainWindow(automatizacion);

                    if (ventana != null)
                    {
                        var hijo = ventana.FindAllChildren();

                        hijo[3].Click();

                        var hijo2 = hijo[3].FindAllChildren();

                        hijo2[4].Click();

                        var hijo3 = hijo2[4].FindAllChildren();
                        var hijo4 = hijo3[0].FindAllChildren();

                        hijo4[2].Click();

                        Thread.Sleep(1000);

                        Keyboard.Type("Frase celebre: " + texto);

                        Thread.Sleep(1000);

                        var captura = Capture.MainScreen();
                        captura.ToFile("captura.png");

                        Keyboard.Press(FlaUI.Core.WindowsAPI.VirtualKeyShort.ALT);
                        Keyboard.Press(FlaUI.Core.WindowsAPI.VirtualKeyShort.F4);
                        Keyboard.Release(FlaUI.Core.WindowsAPI.VirtualKeyShort.ALT);
                        Keyboard.Release(FlaUI.Core.WindowsAPI.VirtualKeyShort.F4);
                        Keyboard.Press(FlaUI.Core.WindowsAPI.VirtualKeyShort.ENTER);
                        Keyboard.Release(FlaUI.Core.WindowsAPI.VirtualKeyShort.ENTER);
                        Keyboard.Type("texto.txt");
                        Keyboard.Press(FlaUI.Core.WindowsAPI.VirtualKeyShort.ENTER);
                        Keyboard.Release(FlaUI.Core.WindowsAPI.VirtualKeyShort.ENTER);
                        Keyboard.Press(FlaUI.Core.WindowsAPI.VirtualKeyShort.TAB);
                        Keyboard.Press(FlaUI.Core.WindowsAPI.VirtualKeyShort.ENTER);
                        Keyboard.Release(FlaUI.Core.WindowsAPI.VirtualKeyShort.TAB);
                        Keyboard.Release(FlaUI.Core.WindowsAPI.VirtualKeyShort.ENTER);

                        Thread.Sleep(3000);

                        app.Close();

                    }

                    Console.WriteLine("Elementos de la Ventana: ");

                    var listaElementos = ventana!.FindAllDescendants();

                    foreach (var element in listaElementos)
                    {
                        Console.WriteLine(element.Name);
                    }
                }
                app.Close();
            }
        }
}
}