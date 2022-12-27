package com.bkb.room.db;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase database = Room.databaseBuilder(this, AppDatabase.class, "mydb")
                .allowMainThreadQueries()
                .build();

        ItemDAO itemDAO = database.getItemDAO();
        Item item = new Item();
        item.setName("Item001");
        item.setDescription("Item 001");
        item.setQuantity((long) 1000.00);

        itemDAO.insert(item);
        List<Item> items = itemDAO.getItems();
        System.out.println(items.toString());

    }
}
