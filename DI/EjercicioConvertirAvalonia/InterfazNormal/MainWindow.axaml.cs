using Avalonia.Controls;
using System.Diagnostics;
using System.Threading.Tasks;

namespace InterfazNormal
{
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();

            pnlSobre.IsVisible = false;

            btnArchivo.Click += BtnArchivo_Click;
            btnConvertir.Click += BtnConvertir_Click;
        }

        private void BtnConvertir_Click(object? sender, Avalonia.Interactivity.RoutedEventArgs e)
        {
            string extension = cbExt.SelectedItem.ToString();
            tbArchivo.Text = extension;
            string nuevo = tbNombre.Text;
        }

        private void BtnArchivo_Click(object? sender, Avalonia.Interactivity.RoutedEventArgs e)
        {
            var ruta = abrirArchivo();
            
            tbArchivo.Text = ruta.ToString();

            if (ruta.Equals(""))
            {

            }
            else
            {

            }
        }

        public async Task abrirArchivo()
        {
            var dialog = new OpenFileDialog();
            dialog.Directory = "C:";
            dialog.AllowMultiple = false;

            var result = await dialog.ShowAsync(this);
        }
    }
}
