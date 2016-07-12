package com.example.administrador.petshopdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrador.petshopdatabase.R;

public class MailActivity extends AppCompatActivity {
    public String strUserFrom;
    public String strPass;
    public String strEmailTo;
    public String strBody;
    public String strSubject;
    TextView txtSubject;
    TextView txtEmailAddressTo;
    TextView txtBody;
    TextView txtFrom;
    TextView txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);
        Toolbar myActionBar = (Toolbar) findViewById(R.id.myToolbar);
        myActionBar.setTitle("Contact me...");
        setSupportActionBar(myActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        txtFrom = (TextView) findViewById(R.id.txtViewFrom);
        txtPass = (TextView) findViewById(R.id.txtViewPass);
        txtEmailAddressTo = (TextView) findViewById(R.id.txtViewEmailAddress);
        txtSubject = (TextView)findViewById(R.id.txtViewSubject);
        txtBody = (TextView)findViewById(R.id.txtViewBody);

        strUserFrom = txtFrom.getText().toString();
        strPass = txtPass.getText().toString();
        strEmailTo = txtEmailAddressTo.getText().toString();
        strSubject = txtSubject.getText().toString();
        strBody = txtBody.getText().toString();
    }

    public void sendEmail(){

        txtFrom.setText("");
        txtPass.setText("");
        txtEmailAddressTo.setText("");
        txtSubject.setText("");
        txtBody.setText("");

        Toast.makeText(MailActivity.this, "Mail Sent", Toast.LENGTH_SHORT).show();

       /*
        if (!strUserFrom.equals("") && !strPass.equals("") && !strEmailTo.equals("") && !strSubject.equals("") && !strBody.equals("")){
            Toast.makeText(MailActivity.this, "Your mail has been sent", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MailActivity.this, MainActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(MailActivity.this, "One or more Fields are empty, check please !", Toast.LENGTH_SHORT).show();
        }
        */
    }
}
