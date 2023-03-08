package ejercicio;

import java.net.Socket;

public class ComunHilos {

    //max de conexiones permitidas
    private int maxConexiones;
    //número de conexiones creadas
    private int numConexiones;
    //número de conexiones en este momento
    private int numconexionesActuales;

    //mensaje escrito por el chat
    String mensajes;
    //array de los sockets conectados
    Socket[] socket = new Socket[maxConexiones];

    //constructores
    public ComunHilos(int maximo, int actuales, int conexiones, Socket[] array) {
        maxConexiones = maximo;
        numconexionesActuales = actuales;
        numConexiones = conexiones;
        this.socket = array;
        mensajes = "";
    }

    public ComunHilos() {
        super();
    }

    public String getMensajes() {
        return mensajes;
    }

    public synchronized void setMensajes(String mensajes) {
        this.mensajes = mensajes;
    }

    public int getNumConexiones() {
        return numConexiones;
    }

    public void setNumConexiones(int numConexiones) {
        this.numConexiones = numConexiones;
    }

    public int getNumconexionesActuales() {
        return numconexionesActuales;
    }

    public void setNumconexionesActuales(int numconexionesActuales) {
        this.numconexionesActuales = numconexionesActuales;
    }

    public int getMaxConexiones() {
        return maxConexiones;
    }

    public void setMaxConexiones(int maxConexiones) {
        this.maxConexiones = maxConexiones;
    }

    public synchronized void aniadirArray(Socket s, int i) {
        socket[i] = s;
    }

    public Socket getElementoArray(int i) {
        return socket[i];
    }
}
