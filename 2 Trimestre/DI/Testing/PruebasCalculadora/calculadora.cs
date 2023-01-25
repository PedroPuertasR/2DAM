using FlaUI.Core;
using FlaUI.UIA2;

namespace PruebasCalculadora
{
    internal class calculadora
    {
        static void Main(string[] args)
        {
            using (var app = Application.Launch(@"C:\Program Files\OldClassicCalc\calc1.exe"))
            {
                using (var automatizacion = new UIA2Automation())
                {
                    var ventana = app.GetMainWindow(automatizacion);

                    var lista_hijos = ventana.FindAllChildren()[0].FindAllChildren();
                    var sumar = ventana.FindAllChildren()[0].FindFirstChild(e => e.ByName("Sumar"));

                    var n1 = ventana.FindAllChildren()[0].FindFirstChild(e => e.ByName("1"));
                    var n2 = ventana.FindAllChildren()[0].FindFirstChild(e => e.ByName("2"));
                    var n3 = ventana.FindAllChildren()[0].FindFirstChild(e => e.ByName("3"));
                    var n4 = ventana.FindAllChildren()[0].FindFirstChild(e => e.ByName("4"));
                    var n5 = ventana.FindAllChildren()[0].FindFirstChild(e => e.ByName("5"));
                    var n6 = ventana.FindAllChildren()[0].FindFirstChild(e => e.ByName("6"));
                    var n7 = ventana.FindAllChildren()[0].FindFirstChild(e => e.ByName("7"));
                    var n8 = ventana.FindAllChildren()[0].FindFirstChild(e => e.ByName("8"));
                    var n9 = ventana.FindAllChildren()[0].FindFirstChild(e => e.ByName("9"));

                    var igual = ventana.FindAllChildren()[0].FindFirstChild(e => e.ByName("Igual a"));

                    n1.Click();
                    sumar.Click();
                    n6.Click();
                    igual.Click();
                }
            }
        }
    }
}
