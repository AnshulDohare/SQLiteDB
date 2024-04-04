package com.example.sqlitedb.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlitedb.R;

public class UpdateContactActivity extends AppCompatActivity {
    EditText etName, etMobile,etEmail,etAddress,etRelation;
    Button btnUpdateContact;
    DatabaseManager databaseManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_contact);
        etName = findViewById(R.id.etName);
        etMobile = findViewById(R.id.etMobile);
        etEmail = findViewById(R.id.etEmail);
        etAddress = findViewById(R.id.etAddress);
        etRelation = findViewById(R.id.etRelation);
        btnUpdateContact = findViewById(R.id.btnUpdateContact);

        databaseManager = new DatabaseManager(this);

        btnUpdateContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                String mobile = etMobile.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String address = etAddress.getText().toString().trim();
                String relation = etRelation.getText().toString().trim();

                if(name.isEmpty()){
                    etName.setError("Enter Name");
                }
                else if(mobile.isEmpty()){
                    etMobile.setError("Enter Mobile Number");
                }
                else{
                    int result = databaseManager.updateData(name,mobile,email,address,relation);
                    if(result==1){
                        Toast.makeText(UpdateContactActivity.this, "Contact Updated Successfully", Toast.LENGTH_SHORT).show();
                        etName.setText("");
                        etMobile.setText("");
                        etEmail.setText("");
                        etAddress.setText("");
                        etRelation.setText("");
                    }
                    else if(result==0){
                        Toast.makeText(UpdateContactActivity.this, "Contact not exist with given mobile number", Toast.LENGTH_SHORT).show();
                        etMobile.setText("");
                    }
                    else if(result==-1){
                        Toast.makeText(UpdateContactActivity.this, "Updation Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}