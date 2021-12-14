package ec.edu.ups.pweb.business;

import javax.ejb.Remote;

import ec.edu.ups.pweb.model.Vehiculo;

@Remote
public interface VehiculoONRemote {
	public void insertar(Vehiculo v) throws Exception;
}
