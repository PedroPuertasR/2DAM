package dao;

import model.Libro;
import java.util.ArrayList;
public interface LibroDao {
    public ArrayList<Libro> getLibros();   
    public ArrayList<Libro> getLibroByAutor(int id);
    public Libro getLibroById(int id);
}
