package ec.edu.ups.pweb.business;



import java.util.List;

import javax.ejb.Local;


import ec.edu.ups.pweb.model.Vehiculo;

@Local
public interface VehiculoONLocal {
	public void insertar(Vehiculo v) throws Exception;
	public List<Vehiculo> getvehiculos(String busqueda);
}
