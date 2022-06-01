package com.example.flooddetectorlast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.RemoteMessage;
import com.pusher.pushnotifications.PushNotificationReceivedListener;
import com.pusher.pushnotifications.PushNotifications;


public class MainActivity extends AppCompatActivity {

    Button on;
    Button off;
    TextView distance;
    DatabaseReference dref;
    String status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        on = (Button) findViewById(R.id.on);
        off = (Button) findViewById(R.id.permission);




        on.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Permulaan Aplikasi");

                builder.setMessage("Tekan 'Ya' untuk mulakan aktiviti baru, Tekan 'Tidak' untuk sambung aktiviti");
                builder.setCancelable(true);

                builder.setPositiveButton("Ya!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(MainActivity.this, MapsActivity.class));
                    }
                });

                builder.setNegativeButton("Tidak!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(MainActivity.this, MapsActivity2.class));
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });
//permission button
        off.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PermissionsActivity.class));
            }
        });




    }


}