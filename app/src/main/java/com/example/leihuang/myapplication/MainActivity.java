package com.example.leihuang.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends Activity {

    static String E_NAME = "com.example.leihuang.Name";
    static String E_PWD = "com.example.leihuang.Pwd";

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

    public void pressLoginButton(View view){
        Intent newIntent = new Intent(this,SecondActivity.class);
        EditText nameText = (EditText)findViewById(R.id.nameTextField);
        String nameString = nameText.getText().toString();
        newIntent.putExtra(E_NAME,nameString);

        EditText pwdText = (EditText)findViewById(R.id.passwordTextField);
        String pwdString = pwdText.getText().toString();
        newIntent.putExtra(E_PWD, pwdString);

        if (nameString.length() == 0 || pwdString.length() == 0) {
            this.showErrorAlert();
        }else {
            startActivity(newIntent);
        }

    }

    public  void showErrorAlert() {
        Dialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Dialog")
                .setMessage("Please input name & password")
                .setPositiveButton("OK",null)
                .create();
        alertDialog.show();
    }
}
