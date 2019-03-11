package br.edu.insper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	private Connection connection = null;
	
	public DAO() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/cronometro", "root", "1234");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public List<Dados> getLista() throws SQLException{
		System.out.println("Entrei no dao");
		List<Dados> dados = new ArrayList<Dados>();
		
		PreparedStatement stmt;

		stmt = connection.prepareStatement("SELECT * FROM dados");
		
		ResultSet rs = stmt.executeQuery();
		System.out.println(rs);
		while (rs.next()) {
			Dados dado = new Dados();
			dado.setId(rs.getInt("id"));
			dado.setHora(rs.getInt("hora"));
			dado.setMinuto(rs.getInt("minuto"));
			dado.setSegundo(rs.getInt("segundo"));
			
			dados.add(dado);

			}

			rs.close();
			stmt.close();
			
			return dados;


		
		
		

		}
	
	public void adiciona(Dados dado) throws SQLException {
		String sql = "INSERT INTO Dados" +
		"(hora,minuto,segundo) values(?,?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		//stmt.setInt(1,dado.getId());
		stmt.setInt(1,dado.getHora());
		stmt.setInt(2, dado.getMinuto());
		stmt.setInt(3,dado.getSegundo());
		
		stmt.execute();
		stmt.close();
	}
	
	public void altera(Dados dado) throws SQLException {
		String sql = "UPDATE Dados SET " +
		 "hora=?, minuto=?, segundo=? WHERE id=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, dado.getHora());
		stmt.setInt(2, dado.getMinuto());
		stmt.setInt(3, dado.getSegundo());
		stmt.setInt(4, dado.getId());
		stmt.execute();
		stmt.close();
		}
	
	public void remove(Integer id) throws SQLException {
		PreparedStatement stmt = connection
		 .prepareStatement("DELETE FROM Dados WHERE id=?");
		stmt.setLong(1, id);
		stmt.execute();
		stmt.close();
		}
}