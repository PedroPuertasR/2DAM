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
                        /* A través de las variables hijo iremos encontrando los menús de la aplicación
                         * notepad.exe , tendremos que movernos entre los hijos hasta encontrar el
                         * menú de ayuda.
                         */
                        var hijo = ventana.FindAllChildren();

                        hijo[3].Click();

                        var hijo2 = hijo[3].FindAllChildren();

                        hijo2[4].Click();

                        var hijo3 = hijo2[4].FindAllChildren();
                        var hijo4 = hijo3[0].FindAllChildren();

                        //Haciendo click en esta posición del hijo4 abriremos el panel Acerca de...
                        hijo4[2].Click();

                        //Esperamos un segundo para realizar la captura
                        Thread.Sleep(3000);

                        //Con la clase Capture realizaremos una foto de la pantalla principal
                        var captura = Capture.MainScreen();
                        //La guardamos con el nombre captura.png
                        captura.ToFile("captura.png");

                        //Justo después escribimos la frase celebre a través del método type de Keyboard
                        Keyboard.Type("Frase celebre: " + texto);

                        //Esperamos 3 segundos para guardar el texto y salir de la aplicación
                        Thread.Sleep(3000);

                        /* Realizamos las combinaciones de teclas que nos permitan guardar el archivo y
                         * salir. En nuestro caso un Alt + F4, escritura del nombre, ENTER para guardar
                         * y en caso de que tengamos que sobreescribir TAB + ENTER para pulsar en Sí
                         */
                        Keyboard.Press(FlaUI.Core.WindowsAPI.VirtualKeyShort.ALT);
                        Keyboard.Press(FlaUI.Core.WindowsAPI.VirtualKeyShort.F4);
                        Keyboard.Release(FlaUI.Core.WindowsAPI.VirtualKeyShort.ALT);
                        Keyboard.Release(FlaUI.Core.WindowsAPI.VirtualKeyShort.F4);
                        Keyboard.Press(FlaUI.Core.WindowsAPI.VirtualKeyShort.ENTER);
                        Keyboard.Release(FlaUI.Core.WindowsAPI.VirtualKeyShort.ENTER);
                        //Indicamos el nombre del archivo
                        Keyboard.Type("texto.txt");
                        Keyboard.Press(FlaUI.Core.WindowsAPI.VirtualKeyShort.ENTER);
                        Keyboard.Release(FlaUI.Core.WindowsAPI.VirtualKeyShort.ENTER);
                        Keyboard.Press(FlaUI.Core.WindowsAPI.VirtualKeyShort.TAB);
                        Keyboard.Press(FlaUI.Core.WindowsAPI.VirtualKeyShort.ENTER);
                        Keyboard.Release(FlaUI.Core.WindowsAPI.VirtualKeyShort.TAB);
                        Keyboard.Release(FlaUI.Core.WindowsAPI.VirtualKeyShort.ENTER);

                        Thread.Sleep(3000);

                        //Cerramos la aplicación
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