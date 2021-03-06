package com.example.mini.secondhandin;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class tourActivity extends AppCompatActivity {
    private Button buttonAmerica, buttonAsia, buttonEurope, buttonAustralia;
    private ImageView continentsImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour);
//        buttonAmerica = (Button)findViewById(R.id.buttonAmerica);
//        buttonAsia = (Button)findViewById(R.id.buttonAsia);
//        buttonEurope = (Button)findViewById(R.id.buttonEurope);
//        buttonAustralia = (Button)findViewById(R.id.buttonAustralia);

        Toast.makeText(getApplicationContext(), "Click on preferred Continent!",
                Toast.LENGTH_SHORT).show();

       continentsImageView = (ImageView) findViewById (R.id.imageViewContinents);
        continentsImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent ev) {


                final int evX = (int) ev.getX();
                final int evY = (int) ev.getY();

                int touchColor = getHotspotColor(R.id.imageViewContinents_data, evX, evY);

                int tolerance = 50;
                if (ev.getAction() == MotionEvent.ACTION_UP) {
                    if (closeMatch(Color.RED, touchColor, tolerance)) {
                        onOneOfTheContinentClick("America");
                        //green
                    } else if (closeMatch(Color.rgb(34, 177, 76), touchColor, tolerance)) {
                        onOneOfTheContinentClick("Africa");
                    } else if (closeMatch(Color.YELLOW, touchColor, tolerance)) {
                        onOneOfTheContinentClick("Australia");
                        //blue
                    } else if (closeMatch(Color.rgb(63, 72, 204), touchColor, tolerance)) {
                        onOneOfTheContinentClick("Asia");
                    } else if (closeMatch(Color.BLACK, touchColor, tolerance)) {
                        onOneOfTheContinentClick("Europe");
                    }
                    return true;
                }
                return true;
            }
        });

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

//    public void onButtonAmericaClick(View view) {
//        onOneOfTheContentClick(buttonAmerica);
//    }
//
//    public void onButtonAsiaClick(View view) {
//        onOneOfTheContentClick(buttonAsia);
//    }
//
//    public void onButtonAustraliaClick(View view) {
//        onOneOfTheContentClick(buttonAustralia);
//    }
//
//    public void onButtonEuropeClick(View view) {
//        onOneOfTheContentClick(buttonEurope);
//    }

    public int getHotspotColor (int hotspotId, int x, int y) {
        ImageView img = (ImageView) findViewById (hotspotId);
        if (img == null) {
            Log.d("ImageAreasActivity", "Hot spot image not found");
            return 0;
        } else {
            img.setDrawingCacheEnabled(true);
            Bitmap hotspots = Bitmap.createBitmap(img.getDrawingCache());
            if (hotspots == null) {
                Log.d ("ImageAreasActivity", "Hot spot bitmap was not created");
                return 0;
            } else {
                img.setDrawingCacheEnabled(false);
                return hotspots.getPixel(x, y);
            }
        }
    }

    private boolean closeMatch (int color1, int color2, int tolerance) {
        if ((int) Math.abs (Color.red (color1) - Color.red (color2)) > tolerance ) return false;
        if ((int) Math.abs (Color.green (color1) - Color.green (color2)) > tolerance ) return false;
        if ((int) Math.abs (Color.blue (color1) - Color.blue (color2)) > tolerance ) return false;
        return true;
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

    public void onAboutButtonClick(View view) {

        Intent aboutIntent = new Intent(this, aboutActivity.class);
        startActivity(aboutIntent);
        overridePendingTransition(R.anim.from_right, R.anim.to_left);
    }

    public void onMainButtonClick(View view) {
        Intent mainIntent = new Intent (this, MainActivity.class);
        startActivity(mainIntent);
        overridePendingTransition(R.anim.from_right, R.anim.to_left);
    }

    public void onContactButtonClick(View view) {
        Intent emailIntent = new Intent (this, emailActivity.class);
        startActivity(emailIntent);
        overridePendingTransition(R.anim.from_right, R.anim.to_left);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.from_left, R.anim.to_right);
    }

    private void onOneOfTheContinentClick(String continent)
    {
        Intent contentToursIntent = new Intent (this, tourOfContinentActivity.class);
        contentToursIntent.putExtra("fromTourActivity", continent);
        startActivityForResult(contentToursIntent, 999);
        overridePendingTransition(R.anim.from_right, R.anim.to_left);
    }
}
