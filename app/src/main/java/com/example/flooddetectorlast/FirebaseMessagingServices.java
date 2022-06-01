package com.example.flooddetectorlast;

import android.content.Intent;
import android.os.IBinder;

import com.google.firebase.messaging.RemoteMessage;

interface FirebaseMessagingServices {

    IBinder onBind(Intent intent);

    void onMessageReceived(RemoteMessage remoteMessage);

    void onDeletedMessages();
}