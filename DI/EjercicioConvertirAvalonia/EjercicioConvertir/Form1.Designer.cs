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
            this.lblNombre = new System.Windows.Forms.Label();
            this.tbNombre = new System.Windows.Forms.TextBox();
            this.tbArchivo = new System.Windows.Forms.TextBox();
            this.ofArchivo = new System.Windows.Forms.OpenFileDialog();
            this.panelSobre = new System.Windows.Forms.Panel();
            this.lblSobre = new System.Windows.Forms.Label();
            this.btnNo = new System.Windows.Forms.Button();
            this.btnSi = new System.Windows.Forms.Button();
            this.cbTipo = new System.Windows.Forms.ComboBox();
            this.lblTipo = new System.Windows.Forms.Label();
            this.panelSobre.SuspendLayout();
            this.SuspendLayout();
            // 
            // btnArchivo
            // 
            this.btnArchivo.Location = new System.Drawing.Point(74, 138);
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
            // lblNombre
            // 
            this.lblNombre.AutoSize = true;
            this.lblNombre.Location = new System.Drawing.Point(108, 90);
            this.lblNombre.Name = "lblNombre";
            this.lblNombre.Size = new System.Drawing.Size(103, 15);
            this.lblNombre.TabIndex = 3;
            this.lblNombre.Text = "Nombre de salida:";
            // 
            // tbNombre
            // 
            this.tbNombre.Location = new System.Drawing.Point(246, 87);
            this.tbNombre.Name = "tbNombre";
            this.tbNombre.Size = new System.Drawing.Size(148, 23);
            this.tbNombre.TabIndex = 4;
            // 
            // tbArchivo
            // 
            this.tbArchivo.Location = new System.Drawing.Point(246, 139);
            this.tbArchivo.Name = "tbArchivo";
            this.tbArchivo.Size = new System.Drawing.Size(148, 23);
            this.tbArchivo.TabIndex = 5;
            this.tbArchivo.Visible = false;
            // 
            // ofArchivo
            // 
            this.ofArchivo.FileName = "openFileDialog1";
            // 
            // panelSobre
            // 
            this.panelSobre.BackColor = System.Drawing.SystemColors.AppWorkspace;
            this.panelSobre.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.panelSobre.Controls.Add(this.lblSobre);
            this.panelSobre.Controls.Add(this.btnNo);
            this.panelSobre.Controls.Add(this.btnSi);
            this.panelSobre.Location = new System.Drawing.Point(322, 190);
            this.panelSobre.Name = "panelSobre";
            this.panelSobre.Size = new System.Drawing.Size(261, 104);
            this.panelSobre.TabIndex = 7;
            this.panelSobre.Visible = false;
            // 
            // lblSobre
            // 
            this.lblSobre.AutoSize = true;
            this.lblSobre.Location = new System.Drawing.Point(35, 16);
            this.lblSobre.Name = "lblSobre";
            this.lblSobre.Size = new System.Drawing.Size(32, 15);
            this.lblSobre.TabIndex = 2;
            this.lblSobre.Text = "label";
            // 
            // btnNo
            // 
            this.btnNo.Location = new System.Drawing.Point(182, 49);
            this.btnNo.Name = "btnNo";
            this.btnNo.Size = new System.Drawing.Size(36, 23);
            this.btnNo.TabIndex = 1;
            this.btnNo.Text = "No";
            this.btnNo.UseVisualStyleBackColor = true;
            this.btnNo.Click += new System.EventHandler(this.btnNo_Click);
            // 
            // btnSi
            // 
            this.btnSi.Location = new System.Drawing.Point(29, 49);
            this.btnSi.Name = "btnSi";
            this.btnSi.Size = new System.Drawing.Size(38, 23);
            this.btnSi.TabIndex = 0;
            this.btnSi.Text = "Sí";
            this.btnSi.UseVisualStyleBackColor = true;
            this.btnSi.Click += new System.EventHandler(this.btnSi_Click);
            // 
            // cbTipo
            // 
            this.cbTipo.FormattingEnabled = true;
            this.cbTipo.Items.AddRange(new object[] {
            "wav",
            "mp3"});
            this.cbTipo.Location = new System.Drawing.Point(246, 34);
            this.cbTipo.Name = "cbTipo";
            this.cbTipo.Size = new System.Drawing.Size(149, 23);
            this.cbTipo.TabIndex = 8;
            // 
            // lblTipo
            // 
            this.lblTipo.AutoSize = true;
            this.lblTipo.Location = new System.Drawing.Point(119, 37);
            this.lblTipo.Name = "lblTipo";
            this.lblTipo.Size = new System.Drawing.Size(92, 15);
            this.lblTipo.TabIndex = 9;
            this.lblTipo.Text = "Tipo de archivo:";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 317);
            this.Controls.Add(this.lblTipo);
            this.Controls.Add(this.cbTipo);
            this.Controls.Add(this.panelSobre);
            this.Controls.Add(this.tbArchivo);
            this.Controls.Add(this.tbNombre);
            this.Controls.Add(this.lblNombre);
            this.Controls.Add(this.btnConvertir);
            this.Controls.Add(this.btnArchivo);
            this.Name = "Form1";
            this.Text = "Form1";
            this.panelSobre.ResumeLayout(false);
            this.panelSobre.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private Button btnArchivo;
        private Button btnConvertir;
        private Label lblNombre;
        private TextBox tbNombre;
        private TextBox tbArchivo;
        private OpenFileDialog ofArchivo;
        private Panel panelSobre;
        private Label lblSobre;
        private Button btnNo;
        private Button btnSi;
        private ComboBox cbTipo;
        private Label lblTipo;
    }
}