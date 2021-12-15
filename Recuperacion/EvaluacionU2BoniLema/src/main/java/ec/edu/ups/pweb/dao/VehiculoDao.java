package ec.edu.ups.pweb.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import ec.edu.ups.pweb.model.Vehiculo;
@Stateless
public class VehiculoDao {
	
	@PersistenceContext // 
	private EntityManager em;
	
	public void insert(Vehiculo op) {
		em.persist(op);
	}
	
	public void update(Vehiculo op) {
		em.merge(op);
	}
	
	public Vehiculo read(int id) {
		Vehiculo op= em.find(Vehiculo.class, id);
		return op;
	}
	
	public void delete(int id) {
		Vehiculo op= em.find(Vehiculo.class, id);
		em.remove(op);
	}
	
	public List<Vehiculo> getList(String busqueda){
		List<Vehiculo> listado=new ArrayList<Vehiculo>();
		String jpql="SELECT p FROM Vehiculo p"
				+" WHERE p.marca = ?1 or p.modelo = ?2 or p.anio = ?3";
		Query query= em.createQuery(jpql,Vehiculo.class);
		query.setParameter(1, busqueda);
		query.setParameter(2, busqueda);
		query.setParameter(3, busqueda);
		listado = query.getResultList();
		return listado;
	}
	

}
