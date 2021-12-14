package ec.edu.ups.pweb.business;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pweb.dao.VehiculoDao;
import ec.edu.ups.pweb.model.Vehiculo;

@Stateless
public class VehiculoON implements VehiculoONLocal, VehiculoONRemote{
	
	@Inject
	private VehiculoDao vehiculodao;
	public void insertar(Vehiculo v) throws Exception {
		vehiculodao.insert(v);	
	}
	
	public void buscar() {
		
	}

}
