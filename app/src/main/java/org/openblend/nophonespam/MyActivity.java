package org.openblend.nophonespam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MyActivity extends Activity {

    public final static String EXTRA_MESSAGE = "com.luksic.kristijan.newapplication";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
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
                startActivity(new Intent(MyActivity.this, Contacts.class));
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




