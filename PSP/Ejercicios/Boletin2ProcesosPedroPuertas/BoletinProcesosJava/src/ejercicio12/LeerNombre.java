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
        
        if(args.length == 0){
            System.out.println("No hay argumentos.");
            System.exit(-1);
        }else{
            for (int i = 0; i < args.length; i++) {
                System.out.println("Argumento nº " + (i + 1) + ": " + args[i]);
            }
            System.exit(1);
        }
    }
    
}
