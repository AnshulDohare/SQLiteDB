package com.example.sqlitedb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.sqlitedb.crud.AddContactActivity;
import com.example.sqlitedb.crud.DeleteContactActivity;
import com.example.sqlitedb.crud.UpdateContactActivity;
import com.example.sqlitedb.crud.ViewAllContactsActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addContact(View view){
        startActivity(new Intent(this, AddContactActivity.class));
    }

    public void viewAllContacts(View view){
        startActivity(new Intent(this, ViewAllContactsActivity.class));
    }

    public void updateContact(View view){
        startActivity(new Intent(this, UpdateContactActivity.class));
    }

    public void deleteContact(View view){
        startActivity(new Intent(this, DeleteContactActivity.class));
    }
}