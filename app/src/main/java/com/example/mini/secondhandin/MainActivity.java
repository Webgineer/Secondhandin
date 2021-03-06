package com.example.mini.secondhandin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        }

        return super.onOptionsItemSelected(item);
    }

    public void onAboutButtonClick(View view) {

        Intent aboutIntent = new Intent(this, aboutActivity.class);
        startActivity(aboutIntent);
        overridePendingTransition(R.anim.from_right, R.anim.to_left);
    }

    public void onContactButtonClick(View view) {
        Intent emailIntent = new Intent (this, emailActivity.class);
        startActivity(emailIntent);
        overridePendingTransition(R.anim.from_right, R.anim.to_left);
    }

    public void onToursButtonClick(View view) {
        Intent toursIntent = new Intent (this, tourActivity.class);
        startActivity(toursIntent);
        overridePendingTransition(R.anim.from_right, R.anim.to_left);
    }

    @Override
    public void onBackPressed() {
        if(isTaskRoot())
        {
            super.onBackPressed();
        }
        else{
            super.onBackPressed();
            overridePendingTransition(R.anim.from_left, R.anim.to_right);}
    }

}
