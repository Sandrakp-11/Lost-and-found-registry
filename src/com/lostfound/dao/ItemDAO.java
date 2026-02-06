package com.lostfound.dao;

import com.lostfound.dto.ItemDTO;
import java.util.List;

public interface ItemDAO {

    boolean addItem(ItemDTO item);
    List<ItemDTO> getAllItems();
    List<ItemDTO> getItemsByStatus(String status);
    boolean deleteItem(int itemId);
}
