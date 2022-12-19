/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.Comparator;

/**
 *
 * @author alumno
 */
public class ComparadorNumCuenta implements Comparator <Nodo>{
    
    @Override
    public int compare(Nodo n1, Nodo n2) {

	if(n1.getIndice() < n2.getIndice()) {
            return -1;
	}else if(n1.getIndice() == n2.getIndice()) {
            return 1;
	}else {
            return 1;
	}
}
}
