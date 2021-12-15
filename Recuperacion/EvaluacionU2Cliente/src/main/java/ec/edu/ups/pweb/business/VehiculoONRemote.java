package ec.edu.ups.pweb.business;

import java.util.List;

import ec.edu.ups.pweb.model.Vehiculo;

public interface VehiculoONRemote {
	public void insertar(Vehiculo v) throws Exception;
	public List<Vehiculo> getvehiculos(String busqueda);
}
