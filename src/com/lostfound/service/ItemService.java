package com.lostfound.service;

import com.lostfound.dao.ItemDAO;
import com.lostfound.daoimpl.ItemDAOImpl;
import com.lostfound.dto.ItemDTO;

import java.util.List;

public class ItemService {

    private ItemDAO dao = new ItemDAOImpl();

    public boolean addItem(ItemDTO item) {
        return dao.addItem(item);
    }

    public List<ItemDTO> getAllItems() {
        return dao.getAllItems();
    }

    public List<ItemDTO> getItemsByStatus(String status) {
        return dao.getItemsByStatus(status);
    }

    public boolean deleteItem(int id) {
        return dao.deleteItem(id);
    }
}
