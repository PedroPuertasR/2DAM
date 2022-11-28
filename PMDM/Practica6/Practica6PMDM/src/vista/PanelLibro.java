/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Herramienta;
import controlador.LoginController;
import controlador.TablaController;
import controlador.UpdateController;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import modelo.Categoria;
import modelo.Editorial;
import modelo.Libro;
import modelo.Tienda;

/**
 *
 * @author alumno
 */
public class PanelLibro extends javax.swing.JPanel {

    private static boolean alta = false;
    
    /**
     * Creates new form PanelLibro
     */
    public PanelLibro() {
        
        initComponents();
        
        iniciarMenu();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLibro = new javax.swing.JPanel();
        btnBaja = new javax.swing.JButton();
        btnAlta = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        lblAutor = new javax.swing.JLabel();
        lblEditorial = new javax.swing.JLabel();
        lblIsbn = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblCateg = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        tfAutor = new javax.swing.JTextField();
        cbEditorial = new javax.swing.JComboBox<>();
        tfIsbn = new javax.swing.JTextField();
        tfPrecio = new javax.swing.JTextField();
        cbCateg = new javax.swing.JComboBox<>();
        dcFecha = new com.toedter.calendar.JDateChooser();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList = new javax.swing.JList<>();
        lblTienda = new javax.swing.JLabel();
        cbTienda = new javax.swing.JComboBox<>();

        pnlLibro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBaja.setText("Bajas");
        btnBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaActionPerformed(evt);
            }
        });
        pnlLibro.add(btnBaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, -1, -1));

        btnAlta.setText("Altas");
        btnAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaActionPerformed(evt);
            }
        });
        pnlLibro.add(btnAlta, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, -1, -1));

        lblNombre.setText("Nombre:");
        pnlLibro.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 56, -1, -1));

        lblAutor.setText("Autor:");
        pnlLibro.add(lblAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 93, -1, -1));

        lblEditorial.setText("Editorial:");
        pnlLibro.add(lblEditorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, -1, -1));

        lblIsbn.setText("ISBN:");
        pnlLibro.add(lblIsbn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, -1, -1));

        lblFecha.setText("Fecha publicación:");
        pnlLibro.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, -1));

        lblCateg.setText("Categoría:");
        pnlLibro.add(lblCateg, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, -1, -1));

        lblPrecio.setText("Precio:");
        pnlLibro.add(lblPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 288, -1, -1));
        pnlLibro.add(tfNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 54, 281, -1));
        pnlLibro.add(tfAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 91, 281, -1));

        cbEditorial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlLibro.add(cbEditorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 128, 150, -1));
        pnlLibro.add(tfIsbn, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 170, 281, -1));
        pnlLibro.add(tfPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 286, 281, -1));

        cbCateg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlLibro.add(cbCateg, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 244, 150, -1));
        pnlLibro.add(dcFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 207, 150, -1));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        pnlLibro.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 368, -1, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pnlLibro.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 368, -1, -1));

        jList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList);

        pnlLibro.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 450, 270));

        lblTienda.setText("Tienda:");
        pnlLibro.add(lblTienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, -1, -1));

        cbTienda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlLibro.add(cbTienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 150, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaActionPerformed
        
        cargarMenuAlta();
        
    }//GEN-LAST:event_btnAltaActionPerformed

    private void btnBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaActionPerformed
        
        cargarMenuBaja();
        
    }//GEN-LAST:event_btnBajaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        
        iniciarMenu();
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        int filas;
        
        if(alta){
            int contador = TablaController.getIdLibro() + 1;
            float pre = Float.parseFloat(tfPrecio.getText());
            
            Libro nuevo = new Libro(contador, 
                                    tfAutor.getText(), 
                                    tfNombre.getText(), 
                                    cbEditorial.getSelectedIndex() + 1, 
                                    tfIsbn.getText(), 
                                    Herramienta.dateToGregorianCalendar(dcFecha.getDate()), 
                                    pre, 
                                    cbCateg.getSelectedIndex() + 1, 
                                    cbTienda.getSelectedIndex() + 1);
            
            filas = UpdateController.insertarLibro(nuevo.getAtributos());
       
            if(filas >= 1){
                JOptionPane.showMessageDialog(null, "Filas afectadas: " + filas);
            }

            cargarMenuAlta();
        }else{
            char [] idLibro = jList.getSelectedValue().toCharArray();
            char verId = idLibro[0];
            
            filas = UpdateController.borrarLibro(verId);
            
            JOptionPane.showMessageDialog(null, "Filas afectadas: " + filas);
            
            cargarMenuBaja();
        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    public void rellenarJList(){
        
        ArrayList <Libro> lista;
        
        lista = TablaController.getListaLibros(LoginController.getTrabajador());
        
        DefaultListModel model = new DefaultListModel();
        
        for (int i = 0; i < lista.size(); i++) {
            model.addElement(lista.get(i).infoLibro());
        }
        this.jList.setModel(model);
    }
    
    public void cargarMenuBaja(){
        alta = false;
        
        lblAutor.setVisible(false);
        lblNombre.setVisible(false);
        lblFecha.setVisible(false);
        lblIsbn.setVisible(false);
        lblPrecio.setVisible(false);
        lblCateg.setVisible(false);
        lblEditorial.setVisible(false);
        lblTienda.setVisible(false);
        tfAutor.setVisible(false);
        tfIsbn.setVisible(false);
        tfNombre.setVisible(false);
        tfPrecio.setVisible(false);
        dcFecha.setVisible(false);
        cbCateg.setVisible(false);
        cbEditorial.setVisible(false);
        cbTienda.setVisible(false);
        
        jList.setVisible(true);
        
        btnCancelar.setVisible(true);
        btnGuardar.setVisible(true);
        btnGuardar.setText("Dar de baja");
        
        btnAlta.setVisible(false);
        btnBaja.setVisible(false);
        
        rellenarJList();
   
    }
    
    public void cargarMenuAlta(){
        alta = true;
        
        ArrayList <Categoria> listaCate = new ArrayList <Categoria>();
        ArrayList <Editorial> listaEdi = new ArrayList <Editorial>();
        ArrayList <Tienda> listaTienda = new ArrayList <Tienda>();
        
        listaTienda = TablaController.getTiendas();
        listaCate = TablaController.getCategorias();
        listaEdi = TablaController.getEditoriales();
        
        String [] edi = new String [(listaEdi.size())];
        String [] cate = new String [(listaCate.size())];
        String [] tiendas = new String [(listaTienda.size())];
        
        for (int i = 0; i < cate.length; i++) {
            cate[i] = listaCate.get(i).getNombre();
        }
        
        for (int i = 0; i < edi.length; i++) {
            edi[i] = listaEdi.get(i).getNombre();
        }
        
        for (int i = 0; i < tiendas.length; i++) {
            tiendas[i] = listaTienda.get(i).getDireccion();
        }
        
        DefaultComboBoxModel <String> cb = new DefaultComboBoxModel(cate);
        DefaultComboBoxModel <String> cbE = new DefaultComboBoxModel(edi);
        DefaultComboBoxModel <String> cbT = new DefaultComboBoxModel(tiendas);
        
        cbCateg.setModel(cb);
        cbEditorial.setModel(cbE);
        cbTienda.setModel(cbT);
        
        lblAutor.setVisible(true);
        lblNombre.setVisible(true);
        lblFecha.setVisible(true);
        lblIsbn.setVisible(true);
        lblPrecio.setVisible(true);
        lblCateg.setVisible(true);
        lblEditorial.setVisible(true);
        
        tfAutor.setVisible(true);
        tfAutor.setText("");
        tfIsbn.setVisible(true);
        tfIsbn.setText("");
        tfNombre.setVisible(true);
        tfNombre.setText("");
        tfPrecio.setVisible(true);
        tfPrecio.setText("");
        
        dcFecha.setVisible(true);
        dcFecha.setCalendar(null);
        
        cbCateg.setVisible(true);
        cbEditorial.setVisible(true);
        
        if(LoginController.getTrabajador().getIdJefe() == 0){
            cbTienda.setVisible(true);
            lblTienda.setVisible(true);
        }else{
            cbTienda.setVisible(false);
            lblTienda.setVisible(false);
        }
        
        jList.setVisible(false);
        
        btnCancelar.setVisible(true);
        btnGuardar.setVisible(true);
        btnGuardar.setText("Guardar");
        
        btnAlta.setVisible(false);
        btnBaja.setVisible(false);
        
    }
    
    public void iniciarMenu(){
        
        lblAutor.setVisible(false);
        lblNombre.setVisible(false);
        lblFecha.setVisible(false);
        lblIsbn.setVisible(false);
        lblPrecio.setVisible(false);
        lblCateg.setVisible(false);
        lblEditorial.setVisible(false);
        lblTienda.setVisible(false);
        
        tfAutor.setVisible(false);
        tfIsbn.setVisible(false);
        tfNombre.setVisible(false);
        tfPrecio.setVisible(false);
        
        dcFecha.setVisible(false);
        
        cbCateg.setVisible(false);
        cbEditorial.setVisible(false);
        cbTienda.setVisible(false);
        
        jList.setVisible(false);
        
        btnCancelar.setVisible(false);
        btnGuardar.setVisible(false);
        
        btnAlta.setVisible(true);
        btnBaja.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlta;
    private javax.swing.JButton btnBaja;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbCateg;
    private javax.swing.JComboBox<String> cbEditorial;
    private javax.swing.JComboBox<String> cbTienda;
    private com.toedter.calendar.JDateChooser dcFecha;
    private javax.swing.JList<String> jList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblCateg;
    private javax.swing.JLabel lblEditorial;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblIsbn;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblTienda;
    private javax.swing.JPanel pnlLibro;
    private javax.swing.JTextField tfAutor;
    private javax.swing.JTextField tfIsbn;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfPrecio;
    // End of variables declaration//GEN-END:variables
}
