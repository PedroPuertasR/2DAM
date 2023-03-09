/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Libro;
import persistence.NewHibernateUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class LibroDaoImplement  implements LibroDao{

    @Override
    public ArrayList<Libro> getLibros() {
        Session session = null;
        ArrayList<Libro> libros = null;
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Libro");
            libros = (ArrayList<Libro>) query.list();
        } catch (HibernateException HE){
            System.err.println(HE.getCause());
            System.err.println("Error doing a libro select.");
        } finally {
            if (session != null){
                session.close();
            }
        }
        return libros;
    }

    @Override
    public ArrayList<Libro> getLibroByAutor(int id) {
        ArrayList <Libro> lista = new ArrayList<>();
        ArrayList <Libro> listaFinal = new ArrayList<>();
        
        lista = getLibros();
        
        for (Libro libro : lista) {
            if(libro.getAutnumero() == id){
                listaFinal.add(libro);
            }
        }
        
        return listaFinal;
    }

    @Override
    public Libro getLibroById(int id) {

        ArrayList <Libro> lista = new ArrayList<Libro>();
        Libro l = null;
        
        lista = getLibros();

        for (Libro libro : lista) {
            if(libro.getCodigo() == id){
                l = libro;
            }
        }
        
        return l;
    }
    
}
