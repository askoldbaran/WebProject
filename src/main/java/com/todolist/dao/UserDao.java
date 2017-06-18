package com.todolist.dao;

import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by askol on 6/13/2017.
 */
public enum UserDao {
    INSTANCE;


    public User getUserById(int id) {
        User user = new User();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Connection connection = DBConnection.getInstance().getConnection();

        try {
            preparedStatement = connection.prepareStatement("select * from user where userID = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user.setUserID(resultSet.getInt("userId"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
                user.setAddress(resultSet.getString("adress"));
                user.setPassword(resultSet.getString("password"));
                user.setLogin(resultSet.getString("login"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    public List<User> allUsers() {
        List<User> allUsers = new ArrayList<User>();
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "Select * from user";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = new User();
                user.setUserID(resultSet.getInt("userID"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
                user.setAddress(resultSet.getString("address"));
                user.setPassword(resultSet.getString("password"));
                user.setLogin(resultSet.getString("login"));
                allUsers.add(user);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allUsers;
    }

    public boolean deleteUserById(int id) {
        // User user = new User();
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            preparedStatement = connection.prepareStatement("delete * from user where userID = ?");
            preparedStatement.setInt(1, id);
            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean saveUser(User user) {

        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            preparedStatement = connection.prepareStatement("insert into user(name, age, login, password, adress ) " +
                    "values (?,?,?,?,?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getAddress());
            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public User getUserByLoginAndPassword(String login, String password) {
        User user = new User();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            preparedStatement = connection.prepareStatement("select * from user where login = ? AND password = ?");
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user.setUserID(resultSet.getInt("userId"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
                user.setAddress(resultSet.getString("adress"));
                user.setPassword(resultSet.getString("password"));
                user.setLogin(resultSet.getString("login"));
            }

            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean updateUser(User user) {

        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getInstance().getConnection();
        try {

            preparedStatement = connection.prepareStatement("update user set name = ?, age = ?, login = ?, password = ?, adress = ?" +
                    "where userID = ?");

            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getAddress());
            preparedStatement.setInt(6, user.getUserID());

            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
