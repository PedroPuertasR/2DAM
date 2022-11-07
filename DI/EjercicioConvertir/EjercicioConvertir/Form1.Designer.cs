namespace EjercicioConvertir
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.btnArchivo = new System.Windows.Forms.Button();
            this.btnConvertir = new System.Windows.Forms.Button();
            this.tbSalida = new System.Windows.Forms.TextBox();
            this.lblNombre = new System.Windows.Forms.Label();
            this.tbNombre = new System.Windows.Forms.TextBox();
            this.tbArchivo = new System.Windows.Forms.TextBox();
            this.ofArchivo = new System.Windows.Forms.OpenFileDialog();
            this.SuspendLayout();
            // 
            // btnArchivo
            // 
            this.btnArchivo.Location = new System.Drawing.Point(70, 114);
            this.btnArchivo.Name = "btnArchivo";
            this.btnArchivo.Size = new System.Drawing.Size(137, 23);
            this.btnArchivo.TabIndex = 0;
            this.btnArchivo.Text = "Seleccionar archivo";
            this.btnArchivo.UseVisualStyleBackColor = true;
            this.btnArchivo.Click += new System.EventHandler(this.btnArchivo_Click);
            // 
            // btnConvertir
            // 
            this.btnConvertir.Location = new System.Drawing.Point(570, 76);
            this.btnConvertir.Name = "btnConvertir";
            this.btnConvertir.Size = new System.Drawing.Size(110, 42);
            this.btnConvertir.TabIndex = 1;
            this.btnConvertir.Text = "Convertir";
            this.btnConvertir.UseVisualStyleBackColor = true;
            this.btnConvertir.Click += new System.EventHandler(this.btnConvertir_Click);
            // 
            // tbSalida
            // 
            this.tbSalida.Location = new System.Drawing.Point(44, 180);
            this.tbSalida.Multiline = true;
            this.tbSalida.Name = "tbSalida";
            this.tbSalida.Size = new System.Drawing.Size(710, 240);
            this.tbSalida.TabIndex = 2;
            // 
            // lblNombre
            // 
            this.lblNombre.AutoSize = true;
            this.lblNombre.Location = new System.Drawing.Point(89, 66);
            this.lblNombre.Name = "lblNombre";
            this.lblNombre.Size = new System.Drawing.Size(103, 15);
            this.lblNombre.TabIndex = 3;
            this.lblNombre.Text = "Nombre de salida:";
            // 
            // tbNombre
            // 
            this.tbNombre.Location = new System.Drawing.Point(242, 63);
            this.tbNombre.Name = "tbNombre";
            this.tbNombre.Size = new System.Drawing.Size(148, 23);
            this.tbNombre.TabIndex = 4;
            // 
            // tbArchivo
            // 
            this.tbArchivo.Location = new System.Drawing.Point(242, 115);
            this.tbArchivo.Name = "tbArchivo";
            this.tbArchivo.Size = new System.Drawing.Size(148, 23);
            this.tbArchivo.TabIndex = 5;
            this.tbArchivo.Visible = false;
            // 
            // ofArchivo
            // 
            this.ofArchivo.FileName = "openFileDialog1";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.tbArchivo);
            this.Controls.Add(this.tbNombre);
            this.Controls.Add(this.lblNombre);
            this.Controls.Add(this.tbSalida);
            this.Controls.Add(this.btnConvertir);
            this.Controls.Add(this.btnArchivo);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private Button btnArchivo;
        private Button btnConvertir;
        private TextBox tbSalida;
        private Label lblNombre;
        private TextBox tbNombre;
        private TextBox tbArchivo;
        private OpenFileDialog ofArchivo;
    }
}