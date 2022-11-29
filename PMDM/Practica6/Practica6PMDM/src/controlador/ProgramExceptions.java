/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author pedro
 */
public class ProgramExceptions extends RuntimeException{
    
    private String msg;
    private int err;
    
    public ProgramExceptions(){
    }
    
    public ProgramExceptions(int err){
        this.err = err;
        
        switch(err){
            case 1:
                this.msg = "Error en una consulta de SQL";
                break;
            case 2:
                this.msg = "Error en el login";
                break;
            case 3:
                this.msg = "Error en el acceso a la base de datos";
                break;
            case 4:
                this.msg = "Error en el guardado de la lista";
                break;
            case 5:
                this.msg = "Error en el movimiento por la lista";
                break;
            case 6:
                this.msg = "Error al actualizar una tabla";
                break;
            case 7:
                this.msg = "Error al borrar una fila";
                break;
            case 8:
                this.msg = "El ISBN debe tener 13 caracteres";
                break;
            case 9:
                this.msg = "El DNI no es válido";
                break;
            case 10:
                this.msg = "El presupuesto no puede ser menor que 0";
                break;
            case 11:
                this.msg = "No ha seleccionado la foto";
                break;
            default:
                this.msg = "Error en el programa";
        }
    }
    
    public void mostrarError(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        GregorianCalendar gc = new GregorianCalendar();
        
        String error = "Error Nº " + err + ": " + msg + ". " + sdf.format(gc.getTime());
        
        JOptionPane.showMessageDialog(null, error);
    }
    
    public static void guardarError(String error){
        try{
            BufferedWriter bf = new BufferedWriter(new FileWriter(new File(System.getProperty("user.dir") 
                    + "/src/logs/log.txt"), true));
            
            bf.write(error);
            bf.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
