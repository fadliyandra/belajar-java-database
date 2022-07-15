package programmer.zaman.now.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetTest {

    @Test
    void testExecuteQuery() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String sql = """

        select * from customers;
        """;

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("customers.name");
            String email = resultSet.getString("email");

            System.out.println(
                    String.join(", ", id, name, email)
            );

        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
