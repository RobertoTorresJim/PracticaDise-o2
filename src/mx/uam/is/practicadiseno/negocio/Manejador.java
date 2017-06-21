package mx.uam.is.practicadiseno.negocio;

import mx.uam.is.practicadiseno.datos.MapeadorDatos;

public interface Manejador {
	
	
	public String[] dameDatos();

	public boolean agrega(String dato);
	
	public boolean borra(String dato);
	
	public boolean agregaObservador(Observador o);
	
	public boolean quitaObservador(Observador o);
	
	public void finaliza();

}
