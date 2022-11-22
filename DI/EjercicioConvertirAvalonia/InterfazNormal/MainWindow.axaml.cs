using Avalonia.Controls;

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
            System.Console.WriteLine(extension);
            string nuevo = tbNombre.Text;
        }

        private void BtnArchivo_Click(object? sender, Avalonia.Interactivity.RoutedEventArgs e)
        {

            string ruta = "";

            if (ruta.Equals(""))
            {

            }
            else
            {

            }
        }
    }
}
