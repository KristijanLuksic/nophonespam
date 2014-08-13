package org.openblend.nophonespam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;

public class EditContact extends Activity{

    EditText firstName;
    EditText lastName;
    EditText phoneNumber;
    EditText emailAddress;


    DBTools dbTools = new DBTools(this);

    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_contact);
        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);
        phoneNumber = (EditText) findViewById(R.id.phoneNumber);
        emailAddress = (EditText) findViewById(R.id.emailAddress);

        Intent theIntent = getIntent();

        String contactId = theIntent.getStringExtra("contactId");

        HashMap<String, String> contactList = dbTools.getContactInfo(contactId);

        if(contactList.size() != 0){

            firstName.setText(contactList.get("firstName"));
            lastName.setText(contactList.get("lastName"));
            phoneNumber.setText(contactList.get("phoneNumber"));
            emailAddress.setText(contactList.get("emailAddress"));


        }
    }

    public void editContact(View view){

        HashMap<String, String> queryValuesMap = new HashMap<String, String>();
        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);
        phoneNumber = (EditText) findViewById(R.id.phoneNumber);
        emailAddress = (EditText) findViewById(R.id.emailAddress);


        Intent theIntent = getIntent();

        String contactId = theIntent.getStringExtra("contactId");

        queryValuesMap.put("contactId", contactId);
        queryValuesMap.put("firstName", firstName.getText().toString());
        queryValuesMap.put("lastName", lastName.getText().toString());
        queryValuesMap.put("phoneNumber", phoneNumber.getText().toString());
        queryValuesMap.put("emailAddress", emailAddress.getText().toString());


        dbTools.updateContact(queryValuesMap);
        this.callMainActivity(view);

    }

    public void removeContact(View view){

        Intent theIntent = getIntent();
        String contactId = theIntent.getStringExtra("contactId");

        dbTools.deleteContact(contactId);

        this.callMainActivity(view);

    }

    public void callMainActivity(View view){

        Intent objIntent = new Intent(getApplication(), MyActivity.class);

        startActivity(objIntent);

    }

}