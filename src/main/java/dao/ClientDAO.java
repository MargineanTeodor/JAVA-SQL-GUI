package dao;

import connection.ConnectionFactory;
import model.Client;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientDAO {

	protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());
	private static final String insertStatementString = "INSERT INTO client (id,name,adress,email,age)"
			+ " VALUES (?,?,?,?,?)";
	private static final String updateStatementString = "UPDATE client SET age = ? where (id = ?);";
	private final static String deleteStatementString = "DELETE FROM client where id = ?";
	private final static String afisareString = "SELECT * FROM client where id=?";

	public  void delete(int clientId) {
		Client toReturn = null;

		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		try {
			findStatement = dbConnection.prepareStatement(deleteStatementString);
			findStatement.setLong(1, clientId);
			findStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"ClientDAO:delete " + e.getMessage());
		} finally {
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
	}
	public  void update(int clientId,int val) {
		Client toReturn = null;
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement updateStatement = null;
		try {
			updateStatement = dbConnection.prepareStatement(updateStatementString);
			updateStatement.setInt(1, val);
			updateStatement.setInt(2,clientId);
			updateStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"ClientDAO:update " + e.getMessage());
		} finally {
			ConnectionFactory.close(updateStatement);
			ConnectionFactory.close(dbConnection);
		}
	}
	public String[]  afisare(int id) {
		Client toReturn = null;
		Connection dbConnection = ConnectionFactory.getConnection();
		String a[] = new String[6];
		ResultSet rs = null;
		PreparedStatement updateStatement = null;
		try {
			updateStatement = dbConnection.prepareStatement(afisareString);
			updateStatement.setInt(1,id);
			rs=updateStatement.executeQuery();
			rs.next();
			a[0]=rs.getString(1);
			a[1]=rs.getString(2);
			a[2]=rs.getString(3);
			a[3]=rs.getString(4);
			a[4]=rs.getString(5);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"ClientDAO:update " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(updateStatement);
			ConnectionFactory.close(dbConnection);
		}
		return a;
	}
	public  int insert(Client student) {
		Connection dbConnection = ConnectionFactory.getConnection();

		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setInt(1,student.getId());
			insertStatement.setString(2, student.getName());
			insertStatement.setString(3, student.getAddress());
			insertStatement.setString(4, student.getEmail());
			insertStatement.setInt(5, student.getAge());
			insertStatement.executeUpdate();

			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				insertedId = rs.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ClientDAO:insert " + e.getMessage());
		} finally {
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(dbConnection);
		}
		return insertedId;
	}
}
