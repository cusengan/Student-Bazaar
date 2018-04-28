package com.example.william.studentbazaar.database.Item;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.william.studentbazaar.TradeDirectory.Item;
import com.example.william.studentbazaar.database.StudentBazaarDbSchema.ItemTable.Cols;

import java.util.UUID;

public class ItemCursorWrapper extends CursorWrapper {

    public ItemCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Item getItem() {

        String uuidString = getString(getColumnIndex(Cols.UUID));
        String ownerId = getString(getColumnIndex(Cols.OWNERID));
        String name = getString(getColumnIndex(Cols.NAME));
        String description = getString(getColumnIndex(Cols.DESCRIPTION));
        int onSale = getInt(getColumnIndex(Cols.ONSALE));

        Item item = new Item(UUID.fromString(uuidString));
        item.setOwnerId(ownerId);
        item.setName(name);
        item.setDescription(description);
        item.setOnSale(onSale != 0);

        return item;
    }
}
