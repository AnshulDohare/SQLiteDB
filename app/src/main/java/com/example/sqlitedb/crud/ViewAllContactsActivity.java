package com.example.sqlitedb.crud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.example.sqlitedb.R;
import com.example.sqlitedb.contact_info.ContactAdapter;
import com.example.sqlitedb.contact_info.MyContacts;

import java.util.ArrayList;
import java.util.List;

public class ViewAllContactsActivity extends AppCompatActivity {
    RecyclerView contactsListView;
    List<MyContacts> myContactsList;
    ContactAdapter contactAdapter;
    DatabaseManager databaseManager;
    Cursor result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_contacts);
        contactsListView = findViewById(R.id.contactList);

        databaseManager = new DatabaseManager(this);
        result = databaseManager.viewAllData();

        myContactsList = new ArrayList<>();
        contactAdapter = new ContactAdapter(this,myContactsList);

        contactsListView.setHasFixedSize(true);
        contactsListView.setLayoutManager(new GridLayoutManager(this,1,GridLayoutManager.VERTICAL,false));



        if(result.getCount()==0){
            Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
        }
        else{
            while(result.moveToNext()){
                myContactsList.add(new MyContacts(result.getString(0),
                        result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5)));
            }
            contactsListView.setAdapter(contactAdapter);
        }
    }
}