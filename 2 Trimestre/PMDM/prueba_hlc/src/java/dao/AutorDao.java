/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.Autor;

/**
 *
 * @author alumno
 */
public interface AutorDao {
    
    public ArrayList<Autor> getAutores();
    public ArrayList<Autor> getAutor(String user, String pass);
    public String getNombreAutorById(int id);
    
}
