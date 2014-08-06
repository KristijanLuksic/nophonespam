package org.openblend.nophonespam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;


public class MyActivity extends Activity {



    public final static String EXTRA_MESSAGE = "com.luksic.kristijan.newapplication";






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        DatabaseHandler db = new DatabaseHandler(this);

        /**
         * CRUD Operations
         * */
        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        db.addContact(new Contact("James", "9100000000"));
        db.addContact(new Contact("Jack", "9199999999"));
        db.addContact(new Contact("Tommy", "9522222222"));
        db.addContact(new Contact("George", "9533333333"));

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.getAllContacts();

        for (Contact cn : contacts) {
            String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
            // Writing Contacts to log
            Log.d("Name: ", log);

        }

 }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.exit) {


            finish();
            System.exit(0);
            return true;

        }
        switch (item.getItemId()) {
            case R.id.refresh:
                recreate();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public boolean toContacts(MenuItem item) {
        switch (item.getItemId()){
            case R.id.contacts:
                startActivity(new Intent(MyActivity.this, Contact.class));
        }
        return super.onOptionsItemSelected(item);

    }
    public boolean toBlockList(MenuItem item) {
        switch (item.getItemId()){
            case R.id.block_list:
                startActivity(new Intent(MyActivity.this, BlockList.class));
        }
        return super.onOptionsItemSelected(item);



    }


}




