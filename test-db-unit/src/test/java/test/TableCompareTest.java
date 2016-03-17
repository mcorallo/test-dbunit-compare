package test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import org.dbunit.Assertion;
import org.dbunit.database.AmbiguousTableNameException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.DataSetException;
import org.junit.Test;

public class TableCompareTest {

	@Test
	public void testName() throws Exception {
		String tableName = "dbo.OBIETTIVO";

		QueryDataSet db1 = getTableData(tableName, "SVILUPPO");
		QueryDataSet db2 = getTableData(tableName, "REPORT");

		Assertion.assertEquals(db1, db2);
	}

	private QueryDataSet getTableData(String tableName, String db) throws Exception, AmbiguousTableNameException, IOException, DataSetException {
		IDatabaseConnection connection = getConnection(db);

		QueryDataSet outputSet = new QueryDataSet(connection);
		outputSet.addTable(tableName);
		return outputSet;
	}

	protected IDatabaseConnection getConnection(String db) throws Exception {
		Class.forName("net.sourceforge.jtds.jdbc.Driver");
		Connection jdbcConnection = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.39.4:1433;databaseName=PFP-BPM-" + db + ";user=ampro;password=ampro;");
		DatabaseConnection connection = new DatabaseConnection(jdbcConnection);
		DatabaseConfig config = connection.getConfig();
		config.setProperty(DatabaseConfig.FEATURE_QUALIFIED_TABLE_NAMES, "true");
		return connection;
	}

}
