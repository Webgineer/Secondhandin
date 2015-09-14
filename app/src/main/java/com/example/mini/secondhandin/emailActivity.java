package com.example.mini.secondhandin;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class emailActivity extends AppCompatActivity {

    private EditText recipient;
    private EditText subject;
    private EditText body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        recipient = (EditText) findViewById(R.id.editTextRecipient);
        subject = (EditText) findViewById(R.id.editTextSubject);
        body = (EditText) findViewById(R.id.editTextText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_email, menu);
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

    protected void sendEmail() {

        String[] recipients = {recipient.getText().toString()};
        Intent email = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
        // prompts email clients only
        email.setType("message/rfc822");

        email.putExtra(Intent.EXTRA_EMAIL, recipients);
        email.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
        email.putExtra(Intent.EXTRA_TEXT, body.getText().toString());

        try {
            // the user can choose the email client
            startActivity(Intent.createChooser(email, "Choose an email client from..."));

        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(emailActivity.this, "No email client installed.",
                    Toast.LENGTH_LONG).show();
        }
    }


    public void onSendButtonClick(View view) {
        sendEmail();

        recipient.setText("");
        subject.setText("");
        body.setText("");
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

    public void onToursButtonClick(View view) {
        Intent toursIntent = new Intent (this, tourActivity.class);
        startActivity(toursIntent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.from_left, R.anim.to_right);
    }
}
