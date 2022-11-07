using System.Diagnostics;

namespace EjercicioConvertir
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnArchivo_Click(object sender, EventArgs e)
        {
            ofArchivo.ShowDialog();

            tbArchivo.Text = ofArchivo.SafeFileName;

            if (ofArchivo.CheckFileExists)
            {
                tbArchivo.Visible = true;
            }
        }

        private void btnConvertir_Click(object sender, EventArgs e)
        {
            if (tbArchivo.Text == "")
            {
                Console.WriteLine("Seleccione un archivo.");
            }
            else
            {
                if (tbNombre.Text == "")
                {
                    Console.WriteLine("Indique un nombre para el nuevo archivo.");
                }
                else
                {
                    string ruta = ofArchivo.FileName;
                    var ps = new ProcessStartInfo();

                    ps.FileName = "cmd.exe";
                    ps.UseShellExecute = false;
                    ps.Arguments = "/c ffmpeg -i " + ruta + " " + Path.GetDirectoryName(ruta) + "\\" + tbNombre.Text + ".wav";
                    ps.RedirectStandardOutput = true;

                    using var proceso = Process.Start(ps);

                    if (proceso != null)
                    {
                        using StreamReader reader = proceso.StandardOutput;
                        string datos = reader.ReadToEnd();
                        tbSalida.Text = datos;
                    }
                }
            }
        }
    }
}