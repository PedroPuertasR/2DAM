namespace Operaciones
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Operacion media = new Operacion(10, 30, 'm');
            Console.WriteLine("La media es: " + media.GetRealResult());
        }
    }
}