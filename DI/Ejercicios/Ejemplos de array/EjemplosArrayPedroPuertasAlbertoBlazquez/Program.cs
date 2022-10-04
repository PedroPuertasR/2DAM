/* Realizado por Pedro Puertas Rodríguez y Alberto Miguel Blázquez Caraballo
 * Ejemplos de Arrays unidimensionales.
 */

namespace EjemplosArrayPedroPuertasAlbertoBlazquez
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //////////////////////////////////////
            ///TIPOS DE DECLARACIONES///
            //////////////////////////////////////

            //Declaramos un array de string con algunos números ya introducidos
            //string[] nombres = {7, 2, 5, 12, 25};

            /*También podemos declarar el array con un tamaño para después añadirle 
             * los números que queramos.
             */
            int[] numeros = new int[7];

            //Variable para controlar la cantidad de números del array
            int cantidad = 0;

            numeros[cantidad++] = 7;
            numeros[cantidad++] = 2;
            numeros[cantidad++] = 5;
            numeros[cantidad++] = 12;
            numeros[cantidad++] = 25;

            /*
            numeros[0] = 4;
            numeros[1] = 3;
            */

            //////////////////////////////////
            ///RECORRER EL ARRAY///
            //////////////////////////////////

            /*En este ejemplo con el bucle for mostraremos a todos aquellos que se
             * encuentran en nuestro array.
            */

            for (int i = 0; i < numeros.Length; i++)
            {
                if (numeros[i] != 0)
                {
                    System.Console.WriteLine("Nº: {0}!", numeros[i]);
                }
            }
            System.Console.WriteLine("-----------------------------------");
            System.Console.WriteLine("Comprobar si existe un número en el array");

            /*Para el siguiente ejemplo declararemos la variable lectura, 
             * para leer por teclado un nombre.
             */
            int lectura;

            System.Console.WriteLine("Indique el número a revisar");
            lectura = System.Convert.ToInt32(System.Console.ReadLine());

            /*Con esta lectura pondremos la condición en el for de que en el
             * momento en que encuentre el número de la lecutra en nuestro array 
             * salga del bucle.
             */

            for (int i = 0; i < numeros.Length; i++)
            {
                /*También anunciaremos en la consola que el número se encuentra en
                 * la lista.
                */
                if (lectura == numeros[i])
                {
                    System.Console.WriteLine("¡El número está en la lista!");
                    break;
                }
                else if (i == cantidad - 1 && lectura != numeros[i])
                {
                    System.Console.WriteLine("No se ha encontrado el número en la lista.");
                }
            }

            ///////////////////////////////
            ///MODIFICAR UN VALOR///
            ///////////////////////////////

            /*Declaramos la variable borrado para leer por teclado el número 
             * que queremos reemplazar.
             */
            int borrado;

            System.Console.WriteLine("-----------------------------------");
            System.Console.WriteLine("Reemplazar un número de la lista.");

            //Volveremos a usar lectura para leer el nuevo nombre.
            System.Console.WriteLine("Indique el nuevo número");
            lectura = System.Convert.ToInt32(System.Console.ReadLine());

            System.Console.WriteLine("Indique el número a reemplazar:");
            borrado = System.Convert.ToInt32(System.Console.ReadLine());

            /* En el siguiente bucle for pondremos una condición con la que comprobaremos
             * si el número que queremos borrar está en el array
             */
            for (int i = 0; i < numeros.Length; i++)
            {
                /* En caso de que el número se encuentre en nuestro array cambiaremos el
                 * anterior por el nuevo
                 */
                if (numeros[i] == borrado)
                {
                    numeros[i] = lectura;
                    System.Console.WriteLine("¡Número reemplazado!");
                    break;
                }
                //En caso de que no esté en el array lo avisaremos
                else if (i == cantidad - 1 && numeros[i] != borrado)
                {
                    System.Console.WriteLine("No se ha encontrado el número en la lista.");
                }
            }

            /////////////////////////////
            ///INSERTAR UN VALOR///
            /////////////////////////////

            System.Console.WriteLine("-----------------------------------");
            System.Console.WriteLine("Agregar un número al array.");
            System.Console.WriteLine("Indique el número que desea insertar:");

            lectura = System.Convert.ToInt32(System.Console.ReadLine());

            /*Con la lectura por teclado podremos introducir el número dentro de 
             * nuestro array. Además gracias a la variable cantidad podremos tener
             * el control del índice de este.
             */
            numeros[cantidad++] = lectura;

            //////////////////////////////
            ///BORRAR UN VALOR///
            //////////////////////////////

            //Variable que nos servirá para indentificar la posición en el array
            int posicionBorrar;

            System.Console.WriteLine("-----------------------------------");
            System.Console.WriteLine("Borrar un número del array.");
            System.Console.WriteLine("Indique el nombre que quiere borrar.");
            lectura = System.Convert.ToInt32(System.Console.ReadLine());

            for (int i = 0; i < numeros.Length; i++)
            {
                //Comprobamos si el número se encuentra en el array
                if (numeros[i] == lectura)
                {
                    //En caso de que lo encuentre almacenamos la posición
                    posicionBorrar = i;
                    /*Realizamos un nuevo bucle que empiece desde la posición 
                     * almacenada y recorremos el array hasta la penúltima posición
                     * para poder reemplazar las posiciones antiguas con las nuevas
                    */
                    for (int j = posicionBorrar; i < cantidad - 1; i++)
                    {
                        /*Una vez dentro del bucle intercambiamos las posiciones
                         * con la siguiente para que todas queden sin partes vacias
                         */
                        numeros[j] = numeros[j + 1];
                    }
                    /*Restamos uno a la cantidad para que cuando añadamos un nuevo valor
                     * se guarde en la posición correcta
                    */
                    cantidad--;
                }
            }

            //Mostramos los números del array
            for (int i = 0; i < numeros.Length; i++)
            {
                if (numeros[i] != 0)
                {
                    System.Console.WriteLine("Nº {0}: {1}", i, numeros[i]);
                }
            }
        }
    }
}