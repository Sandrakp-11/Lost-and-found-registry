package com.lostfound.daoimpl;

import com.lostfound.dao.ItemDAO;
import com.lostfound.dto.ItemDTO;
import com.lostfound.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {

    @Override
    public boolean addItem(ItemDTO item) {
        String sql = "INSERT INTO items (item_name, description, category, status, location, date_reported) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, item.getItemName());
            ps.setString(2, item.getDescription());
            ps.setString(3, item.getCategory());
            ps.setString(4, item.getStatus());
            ps.setString(5, item.getLocation());
            ps.setDate(6, item.getDateReported());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<ItemDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM items";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                ItemDTO item = new ItemDTO();
                item.setItemId(rs.getInt("item_id"));
                item.setItemName(rs.getString("item_name"));
                item.setDescription(rs.getString("description"));
                item.setCategory(rs.getString("category"));
                item.setStatus(rs.getString("status"));
                item.setLocation(rs.getString("location"));
                item.setDateReported(rs.getDate("date_reported"));
                list.add(item);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<ItemDTO> getItemsByStatus(String status) {
        List<ItemDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM items WHERE status = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, status);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ItemDTO item = new ItemDTO();
                item.setItemId(rs.getInt("item_id"));
                item.setItemName(rs.getString("item_name"));
                item.setDescription(rs.getString("description"));
                item.setCategory(rs.getString("category"));
                item.setStatus(rs.getString("status"));
                item.setLocation(rs.getString("location"));
                item.setDateReported(rs.getDate("date_reported"));
                list.add(item);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean deleteItem(int itemId) {
        String sql = "DELETE FROM items WHERE item_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, itemId);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
