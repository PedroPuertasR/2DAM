package fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;

import com.example.pmdmtarea2.R;
import com.google.android.material.button.MaterialButtonToggleGroup;


public class Pregunta3 extends Fragment implements FragmentController {
    private MaterialButtonToggleGroup grupoBotonesPregunta;

    public Pregunta3() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.pregunta3, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // guardamos el grupo de botones del fragmento
        grupoBotonesPregunta = view.findViewById(R.id.grupoPreguntas3);
        // anadimos un OnGlobalLayoutListener al ViewTreeObserver para ejecutar un metodo cuando cargue el layout
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                // cuando se ejecuta quitamos el OnGlobalLayoutListener
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                // usamos el metodo resizeTextButton
                resizeTextButton(getArrayButtonChilds(grupoBotonesPregunta));
            }

        });
    }
    /**
     * Metodo que devuelve el texto del boton seleccionado.
     * @return texto boton seleccionado
     */
    @Override
    public String getSelected(){
        String seletecString;
        // obtiene el texto del boton seleccionado
        seletecString = quitarSaltoLinea(((Button)getActivity().findViewById(grupoBotonesPregunta.getCheckedButtonId())).getText().toString());

        return seletecString;
    }
    /**
     * Metodo que devuelve true si hay un boton seleccionado o false si no lo hay.
     * @return true si boton selecionado false si no
     */
    @Override
    public boolean checkSelected(){
        boolean selected;
        // si el id de grupo botones no es == a -1 devuelve true
        selected = !(grupoBotonesPregunta.getCheckedButtonId() == -1);

        return selected;
    }
    /**
     * Metodo que muestra un error.
     */
    @Override
    public void setError(){
        ((Button)grupoBotonesPregunta.getChildAt(grupoBotonesPregunta.getChildCount()-1)).setError(getResources().getString(R.string.error_radio_button_no_seleccionado));
    }
}