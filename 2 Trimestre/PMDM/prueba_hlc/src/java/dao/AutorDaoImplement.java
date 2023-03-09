/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.Autor;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import persistence.NewHibernateUtil;

/**
 *
 * @author alumno
 */
public class AutorDaoImplement implements AutorDao{

    @Override
    public ArrayList<Autor> getAutores() {
        
        Session session = null;
        ArrayList <Autor> lista = null;
        
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Autor");
            lista = (ArrayList<Autor>) query.list();
        } catch (HibernateException HE) {
            System.err.println(HE.getCause());
            System.err.println("Error doing a trabajo select.");
        } finally {
            if (session != null) {
                session.close();
            }
        }
        
        return lista;
    }

    @Override
    public ArrayList<Autor> getAutor(String user, String pass) {

        ArrayList<Autor> listaFinal = new ArrayList<>();
        ArrayList<Autor> autores = getAutores();
        for (Autor aut: autores){
            if(aut.getNombre().equals(user) && aut.getPassowrd().equals(pass)){
                listaFinal.add(aut);
            }
        }
        return listaFinal;
        
    }

    @Override
    public String getNombreAutorById(int id) {
        ArrayList<Autor> autores = getAutores();
        String nombre = "";
        
        for (Autor aut: autores){
            if(aut.getNumero() == id){
                nombre = aut.getNombre() + " " + aut.getApellido();
            }
        }
        return nombre;
    }
    
}
