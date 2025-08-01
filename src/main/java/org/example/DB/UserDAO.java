package org.example.DB;
import java.sql.*;
import org.example.DBConfig;
import org.example.model.User;

public class UserDAO {
    private final DBConfig dbConfig;

    public UserDAO() {
        this.dbConfig = new DBConfig();
    }


    public User getUserDetails(int emp_id) {
        User user = null;

        // CORRECTED SQL: The column name is 'emp_id', not 'id'.
        String sql = "SELECT * FROM user_profile_details WHERE emp_id = ?";

        try (
                Connection conn = DriverManager.getConnection(
                        dbConfig.getJdbcURL(),
                        dbConfig.getJdbcUsername(),
                        dbConfig.getJdbcPassword()
                );
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, emp_id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setEmploymentId(rs.getInt("emp_id"));
                user.setEmail(rs.getString("email"));
                user.setReportTo(rs.getInt("report_to"));
                user.setName(rs.getString("name"));
                user.setPhoneNumber(rs.getString("phone_num"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
