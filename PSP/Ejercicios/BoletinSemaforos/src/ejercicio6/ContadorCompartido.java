/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio6;

/**
 *
 * @author alumno
 */
public class ContadorCompartido {
    
    private int almacenar;
    
    public ContadorCompartido(int a){
        almacenar = a;
    }

    public int getN(String id){
        if(id.equalsIgnoreCase("Hilo 1")){
            almacenar = 1;
        }
        return almacenar;
    }
    
    public int setN(String id, int n){
        
        
        
    }
    
}
