package com.example.try1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    EditText username, password;
    String user_value, key_value;
    Button enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.editText2);
        password = (EditText) findViewById(R.id.editText);
        enter = (Button) findViewById(R.id.button2);

        enter.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //  user_value = username.getText().toString();
              //  key_value = password.getText().toString();
   //             Toast.makeText(login.this, "You entered " + user_value + " " + key_value, Toast.LENGTH_SHORT).show();
                check();
            }
        });

    }
String txt="User not registered";
    public void check(){ {
        user_value = username.getText().toString();
        key_value = password.getText().toString();
        switch(user_value+"."+key_value){
            case "Shanu Garg.123":
            case "Vineet Dhankar.5896":
            case "Bansri Sinha.4631":
            case "Vinay Kumar.7391":
            case "Pratham Agrasen.6969":
            case "Agam Kaushik.4943":
            case "Shaurya Anand.1973":
            case "Khushboo.5493":
                txt = "Welcome "+user_value+"😃";
                Intent intent = new Intent(login.this, Upload.class);
                intent.putExtra("user", user_value);
                startActivity(intent);
            default: Toast.makeText(login.this, txt, Toast.LENGTH_SHORT).show();

        }
        }
    }

}
