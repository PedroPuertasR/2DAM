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
    
    private Nodo [] arrayNodos;
    private int contador;
    
    public Lista(int n) {
        arrayNodos = new Nodo[n];
        contador = 0;
    }
    
    public void insertar(int indice, T typo) {
        
        arrayNodos[contador] = new Nodo<T>(indice, typo);
        // ********** MENSAJE DE CONTROL **********
        System.out.println(arrayNodos[contador].getTypo().toString());
        contador++;
        
    }
    
    public Nodo[] getArrayNodos() {
        return arrayNodos;
    }

    public void setArrayNodos(Nodo[] arrayNodos) {
        this.arrayNodos = arrayNodos;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
    public int getContador() {
        return contador;
    }
    
//    public void moveForward(){
//        //This method move de current pointer to the next node of the list.
//        if (actual.getSig() != null)
//            setActual(actual.getSig());
//    }
//    
//    public void goBack(){
//        //This method move de current pointer to the previous node of the list.
//        if (actual.getAnt() != null)
//            setActual(actual.getAnt());
//    }
//    
//    public void resetCurrentFirst(){
//        //When is required this method move the current pointer to the head list from beginning.
//        actual = first;
//    }
//    
//    public void resetCurrentLast(){
//        //When is required this method move the current pointer to the last list from ending.
//        actual = last;
//    }

//    public T getActual() {
//        return actual.getTypo();
//    }
    
}
