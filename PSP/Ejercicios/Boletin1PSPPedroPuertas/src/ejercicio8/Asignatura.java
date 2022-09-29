/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio8;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Asignatura implements Serializable{
    
    private String nombre;
    private double nota;

    public Asignatura(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public double getNota() {
        return nota;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Asignatura{" + "Nombre:" + nombre + ", Nota:" + nota + '}';
    }
    
    /*Método para introducir la nota que comprueba si 
    esta es menor que 10 y mayor que 0*/
    public double introducirNota(){
        Scanner leer = new Scanner(System.in);
        double notaElegida;
        do{
            notaElegida = leer.nextDouble();
            
            if(notaElegida < 0 || notaElegida > 10){  
                System.out.println("Introduzca un número correcto.");
            }
            
        }while(notaElegida < 0 || notaElegida > 10);
        
        return notaElegida;
        
    }
    
}
