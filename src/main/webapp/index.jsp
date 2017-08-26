<!DOCTYPE html>
<%@page import="br.com.pos.model.Cliente"%>
<%@page import="java.util.List"%>
<html>
	
	<head>
		<meta charset="UTF-8" >
		<title>CRUD clientes</title>
	</head>
	
	<body>
		
		<form method="POST" action="cliente" >
			
			Nome:
			<input type="text" value="" name="nome" />
			
			<input type="submit" value="Save" />
			
		</form>
		
		<%
			
			List<Cliente> clientes = (List<Cliente>) request.getAttribute("lista");
			
			for(Cliente c : clientes) {
				out.print(c.getNome() + "<br/>");
			}
			
		%>
	
	</body>

</html>