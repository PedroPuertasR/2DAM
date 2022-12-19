namespace EjemploStack
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //Instanciamos la pila.

            var pila = new Stack<int>();

            //Para introducir valores en la pila utilizamos el método push.

            pila.Push(0);
            pila.Push(1);
            pila.Push(2);
            pila.Push(3);
            pila.Push(4);
            pila.Push(5);

            //Con el método count podemos sacar el tamaño de la pila.

            System.Console.WriteLine("Tamaño: " + pila.Count);

            /* Podemos comprobar el primer valor que contiene la
            * pila con el método Peek.
            */

            System.Console.WriteLine("\nPrimer valor de la pila: " + pila.Peek());

            /*Además con el método Contains comprobaremos si existe un número en 
             * la pila.
            */

            System.Console.WriteLine("\nIndique el número que quiere buscar en la pila:");

            int teclado = System.Convert.ToInt32(System.Console.ReadLine());

            if (pila.Contains(teclado))
            {
                System.Console.WriteLine("\nSí se encuentra en la pila.");
            }
            else
            {
                System.Console.WriteLine("\nNo se encuentra en la pila.");
            }

            /*Para mostrar el contenido de la pila utilizamos el método Pop. Una vez
             * que saquemos los valores de la pila esta quedará vacía.
             */

            System.Console.WriteLine("\nSalida de la pila:");

            for (int i = 0; i < 6; i++)
            {
                System.Console.WriteLine(pila.Pop());
            }

            /* En una pila los últimos valores en entrar en ella son los 
             * primeros valores en salir por eso en este ejemplo se hace
             * una cuenta atras.
             */

            pila.Push(0);
            pila.Push(1);
            pila.Push(2);

            //Por último podemos vaciar la pila con el método Clear

            pila.Clear();

        }
    }
}