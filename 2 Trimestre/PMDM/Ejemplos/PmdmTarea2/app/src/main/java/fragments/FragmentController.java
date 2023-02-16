package fragments;

import android.widget.Button;

import com.google.android.material.button.MaterialButtonToggleGroup;

/**
 * Interfaz que contiene los controles de los fragments de las preguntas.
 */
public interface FragmentController {

    String getSelected();
    boolean checkSelected();
    void setError();

    /**
     * Cambia las lineas del boton si el texto es demasiado largo
     * @param botones array botones a comprobar
     */
    default void resizeTextButton(Button[] botones){
        StringBuilder cadenaBoton = new StringBuilder();
        double botonSize;
        double textoSize;
        int mitadCadena;
        boolean found;
        // recorremos el array de botones a comprobar
        for(int i=0;i<botones.length;i++){
            // anadimos el texto del boton actual al StringBuilder cadenaBoton
            cadenaBoton.append(botones[i].getText());
            // obtenemos el valor de la mitad del tamano de la cadena
            mitadCadena = cadenaBoton.length()/2;
            // obtenemos el width del boton
            botonSize = botones[i].getWidth();
            // obtenemos el tamano de la cadena multiplicado por 20
            textoSize = botones[i].getText().length()*20;
            // le damos el valor de false a found
            found = false;
            // si el texto es mayor al 96% del tamano del boton
            if(textoSize > botonSize*0.96){
                // mientras found sea false
                do{
                    // si encuentra un espacio vacio en la cadena o llega al ultimo caracter cambia found a true
                    if(mitadCadena >= cadenaBoton.length() || cadenaBoton.charAt(mitadCadena++)==' ')
                        found = true;

                }while(!found);
                // anadimos el salto de linea la mitad de la cadena(primer espacio en blanco dps de la mitad)
                cadenaBoton.insert(mitadCadena,"\n");
                // cambiamos el maximo de lineas del boton a 2
                botones[i].setMaxLines(2);
                // anadimos el nuevo texto al boton
                botones[i].setText(cadenaBoton.toString());
            }
            //borramos el contenido del objeto StringBuilder
            cadenaBoton.delete(0,cadenaBoton.length());
        }
    }

    /**
     * Metodo que recibe el grupo de botones y devuelve un array con los botones que lo componen.
     * @param buttonGroup grupo de botones
     * @return devuelve los botones del grupo de botones
     */
    default Button[] getArrayButtonChilds(MaterialButtonToggleGroup buttonGroup){
        // crea un array de botones
        Button[] botones = new Button[buttonGroup.getChildCount()];
        // recprre el array de botones guardando el boton
        for(int i=0;i<botones.length;i++){
            botones[i] = (Button)buttonGroup.getChildAt(i);
        }
        // devuelve el array de botones
        return botones;
    }

    /**
     * Metodo que quita los saltos de linea.
     * @param cadena cadena a cambiar
     * @return cadena sin salto de linea
     */
    default String quitarSaltoLinea(String cadena){
        String newCadena = cadena;
        // si contiene un salto de linea lo remplaza por ""
        if(cadena.contains("\n"))
            newCadena = cadena.replace("\n","");
        return newCadena;
    }

}
