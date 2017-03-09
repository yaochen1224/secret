package com.yaoc.secret;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void save(View view) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("secret");

        EditText editText = (EditText)findViewById(R.id.editTest);
        String userSecret = editText.getText().toString();
        myRef.setValue(userSecret);
    }

    public void reveal(View view) {
        Intent intent = new Intent(this, Activity_Second.class);
        startActivity(intent);
    }
}
