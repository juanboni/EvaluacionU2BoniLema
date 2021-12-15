package ec.edu.ups.pweb.views;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ec.edu.ups.pweb.business.VehiculoONLocal;
import ec.edu.ups.pweb.model.Vehiculo;

/**
 * Servlet implementation class vistavehiculo
 */
@WebServlet("/vistavehiculo")
public class vistavehiculo extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	
	@Inject
	private VehiculoONLocal vehiculoonlocal;
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	
    public vistavehiculo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Vehiculo v=new Vehiculo();
		v.setNumero(1);
		v.setMarca("Mazda");
		v.setModelo("CX5");
		v.setAnio("2021");
		try {
			vehiculoonlocal.insertar(v);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Vehiculo> listav=vehiculoonlocal.getvehiculos("Mazda");
		for(Vehiculo v1 : listav) {
			
			response.getWriter().append("<Strong>"+v1.getMarca()+"</strong>");
		}
		
		response.getWriter().append("<h1> se inserto</h1>"+"<Strong>"+"UPS"+"</strong>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	

	//public static void main(String[] args) {
		// TODO Auto-generated method stub

	//}
	
}
