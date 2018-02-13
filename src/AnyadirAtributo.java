

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AnyadirAtributo
 */
@WebServlet("/anyadir")
public class AnyadirAtributo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnyadirAtributo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Recuperamos los dos atributos quen os manda el formulario
		String atributo= request.getParameter("atributo");
		String valor= request.getParameter("valor");
		
		//Recuperamos la sesión del usuario
		HttpSession sesion =request.getSession();
		
		//Añadimos a la sesión la información del formulario guardada en el paso anterior.
		sesion.setAttribute(atributo, valor);
		
		//Salida del servlet para el usuario
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Sesiones</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Hola, Mundo</h1>");
		out.println("<p>Sesion del usuario</p>");
		
		Enumeration<String> nombresDeAtributos= sesion.getAttributeNames();
		
		while(nombresDeAtributos.hasMoreElements()){
			
			atributo=nombresDeAtributos.nextElement();
			valor=(String) sesion.getAttribute(atributo);
			
			out.println("<p>Atributo: " + atributo + "</p>");
			out.println("<p>Valor: " + valor + "</p><hr>");
			

			
		}
				
		out.println("</body>");
		out.println("</html>");
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
