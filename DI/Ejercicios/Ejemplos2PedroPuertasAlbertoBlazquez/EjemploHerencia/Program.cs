namespace EjemploHerencia
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello, World!");
        }

        public class Persona{

            private string nombre;
            private string apellidos;
            private string dni;

            public Persona(string nombre, string apellidos, string dni)
            {
                this.nombre = nombre;
                this.apellidos = apellidos;
                this.dni = dni;
            }

            public string Nombre 
            { get 
                { 
                    return nombre; 
                }
              set
                {
                    this.nombre = value;
                }
            }

            public string Apellidos
            {
                get 
                {
                    return apellidos; 
                }

                set 
                {
                    this.apellidos = value; 
                }
            }

            public string Dni
            {
                get
                {
                    return dni;
                }

                set
                {
                    this.dni = value;
                }
            }

            

        }

        public class Alumno : Persona
        {

            private double notaMedia;
            private string curso;

            public Alumno(double notaMedia, string curso) : base
            {
                this.notaMedia = notaMedia;
                this.curso = curso;
            }
        }
    }
}