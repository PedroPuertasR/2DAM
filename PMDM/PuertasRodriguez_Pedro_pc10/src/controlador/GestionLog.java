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

/**
 *
 * @author alumno
 */
public class GestionLog {
    

    private static Errores e;
    
    public static void guardarError(){
        try{
            BufferedWriter bf = new BufferedWriter(new FileWriter(new File(System.getProperty("user.dir") 
                    + "/src/logs/log.txt"), true));
            
            bf.write(e.mostrarError());
            bf.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
