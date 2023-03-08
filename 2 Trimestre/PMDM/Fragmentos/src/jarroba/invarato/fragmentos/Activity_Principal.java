package jarroba.invarato.fragmentos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;


/**
 * Esta actividad detectará el tamaño de la pantalla y variará en función a esta.
 * En móviles solo representará un único fragmento de listado, al pulsar un elemento abrirá la actividad Activity_Entrada.
 * En tablets representará dos fragmentos, el listado a la izquierda y el detalle de la entrada seleccionada a la derecha
 * Implementa el Callback para escuchar que entrada del listado se ha pulsado y cargarla en consecuencia
 * @author Google, modificado por Ramon Invarato Menéndez
 * @see {@link www.jarroba.es}
 */
public class Activity_Principal extends FragmentActivity implements Fragment_Lista.Callbacks {
	
	//Guardará TRUE si es una pantalla grande y caben dos fragmentos; o FALSE si es una pantalla pequeña y cabe solo un fragmento
	private boolean dosFragmentos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_activity_principal_listado);
		
		//Se comprueba que exista el framelayout framelayout_contenedor_entrada. Si existe estaremos usando activity_dospaneles.xml, sino estaremos usando activity_listado.xml 
		if (findViewById(R.id.framelayout_contenedor_detalle) != null) {
			// Entra aquí solo en diseños para pantallas grandes (es decir, si usamos res/values-large o res/values-sw600dp). Estaremos usando activity_dospaneles.xml
			dosFragmentos = true;
		}
	}

	
	/**
	 * Método Callback que escucha cuando un elemento de la lista ha sido pulsado, entonces entra aquí. Devuelve el ID del elemento de la lista que fue seleccionado
	 */
	@Override
	public void onEntradaSelecionada(String id) {
		if (dosFragmentos) {
			// Si estamos en pantallas grandes, se mostrará el detalle seleccionado en esta misma actividad remplazando el fragmento del detalle por el nuevo
			Bundle arguments = new Bundle();
			arguments.putString(Fragment_Detalle.ARG_ID_ENTRADA_SELECIONADA, id);
			Fragment_Detalle fragment = new Fragment_Detalle();
			fragment.setArguments(arguments);
			getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_contenedor_detalle, fragment).commit();

		} else {
			// En pantallas pequeñas, iniciaremos una nueva actividad con el contenido del elemento seleccionado de la lista
			Intent detailIntent = new Intent(this, Activity_Detalle.class);
			detailIntent.putExtra(Fragment_Detalle.ARG_ID_ENTRADA_SELECIONADA, id);
			startActivity(detailIntent);
		}
	}
}
