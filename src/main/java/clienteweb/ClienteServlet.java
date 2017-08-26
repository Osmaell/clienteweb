package clienteweb;
	
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pos.model.Cliente;
	
@WebServlet(urlPatterns={"/cliente", "/clienteServlet"} )
public class ClienteServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private List<Cliente> clientes = new ArrayList<>();
	
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
		
		// permite configurar um objeto de encaminhamento
		// capaz de encaminhar o fluxo da requisição
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		
		// adicionando o objeto lista como
		// atributo do request
		request.setAttribute("lista", clientes);
		
		// encaminhando o request e o response
		// para o arquivo jsp, onde este arquivo
		// vai processar a requisição
		dispatcher.forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		
		clientes.add(cliente);
		
		// permite montar e imprimir alguma informação no cliente
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter writer = response.getWriter();
		writer.print("Chamou pelo método POST enviando nome " + nome + "!");
		
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












