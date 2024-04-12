package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class ExibirProntuario {
	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		Statement ps = null;
		ResultSet pg = null;
		
		try {
			int idPaciente = 1;
			conn = DB.getConnection();
			
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM prontuarios WHERE Id="+idPaciente);
			
			//searching paciente nome
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
			DB.closeStatement(st);
			DB.closeResultSet(rs);
			DB.closeConnection();
		}
		
	}
	
}
