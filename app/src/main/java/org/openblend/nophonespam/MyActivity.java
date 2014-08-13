package org.openblend.nophonespam;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;


public class MyActivity extends ListActivity {



    // The Intent is used to issue that an operation should
    // be performed

    Intent intent;
    TextView contactId;

    // The object that allows me to manipulate the database

    DBTools dbTools = new DBTools(this);

    // Called when the Activity is first called

    protected void onCreate(Bundle savedInstanceState) {
        // Get saved data if there is any

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        ArrayList<HashMap<String, String>> contactList =  dbTools.getAllContacts();

        if(contactList.size()!=0) {

            ListView listView = getListView();
            listView.setOnItemClickListener(new OnItemClickListener() {

                public void onItemClick(AdapterView<?> parent, View view,int position, long id) {

                    contactId = (TextView) view.findViewById(R.id.contactId);
                    String contactIdValue = contactId.getText().toString();

                    Intent  theIndent = new Intent(getApplication(),EditContact.class);
                    theIndent.putExtra("contactId", contactIdValue);

                    // Starts Edit Contact.

                    startActivity(theIndent);

                }
            });

             ListAdapter adapter = new SimpleAdapter( MyActivity.this,contactList, R.layout.contact_entry, new String[] { "contactId","lastName", "firstName"}, new int[] {R.id.contactId, R.id.lastName, R.id.firstName});

             setListAdapter(adapter);


        }
    }

   //Response to Button.

    public void showAddContact(View view) {
        Intent theIntent = new Intent(getApplicationContext(), NewContact.class);
        startActivity(theIntent);

    }
}