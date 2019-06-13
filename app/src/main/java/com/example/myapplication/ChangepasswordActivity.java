package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

public class ChangepasswordActivity extends AppCompatActivity {
private ActionBar kib;
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changepassword);
kib= getSupportActionBar();
kib.setDisplayHomeAsUpEnabled(true);
button  = findViewById(R.id.button_regi);
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        System.out.println("Password reset successfully");
    }
});


    }
    public  boolean onOptionsItemSelected(MenuItem item){
        Intent didy = new Intent(getApplicationContext(),DrawerActivity.class);
        //startActivity(didy);

        startActivityForResult(didy,0);
        return true;
    }
}
