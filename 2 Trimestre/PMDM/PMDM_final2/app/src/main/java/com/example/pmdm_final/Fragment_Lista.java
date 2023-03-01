package com.example.pmdm_final;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Fragment_Lista extends ListFragment {

    private Callbacks mCallbacks = CallbacksVacios;

    public interface Callbacks {
        public void onEntradaSelecionada(String id);
    }

    private static Callbacks CallbacksVacios = new Callbacks() {
        @Override
        public void onEntradaSelecionada(String id) {
        }
    };

    public Fragment_Lista() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new Lista_adaptador(getActivity(), R.layout.layout_elemento_listado, Lista_contenido.ENTRADAS_LISTA){
            @Override
            public void onEntrada(Object entrada, View view) {
                if (entrada != null) {
                    TextView texto_superior_entrada = (TextView) view.findViewById(R.id.textView_titulo);
                    if (texto_superior_entrada != null)
                        texto_superior_entrada.setText(((Lista_contenido.Lista_entrada) entrada).textoEncima);

                    ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imageView_imagen_miniatura);
                    if (imagen_entrada != null)
                        imagen_entrada.setImageResource(((Lista_contenido.Lista_entrada) entrada).idImagen);
                }
            }
        });

    }

    /*@Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (!(activity instanceof Callbacks)) {
            throw new IllegalStateException("Error: La actividad debe implementar el callback del fragmento");
        }

        mCallbacks = (Callbacks) activity;
    }*/

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = CallbacksVacios;
    }

    @Override
    public void onListItemClick(ListView listView, View view, int posicion, long id) {
        super.onListItemClick(listView, view, posicion, id);
        mCallbacks.onEntradaSelecionada(Lista_contenido.ENTRADAS_LISTA.get(posicion).id);
    }

}