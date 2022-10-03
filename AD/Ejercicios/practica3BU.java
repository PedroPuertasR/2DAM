private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                              
    // TODO add your handling code here:
    
    botonSiguiente.setVisible(true);
    botonAnterior.setVisible(true);
    botonNuevo.setVisible(true);
    botonCancelar.setVisible(false);
    botonAceptar.setVisible(false);
    saldoField.setEditable(false);
    propietarioField.setEditable(false);
    saldoField.setEnabled(false);
    propietarioField.setEnabled(false);
    
    if(aux.getSiguiente() == null){
        botonSiguiente.setEnabled(false);
        botonAnterior.setEnabled(true);
    }else if(aux.getAnterior() == null){
        botonAnterior.setEnabled(false);
        botonSiguiente.setEnabled(true);
    }else{
        botonAnterior.setEnabled(true);
        botonSiguiente.setEnabled(true);
    }
    
    numeroField.setText("" + actual.getNumero());
    fechaField.setText("" + actual.getFecha().toInstant());
    saldoField.setText("" + actual.getSaldo() + " €");
    propietarioField.setText("" + actual.getPropietario());
}                                             

private void botonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {                                              
    // TODO add your handling code here:
    
    if(aux.getAnterior() == null){
        botonAnterior.setEnabled(false);
    }else{
        aux = aux.getAnterior();
        actual = (Cuenta) aux.getDato();
        if(!botonSiguiente.isEnabled()){
            botonSiguiente.setEnabled(true);
        }else if(aux.getAnterior() == null){
            botonAnterior.setEnabled(false);
        }
    }
    
    numeroField.setText("" + actual.getNumero());
    fechaField.setText("" + actual.getFecha().toInstant());
    saldoField.setText("" + actual.getSaldo() + " €");
    propietarioField.setText("" + actual.getPropietario());
    
}                                             

private void botonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {                                               
    // TODO add your handling code here:
    
    if(aux.getSiguiente() == null){
        botonSiguiente.setEnabled(false);
    }else{
        aux = aux.getSiguiente();
        actual = (Cuenta) aux.getDato();
        if(!botonAnterior.isEnabled()){
            botonAnterior.setEnabled(true);
        }else if(aux.getSiguiente() == null){
            botonSiguiente.setEnabled(false);
        }
    }
    
    numeroField.setText("" + actual.getNumero());
    fechaField.setText("" + actual.getFecha().toInstant());
    saldoField.setText("" + actual.getSaldo() + " €");
    propietarioField.setText("" + actual.getPropietario());
    
}                                              

private void botonNuevoActionPerformed(java.awt.event.ActionEvent evt) {                                           
    // TODO add your handling code here:
    
    botonAnterior.setVisible(false);
    botonSiguiente.setVisible(false);
    botonNuevo.setVisible(false);
    botonAceptar.setVisible(true);
    botonCancelar.setVisible(true);
    
    saldoField.setEditable(true);
    propietarioField.setEditable(true);
    saldoField.setEnabled(true);
    propietarioField.setEnabled(true);
    
    numeroField.setText("");
    fechaField.setText("");
    saldoField.setText("");
    propietarioField.setText("");   
}                                          

private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {                                             
    // TODO add your handling code here:
    
    botonSiguiente.setVisible(true);
    botonAnterior.setVisible(true);
    botonNuevo.setVisible(true);
    botonCancelar.setVisible(false);
    botonAceptar.setVisible(false);
    
    botonAnterior.setEnabled(true);
    botonSiguiente.setEnabled(false);
    
    saldoField.setEditable(false);
    propietarioField.setEditable(false);
    saldoField.setEnabled(false);
    propietarioField.setEnabled(false);
    
    try {
        double s = Double.parseDouble(saldoField.getText());
        listado.insertar(new Cuenta(contador++, new GregorianCalendar(), s, propietarioField.getText()));

    } catch (NumberFormatException nf) {
        System.out.println(saldoField.getText() + ", no es un número.");
    }
    
    aux = listado.getFin();
    
    actual = (Cuenta) aux.getDato();
    
    numeroField.setText("" + actual.getNumero());
    fechaField.setText("" + actual.getFecha().toInstant());
    saldoField.setText("" + actual.getSaldo() + " €");
    propietarioField.setText("" + actual.getPropietario());
}