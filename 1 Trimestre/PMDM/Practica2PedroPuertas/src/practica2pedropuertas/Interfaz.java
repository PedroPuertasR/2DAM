/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2pedropuertas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Pedro
 */
public class Interfaz extends JFrame {

    private JLabel numeroLabel;
    private JLabel fechaLabel;
    private JLabel saldoLabel;
    private JLabel propietarioLabel;

    private static String numeroString = "Numero de cuenta: ";
    private static String fechaString = "Fecha de apertura: ";
    private static String saldoString = "Saldo: ";
    private static String propietarioString = "Titular: ";

    private TextField numeroField;
    private TextField fechaField;
    private TextField saldoField;
    private TextField propietarioField;
    
    private static Cuenta actual;
    Cuenta c1 = new Cuenta(3211, "Santiago Blanco");
    Cuenta c2 = new Cuenta(34521, "Álvaro López");
    Cuenta c3 = new Cuenta(38492, "Pablo Jiménez");
    Cuenta c4 = new Cuenta(5002, "Fernando García");
    Cuenta c5 = new Cuenta(9861, "Alberto González");
    
    private boolean focusIsSet = false;

    public void setFocus() {
        if (!focusIsSet) {
            numeroField.requestFocus();
            focusIsSet = true;
        }
    }

