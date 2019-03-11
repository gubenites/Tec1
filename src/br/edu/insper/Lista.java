package br.edu.insper;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Lista
 */
@WebServlet("/Lista")
public class Lista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Lista() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("Entrei no service");
		DAO dao;

			try {
				dao = new DAO();
				List<Dados> dados = dao.getLista();
				
				System.out.println(dados);
				
				PrintWriter out = response.getWriter();
				out.println("<html><body><table border='1'>");
				out.println("<tr><td>ID</td><td>Hora</td>" +
						"<td>Minuto</td><td>Segundo</td></tr>");
				
			
				for (Dados dado : dados) {
					out.println("<tr><td>" + dado.getId() + "</td>");
					out.println("<td>" + dado.getHora() + "</td>");
					out.println("<td>" + dado.getMinuto() + "</td>");
					out.println("<td>" + dado.getSegundo() + "</td></tr>");
				}
				out.println("</table></body></html>");
				
				dao.close();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				

	
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Entrei no get");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		System.out.println("Entrei no post");
	}
	

	
}
