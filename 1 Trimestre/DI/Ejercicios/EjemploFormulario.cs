using System.Diagnostics;

namespace EjemploInterfaz
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

        }

        private void btnEmpezar_Click(object sender, EventArgs e)
        {
            var ps = new ProcessStartInfo();

            ps.FileName = tbComando.Text;
            ps.UseShellExecute = false;
            ps.Arguments = tbArgumento.Text;
            ps.RedirectStandardOutput = true;

            using var proceso = Process.Start(ps);

            if(proceso != null)
            {
                using StreamReader reader = proceso.StandardOutput;
                string datos = reader.ReadToEnd();
                tbSalida.Text = datos;
            }
        }

        private void btnArchivo_Click(object sender, EventArgs e)
        {
            ofArchivo.ShowDialog();
            tbArchivo.Text = ofArchivo.FileName;

            if (ofArchivo.CheckFileExists)
            {
                tbArchivo.Visible = true;
            }
        }
    }
}