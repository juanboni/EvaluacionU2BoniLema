package ec.edu.ups.pweb.business;

import javax.ejb.Local;

import ec.edu.ups.pweb.model.Vehiculo;

@Local
public interface VehiculoONLocal {
	public void insertar(Vehiculo v) throws Exception;
}
