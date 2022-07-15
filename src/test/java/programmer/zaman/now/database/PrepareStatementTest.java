package programmer.zaman.now.database;

import java.sql.Connection;
import org.junit.jupiter.api.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrepareStatementTest {

    @Test
    void testPrepareStatement() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String username = "admin";
        String password = "admin";

        String sql = "select * from admin where username = ? and password = ?";


        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);

       ResultSet resultSet =  preparedStatement.executeQuery();
       if (resultSet.next()){
           //sukses login
           System.out.println("sukses login : " + resultSet.getString("username"));
       }else {
           //gagal login
           System.out.println("Gagal login");
       }

        preparedStatement.close();
        connection.close();

    }
}
