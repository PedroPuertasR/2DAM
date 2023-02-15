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
                         * notepad.exe , tendremos que movernos buscando por el nombre los diferentes menús.
                         */

                        Keyboard.Type("Accediendo al menu de acerca de...\n");

                        Thread.Sleep(1500);

                        var hijo = ventana!.FindFirstDescendant(e => e.ByName("Ayuda"));

                        hijo!.Click();

                        hijo = ventana!.FindFirstDescendant(e => e.ByName("Acerca del Bloc de notas"));

                        hijo!.Click();

                        //Esperamos un segundo para realizar la captura
                        Thread.Sleep(3000);

                        //Con la clase Capture realizaremos una foto de la pantalla principal
                        var captura = Capture.MainScreen();
                        //La guardamos con el nombre captura.png
                        captura.ToFile("captura.png");

                        Thread.Sleep(2000);

                        //Cerramos la ventana de acerca de...
                        hijo = ventana!.FindFirstDescendant(e => e.ByName("Cerrar"));

                        hijo!.Click();

                        Keyboard.Type("Captura realizada. Introduciendo frase celebre:\n");

                        Thread.Sleep(2000);

                        //Justo después escribimos la frase celebre a través del método type de Keyboard
                        Keyboard.Type("Frase celebre: " + texto);

                        //Esperamos 3 segundos para guardar el texto y salir de la aplicación
                        Thread.Sleep(1000);

                        Keyboard.Type("\nGuardando y cerrando...");

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