package com.siddall.budgetapp.DAOs;

import com.mysql.jdbc.Driver;
import com.siddall.budgetapp.Models.User;
import org.springframework.beans.factory.annotation.Value;

import java.sql.*;
import java.util.ArrayList;

public class JDBC {

    @Value("${spring.datasource.url}")
    private String accessDBurl;

    @Value("${spring.datasource.username}")
    private String accessDBusername;

    @Value("${spring.datasource.password}")
    private String accessDBpassword;

    private PreparedStatement sqlCalls(Connection connection, String callType, String username, String password) throws SQLException {
        String sql = "";
        if (callType.equalsIgnoreCase("findbyusername")){
            sql = "SELECT * FROM user_login WHERE Username = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            return statement;

        }else if (callType.equalsIgnoreCase("findallusers")){
            sql = "SELECT * FROM user_login";
            return connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        }
        else if(callType.equalsIgnoreCase("insertintousers")){
            sql = "INSERT INTO user_login(Username, password) VALUES (?,?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            return statement;

        }
        return null;
    }

    private Connection accessDB(){

        {
            try {
                DriverManager.registerDriver(new Driver());

                return DriverManager.getConnection(
                        accessDBurl,
                        accessDBusername,
                        accessDBpassword
                );
            } catch (SQLException e) {
             e.printStackTrace();
            }
        }
        return null;
    }

    private ResultSet communicateToDB(String callType, String searchTerm, String password) {
        ResultSet resultSet = null;
       Connection connection = accessDB();

        try {
            PreparedStatement statement = sqlCalls(connection, callType, searchTerm, password);

            if (callType.equalsIgnoreCase("insertintousers")){
                boolean response = statement.execute();
                if (response){
                    System.out.println("table updated");
                }
            }else  if (callType.equalsIgnoreCase("update")){
                statement.executeUpdate();
            }else  if (
                    callType.equalsIgnoreCase("finduserbyusername")
                || callType.equalsIgnoreCase("findallusers")
                    ){
               return statement.executeQuery();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<User> data(String callType, String searchTerm, String password){
        ResultSet resultSet = communicateToDB(callType, searchTerm, password);

        ArrayList<User> users = new ArrayList<>();

        try {
            if (resultSet != null) {
                while (resultSet.next()){
                User userObject = new User();

                userObject.setId(resultSet.getInt("id"));
                userObject.setUsername(resultSet.getString("Username"));
                userObject.setPassword(resultSet.getString("password"));

                users.add(userObject);

                }
            }if (resultSet == null){
                System.out.println("were coming up empty boss");
            }
        }catch (SQLException e) {
        e.printStackTrace();
        }
        return users;
    }
}
