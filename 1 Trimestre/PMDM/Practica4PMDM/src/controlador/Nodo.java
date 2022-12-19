/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;

/**
 *
 * @author alumno
 */
public class Nodo <T> implements Serializable{
    
    private int indice;
    private T typo;

    public Nodo(int indice, T typo) {
        this.typo = typo;
        this.indice = indice;
    }

    public T getTypo() {
        return typo;
    }

    public void setTypo(T typo) {
        this.typo = typo;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

}
