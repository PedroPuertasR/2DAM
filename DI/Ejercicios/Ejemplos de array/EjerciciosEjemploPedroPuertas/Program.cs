namespace EjerciciosEjemploPedroPuertas
{

    internal class Program
    {
        static void Main(string[] args)
        {
            //Declaramos un array de string con algunos nombres ya introducidos
            //string[] nombres = { "Pedro", "Alberto", "Pablo", "Miguel", "David"};

            /*También podemos declarar el array con un tamaño para después añadirle 
             * los nombres que queramos.
             */
            //string[] nombres = new string [4];

            //O incluso declararlo sin un tamaño específico e ir añadiendo más tarde
            string[] nombres= new string[] {};

            //Variable para controlar la cantidad de nombres del array
            int cantidad = 0;

            nombres[cantidad++] = "Pedro";
            nombres[cantidad++] = "Alberto";
            nombres[cantidad++] = "Pablo";
            nombres[cantidad++] = "Miguel";
            nombres[cantidad++] = "David";

            /*
            nombres[0] = "Javier";
            nombres[1] = "Pablo";
            */

            /*En este ejemplo con el bucle for saludaremos a todos aquellos que se
             * encuentran en nuestro array.
            */
            foreach(string n in nombres)
            {
                System.Console.WriteLine("Bienvenido, {0}!", n);
            }

            /*Para el siguiente ejemplo declararemos la variable lectura, 
             * para leer por teclado un nombre.
             */
            string lectura;

            System.Console.WriteLine("Indique el nombre del invitado:");
            lectura = Console.ReadLine();

            /*Con esta lectura pondremos la condición en el for de que en el
             * momento en que encuentre el nombre en nuestro array salga del bucle.
             */
            for (int i = 0; i < nombres.Length && 
                lectura.ToLower() != nombres[i].ToLower(); i++)
            {
                /*También anunciaremos en la consola que el nombre se encuentra en
                 * lista, como si fuera una invitación a una fiesta.
                */
                if (lectura.ToLower() == nombres[i].ToLower())
                {
                    System.Console.WriteLine("¡El nombre está en la lista!");
                }
                else
                {
                    System.Console.WriteLine("El nombre no ha sido encontrado.");
                }
            }

            /*Declaramos la variable borrado para leer por teclado el nombre 
             * que queremos reemplazar.
             */
            string borrado;

            System.Console.WriteLine("Indique el nombre a borrar:");
            borrado = System.Console.ReadLine();

            //Volveremos a usar lectura para leer el nuevo nombre.
            System.Console.WriteLine("Indique el nuevo nombre");
            lectura = System.Console.ReadLine();

            /* En el siguiente bucle for pondremos una condición con la que comprobaremos
             * si el nombre que queremos borrar está en el array
             */
            for (int i = 0; i < nombres.Length && borrado.ToLower() == nombres[i].ToLower(); i++)
            {
                /* En caso de que el nombre se encuentre en nuestro array cambiaremos el
                 * anterior por el nuevo
                 */
                if (nombres[i].ToLower() == borrado.ToLower())
                {
                    nombres[i] = borrado;
                    System.Console.WriteLine("Nombre reemplazado!");
                }
                else
                {
                    System.Console.WriteLine("No se ha encontrado el nombre en la lista.");
                }
            }

            System.Console.WriteLine("Indique el nombre que desea insertar:");

            lectura = System.Console.ReadLine();

            /*Con la lectura por teclado podremos introducir el nombre dentro de 
             * nuestro array. Además gracias a la variable cantidad podremos tener
             * el control del índice de este.
             */
            nombres[cantidad++] = lectura;
        }
    }
}