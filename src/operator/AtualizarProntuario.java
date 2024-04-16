package operator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class AtualizarProntuario {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement pst = null;
		int IdAAAtualizar = 1;
		try {
			conn = DB.getConnection();

			pst = conn.prepareStatement("UPDATE prontuarios " + "SET PacienteID = ?," + "Queixas = ?,"
					+ "Diagnostico = ?," + "Tratamento = ?," + "DataConsulta = ?" + "WHERE Id = ?");

			pst.setInt(1, 1);
			pst.setString(2, "a");
			pst.setString(3, "a");
			pst.setString(4, "a");
			pst.setDate(5, new java.sql.Date(sdf.parse("01/01/2000").getTime()));
			pst.setInt(6, IdAAAtualizar);

			int rowsaffetcted = pst.executeUpdate();
			System.out.println("Done! Rows Affected: " + rowsaffetcted);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(pst);
			DB.closeConnection();
		}
	}

}
