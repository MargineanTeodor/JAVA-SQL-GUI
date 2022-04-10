package dao;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import connection.ConnectionFactory;
import model.Client;
import model.Order;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Integer.parseInt;

public class OrderDAO {

	protected static final Logger LOGGER = Logger.getLogger(OrderDAO.class.getName());
	private static final String insertStatementString = "INSERT INTO ordere (id,prodId,clientId,cantitate)"
			+ " VALUES (?,?,?,?)";

	private  static void inserting(String S,int id) throws FileNotFoundException, DocumentException {
		Document document= new Document();
		PdfWriter.getInstance(document, new FileOutputStream("Bill" +id+".pdf"));
		document.open();
		Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, BaseColor.BLUE);
		Chunk chunk = new Chunk(S, font);
		document.add(chunk);
		document.close();
	}
	public int insert(Order order,int id) {
		Connection dbConnection = ConnectionFactory.getConnection();

		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setInt(1,order.getId());
			insertStatement.setInt(2, order.getProdId());
			insertStatement.setInt(3, order.getClientId());
			insertStatement.setInt(4,order.getCantitate());
			insertStatement.executeUpdate();
			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				insertedId = rs.getInt(1);
			}
			String S= "Cumparator: "+ order.getClientId()+ "produs: "+order.getProdId()+"cantitate: "+order.getCantitate();

			ProductDAO x= new ProductDAO();
			String a[];
			a=x.afisare(order.getProdId());
			int val=parseInt(a[2]);
			if(val>order.getCantitate())
			{
				x.update(order.getClientId(),val-order.getCantitate());
				inserting(S,id);
			}
			else
				System.out.println("under-stock");

		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "OrderDAO:insert " + e.getMessage());
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(dbConnection);
		}
		return insertedId;
	}
}
