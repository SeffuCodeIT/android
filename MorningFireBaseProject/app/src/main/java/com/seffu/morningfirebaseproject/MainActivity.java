package com.seffu.morningfirebaseproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    EditText mName,mEmail,mid;
    Button mBtnSave,mBtnView;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mName = findViewById(R.id.edtname);
        mEmail = findViewById(R.id.edtmail);
        mid = findViewById(R.id.edtid);
        mBtnSave = findViewById(R.id.btnsave);
        mBtnView = findViewById(R.id.btnview);
        dialog = new ProgressDialog(this);
        dialog.setTitle("Saving");
        dialog.setMessage("Please wait...");
        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create a unique value to form the table row
                long time = System.currentTimeMillis();

                //create a table called users in the database
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("users/"+time);


                //check if the user has entered all the details
                String name = mName.getText().toString();
                String Email = mEmail.getText().toString();
                String id = mid.getText().toString().trim();
                if (name.isEmpty() || Email.isEmpty() || id.isEmpty()){
                    Toast.makeText(MainActivity.this, "Fill in all inputs", Toast.LENGTH_SHORT).show();
                }else {
                    //code to save data in the db
                    User mtu = new User(name,Email,id,String.valueOf(time));
                    dialog.show();
                    ref.setValue(mtu).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            dialog.dismiss();
                            if (task.isSuccessful()){
                                Toast.makeText(MainActivity.this, "Saved successfully", Toast.LENGTH_SHORT).show();
                                mName.setText("");
                                mEmail.setText("");
                                mid.setText("");
                            }else {
                                Toast.makeText(MainActivity.this, "Saving failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }
        });

        mBtnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent view = new Intent(getApplicationContext(),UsersActivity.class);
                startActivity(view);
            }
        });

    }
}
