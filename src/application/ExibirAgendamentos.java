package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import db.DB;


public class ExibirAgendamentos {
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
			
			//query para retornar agendamentos
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM agendamentos WHERE Id="+idPaciente);
			
			//prcurando paciente pelo nome
			ps = conn.createStatement();
			pg = ps.executeQuery("SELECT Nome FROM pacientes WHERE Id="+idPaciente);
			
			while(rs.next() && pg.next()) {
				System.out.println("{");
			    System.out.println("  \"NomePaciente\": " + pg.getString("Nome") + ",");
			    System.out.println("  \"PacienteID\": " + rs.getInt("PacienteID") + ",");
			    System.out.println("  \"DataAgendamento\": \"" + rs.getString("DataAgendamento") + "\",");
			    System.out.println("  \"DataConsulta\": \"" + rs.getString("DataConsulta") + "\",");
			    System.out.println("  \"Observacoes\": \"" + rs.getString("Observacoes") + "\",");
			    System.out.println("}");
			}
		
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			//encerrando conexão com o db
			DB.closeConnection();
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
		
	}
}
