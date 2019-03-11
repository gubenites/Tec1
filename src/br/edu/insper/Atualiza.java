package br.edu.insper;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Atualiza")
public class Atualiza extends HttpServlet {
	
	
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
		out.println("ID: <input type='number' name='id'><br>");
		out.println("Hora: <input type='number' name='hora'><br>");
		out.println("Minuto: <input type='number' name='minuto'><br>");
		out.println("Segundo: <input type='number' name='segundo'><br>");
		out.println("<input type='submit' value='Submit'>");
		out.println("</form>");
		out.println("<body><html>");
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	DAO dao;
	try {
		dao = new DAO();
		Dados dado = new Dados();
		
		dado.setId(Integer.valueOf(request.getParameter("id")));
		dado.setHora(Integer.valueOf(request.getParameter("hora")));
		dado.setMinuto(Integer.valueOf(request.getParameter("minuto")));
		dado.setSegundo(Integer.valueOf(request.getParameter("segundo")));
		dao.altera(dado);
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("atualizado" + dado.getId());
		out.println("</body></html>");
		
		dao.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}
}
