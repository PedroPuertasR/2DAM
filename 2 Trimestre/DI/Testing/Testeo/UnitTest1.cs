using FlaUI.Core;
using FlaUI.Core.AutomationElements;
using FlaUI.UIA2;

namespace Testeo
{

    public class Tests
    {
        Application app;
        Window ventana;
        UIA2Automation automatizacion;
        private AutomationElement sumar;
        private AutomationElement restar;
        private AutomationElement multi;
        private AutomationElement div;
        private AutomationElement n0;
        private AutomationElement n1;
        private AutomationElement n2;
        private AutomationElement n3;
        private AutomationElement n4;
        private AutomationElement n5;
        private AutomationElement n6;
        private AutomationElement n7;
        private AutomationElement n8;
        private AutomationElement n9;
        private AutomationElement igual;

        [SetUp]
        public void Setup()
        {
            app = Application.Launch(@"C:\Program Files\OldClassicCalc\calc1.exe");
            
            automatizacion = new UIA2Automation();

            ventana = app.GetMainWindow(automatizacion);

            sumar = ventana.FindAllChildren()[0].FindFirstChild(e => e.ByName("Sumar"));
            restar = ventana.FindAllChildren()[0].FindFirstChild(e => e.ByName("Restar"));
            multi = ventana.FindAllChildren()[0].FindFirstChild(e => e.ByName("Multiplicar"));
            div = ventana.FindAllChildren()[0].FindFirstChild(e => e.ByName("Dividir"));

            n0 = ventana.FindAllChildren()[0].FindFirstChild(e => e.ByAutomationId("130"));
            n1 = ventana.FindAllChildren()[0].FindFirstChild(e => e.ByName("1"));
            n2 = ventana.FindAllChildren()[0].FindFirstChild(e => e.ByName("2"));
            n3 = ventana.FindAllChildren()[0].FindFirstChild(e => e.ByName("3"));
            n4 = ventana.FindAllChildren()[0].FindFirstChild(e => e.ByName("4"));
            n5 = ventana.FindAllChildren()[0].FindFirstChild(e => e.ByName("5"));
            n6 = ventana.FindAllChildren()[0].FindFirstChild(e => e.ByName("6"));
            n7 = ventana.FindAllChildren()[0].FindFirstChild(e => e.ByName("7"));
            n8 = ventana.FindAllChildren()[0].FindFirstChild(e => e.ByName("8"));
            n9 = ventana.FindAllChildren()[0].FindFirstChild(e => e.ByName("9"));

            igual = ventana.FindAllChildren()[0].FindFirstChild(e => e.ByName("Igual a"));

        }

        [Test]
        public void ComprobarSuma()
        {
            n1.Click();
            sumar.Click();
            n2.Click();
            igual.Click();
            var salida = igual = ventana.FindAllChildren()[0].FindFirstChild(e => e.ByAutomationId("150"));
            var result = Convert.ToInt32(salida.Name);
            Assert.That(result, Is.EqualTo(3));
        }

        [Test]
        public void ComprobarResta()
        {
            n9.Click(); 
            restar.Click();
            n2.Click();
            igual.Click();
            var salida = igual = ventana.FindAllChildren()[0].FindFirstChild(e => e.ByAutomationId("150"));
            var result = Convert.ToInt32(salida.Name);
            Assert.That(result, Is.EqualTo(7));
        }

        [Test]
        public void ComprobarMult()
        {
            n9.Click();
            multi.Click();
            n5.Click();
            igual.Click();
            var salida = igual = ventana.FindAllChildren()[0].FindFirstChild(e => e.ByAutomationId("150"));
            var result = Convert.ToInt32(salida.Name);
            Assert.That(result, Is.EqualTo(45));
        }

        [Test]
        public void ComprobarDiv()
        {
            n8.Click();
            div.Click();
            n2.Click();
            igual.Click();
            var salida = igual = ventana.FindAllChildren()[0].FindFirstChild(e => e.ByAutomationId("150"));
            var result = Convert.ToInt32(salida.Name);
            Assert.That(result, Is.EqualTo(4));
        }

        [Test]
        public void ComprobarDivCero()
        {
            n9.Click();
            div.Click();
            n0.Click();
            igual.Click();
            var salida = igual = ventana.FindAllChildren()[0].FindFirstChild(e => e.ByAutomationId("150"));
            var result = salida.Name;
            Assert.That(result, Is.EquivalentTo("No se puede dividir entre cero"));
        }
    }
}