/*Hecho por Pedro Puertas Rodríguez y Alberto Miguel Blázquez Caraballo
/****SOBREESCRITURA DE METODOS****
Si queremos sobreescribir un método de una clase padre
en una clase hija, podemos usar "new"
*/
using System;

namespace DI 
{
    public class Program
    {
        static void Main(string[] args)
        {
            //Declaramos una clase "Clase" y una clase "PrimeraClaseHija"
            //que use new para sobreescribir la funcion
            PrimeraClase primeraclase = new PrimeraClase();
            PrimeraClaseHija primeraClaseHija = new PrimeraClaseHija();
            //Usamos la función comprobar para ver que el método de la
            //clase hija funciona
            primeraclase.comprobar();
            primeraClaseHija.comprobar();
            //Procedemos a hacer lo mismo pero con metodos con virtual
            //y override para la clase padre e hija respectivamente
            SegundaClase segundaClase = new SegundaClase();
            SegundaClaseHija segundaClaseHija = new SegundaClaseHija();
            //Usamos la función comprobar para ver que el método de la
            //clase hija funciona
            segundaClase.comprobar();
            segundaClaseHija.comprobar();
            //Esta vez declaramos un vector para ver si la clase hija funciona
            PrimeraClase[] vectorPrimera = new PrimeraClase[2];
            vectorPrimera[0] = new PrimeraClase();
            vectorPrimera[1] = new PrimeraClaseHija();
            vectorPrimera[0].comprobar();
            vectorPrimera[1].comprobar();
            //Como podemos apreciar, al llamar al metodo de la clase hija,
            //aparecerá el del padre, dado que new no funciona en vectores
            //Debido a esto, procederemos a hacer lo mismo pero con
            //override y virtual
            SegundaClase[] vectorSegunda = new SegundaClase[2];
            vectorSegunda[0] = new SegundaClase();
            vectorSegunda[1] = new SegundaClaseHija();
            vectorSegunda[0].comprobar();
            vectorSegunda[1].comprobar();
            //Aquí vemos que override SI funciona dentro de un vector de
            //La clase padre.
        }
    }
    //Clase es una clase padre con un método llamado comprobar para
    //que mande un mensaje diciendo que clase es
    public class PrimeraClase{
            public void comprobar(){
                Console.WriteLine("Soy una clase padre");
            }
    }
    //En el caso de PrimeraClaseHija, esta es una clase hija de Clase. El método de comprobar que 
    //clase es se sobreescribe dentro de esta.
    public class PrimeraClaseHija : PrimeraClase{
            public new void comprobar(){//Utilizamos new para sobreescribir el metodo de Clase
                Console.WriteLine("Soy la clase hija numero 1");
            }
    }
    public class SegundaClase{
        public virtual void comprobar(){//Utilizamos virtual para marcar que este método será 
        //sustituido en cualquier situacion con una clase hija
            Console.WriteLine("Soy otra clase padre");
        }
    }
    public class SegundaClaseHija : SegundaClase{
        override public void comprobar(){//Usamos override para sobreescribir el método virtual
            Console.WriteLine("Soy las clase hija numero 2");
        }
    }
}
