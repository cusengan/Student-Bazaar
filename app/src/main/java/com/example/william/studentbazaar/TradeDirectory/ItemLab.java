package com.example.william.studentbazaar.TradeDirectory;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.william.studentbazaar.database.Item.ItemCursorWrapper;
import com.example.william.studentbazaar.database.DBHelper;
import com.example.william.studentbazaar.database.StudentBazaarDbSchema;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.example.william.studentbazaar.database.StudentBazaarDbSchema.ItemTable.Cols.DESCRIPTION;
import static com.example.william.studentbazaar.database.StudentBazaarDbSchema.ItemTable.Cols.NAME;
import static com.example.william.studentbazaar.database.StudentBazaarDbSchema.ItemTable.Cols.ONSALE;
import static com.example.william.studentbazaar.database.StudentBazaarDbSchema.ItemTable.Cols.OWNERID;

public class ItemLab {
    private static ItemLab sItemLab;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static ItemLab get(Context context) {
        if (sItemLab == null) {
            sItemLab = new ItemLab(context);
//            context.deleteDatabase("studentBazaar.db");
        }

        return sItemLab;
    }

    private ItemLab(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new DBHelper(mContext)
                .getWritableDatabase();

    }

    public void addItem(Item c) {
        ContentValues values = getContentValues(c);
        mDatabase.insert(StudentBazaarDbSchema.ItemTable.NAME, null, values);
    }

    public List<Item> getItems() {
        List<Item> Items = new ArrayList<>();
        ItemCursorWrapper cursor = queryItems(null, null);
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Items.add(cursor.getItem());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return Items;
    }

    public List<Item> getItemsOnSale() {
        List<Item> items = new ArrayList<>();
        ItemCursorWrapper cursor = queryItems(ONSALE + " = 1", null);
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                items.add(cursor.getItem());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return items;
    }

    public Item getItem(UUID id) {
        ItemCursorWrapper cursor = queryItems(
                StudentBazaarDbSchema.ItemTable.Cols.UUID + " = ?",
                new String[]{id.toString()}
        );
        try {
            if (cursor.getCount() == 0) {
                return null;
            }
            cursor.moveToFirst();
            return cursor.getItem();
        } finally {
            cursor.close();
        }
    }


    public void updateItem(Item Item) {
        String uuidString = Item.getId().toString();
        ContentValues values = getContentValues(Item);
        mDatabase.update(StudentBazaarDbSchema.ItemTable.NAME, values,
                StudentBazaarDbSchema.ItemTable.Cols.UUID + " = ?",
                new String[]{uuidString});
    }

    private ItemCursorWrapper queryItems(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                StudentBazaarDbSchema.ItemTable.NAME,
                null, // Columns - null selects all columns
                whereClause,
                whereArgs,
                null, // groupBy
                null, // having
                null  // orderBy
        );
        return new ItemCursorWrapper(cursor);
    }

    private static ContentValues getContentValues(Item item) {
        ContentValues values = new ContentValues();
        values.put(StudentBazaarDbSchema.ItemTable.Cols.UUID, item.getId().toString());
        values.put(OWNERID, item.getOwnerId());
        values.put(NAME, item.getName());
        values.put(DESCRIPTION, item.getDescription());
        values.put(ONSALE, item.isOnSale());

        return values;
    }
}
