using System.Net;

namespace EjemploHerencia
{
    internal class Program
    {
        static void Main(string[] args)
        {
            /*Declaramos nuestros dos objetos Alumno y Profesor. Cada uno de ellos heredan de 
             * la clase Persona los atributos nombre, apellidos y dni, por lo que deberemos
             * incluirlos al instanciarlos
             */
            Alumno a = new Alumno(8, 6.5, "2º DAM", "Pedro", "Puertas Rodríguez", "12345678A");
            Profesor p = new Profesor("Mario", "Vázquez López", "87654321B", 1600, true, 40);

            //Con el método mostrarDatos() podremos visualizar cada uno de sus atributos
            System.Console.WriteLine("Alumno:");
            a.mostrarDatos();
            System.Console.WriteLine("\nProfesor:");
            p.mostrarDatos();

            System.Console.WriteLine("\n----------------------------------------");
            /*A continuación utilizaremos el método nombreCompleto(), el cual se encuentra
             * únicamente se encuentra en la clase Persona, pero al heredar ambas clases de esta
             * podemos utilizarlo igualmente
             */
            System.Console.WriteLine("\nAlumno:");
            a.nombreCompleto();

            /* Sin embargo como el método notaMedia() solo está definido en la clase Alumno
             * tendremos que llamar a este a través de un objeto del mismo tipo, o no causará
             * ningún efecto como podemos comprobar si intentamos hacerlo con la clase
             * Profesor
             */
            System.Console.WriteLine("La nota media de {0} es: {1}", a.Nombre, a.notaMedia());
            //p.notaMedia();

            System.Console.WriteLine("\nProfesor:");
            p.nombreCompleto();

            /* Lo mismo ocurre con el método calcularSalario(), el cual no incluye ninguna otra clase
             * por lo que solamente puede ser llamado a través de un objeto tipo Profesor
             */
            System.Console.WriteLine("El salario de {0} es: {1} euros", p.Nombre, p.calcularSalario());
            //a.calcularSalario();

        }

        public class Persona{

            /* Esta es nuestra clase madre, de la que heredaran las siguientes subclases. Tanto
             * sus atributos como sus métodos podrán ser utilizados en ellas.
             * 
             * Los atributos de la clase pueden ser private, public o protected. Estos son los
             * mas utilizados y dependiendo del tipo de privacidad que elijamos 
             * nuestros métodos y subclases posteriores podrán visibilizarlos o no
             */

            private string nombre;
            private string apellidos;
            private string dni;

            public Persona(string nombre, string apellidos, string dni)
            {
                this.nombre = nombre;
                this.apellidos = apellidos;
                this.dni = dni;
            }

            //Getters y setters
            public string Nombre 
            { 
              get;
              set;
            }

            public string Apellidos
            {
                get;
                set;
            }

            public string Dni
            {
                get;
                set;
            }

            //Con este método mostraremos los atributos de la clase
            public void mostrarDatos()
            {
                System.Console.WriteLine("Nombre: " + nombre);
                System.Console.WriteLine("Apellidos: "+apellidos);
                System.Console.WriteLine("DNI: "+dni);
            }

            /*Esta clase será utilizada más tarde para confirmar que las clases hijas pueden usar
             * los métodos de la clase madre
             */
            public void nombreCompleto()
            {
                System.Console.WriteLine("Nombre completo: " + nombre + " " + apellidos);
            }
        }

        public class Alumno : Persona
        {

            private double notaUno;
            private double notaDos;
            private string curso;

            /* Para conseguir que el constructor de la subclase incluya los atributos de la madre
             * deberemos pasarlos como parámetros y más tarde poner : base(), entre el paréntesis
             * de este deberemos indicar cuales son los atributos heredados, en este caso nombre,
             * apell y dni
             */
            public Alumno(double notaUno, double notaDos, string curso, string nombre,
                string apell, string dni) : base(nombre, apell, dni)
            {
                this.notaUno = notaUno;
                this.notaDos = notaDos;
                this.curso = curso;
            }

            //Getters y setters
            public double NotaUno
            {
                get;
                set;
            }

            public double NotaDos
            {
                get;
                set;
            }

            public string Curso
            {
                get;
                set;
            }

            //Como ya veremos más adelante se pueden reescribir los métodos de la clase madre
            public new void mostrarDatos()
            {
                System.Console.WriteLine("Nombre: " + Nombre);
                System.Console.WriteLine("Apellidos: " + Apellidos);
                System.Console.WriteLine("DNI: " + Dni);
                System.Console.WriteLine("Curso: " + curso);
                System.Console.WriteLine("Nota programación: " + notaUno);
                System.Console.WriteLine("Nota BBDD: " + notaDos);
            }

            /* Este método será usado como ejemplo para indicar que solo la clase Alumno puede
             * utilizarlo. Tanto la madre como sus hijas no podrán acceder a este método
             */
            public double notaMedia()
            {
                double total;

                total = notaUno + notaDos;
                total = total / 2;

                return total;
            }
        }

        public class Profesor : Persona
        {
            private double salario;
            private Boolean tutor;
            private int horas;

            /* Como se ha indicado en el constructor de Alumno debemos pasar por parámetros los
             * atributos que queramos incluir de la clase madre Persona y más tarde incluirlas
             * en el paréntesis de base()
             */
            public Profesor(string nombre, string apellidos, 
                string dni, double salario, Boolean tutor, int horas) 
                    : base(nombre, apellidos, dni)
            {
                this.horas = horas;
                this.salario = salario;
                this.tutor = tutor;
            }

            //Getters y setters

            public int Horas
            {
                get;
                set;
            }

            public double Salario
            {
                get;
                set;
            }

            public Boolean Tutor
            {
                get;
                set;
            }

            //Método heredado de Persona
            public new void mostrarDatos()
            {
                System.Console.WriteLine("Nombre: " + Nombre);
                System.Console.WriteLine("Apellidos: " + Apellidos);
                System.Console.WriteLine("DNI: " + Dni);
                System.Console.WriteLine("Horas trabajadas: " + horas);
                System.Console.WriteLine("Salario: " + salario);
                if (tutor)
                {
                    System.Console.WriteLine("Es tutor: Sí");
                }
                else
                {
                    System.Console.WriteLine("Es tutor: No");
                }
            }

            /* Este método también es utilizado como ejemplo para comprobar que tanto la clase
             * madre como sus hijas no pueden utilizar métodos declarados únicamente en una 
             * subclase
             */
            public double calcularSalario()
            {
                double extra = 100;
                double total;

                if(horas >= 40)
                {
                    if (tutor)
                    {
                        total = salario + extra * 2;
                    }
                    else
                    {
                        total = salario + extra;
                    }
                }
                else
                {
                    if (tutor)
                    {
                        total = salario + extra;
                    }
                    else
                    {
                        total = salario;
                    }
                }

                return total;
            }
        }
    }
}