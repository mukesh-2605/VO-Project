package org.example.DB;
import java.sql.*;
import org.example.DBConfig;
import org.example.model.User;

public class UserDAO {
    private final DBConfig dbConfig;

    public UserDAO() {
        this.dbConfig = new DBConfig();
    }

    public User getUserByEmail(String email) {
        User user = null;

        String sql = "SELECT * FROM profileDetails WHERE email = ?";

        try (
                Connection conn = DriverManager.getConnection(
                        dbConfig.getJdbcURL(),
                        dbConfig.getJdbcUsername(),
                        dbConfig.getJdbcPassword()
                );
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setEmail(rs.getString("email"));
                user.setName(rs.getString("name"));
                user.setPhoneNumber(rs.getString("phone_number"));
                user.setEmploymentId(rs.getString("employement_id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
