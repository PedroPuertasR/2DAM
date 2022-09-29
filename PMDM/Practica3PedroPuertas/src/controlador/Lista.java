/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author alumno
 */
public class Lista <T>{
    
    private Nodo inicial;

    public Lista() {
        this.inicial = null;
    }

    public Nodo getInicio() {
        return inicial;
    }

    public void setInicio(Nodo inicio) {
        this.inicial = inicio;
    }
    
    //Métodos
    
    public void insertar (T objeto){
        Nodo n = new Nodo(objeto);
        Nodo aux;
        
        if(inicial == null){
            inicial = n;
        }else{
            aux = inicial;
            
            while(aux.getSiguiente() == null){
                aux = aux.getSiguiente();
            }
            
            n.setAnterior(aux);
            aux.setSiguiente(n);
            
        }
    }    
    
}
