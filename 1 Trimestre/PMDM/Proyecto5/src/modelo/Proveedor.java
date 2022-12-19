package modelo;

public class Proveedor {
    private int codProv;
    private String nombre;
    private String password;
    private String foto;
    private float precioMedio;

    public Proveedor(int codProv, String nombre, String password, float precioMedio, String foto) {
        this.codProv = codProv;
        this.nombre = nombre;
        this.password = password;
        this.foto = foto;
        this.precioMedio = precioMedio;
    }

    public int getCodProv() {
        return codProv;
    }

    public void setCodProv(int codProv) {
        this.codProv = codProv;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public float getPrecioMedio() {
        return precioMedio;
    }

    public void setPrecioMedio(float precioMedio) {
        this.precioMedio = precioMedio;
    }

    @Override
    public String toString() {
        return "Proveedor{" 
                + "codProv=" + codProv 
                + ", nombre=" + nombre 
                + ", password=" + password 
                + ", foto=" + foto 
                + ", precioMedio=" + precioMedio + '}';
    }

}
