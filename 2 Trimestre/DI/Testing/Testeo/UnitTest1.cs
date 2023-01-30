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
            //Instanciamos la aplicación
            app = Application.Launch(@"C:\Program Files\OldClassicCalc\calc1.exe");
            
            //Instanciamos la automatización
            automatizacion = new UIA2Automation();

            //Instanciamos la ventana principal también
            ventana = app.GetMainWindow(automatizacion);

            /*Instanciamos los botones de las operaciones de la calculadora. Estos los encontramos
             * utilizando el método FindAllChildren y la posición 0 (en la que se localizan los
             * botones) y utilizando FindFirstChild con un lambda para encontrarlo a través
             * del nombre.
             */
            sumar = ventana.FindAllChildren()[0].FindFirstChild(e => e.ByName("Sumar"));
            restar = ventana.FindAllChildren()[0].FindFirstChild(e => e.ByName("Restar"));
            multi = ventana.FindAllChildren()[0].FindFirstChild(e => e.ByName("Multiplicar"));
            div = ventana.FindAllChildren()[0].FindFirstChild(e => e.ByName("Dividir"));

            /*Realizamos la misma operación que con los botones anteriores para instanciar los
             * números y el "Igual a...". La única excepción es que tendremos que buscar el
             * 0 con un ID, puesto que no se puede encontrar por nombre, ya que muchos tienen
             * el mismo que el 0.
             */
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

        /*Realizamos un test con la suma utilizando 1 + 2 = 3. Convertimos el resultado a int y con el
         * Assert comprobamos que se sume bien.
         */
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

        /*Realizamos un test con la resta utilizando 9 - 2 = 7. Convertimos el resultado a int y con el
         * Assert comprobamos que se reste bien.
         */
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

        /* En esta ocasión será un test para comprobar la multiplicación de 9 * 5 = 45. Convertimos 
         * el resultado a int y con el Assert comprobamos que se multiplique bien.
         */
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

        /* También hacemos un test para comprobar la división de 8 / 2 = 4. Convertimos el resultado en
         * int y lo igualamos a la solución que debería dar.
         */
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

        /* Por último comprobamos que si intentamos dividir entre 0 de la solución correcta, la cual debería
         * ser que no se puede dividir por cero. Por lo que no convertimos a int, puesto que nos devolverá
         * un string con el mensaje. Esto lo pasamos por el Assert
         */
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