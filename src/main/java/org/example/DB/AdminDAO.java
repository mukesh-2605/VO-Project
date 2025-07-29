package org.example.DB;

/* *
 *
 * @author Java Programming with Aldrin
 */


import org.example.DBConfig;
import org.example.model.Vendor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {
    private final String jdbcURL = new DBConfig().getJdbcURL();
    private final String jdbcUsername = new DBConfig().getJdbcUsername();
    private final String jdbcPassword = new DBConfig().getJdbcPassword();

    private static final String ADD_VENDORS_SQL = "INSERT INTO passwordManager (email, password, role) VALUES (?, ?, ?)";
    private static final String INSERT_VENDORS_SQL = "INSERT INTO vendorDetails (v_email) VALUES (?)";
//    private static final String SELECT_ALL_USERS = "SELECT * FROM users";
//    private static final String DELETE_USERS_SQL = "DELETE FROM users WHERE id = ?";
//    private static final String UPDATE_USERS_SQL = "UPDATE users SET name = ?, email = ?, country = ? WHERE id = ?";

//    protected Connection getConnection() {
//        Connection connection = null;
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return connection;
//    }

    protected Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            if (connection == null) {
                throw new SQLException("Connection returned null — check DB credentials or URL.");
            }
            return connection;
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found.", e);
        }
    }


    // ADD_VENDORS_SQL
    // add servlet in admin and get vendor mail and put here
    public void requestNewVendor(Vendor vendor) throws SQLException {
//        try (Connection connection = getConnection();
//             connection.setAutoCommit(false);
//             PreparedStatement preparedStatement1 = connection.prepareStatement(ADD_VENDORS_SQL);
//             PreparedStatement preparedStatement2 = connection.prepareStatement(INSERT_VENDORS_SQL)) {
//            preparedStatement1.setString(1, vendor.getMail());
//            preparedStatement1.setString(2, vendor.getPassword());
//            preparedStatement1.setString(3, "vendor");
//            preparedStatement1.executeUpdate();
//
//            preparedStatement2.setString(1, vendor.getMail());
//            preparedStatement2.executeUpdate();
//
//            connection.commit();
//        } catch (SQLException e) {
//            printSQLException(e);
//        }

        try (Connection connection = getConnection()) {
            connection.setAutoCommit(false);  // <-- Required to enable manual transaction control

            try (PreparedStatement preparedStatement1 = connection.prepareStatement(ADD_VENDORS_SQL);
                 PreparedStatement preparedStatement2 = connection.prepareStatement(INSERT_VENDORS_SQL)) {

                preparedStatement1.setString(1, vendor.getMail());
                preparedStatement1.setString(2, vendor.getPassword());
                preparedStatement1.setString(3, "vendor");
                preparedStatement1.executeUpdate();

                preparedStatement2.setString(1, vendor.getMail());
                preparedStatement2.executeUpdate();

                connection.commit();  // Commit only if both succeed
            } catch (SQLException e) {
                connection.rollback(); // Optional: rollback if something fails
                printSQLException(e);
            }
        }

    }

//    public User selectUser(int id) {
//        User user = null;
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)) {
//            preparedStatement.setInt(1, id);
//            ResultSet rs = preparedStatement.executeQuery();
//
//            while (rs.next()) {
//                String name = rs.getString("name");
//                String email = rs.getString("email");
//                String country = rs.getString("country");
//                user = new User(id, name, email, country);
//            }
//        } catch (SQLException e) {
//            printSQLException(e);
//        }
//        return user;
//    }
//
//    public List<User> selectAllUsers() {
//        List<User> users = new ArrayList<>();
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS)) {
//            ResultSet rs = preparedStatement.executeQuery();
//
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                String email = rs.getString("email");
//                String country = rs.getString("country");
//                users.add(new User(id, name, email, country));
//            }
//        } catch (SQLException e) {
//            printSQLException(e);
//        }
//        return users;
//    }
//
//    public boolean deleteUser(int id) throws SQLException {
//        boolean rowDeleted;
//        try (Connection connection = getConnection();
//             PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL)) {
//            statement.setInt(1, id);
//            rowDeleted = statement.executeUpdate() > 0;
//        }
//        return rowDeleted;
//    }
//
//    public boolean updateUser(User user) throws SQLException {
//        boolean rowUpdated;
//        try (Connection connection = getConnection();
//             PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL)) {
//            statement.setString(1, user.getName());
//            statement.setString(2, user.getEmail());
//            statement.setString(3, user.getCountry());
//            statement.setInt(4, user.getId());
//
//            rowUpdated = statement.executeUpdate() > 0;
//        }
//        return rowUpdated;
//    }
//
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}

