package operator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class CancelarRegistroProntuario {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pst = null;
		int ApagarRegistro = 1;
		try {
			conn = DB.getConnection();
			pst = conn.prepareStatement("DELETE FROM prontuarios "
					+ "WHERE Id = ?");
			pst.setInt(1, ApagarRegistro);
			
			int rowsAffectet = pst.executeUpdate();
			System.out.println("Done! Rows affected: "+rowsAffectet);
					
					
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DB.closeStatement(pst);
			DB.closeConnection();
		}

	}

}
