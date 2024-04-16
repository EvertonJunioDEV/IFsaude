package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class CriarAgendamento {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement pst = null;

		try {
			conn = DB.getConnection();

			pst = conn.prepareStatement("INSERT INTO agendamentos"
					+ "(PacienteID, DataAgendamento, DataConsulta, Observacoes)" 
					+ "VALUES (?,?,?,?)");
			pst.setInt(1, 1);
			pst.setDate(2, new java.sql.Date(sdf.parse("22/04/2024").getTime()));
			pst.setDate(3, new java.sql.Date(sdf.parse("22/04/2024").getTime()));
			pst.setString(4, "nada a observar");

			int rowsAffected = pst.executeUpdate();
			System.out.println("Done: Rows affected: " + rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(pst);
			DB.closeConnection();
		}
	}
}
