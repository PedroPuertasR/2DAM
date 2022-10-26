/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio12;

/**
 *
 * @author pedro
 */
public class LeerNombre {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Comprobamos si existen argumentos, en caso de que no avisamos y realizamos la salida en -1
        if(args.length == 0){
            System.out.println("No hay argumentos.");
            System.exit(-1);
        }else{
            //En caso de que sí haya argumentos los mostramos por la salida estándar y salimos en 1
            for (int i = 0; i < args.length; i++) {
                System.out.println("Argumento nº " + (i + 1) + ": " + args[i]);
            }
            System.exit(1);
        }
    }
    
}
