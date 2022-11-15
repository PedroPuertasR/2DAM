using System.Diagnostics;
using System.Security.Cryptography;

namespace EjercicioConvertir
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        /*En caso de que pulsemos el botón de seleccionar archivo se mostrará el openFileDialog para que el
         * usuario pueda seleccionarlo
         */
        private void btnArchivo_Click(object sender, EventArgs e)
        {
            ofArchivo.ShowDialog();

            //Guardamos en una variable el nombre y la extensión del archivo
            tbArchivo.Text = ofArchivo.SafeFileName;

            //Solo si el archivo existe mostrará en un textBox el nombre y su extensión
            if (ofArchivo.CheckFileExists)
            {
                tbArchivo.Visible = true;
            }
        }

        private void btnConvertir_Click(object sender, EventArgs e)
        {
            //En caso de que no seleccione un archivo le avisa y no se hace nada.
            if (tbArchivo.Text.Equals(""))
            {
                //Muestra un messageBox al usuario
                MessageBox.Show("Seleccione un archivo");
            }
            else
            {
                //En caso de que no seleccione un nombre del nuevo archivo le avisa y no se hace nada.
                if (tbNombre.Text.Equals(""))
                {
                    //Muestra un messageBox al usuario
                    MessageBox.Show("Elija un nombre");
                }
                else
                {
                    //En caso de que no seleccione un tipo al que convertir le avisa y no se hace nada.
                    if (cbTipo.Text.Equals(""))
                    {
                        //Muestra un messageBox al usuario
                        MessageBox.Show("Seleccione un tipo al que convertir");
                    }
                    else
                    {
                        //Guardamos la ruta del openFileDialog
                        string ruta = ofArchivo.FileName;

                        //Instanciamos la variable que ejecutará el proceso
                        var ps = new ProcessStartInfo();

                        //El proceso ejecutará el cmd
                        ps.FileName = "cmd.exe";

                        //No se abrirá la consola en el proceso gracias a este método
                        ps.UseShellExecute = false;

                        /*Le pasamos las instrucciones con la ruta y el nombre de archivo 
                         * para que realice la conversión
                         */
                        ps.Arguments = "/c ffmpeg -i " + ruta + " " + Path.GetDirectoryName(ruta) + "\\" + tbNombre.Text + "." + cbTipo.Text;

                        /*Guardamos en un string la ruta del archivo con el nuevo nombre 
                         * por si coincide con uno que ya exista
                         */
                        string sobre = Path.GetDirectoryName(ruta) + "\\" + tbNombre.Text + "." + cbTipo.Text;

                        /*Si nuestra variable coincide con el nuevo archivo ponemos como visible un panel que
                         * le preguntará al usuario si desea sobreescribir el archivo
                         */
                        if (File.Exists(sobre))
                        {
                            panelSobre.Visible = true;

                            lblSobre.Text = "El archivo ya existe\n¿Desea sobreescribirlo?";
                        }
                        /*En caso de que no exista realizará el proceso normalmente y mostrará un 
                         * label de éxito en la conversión
                         */
                        else
                        {
                            //Iniciamos el proceso para realizar la conversión
                            using var proceso = Process.Start(ps);

                            //Cuando se ejecute el proceso mostrará un MessageBox de éxito
                            MessageBox.Show("Conversión a ." + cbTipo.Text + " realizada.");
                        }
                    }
                }
            }
        }

        /*En caso de que el usuario elija que no en la sobreescritura simplemente ocultará el panel 
         * y no hará nada
         */
        private void btnNo_Click(object sender, EventArgs e)
        {
            panelSobre.Visible = false;
        }

        /*En caso de que el usuario seleccione que si se ejecutará el comando del cmd con un -y delante, 
         * el cual hará que se sobreescriba automáticamente sin preguntar nada al usuario por consola
         */
        private void btnSi_Click(object sender, EventArgs e)
        {
            //Oculta el panel una vez que pulsemos el sí
            panelSobre.Visible = false;
            string ruta = ofArchivo.FileName;
            var ps = new ProcessStartInfo();

            //Instrucciones a la hora de ejecutar el proceso
            ps.FileName = "cmd.exe";
            ps.UseShellExecute = false;
            ps.Arguments = "/c ffmpeg -y -i " + ruta + " " + Path.GetDirectoryName(ruta) + "\\" + tbNombre.Text + "." + cbTipo.Text;

            //Iniciamos el proceso para que convierta el archivo
            using var proceso = Process.Start(ps);

            //Cuando se ejecute el proceso mostrará un MessageBox de éxito
            MessageBox.Show("Conversión a ." + cbTipo.Text + " realizada.");
        }
    }
}