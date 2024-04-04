package com.example.sqlitedb.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlitedb.R;

public class DeleteContactActivity extends AppCompatActivity {
    EditText etName, etMobile;
    Button btnDeleteContact;
    DatabaseManager databaseManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_contact);
        etName = findViewById(R.id.etName);
        etMobile = findViewById(R.id.etMobile);
        btnDeleteContact = findViewById(R.id.btnDeleteContact);

        databaseManager = new DatabaseManager(this);

        btnDeleteContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                String mobile = etMobile.getText().toString().trim();

                if(name.isEmpty()){
                    etName.setError("Enter Name");
                }
                else if(mobile.isEmpty()){
                    etMobile.setError("Enter Mobile Number");
                }
                else{
                    int result = databaseManager.deleteData(name,mobile);
                    if(result==1){
                        Toast.makeText(DeleteContactActivity.this, "Contact Deleted Successfully", Toast.LENGTH_SHORT).show();
                        etName.setText("");
                        etMobile.setText("");
                    }
                    else if(result==-1){
                        Toast.makeText(DeleteContactActivity.this, "Contact not exist with given name and mobile number", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}