    public Interfaz() {

        super("Interfaz");
        
        actual = Cuenta.getInicial();

        numeroLabel = new JLabel(numeroString);
        fechaLabel = new JLabel(fechaString);
        saldoLabel = new JLabel(saldoString);
        propietarioLabel = new JLabel(propietarioString);

        numeroField = new TextField(30);
        fechaField = new TextField(30);
        saldoField = new TextField(30);
        propietarioField = new TextField(30);

        numeroField.setText("" + Cuenta.getInicial().getNumero());
        fechaField.setText("" + Cuenta.getInicial().getFecha().toInstant());
        saldoField.setText("" + Cuenta.getInicial().getSaldo());
        propietarioField.setText("" + Cuenta.getInicial().getPropietario());

        numeroField.setForeground(Color.blue);
        fechaField.setForeground(Color.blue);
        saldoField.setForeground(Color.blue);
        propietarioField.setForeground(Color.blue);

        numeroField.setEditable(false);
        fechaField.setEditable(false);
        saldoField.setEditable(false);
        propietarioField.setEditable(false);

        JButton botonIzq = new JButton("←");
        JButton botonDer = new JButton("→");
        JButton botonNuevo = new JButton("Crear");
        JButton botonAceptar = new JButton("Aceptar");
        JButton botonCancelar = new JButton("Cancelar");

        botonAceptar.setVisible(false);
        botonCancelar.setVisible(false);
        botonIzq.setVisible(true);
        botonDer.setVisible(true);
        botonIzq.setEnabled(false);
        botonDer.setEnabled(true);

        botonIzq.setMnemonic(KeyEvent.VK_LEFT);
        botonDer.setMnemonic(KeyEvent.VK_RIGHT);

        botonIzq.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                if(actual.getAnterior() == null){
                    botonIzq.setEnabled(false);
                }else{
                    actual = actual.getAnterior();
                    if(!botonDer.isEnabled()){
                        botonDer.setEnabled(true);
                    }else if(actual.getAnterior() == null){
                        botonIzq.setEnabled(false);
                    }
                }

                numeroField.setText("" + actual.getNumero());
                fechaField.setText("" + actual.getFecha().toInstant());
                saldoField.setText("" + actual.getSaldo() + " €");
                propietarioField.setText("" + actual.getPropietario());
                
            }

        });

        botonDer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                if(actual.getSiguiente() == null){
                    botonDer.setEnabled(false);
                }else{
                    actual = actual.getSiguiente();
                    if(!botonIzq.isEnabled()){
                        botonIzq.setEnabled(true);
                    }else if(actual.getSiguiente() == null){
                        botonDer.setEnabled(false);
                    }
                }
                
                numeroField.setText("" + actual.getNumero());
                fechaField.setText("" + actual.getFecha().toInstant());
                saldoField.setText("" + actual.getSaldo() + " €");
                propietarioField.setText("" + actual.getPropietario());
            }

        });

        botonNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                botonIzq.setEnabled(false);
                botonDer.setEnabled(false);
                botonNuevo.setEnabled(false);
                botonIzq.setVisible(false);
                botonDer.setVisible(false);
                botonAceptar.setVisible(true);
                botonCancelar.setVisible(true);
                botonNuevo.setVisible(false);
                saldoField.setEditable(true);
                propietarioField.setEditable(true);

                numeroLabel.setText(numeroString);
                fechaLabel.setText(fechaString);
                saldoLabel.setText(saldoString);
                propietarioLabel.setText(propietarioString);

                numeroField.setText("");
                fechaField.setText("");
                saldoField.setText("");
                propietarioField.setText("");

            }

        });

        botonAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String sNum;
                double s;

                sNum = saldoField.getText();

                try {
                    s = Double.parseDouble(sNum);
                    actual = new Cuenta(s, propietarioField.getText());
                } catch (NumberFormatException nf) {
                    System.out.println(sNum + ", no es un número.");
                }

                botonAceptar.setVisible(false);
                botonCancelar.setVisible(false);
                botonIzq.setVisible(true);
                botonDer.setVisible(true);
                botonDer.setEnabled(true);
                botonIzq.setEnabled(false);
                botonNuevo.setEnabled(true);
                botonNuevo.setVisible(true);
                saldoField.setEditable(false);
                propietarioField.setEditable(false);

                numeroLabel.setText(numeroString);
                fechaLabel.setText(fechaString);
                saldoLabel.setText(saldoString);
                propietarioLabel.setText(propietarioString);

                numeroField.setText("" + actual.getNumero());
                fechaField.setText("" + actual.getFecha().toInstant());
                saldoField.setText("" + actual.getSaldo() + " €");
                propietarioField.setText("" + actual.getPropietario());

            }

        });

        botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                botonAceptar.setVisible(false);
                botonCancelar.setVisible(false);
                botonIzq.setVisible(true);
                botonDer.setVisible(true);
                botonNuevo.setVisible(true);
                botonNuevo.setEnabled(true);
                saldoField.setEditable(false);
                propietarioField.setEditable(false);
                
                if(actual.getSiguiente() == null){
                    botonDer.setEnabled(false);
                    botonIzq.setEnabled(true);
                }else if(actual.getAnterior() == null){
                    botonIzq.setEnabled(false);
                    botonDer.setEnabled(true);
                }else{
                    botonIzq.setEnabled(true);
                    botonDer.setEnabled(true);
                }

                numeroLabel.setText(numeroString);
                fechaLabel.setText(fechaString);
                saldoLabel.setText(saldoString);
                propietarioLabel.setText(propietarioString);

                numeroField.setText("" + actual.getNumero());
                fechaField.setText("" + actual.getFecha().toInstant());
                saldoField.setText("" + actual.getSaldo() + " €");
                propietarioField.setText("" + actual.getPropietario());
            }

        });

        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(0, 1));
        labelPanel.add(numeroLabel);
        labelPanel.add(fechaLabel);
        labelPanel.add(saldoLabel);
        labelPanel.add(propietarioLabel);

        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(new GridLayout(0, 1));
        fieldPanel.add(numeroField);
        fieldPanel.add(fechaField);
        fieldPanel.add(saldoField);
        fieldPanel.add(propietarioField);

        JPanel botonPanel = new JPanel();
        botonPanel.setLayout(new BorderLayout());
        botonPanel.add(botonNuevo, BorderLayout.CENTER);
        botonPanel.add(botonIzq, BorderLayout.PAGE_START);
        botonPanel.add(botonDer, BorderLayout.PAGE_END);
        botonPanel.add(botonAceptar, BorderLayout.WEST);
        botonPanel.add(botonCancelar, BorderLayout.EAST);

        JPanel todo = new JPanel();
        todo.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        todo.setLayout(new BorderLayout());
        todo.add(labelPanel, BorderLayout.CENTER);
        todo.add(fieldPanel, BorderLayout.EAST);
        todo.add(botonPanel, BorderLayout.PAGE_END);

        setContentPane(todo);

    }

}
