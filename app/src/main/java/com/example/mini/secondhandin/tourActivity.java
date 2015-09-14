package com.example.mini.secondhandin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class tourActivity extends AppCompatActivity {
    private Button buttonAmerica, buttonAsia, buttonEurope, buttonAustralia;
    private String buttonText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour);
        buttonAmerica = (Button)findViewById(R.id.buttonAmerica);
        buttonAsia = (Button)findViewById(R.id.buttonAsia);
        buttonEurope = (Button)findViewById(R.id.buttonEurope);
        buttonAustralia = (Button)findViewById(R.id.buttonAustralia);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tour, menu);
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

    public void onButtonAmericaClick(View view) {
            Intent contentToursIntent = new Intent (this, tourOfContinentActivity.class);

            buttonText = buttonAmerica.getText().toString();
            contentToursIntent.putExtra("fromTourActivity", buttonText);
            startActivityForResult(contentToursIntent, 999);
    }

    public void onButtonAsiaClick(View view) {
        Intent contentToursIntent = new Intent (this, tourOfContinentActivity.class);

        buttonText = buttonAsia.getText().toString();
        contentToursIntent.putExtra("fromTourActivity", buttonText);
        startActivityForResult(contentToursIntent, 999);
    }

    public void onButtonAustraliaClick(View view) {
        Intent contentToursIntent = new Intent (this, tourOfContinentActivity.class);

        String buttonText = buttonAustralia.getText().toString();
        contentToursIntent.putExtra("fromTourActivity", buttonText);
        startActivityForResult(contentToursIntent, 999);
    }

    public void onButtonEuropeClick(View view) {
        Intent contentToursIntent = new Intent (this, tourOfContinentActivity.class);

        String buttonText = buttonEurope.getText().toString();
        contentToursIntent.putExtra("fromTourActivity", buttonText);
        startActivityForResult(contentToursIntent, 999);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK ) {
            int returnResult = data.getExtras().getInt("fromTourOfContinentActivity");
            Toast.makeText(getApplicationContext(),
                    "Sorry, tickets to this festival #" + returnResult + " are sold out.",
                    Toast.LENGTH_LONG)
                    .show();
        }
    }
}
