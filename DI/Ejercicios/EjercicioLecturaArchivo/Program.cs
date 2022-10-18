namespace EjercicioMP3
{
    internal class Program
    {
        static void Main(string[] args)
        {

            //Ruta del archivo
            string nombre = @"C:\Users\Administrador\Desktop\sonido.mp3";

            //Lectura del archivo
            BinaryReader fichero = new BinaryReader(File.Open(nombre, FileMode.Open));

            /*Buscamos el byte 16, en el cual se encuentra la información 
             del copyright del archivo*/
            fichero.BaseStream.Seek(16, SeekOrigin.Begin);

            //En esta variable byte guardaremos lo leido.
            byte lectura = fichero.ReadByte();

            //Además dividiremos la lectura por 128 para sacar los bits del archivo
            int total = lectura / 128;

            System.Console.WriteLine("Copyright:\n");
            System.Console.WriteLine("Lectura: " + total);

            /* Con esta condición comprobaremos si tiene o no copyright. En caso de
            * que tenga se mostrará un 1 y en caso de que no un 0
            */
            if (total == 1)
            {
                System.Console.WriteLine("El audio tiene copyright.\n");
            }
            else
            {
                System.Console.WriteLine("El audio no tiene copyright.\n");
            }

            //Ahora buscaremos el modo de canal del archivo, se encuentra en los bytes 6 y 7
            fichero.BaseStream.Seek(6, SeekOrigin.Begin);

            lectura = fichero.ReadByte();

            total = lectura / 128;

            byte lectura2 = fichero.ReadByte();

            int total2 = lectura / 128;

            //Tras realizar los calculos cerramos el flujo
            fichero.close();

            System.Console.WriteLine("Modo de canal:\n");

            System.Console.WriteLine("Lectura: {0} y {1}", total, total2);

            /* En este caso la condición sera diferente, puesto que tenemos que
            * comprobar dos números. Juntos estos dos nos darán una combinación
            * que nos informarán del modo de canal como podemos observar abajo
            */
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