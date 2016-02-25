package com.elbsoft.demopackinglistwithmvp;

import java.util.ArrayList;

public class ModelItemService {

    private ArrayList<Item> items = new ArrayList();

    public boolean saveItem(String itemName) {
        boolean itemFoundInList = false;
        if (itemName != null && !itemName.isEmpty()) {
            for (Item item : items) {
                if (item.getName().equalsIgnoreCase(itemName)) {
                    itemFoundInList = true;
                }
            }
            if (!itemFoundInList) {
                items.add(new Item(itemName));
                return true;
            }
        }
        return false;
    }
}

