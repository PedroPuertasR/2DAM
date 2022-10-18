namespace EjercicioMP3
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string nombre = @"C:\Users\Administrador\Desktop\sonido.mp3";

            BinaryReader fichero = new BinaryReader(File.Open(nombre, FileMode.Open));

            fichero.BaseStream.Seek(16, SeekOrigin.Begin);

            byte lectura = fichero.ReadByte();

            int total = lectura / 128;

            System.Console.WriteLine("Copyright:\n");
            System.Console.WriteLine("Lectura: " + total);

            if (total == 1)
            {
                System.Console.WriteLine("El audio tiene copyright.\n");
            }
            else
            {
                System.Console.WriteLine("El audio no tiene copyright.\n");
            }

            fichero.BaseStream.Seek(6, SeekOrigin.Begin);

            lectura = fichero.ReadByte();

            total = lectura / 128;

            byte lectura2 = fichero.ReadByte();

            int total2 = lectura / 128;

            System.Console.WriteLine("Modo de canal:\n");

            System.Console.WriteLine("Lectura: {0} y {1}", total, total2);

            if (total == 0 && total2 == 0)
            {
                System.Console.WriteLine("El modo de canal es Stereo.");
            }else if(total == 0 && total2 == 1)
            {
                System.Console.WriteLine("El modo de canal es Joint Stereo.");
            }else if(total == 1 && total2 == 0)
            {
                System.Console.WriteLine("El modo de canal es Dual mono channel.");
            }
            else
            {
                System.Console.WriteLine("El modo de canal es Mono channel.");
            }

        }
    }
}