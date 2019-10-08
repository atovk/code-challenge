import com.atovk.execise.adapter.MySQLUtil;
import com.atovk.execise.adapter.RDBMSConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TesMain {

    public static List<String> getColumnNames(ResultSetMetaData rsMetaData, String tableName) {

        List<String> result = new ArrayList<>();
        try {
            int columnCount = rsMetaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                result.add(rsMetaData.getColumnName(i));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) throws SQLException {

        Connection conn = RDBMSConnect.getConn("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/test", "root", "");

        ResultSet catalogs = conn.getMetaData().getCatalogs();
        ResultSetMetaData metaData = catalogs.getMetaData();
        int catalogsColumnCount = metaData.getColumnCount();
        for (int i = 1; i <= catalogsColumnCount; i++) {
            metaData.getSchemaName(1);
            System.out.println( catalogs.getString(i));
        }
        System.out.println(" ---------- ");


        ResultSet tables = conn.getMetaData().getColumns(null, null, null, null);

        int columnCount = tables.getMetaData().getColumnCount();

        for (int i = 1; i <= columnCount; i++) {
            System.out.print(tables.getMetaData().getColumnName(i) + " $"
                    + tables.getMetaData().getColumnClassName(i) + " $"
                    + tables.getMetaData().getColumnTypeName(i) + " / "
            );
        }
        System.out.println("\n");
        while (tables.next()) {
/*            for (int i = 1; i <= columnCount; i++) {
                System.out.print(tables.getString(i) + " ");
            }*/


            System.out.println(tables.getString("TABLE_NAME") + tables.getString("COLUMN_NAME")
                    + tables.getString("TYPE_NAME") + tables.getString("COLUMN_SIZE") + tables.getString("REMARKS")

            );
        }

        ResultSet table = conn.getMetaData().getTables(null, null, null, new String[] { "TABLE", "VIEW" });



        ResultSet resultSet = conn.createStatement().executeQuery("select * from cpp_area where 1=0");
        ResultSetMetaData rsMeta = resultSet.getMetaData();

        for (int i = 1; i <= rsMeta.getColumnCount(); i++) {
            System.out.print(rsMeta.getColumnName(i) + " $"
                    + rsMeta.getColumnClassName(i) + " $"
                    + rsMeta.getColumnTypeName(i) + " / "
            );
        }
        System.out.println();

        ResultSet show_databases = conn.createStatement().executeQuery("show databases");
        int columnCount1 = show_databases.getMetaData().getColumnCount();
        while (show_databases.next()) {
            for (int i = 1; i <= columnCount1; i++) {
                System.out.print(show_databases.getString(i));
            }
            System.out.println();
        }




    }


}
