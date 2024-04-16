package operator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import db.DB;

public class ExibirProntuario {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;


		try {
			int idProntuarioASerExibido = 1;
			
			conn = DB.getConnection();


			pst = conn.prepareStatement("SELECT * FROM prontuarios WHERE Id=?");
			pst.setInt(1, idProntuarioASerExibido);
			
			rs = pst.executeQuery();
			
			while (rs.next()) {
				System.out.println("{");
				System.out.println("  \"PacienteID\": " + rs.getInt("PacienteID") + ",");
				System.out.println("  \"Queixas\": \"" + rs.getString("Queixas") + "\",");
				System.out.println("  \"Diagnostico\": \"" + rs.getString("Diagnostico") + "\",");
				System.out.println("  \"Tratamento\": \"" + rs.getString("Tratamento") + "\",");
				System.out.println("  \"DataConsulta\": \"" + rs.getString("DataConsulta") + "\"");
				System.out.println("}");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			DB.closeStatement(pst);
			DB.closeResultSet(rs);
			DB.closeConnection();
		}

	}

}
