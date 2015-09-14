package com.example.mini.secondhandin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class aboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        TextView aboutVolbeatTextView = (TextView)findViewById(R.id.textViewAboutVolbeat);
        aboutVolbeatTextView.setMovementMethod(new ScrollingMovementMethod());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_about, menu);
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

    public void onTextViewMoreInfoClick(View view) {
        Intent webViewVolbeat = new Intent (this, webViewAboutVolbeatActivity.class);
        startActivity(webViewVolbeat);
        overridePendingTransition(R.anim.from_right, R.anim.to_left);
    }


    public void onContactButtonClick(View view) {
        Intent emailIntent = new Intent (this, emailActivity.class);
        startActivity(emailIntent);
        overridePendingTransition(R.anim.from_right, R.anim.to_left);
    }

    public void onMainButtonClick(View view) {
        Intent mainIntent = new Intent (this, MainActivity.class);
        startActivity(mainIntent);
        overridePendingTransition(R.anim.from_right, R.anim.to_left);
    }

    public void onToursButtonClick(View view) {
        Intent toursIntent = new Intent (this, tourActivity.class);
        startActivity(toursIntent);
        overridePendingTransition(R.anim.from_right, R.anim.to_left);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.from_left, R.anim.to_right);
    }

}
