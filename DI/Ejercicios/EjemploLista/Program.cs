namespace EjemploListas
{
    internal class Program
    {
        private delegate int ModificaEntero(int input);

        public static void Main()
        {
            //Instanciamos el List

            double lectura;
            var lista = new List<double>();
            
            //Añadimos valores a la lista con el método Add.

            lista.Add(7.2);
            lista.Add(5.5);
            lista.Add(6.3);
            lista.Add(8);
            lista.Add(4.5);
            lista.Add(6.3);
            lista.Add(9);

            //Mostramos las "notas" de nuestra lista.

            System.Console.WriteLine("Notas del curso: ");

            foreach(double d in lista)
            {
                System.Console.WriteLine(d);
            }

            /* En caso de que queramos introducir un valor en una posición
             * en particular podemos utilizar el método insert indicandole 
             * la posición y el nuevo valor.
             */

            lista.Insert(1, 5);

            System.Console.WriteLine("\nEjemplo del insert:");

            System.Console.WriteLine(lista[2]);

            /* A la hora de eliminar un elemento de la lista podemos hacerlo de
             * varias formas. Eligiendo la posición en la que se encuentra el
             * valor o introduciendo el valor directamente. 
             */

            lista.Remove(6.3);

            System.Console.WriteLine("\nLista tras borrado:");

            foreach (double d in lista)
            {
                System.Console.WriteLine(d);
            }

            /*En caso de que haya dos valores iguales dentro de una lista
             *(Como es el caso anterior) solo se borrará uno de ellos.
             */

            /* También podemos buscar la posición en la que se encuentra un
             * valor con el método indexOf
             */
            System.Console.WriteLine("\nIndique el número a buscar:");

            lectura = System.Convert.ToDouble(System.Console.ReadLine());

            if (lista.Contains(lectura))
            {
                System.Console.WriteLine("Se encuentra en la posición nº " + (lista.IndexOf(lectura) + 1));
            }
            else
            {
                System.Console.WriteLine("El número no se encuentra en la lista, seleccione otro:");
                lectura = System.Convert.ToDouble(System.Console.ReadLine());
            }

            //Podemos comprobar el tamaño de la lista con el método Capacity.

            System.Console.WriteLine("\nTamaño de la lista:");
            System.Console.WriteLine(lista.Capacity);

            //También podemos ordenar la lista

            lista.Sort();

            System.Console.WriteLine("\nLista ordenada:");

            foreach (double d in lista)
            {
                System.Console.WriteLine(d);
            }

            //Por último podemos vaciar la lista con el método Clear

            lista.Clear();

        }
    }
}