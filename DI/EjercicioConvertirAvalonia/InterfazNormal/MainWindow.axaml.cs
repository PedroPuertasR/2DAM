using Avalonia.Controls;
using Avalonia.Media;
using System;
using System.Diagnostics;
using System.IO;
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
            btnNo.Click += BtnNo_Click;
            btnSi.Click += BtnSi_Click;
            tbArchivo.IsVisible = false;
            tbInfo.IsVisible = false;
            pnlSobre.Background = new SolidColorBrush(Colors.LightGray);
            btnSi.Background = new SolidColorBrush(Colors.White);
            btnNo.Background = new SolidColorBrush(Colors.White);
        }

        private void BtnSi_Click(object? sender, Avalonia.Interactivity.RoutedEventArgs e)
        {
            /* Creamos un ComboBoxItem y le asignamos el que haya seleccionado el usuario
             * transformandolo a ComboBoxItem, pues este devuelve un object.
             * A continuación lo pasamos a nuestra string extension cogiendo su contenido
             * y haciendo un toString.
             */
            ComboBoxItem cbi = (ComboBoxItem)cbExt.SelectedItem;
            string extension = cbi.Content.ToString();

            //Guardamos el nombre y la ubicación del archivo en dos strings de nuevo.
            string nuevo = tbNombre.Text;
            string archivo = tbArchivo.Text;

            /* Como ya hemos hecho todas las comprobaciones en el boton Convertir y los textBox y
             * ComboBox están desabilitados realizamos directamente la transformación del archivo
             * con nuestra variable proceso.
             */
            var ps = new ProcessStartInfo();
            ps.FileName = "cmd.exe";
            ps.UseShellExecute = false;
            ps.Arguments = "/c ffmpeg -y -i " + archivo + " " + Path.GetDirectoryName(archivo) + "\\" + tbNombre.Text + "." + extension;
            ps.CreateNoWindow = true;
            using var proceso = Process.Start(ps);

            //Mostramos el textBox de Conversión realizada.
            tbInfo.Background = new SolidColorBrush(Colors.Green);
            tbInfo.IsVisible = true;
            tbInfo.Text = "Conversión realizada";

            //Ocultamos el panel y habilitamos los textBox/ComboBox para una posible nueva conversión.
            pnlSobre.IsVisible = false;
            cbExt.IsEnabled = true;
            tbArchivo.IsEnabled = true;
            tbNombre.IsEnabled = true;
        }

        private void BtnNo_Click(object? sender, Avalonia.Interactivity.RoutedEventArgs e)
        {
            //Ocultamos el panel de sobreescritura y habilitamos el comboBox y los textBoxs.
            pnlSobre.IsVisible = false;
            cbExt.IsEnabled = true;
            tbArchivo.IsEnabled = true;
            tbNombre.IsEnabled = true;
        }

        private void BtnConvertir_Click(object? sender, Avalonia.Interactivity.RoutedEventArgs e)
        {
            //Hacemos invisible el textBox de información puesto que estamos convirtiendo.
            tbInfo.IsVisible = false;

            /* Creamos un ComboBoxItem y le asignamos el que haya seleccionado el usuario
             * transformandolo a ComboBoxItem, pues este devuelve un object.
             * A continuación lo pasamos a nuestra string extension cogiendo su contenido
             * y haciendo un toString.
             */
            ComboBoxItem cbi = (ComboBoxItem)cbExt.SelectedItem;
            string extension = cbi.Content.ToString();

            //Guardamos el nombre y la ubicación del archivo en dos strings.
            string nuevo = tbNombre.Text;
            string archivo = tbArchivo.Text;

            /* Comprobamos si el comboBox y los textBoxs están vacios para comprobar que
             * se pueda realizar la conversión. En caso de que falte algún dato se mostrará
             * un textBox de información en rojo que nos indicará el error.
             */
            if (archivo.Equals("") || archivo.Equals("null")){
                tbInfo.Background = new SolidColorBrush(Colors.Red);
                tbInfo.IsVisible = true;
                tbInfo.Text = "Seleccione un archivo para convertirlo";
            }
            else
            {
                if (nuevo.Equals(""))
                {
                    tbInfo.Background = new SolidColorBrush(Colors.Red);
                    tbInfo.IsVisible = true;
                    tbInfo.Text = "Indique un nombre para el archivo";
                }
                else
                {
                    if (extension.Equals(""))
                    {
                        tbInfo.Background = new SolidColorBrush(Colors.Red);
                        tbInfo.IsVisible = true;
                        tbInfo.Text = "Seleccione un tipo de archivo";
                    }
                    else
                    {
                        /*Guardamos la ruta con el nuevo nombre y la extensión en un string
                         * para comprobrar si existe el archivo.
                         */
                        string sobre = Path.GetDirectoryName(archivo) + "\\" + nuevo + "." + extension;

                        /*En caso de que exista mostramos el panel de sobreescritura y deshabilitamos 
                         * los textBoxs y el comboBox para que no sean modificados.
                         */
                        if (File.Exists(sobre))
                        {
                            pnlSobre.IsVisible = true;
                            cbExt.IsEnabled = false;
                            tbArchivo.IsEnabled = false;
                            tbNombre.IsEnabled = false;
                        }
                        /* En caso de que todo esté en orden realizamos la creación del proceso y le 
                         * pasamos los comandos y argumentos antes de iniciarlo y realizar la conversión.
                         * Esta se realizará con los datos que hemos almacenado anteriormente.
                         */
                        else
                        {
                            var ps = new ProcessStartInfo();
                            ps.FileName = "cmd.exe";
                            ps.UseShellExecute = false;
                            ps.Arguments = "/c ffmpeg -i " + archivo + " " + Path.GetDirectoryName(archivo) + "\\" + tbNombre.Text + "." + extension;
                            ps.CreateNoWindow = true;
                            using var proceso = Process.Start(ps);

                            //Se mostrará el textBox de conversión realizada correctamente.
                            tbInfo.Background = new SolidColorBrush(Colors.Green);
                            tbInfo.IsVisible = true;
                            tbInfo.Text = "Conversión realizada";
                        }
                    }
                }
            }

            
        }

        /* Con este Click utilizaremos el método abrirArchivo, el cual nos devolverá la 
         * ruta del archivo seleccionado. Tras esto mostraremos la ruta en un textBox.
         */
        private async void BtnArchivo_Click(object? sender, Avalonia.Interactivity.RoutedEventArgs e)
        {
            var ruta = await abrirArchivo();

            //Comprobamos que el método devuelva algo.
            if(ruta == null)
            {
                tbArchivo.Text = "Error";
            }
            else
            {
                tbArchivo.IsVisible = true;
                tbArchivo.Text = ruta;
            }

        }

        /* Con este método conseguimos instanciar un openFileDialog el cual nos 
         * permitirá seleccionar el archivo de audio que queremos convertir.
         */
        public async Task<string> abrirArchivo()
        {
            var dialog = new OpenFileDialog();
            //Indicamos la carpeta desde donde queremos que empiece el dialog.
            dialog.Directory = "C:";
            //Solo dejamos que se seleccione un único archivo.
            dialog.AllowMultiple = false;

            //Esperamos el resultado del diálogo y lo guardamos en una variable.
            var result = await dialog.ShowAsync(this);

            //Comprobamos que el resultado contenga algo para poder devolverlo.
            if(result.Length > 0)
            {
                //Devolvemos la posición 0 del array la cual incluye la ruta del archivo.
                return result[0];
                tbArchivo.IsVisible = true;
            }
            else
            {
                /*En caso de que no contenga nada devolverá null y lo tendremos en cuenta
                 * cuando usemos el método.
                 */
                return null;
            }
        }
    }
}
