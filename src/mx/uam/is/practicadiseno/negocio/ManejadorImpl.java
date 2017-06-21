package mx.uam.is.practicadiseno.negocio;

import java.util.ArrayList;
import java.util.List;

import mx.uam.is.practicadiseno.datos.MapeadorDatos;

public class ManejadorImpl implements Manejador {

	public MapeadorDatos mapeador;
	public List <Observador> obs = new ArrayList<Observador>();

	/**
	 * Constructor que inicializa con algunos datos
	 *
	 */
	public ManejadorImpl(MapeadorDatos mapeador) {
		this.mapeador=mapeador;
		agrega("Entrada 1");
		agrega("Entrada 2");
		agrega("Entrada 3");
	}

	@Override
	public boolean agrega(String dato) {
		// TODO Auto-generated method stub
		mapeador.agrega(dato);
		notifica();
		return true;
	}

	@Override
	public boolean borra(String dato) {
		// TODO Auto-generated method stub
		mapeador.borra(dato);
		notifica();
		return true;
	}

	public boolean agregaObservador(Observador o) {
		// agregar un observador a la lista de observadores
		obs.add(o);
		return true;
		}
	public boolean quitaObservador(Observador o) {
		// quitar un observador de la lista de observadores
		if(obs.size()>1){
			obs.remove(o);
			notifica();
		}
		else{
			
			finaliza();
		}
		return true;
	}
	private void notifica() {
		// llamar actualiza() sobre todos los observadores
		
		for (Observador o: obs){
			o.actualiza();
		}
	}
	/**
	 * Metodo llamado cuando se cierra la ventana
	 *
	 */
	public void finaliza() {
		System.exit(0);
	}

	@Override
	public String[] dameDatos() {
		// TODO Auto-generated method stub
		
		return mapeador.dameDatos();
	}



	
}
