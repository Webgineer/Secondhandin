package com.example.mini.secondhandin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class tourOfContinentActivity extends AppCompatActivity {

    private ListView toursList;
    private Button buttonSelectedContinent;
    private String[] values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_of_continent);
        toursList = (ListView)findViewById(R.id.listViewContinent);
        buttonSelectedContinent = (Button)findViewById(R.id.buttonSelectedContinent);

        Bundle bundle = getIntent().getExtras();
        String currentContent = bundle.getString("fromTourActivity");
        buttonSelectedContinent.setText(currentContent);

        if(currentContent.equals("America"))
        {
            values = getResources().getStringArray(R.array.tour_america_array);
        }
        else if (currentContent.equals("Asia"))
        {
            values = getResources().getStringArray(R.array.tour_asia_array);
        }
        else if (currentContent.equals("Europe"))
        {
            values = getResources().getStringArray(R.array.tour_europe_array);
        }
        else if (currentContent.equals("Australia"))
        {
            values = getResources().getStringArray(R.array.tour_australia_array);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, values);
        toursList.setAdapter(adapter);

        toursList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent returnIntent = new Intent();
                returnIntent.putExtra("fromTourOfContinentActivity", position);
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tour_of_content, menu);
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
}
