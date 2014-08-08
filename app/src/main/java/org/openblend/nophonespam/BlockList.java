package org.openblend.nophonespam;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BlockList extends Activity {
    private List<Contact> myContacts = new ArrayList<Contact>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.block_list_view);

        populateContactList();
        populateListView();
        registerClickCallback();
 }
        private void populateContactList() {

        DatabaseHandler db = new DatabaseHandler(this);
        Log.d("Insert: ", "Inserting ..");
            db.addContact(new Contact(1, "John", "051223145"));
            db.addContact(new Contact(2, "James", "014578321"));
            db.addContact(new Contact(3, "Tim", "031475149"));
            db.addContact(new Contact(4, "Mark", "040985247"));
            db.addContact(new Contact(5, "Angelina", "068712332"));
            db.addContact(new Contact(6, "Desperado", "041700700"));
            db.addContact(new Contact(7, "Smith", "014578321"));
            db.addContact(new Contact(8, "Thomas", "031475149"));
            db.addContact(new Contact(9, "Susan", "040985247"));
            db.addContact(new Contact(10, "Phillips", "068712332"));
            db.addContact(new Contact(11, "Clark", "051223145"));
            db.addContact(new Contact(12, "Williams", "014578321"));
            db.addContact(new Contact(13, "Daniel", "031475149"));
            db.addContact(new Contact(14, "Robert", "040985247"));
            db.addContact(new Contact(15, "Patricia", "068712332"));
            db.addContact(new Contact(16, "Laura", "051223145"));
            db.addContact(new Contact(17, "Betty", "014578321"));
            db.addContact(new Contact(18, "Scott", "031475149"));
            db.addContact(new Contact(19, "David", "040985247"));
            db.addContact(new Contact(20, "Johnson", "068712332"));
            db.addContact(new Contact(21, "Lee", "051223145"));
            db.addContact(new Contact(22, "James", "014578321"));
            db.addContact(new Contact(23, "Walker", "031475149"));
            db.addContact(new Contact(24, "Lewis", "040985247"));







            myContacts.add(new Contact(1, "John", "051223145"));
            myContacts.add(new Contact(2, "James", "014578321"));
            myContacts.add(new Contact(3, "Tim", "031475149"));
            myContacts.add(new Contact(4, "Mark", "040985247"));
            myContacts.add(new Contact(5, "Angelina", "068712332"));
            myContacts.add(new Contact(6, "Desperado", "041700700"));
            myContacts.add(new Contact(7, "Smith", "014578321"));
            myContacts.add(new Contact(8, "Thomas", "031475149"));
            myContacts.add(new Contact(9, "Susan", "040985247"));
            myContacts.add(new Contact(10, "Phillips", "068712332"));
            myContacts.add(new Contact(11, "Clark", "051223145"));
            myContacts.add(new Contact(12, "Williams", "014578321"));
            myContacts.add(new Contact(13, "Daniel", "031475149"));
            myContacts.add(new Contact(14, "Robert", "040985247"));
            myContacts.add(new Contact(15, "Patricia", "068712332"));
            myContacts.add(new Contact(16, "Laura", "051223145"));
            myContacts.add(new Contact(17, "Betty", "014578321"));
            myContacts.add(new Contact(18, "Scott", "031475149"));
            myContacts.add(new Contact(19, "David", "040985247"));
            myContacts.add(new Contact(20, "Johnson", "068712332"));
            myContacts.add(new Contact(21, "Lee", "051223145"));
            myContacts.add(new Contact(22, "James", "014578321"));
            myContacts.add(new Contact(23, "Walker", "031475149"));
            myContacts.add(new Contact(24, "Lewis", "040985247"));






        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.getAllContacts();

        for (Contact cn : contacts) {
            String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
            // Writing Contacts to log
            Log.d("Name: ", log);
            // Inserting Contacts


        }
    }

    private void populateListView() {
        ArrayAdapter<Contact> adapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.listView5);
        list.setAdapter(adapter);
    }

    private void registerClickCallback() {
        ListView list = (ListView) findViewById(R.id.listView5);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked,
                                    int position, long id) {

                Contact clickedContact = myContacts.get(position);
                String message = "You clicked position " + position
                        + " Which is contact is " + clickedContact.getName();
                Toast.makeText(BlockList.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class MyListAdapter extends ArrayAdapter<Contact> {
        public MyListAdapter() {
            super(BlockList.this, R.layout.item_view, myContacts);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Make sure we have a view to work with (may have been given null)
            View itemView = convertView;
            if (itemView == null) {
                itemView = getLayoutInflater().inflate(R.layout.item_view, parent, false);
            }

            // Find the Contact to work with.
            Contact currentContact = myContacts.get(position);





            // Name:
            TextView nameText = (TextView) itemView.findViewById(R.id.txtName);
            nameText.setText(currentContact.getName());



            // Phone Number:
            TextView numberText = (TextView) itemView.findViewById(R.id.txtNumber);
            numberText.setText(currentContact.getPhoneNumber());

            return itemView;
        }
    }
}












