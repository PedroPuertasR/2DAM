using Operaciones;

namespace TestProject1
{

    [TestFixture]
    public class Tests
    {
        [SetUp]
        public void Setup()
        {
        }

        [Test]
        public void GetIntResult_Addition_ReturnsCorrectResult()
        {

            var operacion = new Operacion(5, 3, '+');

            var result = operacion.GetIntResult();

            Assert.That(result, Is.EqualTo(8));
        }
    }
}