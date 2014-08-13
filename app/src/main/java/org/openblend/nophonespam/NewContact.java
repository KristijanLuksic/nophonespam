package org.openblend.nophonespam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;


public class NewContact extends Activity{

    // The EditText objects

    EditText firstName;
    EditText lastName;
    EditText phoneNumber;
    EditText emailAddress;


    DBTools dbTools = new DBTools(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {

        // Get saved data if there is any

        super.onCreate(savedInstanceState);

        // Designate that add_new_contact.xml is the interface used

        setContentView(R.layout.add_new_contact);

        // Initialize the EditText objects

        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);
        phoneNumber = (EditText) findViewById(R.id.phoneNumber);
        emailAddress = (EditText) findViewById(R.id.emailAddress);


    }
    public void addNewContact(View view) {

       HashMap<String, String> queryValuesMap =  new  HashMap<String, String>();

        // Values from the EditText boxes

        queryValuesMap.put("firstName", firstName.getText().toString());
        queryValuesMap.put("lastName", lastName.getText().toString());
        queryValuesMap.put("phoneNumber", phoneNumber.getText().toString());
        queryValuesMap.put("emailAddress", emailAddress.getText().toString());


        // Call for the HashMap.

        dbTools.insertContact(queryValuesMap);

        // Call MyActivity

        this.callMainActivity(view);
    }
    public void callMainActivity(View view) {
        Intent theIntent = new Intent(getApplicationContext(), MyActivity.class);
        startActivity(theIntent);



    }
}