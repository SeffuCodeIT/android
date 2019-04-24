package com.seffu.morningsqliteproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText mName,mId,mEmail;
    Button mBtnSave,mBtnView,mBtnDelete;
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mName = findViewById(R.id.edtname);
        mId = findViewById(R.id.edtid);
        mEmail = findViewById(R.id.edtmail);
        mBtnSave = findViewById(R.id.btnsave);
        mBtnView = findViewById(R.id.btnview);
        mBtnDelete = findViewById(R.id.btndelete);
        db = openOrCreateDatabase("voterDb",MODE_PRIVATE,null);
        //Creating a table query
        db.execSQL("CREATE TABLE IF NOT EXISTS voterreg(name VARCHAR, email VARCHAR, idNO VARCHAR)");
        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check if user has filled all records
                String name = mName.getText().toString();
                String email = mEmail.getText().toString();
                String id = mId.getText().toString().trim();
                if (name.isEmpty()){
                    messageDisplay("Name Error","Kindly fill in your name");
                }else if (email.isEmpty()){
                    messageDisplay("Email Error","Kindly Fill In your Email");
                }else if (id.isEmpty()){
                    messageDisplay("Id Error","Kindly fill in your Id");
                }else {
                    //insert into db query
                    db.execSQL("INSERT INTO voterreg VALUES ('"+name+"','"+email+"','"+id+"')");
                    messageDisplay("Query success","Data Saved successfuly");
                    clear();
                }
            }
        });
        mBtnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Query To View Database Records
                Cursor cursor = db.rawQuery("SELECT * FROM voterreg",null);
                //check if thee are any records
                if (cursor.getCount()==0){
                    messageDisplay("No Records","Sorry no records were found");
                }
                //use Buffer to append the records
                StringBuffer buffer = new StringBuffer();
                while (cursor.moveToNext()){
                    buffer.append("\n"+cursor.getString(0));
                    buffer.append("\t"+cursor.getString(1));
                    buffer.append("\t"+cursor.getString(2));
                    buffer.append("\n");
                }
                messageDisplay("DATABASE RECORDS",buffer.toString());
            }
        });
        mBtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Check if someone has not entered the id
                String id = mId.getText().toString().trim();
                if (id.isEmpty()){
                    messageDisplay("Id Error","Kindly fill in the id");
                }else {
                    Cursor cursor = db.rawQuery("SELECT * FROM voterreg WHERE idNO = '"+id+"'",null);
                    if (cursor.moveToFirst()) {
                        db.execSQL("DELETE FROM voterreg WHERE idNO = '"+id+"'");
                        messageDisplay("deleted","Record deleted successfuly");
                        clear();
                    }
                }
            }
        });
    }
    //Message display function
    private void messageDisplay(String title,String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.create().show();
    }
    //Clear the EditText after saving
    public void clear(){
        mName.setText("");
        mEmail.setText("");
        mId.setText("");
    }
}
