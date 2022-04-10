package dao;

import connection.ConnectionFactory;
import model.Client;
import model.Product;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductDAO {

	protected static final Logger LOGGER = Logger.getLogger(ProductDAO.class.getName());
	private static final String insertStatementString = "INSERT INTO product (id,name,stock)"
			+ " VALUES (?,?,?)";
	private static final String updateStatementString = "UPDATE product SET stock = ? where (id = ?);";
	private final static String deleteStatementString = "DELETE FROM product where id = ?";
	private final static String afisareString = "SELECT * FROM product where id=?";

	public  void delete(int clientId) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		try {
			findStatement = dbConnection.prepareStatement(deleteStatementString);
			findStatement.setLong(1, clientId);
			findStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"ProductDAO:delete " + e.getMessage());
		} finally {
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
	}
	public  void update(int clientId,int val) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement updateStatement = null;
		try {
			updateStatement = dbConnection.prepareStatement(updateStatementString);
			updateStatement.setInt(1, val);
			updateStatement.setInt(2,clientId);
			updateStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"ProductDAO:update " + e.getMessage());
		} finally {
			ConnectionFactory.close(updateStatement);
			ConnectionFactory.close(dbConnection);
		}
	}
	public String[]  afisare(int id) {
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
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"ProductDAO:afisare " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(updateStatement);
			ConnectionFactory.close(dbConnection);
		}
		return a;
	}
	public  int insert(Product x) {
		Connection dbConnection = ConnectionFactory.getConnection();

		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setInt(1,x.getId());
			insertStatement.setString(2, x.getName());
			insertStatement.setInt(3, x.getStock());
			insertStatement.executeUpdate();

			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				insertedId = rs.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ProductDAO:insert " + e.getMessage());
		} finally {
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(dbConnection);
		}
		return insertedId;
	}
}
