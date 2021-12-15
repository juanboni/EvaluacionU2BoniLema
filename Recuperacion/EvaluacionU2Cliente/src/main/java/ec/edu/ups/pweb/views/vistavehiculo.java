package ec.edu.ups.pweb.views;

import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import ec.edu.ups.pweb.business.VehiculoONRemote;
import ec.edu.ups.pweb.model.Vehiculo;



public class vistavehiculo {
	
	private VehiculoONRemote vehiculoremote;
	
	public void conectar() throws Exception {
		try {  
            final Hashtable<String, Comparable> jndiProperties =  
                    new Hashtable<String, Comparable>();  
            jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,  
                    "org.wildfly.naming.client.WildFlyInitialContextFactory");  
            jndiProperties.put("jboss.naming.client.ejb.context", true);  
              
            jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");  
            jndiProperties.put(Context.SECURITY_PRINCIPAL, "demop59");  
            jndiProperties.put(Context.SECURITY_CREDENTIALS, "demop59");  
              
            final Context context = new InitialContext(jndiProperties);  
              
            final String lookupName = "ejb:/EvaluacionU2BoniLema/VehiculoON!ec.edu.ups.pweb.business.VehiculoONRemote";
            this.vehiculoremote = (VehiculoONRemote) context.lookup(lookupName);
            
            
        } catch (Exception ex) {  
            ex.printStackTrace();  
            throw ex;  
        }  
	}
	
	public void crearvehiculo() {
		Vehiculo v=new Vehiculo();
		v.setNumero(1);
		v.setMarca("toyotares");
		v.setModelo("bounjour");
		v.setAnio("2021");
		Vehiculo v1=new Vehiculo();
		v1.setNumero(2);
		v1.setMarca("toyotares");
		v1.setModelo("yaris");
		v1.setAnio("2020");
		Vehiculo v2=new Vehiculo();
		v2.setNumero(3);
		v2.setMarca("mazda");
		v2.setModelo("cx5");
		v2.setAnio("2021");
		Vehiculo v3=new Vehiculo();
		v3.setNumero(4);
		v3.setMarca("hiunday");
		v3.setModelo("tucson");
		v3.setAnio("2019");
		
		try {
			vehiculoremote.insertar(v);
			vehiculoremote.insertar(v1);
			vehiculoremote.insertar(v2);
			vehiculoremote.insertar(v3);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mostrarvehiculos(String busqueda) {
		List<Vehiculo> listav=this.vehiculoremote.getvehiculos(busqueda);
		for(Vehiculo v : listav) {
			System.out.println(v.getMarca()+","+v.getModelo()+","+v.getAnio());
		}
	}
	public List<Vehiculo> mostrarvehiculo(String busqueda) {
		List<Vehiculo> listav=this.vehiculoremote.getvehiculos(busqueda);
		return listav;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		vistavehiculo vv=new vistavehiculo();
		try {
			vv.conectar();
			//vv.crearvehiculo();
			vv.mostrarvehiculos("2021");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
