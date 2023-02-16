package com.example.pmdmtarea2;




import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

/**
 * Clase que crea una toolbar para la activity y controla el menu. Puede tener un menu o no.
 * @author Rui Jorge
 */
public final class ToolbarController implements View.OnClickListener {
    private Toolbar toolbar;
    private ImageButton botonMenu;
    private AppCompatActivity activity;
    private PopupMenu popupMenu;

    /**
     * Constructor de ToolbarController. Crea un objeto con una toolbar con menu.
     * @param activity actividad actual
     */
    public ToolbarController(AppCompatActivity activity){
        this(activity,Visibilidad.VISIBLE);
    }

    /**
     * Constructor de ToolbarController. Crea un objeto con una toolbar con menu o no dependiendo de la visibilidad del menu pasado como parametro.
     * @param activity actividad actual
     * @param visibilidad visibilidad del menu
     */
    @SuppressLint("WrongConstant")
    public ToolbarController(AppCompatActivity activity, Visibilidad visibilidad){
        this.activity = activity;
        this.toolbar = this.activity.findViewById(R.id.toolbar);
        this.botonMenu = this.activity.findViewById(R.id.imageMenu);
        setToolbar();
        this.botonMenu.setVisibility(visibilidad.getVisibilidad());
        if(visibilidad.isVISIBLE()){
            this.botonMenu.setOnClickListener(this);
            createPopup();
        }
    }

    // Establece toolbar como la actionbar de nuestra app y ponemos el ShowTitleEnabled en false para que no se vea el titulo de la app.
    private void setToolbar(){
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setDisplayShowTitleEnabled(false);
    }


    // Crea el menu de la toolbar.
    private void createPopup(){
        // crea un nuevo objeto PopupMenu
        popupMenu = new PopupMenu(this.activity,botonMenu);
        // inflamos el popup con el menu del toolbar
        popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());
        // ponemos un OnMenuItemClickListener para detectar la opcion elegida del menu
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            // sobrescribimos el metodo onMenuItemClick para que el menu haga lo que queramos
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent nuevaActividad;
                Class clase;
                // hacemos un switch con el id del objeto elegido del menu
                switch (item.getItemId()){
                    // si es el id de menuAcerca guardamos la clase Acerca
                    case R.id.menuAcerca:
                        clase = Acerca.class;
                        break;
                    // si es el id de menuAcerca guardamos la clase Ayuda
                    case R.id.menuAyuda:
                        clase = Ayuda.class;
                        break;
                    // si no es ninguno de los anteriores devuelve false
                    default:
                        return false;
                }
                // inicializamos una nueva actividad pasando el atributo activity y la clase a la que ir
                nuevaActividad = new Intent(activity,clase);
                // iniciamos la nueva actividad
                activity.startActivity(nuevaActividad);
                // devolvemos true
                return true;
            }
        });
    }

    // sobrescribimos el metodo onClick para que ensene el menu cuando pulsamos en el boton de la toolbar
    @Override
    public void onClick(View view) {
        popupMenu.show();
    }

    /**
     * Enum visibilidad tiene 2 valores VISIBLE o INVISIBLE.
     */
    public enum Visibilidad{
        VISIBLE(View.VISIBLE), INVISIBLE(View.INVISIBLE);
        //
        private final int visibilidad;
        // Constructor del enum
        Visibilidad(int visibilidad){
            this.visibilidad = visibilidad;
        }
        // metodo para saber si es visible
        private boolean isVISIBLE(){
            return (visibilidad == View.VISIBLE);
        }
        // metodo que devuelve el atributo visibilidad del enum
        private int getVisibilidad() {
            return visibilidad;
        }
    }
}
