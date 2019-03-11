package br.edu.insper;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Cria")
public class Cria extends HttpServlet {
	public Integer hour;
	public Integer min;
	public Integer segundo;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
						HttpServletResponse response)
						throws ServletException, IOException {

	PrintWriter out = response.getWriter();
	out.println("<html><body>");
	out.println("<form method='post'>");
	out.println("Hora: <input type='number' name='hora' min='00' max='24'><br>");
	out.println("Minuto: <input type=‘number' name='minuto' min='00' max='59'><br>");
	out.println("Segundo: <input type='number' name='segundo' min='00' max='59'><br>");
	out.println("<input type='submit' value='Submit'>");
	out.println("</form>");
	out.println("<body><html>");
	 }
 
	@Override
	protected void doPost(HttpServletRequest request,
							HttpServletResponse response)
					throws ServletException, IOException {
		DAO dao;
		try {
			dao = new DAO();
			Dados dado = new Dados();
			
			Integer hour = Integer.valueOf(request.getParameter("hora"));
			Integer min = Integer.valueOf(request.getParameter("minuto"));
			Integer segundo = Integer.valueOf(request.getParameter("segundo"));
			
			dado.setHora(Integer.valueOf(request.getParameter("hora")));
			dado.setMinuto(Integer.valueOf(request.getParameter("minuto")));
			dado.setSegundo(Integer.valueOf(request.getParameter("segundo")));
			
			dao.adiciona(dado);

			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("adicionado" + dado.getId());
			out.println("</body></html>");
			
			RequestDispatcher rs = request.getRequestDispatcher("/index.html");
			
			rs.forward(request,response);
			
			dao.close();
	
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

}