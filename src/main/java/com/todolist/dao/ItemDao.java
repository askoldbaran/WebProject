package com.todolist.dao;

import entity.Item;
import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by askol on 6/14/2017.
 */
public enum ItemDao {
    INSTANCE;

    public void saveItem(User user, Item item) {
        PreparedStatement preparedStatement;
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            preparedStatement = connection.prepareStatement("insert into item(text, userID) " +
                    "values (?,?)");
            preparedStatement.setString(1, item.getText());
            preparedStatement.setInt(2, user.getUserID());
            int i = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean updateItem(Item item) {

        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getInstance().getConnection();
        try {

            preparedStatement = connection.prepareStatement("update item set text = ?" +
                    "where id = ?");

            preparedStatement.setString(1, item.getText());

            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void deleteItemById(int id) {

        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            preparedStatement = connection.prepareStatement("delete from item where id = ?");
            preparedStatement.setInt(1, id);
            int i = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Item> itemsByUserId(int id) {
        List<Item> items = new ArrayList<Item>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            preparedStatement = connection.prepareStatement("select a.id, a.text from item a where userID = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Item item = new Item();
                item.setId(resultSet.getInt("id"));
                item.setText(resultSet.getString("text"));
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

}
