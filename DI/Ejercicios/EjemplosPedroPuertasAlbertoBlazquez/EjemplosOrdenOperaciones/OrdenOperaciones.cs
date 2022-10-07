/*Hecho por Pedro Puertas Rodríguez y Alberto Miguel Blázquez Caraballo
/****ORDEN DE PRIORIDAD DE LOS OPERADORES****
A la hora de realizar operaciones matemáticas en C#, 
así como la mayoría de los lenguajes de programación,
es necesario saber el COMO escribirlas, ya que el orden
de estas cambiará el resultado.
Para este programa utilizaremos variables para los ejemplos
para una más facil comprensión*/

using System;

namespace DI 
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //Primero, definiremos las variables
            var num1=4;
            var num2=7;
            var num3=10;
            var num4=2;
            /*A la hora de ordenar, el programa tomará las acciones en este orden:
            1-Negativos (simbolo -)
            2.-Multiplicaciones (*), divisiones (/) y resto (%)
            3.-Sumas y restas
            En caso de que dos operaciones tengan la misma prioridad, se leera de
            izquierda a derecha.
            */
            //Ejemplo de prioridad de izquierda a derecha
            Console.WriteLine("Esto es un ejemplo de prioridad de operaciones de izquierda a derecha:");
            Console.WriteLine("{1} * {2} % {3}={0}",num1*num2%num3, num1, num2, num3);
            Console.WriteLine("{2} % {3} * {1}={0}",num2%num3*num1, num1, num2, num3);
            //Ejemplo de prioridad de clase 2 sobre 3 dando igual el orden (el resultado no cambia)
            Console.WriteLine("Esto es un ejemplo de prioridad de multiplicaciones/divisiones/restos sobre sumas/restas");
            Console.WriteLine("{1} + {3} / {2} = {0}", num2+num1/num4, num2, num1, num4);
            Console.WriteLine("{3} / {2} + {1} = {0}", num1/num4+num2, num2, num1, num4);
            /*Dado que el orden de los negativos no afecta a las multiplicaciones, divisiones
            y resto, es dificil mostrar un ejemplo de la prioridad de este.
            Para utilizar operadores de baja prioridad antes que otros,
            o simplemente para ayudar con la claridad de la operación,
            se pueden añadir paréntesis "()". Las operaciones dentro de
            estos tendrán prioridad sobre todo lo demás
            */
            //Ejemplos de prioridad de paréntesis cambiando el resultado al añadirlos
            Console.WriteLine("Esto son ejemplos de prioridad de parentesis sobre cualquier operador:");
            Console.WriteLine("{1}+{2}*{3}={0}", num3+num2*num4, num3, num2, num4);
            Console.WriteLine("({1}+{2})*{3}={0}", (num3+num2)*num4, num3, num2, num4);
            Console.WriteLine("-{1}+{2}={0}", -num2+num4, num2, num4);
            Console.WriteLine("-({1}+{2})={0}", -(num2+num4), num2, num4);
        }
    }
}