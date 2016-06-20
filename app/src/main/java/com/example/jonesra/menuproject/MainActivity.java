package com.example.jonesra.menuproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.action_help){
            Toast t = Toast.makeText(this, "Help", Toast.LENGTH_SHORT);
            t.show();
            final Intent intentHelpActivity = new Intent(getApplicationContext(), HelpActivity.class);
            startActivity(intentHelpActivity);
            return true;
        }

      /*  if (id == R.id.action_help) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);

    }

    //explicit intent option being called in this case
    public void btnSMSClick(View view) {
        //Intent intent = new Intent(this,NewActivity.class);
        final Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:" + Uri.encode("tel:6468316127")));
        intent.putExtra("sms_body", "Rawle Jones");
        startActivity(intent);
    }

    public void btnPhoneClick(View view) {
        //Intent intent = new Intent(this,NewActivity.class);
        final Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:6468316127"));
        startActivity(intent);
    }

    public void btnWebClick(View view) {
        //Intent intent = new Intent(this,NewActivity.class);
        final Intent intentWebSearch = new Intent(Intent.ACTION_VIEW, Uri.parse("http://Yahoo.com"));
        startActivity(intentWebSearch);
    }

    public void btnMapsClick(View view) {
        //Intent intent = new Intent(this,NewActivity.class);
        String geoUriLoc = String.format("geo:13.1773624,-59.4828687");
        Uri geo = Uri.parse(geoUriLoc);
        final Intent geoMapLoc = new Intent(Intent.ACTION_VIEW, geo);
        startActivity(geoMapLoc);
    }

    public void btnShareClick(View view) {
        final Intent intent = new Intent(Intent.ACTION_SEND);
        // intent.setAction(Intent.ACTION_CHOOSER);
        intent.setType("text/plain");
       // intent.putExtra(Intent.EXTRA_TEXT, R.);
        //startActivity(intent);
        startActivity(Intent.createChooser(intent, getResources().getText(R.string.send_to)));
    }

    public void btnNewActivityClick(View view) {
        final Intent intentNewActivity = new Intent(getApplicationContext(), NewActivity.class);
        startActivity(intentNewActivity);
    }

}