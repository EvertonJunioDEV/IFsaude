package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class RecuperarTodosProntuariosDoPaciente {
	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		Statement ps = null;
		ResultSet pg = null;
	
		try {
			//mutavel futuramente
			//int idPaciente = sc.nextInt();
			int idPaciente = 1;
			
			//conexao com o db
			conn = DB.getConnection();
			
			//query para prontuario
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM prontuarios WHERE Id="+idPaciente);
			
			//query para nome do paciente
			ps = conn.createStatement();
			pg = ps.executeQuery("SELECT Nome FROM pacientes WHERE Id="+idPaciente);
			
			while(rs.next() && pg.next()) {
			    System.out.println("{");
			    System.out.println("  \"NomePaciente\": " + pg.getString("Nome") + ",");
			    System.out.println("  \"PacienteID\": " + rs.getInt("PacienteID") + ",");
			    System.out.println("  \"Queixas\": \"" + rs.getString("Queixas") + "\",");
			    System.out.println("  \"Diagnostico\": \"" + rs.getString("Diagnostico") + "\",");
			    System.out.println("  \"Tratamento\": \"" + rs.getString("Tratamento") + "\",");
			    System.out.println("  \"DataConsulta\": \"" + rs.getString("DataConsulta") + "\"");
			    System.out.println("}");
			}

		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			//encerrando conexao com o db
			DB.closeStatement(st);
			DB.closeResultSet(rs);
			DB.closeConnection();
		}
		
	}
	
}
