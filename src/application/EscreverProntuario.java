package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class EscreverProntuario {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement pst = null;

		try {
			conn = DB.getConnection();

			pst = conn.prepareStatement("INSERT INTO prontuarios"
					+ "(PacienteID, Queixas, Diagnostico, Tratamento, DataConsulta)" 
					+ "VALUES (?,?,?,?,?)");
			pst.setInt(1, 1);
			pst.setString(2, "febre");
			pst.setString(3, "Gripe");
			pst.setString(4, "Repouso");
			pst.setDate(5, new java.sql.Date(sdf.parse("00/00/0000").getTime()));

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
