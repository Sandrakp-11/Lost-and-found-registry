package com.lostfound.daoimpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.lostfound.dao.ItemDAO;
import com.lostfound.dto.Item;
import com.lostfound.util.DBConnection;

public class ItemDAOImpl implements ItemDAO {

    @Override
    public void addItem(Item item) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO items(item_name, description, location, status) VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, item.getItemName());
            ps.setString(2, item.getDescription());
            ps.setString(3, item.getLocation());
            ps.setString(4, item.getStatus());

            ps.executeUpdate();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Item> getAllItems() {
        List<Item> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM items";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Item item = new Item(
                        rs.getInt("id"),
                        rs.getString("item_name"),
                        rs.getString("description"),
                        rs.getString("location"),
                        rs.getString("status")
                );
                list.add(item);
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void updateItemStatus(int id, String status) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "UPDATE items SET status=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, status);
            ps.setInt(2, id);

            ps.executeUpdate();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteItem(int id) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "DELETE FROM items WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
