package clienteweb;
	
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
	
@WebServlet(urlPatterns={"/cliente", "/clienteServlet"} )
public class ClienteServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public ClienteServlet() {
		System.out.println("Construindo Servlet...");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("Inicializando Servlet");
		super.init();
	}
	
	/**
	 * Recebe em primeiro lugar os objetos 
	 * HttpServletRequest e HttpServletResponse
	 * e partir dai decide se vai para o doGet,
	 * doPost etc...
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Chamando o service");
		super.service(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		System.out.println("Chamou pelo método GET " + request.getContextPath());
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// permite montar e imprimir alguma informação no cliente
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter writer = response.getWriter();
		writer.print("Chamou pelo método POST");
		
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter writer = response.getWriter();
		writer.print("Chamou pelo método DELETE");
		
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UF-8");
		
		PrintWriter writer = response.getWriter();
		writer.print("Chamou pelo método PUT");
		
	}
	
	@Override
	public void destroy() {
		System.out.println("Servlet está sendo destruido");
		super.destroy();
	}
	
}