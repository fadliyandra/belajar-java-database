package programmer.zaman.now.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlInjectionTest {

    @Test
    void testSqlInjection() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String username = "admin'; #";
        String password = "admn";

        String sql = "select * from admin where username = '"+username+
                "' and password = '"+password+"'";

        System.out.println(sql);

        ResultSet resultSet = statement.executeQuery(sql);

        if(resultSet.next()){
            //sukses login
            System.out.println("sukse login : " + resultSet.getString("username"));
        }else {
           // gagal login
            System.out.println("gagal login");
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
