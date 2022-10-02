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
    
    private Nodo inicio;
    private Nodo fin;

    public Lista() {
        //this.inicial = null;
        inicio = fin = null;
    }

    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public Nodo getFin() {
        return fin;
    }

    public void setFin(Nodo fin) {
        this.fin = fin;
    }
    
    //Métodos
    
    public boolean esVacio(){
        if(inicio == null){
            return true;
        }else{
            return false;
        }
    }
    
    public void insertar (T objeto){
        
        if(!esVacio()){
            fin = new Nodo(objeto, null, fin);
            fin.getAnterior().setSiguiente(fin);
        }else{
            inicio = fin = new Nodo(objeto);
        }
        /*Nodo n = new Nodo(objeto);
        Nodo aux;
        
        if(inicio == null){
            inicio = n;
        }else{
            aux = inicio;
            
            while(aux.getSiguiente() == null){
                aux = aux.getSiguiente();
            }
            
            n.setAnterior(aux);
            aux.setSiguiente(n);
        }
        */
    }
    
}
