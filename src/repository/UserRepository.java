package repository;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserRepository {
    public static List<User> getAllUsers() {
        String sql = "SELECT * FROM database_users ";
        List<User> userList = new ArrayList<>();
        PropertiesLoader.loadProperties();
        try (
                Connection connection = DriverManager.getConnection(
                        PropertiesLoader.properties.getProperty("database_url"),
                        PropertiesLoader.properties.getProperty("database_username"),
                        PropertiesLoader.properties.getProperty("database_password"));
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ) {
            while (resultSet.next()) {
                userList.add(new User(
                        resultSet.getInt("user_id"),
                        resultSet.getString("user_uuid"),
                        resultSet.getString("user_name"),
                        resultSet.getString("user_email"),
                        resultSet.getString("user_password"),
                        resultSet.getBoolean("is_deleted"),
                        resultSet.getBoolean("is_verified")));
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return userList;
    }

    public static User updateUser(int id, User user)  {
        PropertiesLoader.loadProperties();
        // SQL query updateUserById
        String sql = "UPDATE database_users SET user_uuid = ?, user_name = ?, user_email = ?, user_password = ?, is_deleted = ?, is_verified = ? WHERE user_id = ?";
        try (Connection connection = DriverManager.getConnection(
                PropertiesLoader.properties.getProperty("database_url"),
                PropertiesLoader.properties.getProperty("database_username"),
                PropertiesLoader.properties.getProperty("database_password")
        );
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            System.out.println("Connected to database");
            preparedStatement.setString(1, user.getUserUuid());
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.setString(3, user.getUserEmail());
            preparedStatement.setString(4, user.getUserPassword());
            preparedStatement.setBoolean(5, user.getIsDeleted());
            preparedStatement.setBoolean(6, user.getIsVerified());
            preparedStatement.setInt(7, id);

            return (User) preparedStatement.executeQuery();
        } catch (SQLException sqlException) {
            System.out.println("Problem during updating data in database: " + sqlException.getMessage());
        }
        return user;

    }


    public static Integer deleteById (Integer id) {
        String sql = "DELETE FROM database_users WHERE user_id = ?";
        try (
                Connection connection = DriverManager.getConnection(
                        PropertiesLoader.properties.getProperty("database_url"),
                        PropertiesLoader.properties.getProperty("database_username"),
                        PropertiesLoader.properties.getProperty("database_password"));
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

        }
        return id;
    }

    public static User insertUser(User user) {
        PropertiesLoader.loadProperties();
        String sql = "INSERT INTO database_users (user_uuid, user_name, user_email, user_password, is_deleted, is_verified) VALUES (?, ?, ?, ?, ?, ?)";
        try (
                Connection connection = DriverManager.getConnection(
                        PropertiesLoader.properties.getProperty("database_url"),
                        PropertiesLoader.properties.getProperty("database_username"),
                        PropertiesLoader.properties.getProperty("database_password"));
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setString(1, user.getUserUuid());
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.setString(3, user.getUserEmail());
            preparedStatement.setString(4, user.getUserPassword());
            preparedStatement.setBoolean(5, user.getIsDeleted());
            preparedStatement.setBoolean(6, user.getIsVerified());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    return new User(
                            resultSet.getInt("user_id"),
                            resultSet.getString("user_uuid"),
                            resultSet.getString("user_name"),
                            resultSet.getString("user_email"),
                            resultSet.getString("user_password"),
                            resultSet.getBoolean("is_deleted"),
                            resultSet.getBoolean("is_verified")
                    );
                }
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return new User();
    }
}

