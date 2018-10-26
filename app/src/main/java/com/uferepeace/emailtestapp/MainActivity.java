package com.uferepeace.emailtestapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sendMailBtn = (Button) findViewById(R.id.btn_send_mail);
        sendMailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMail();
            }
        });
    }

    private void sendMail() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    // TODO: Add your gmail address and password where needed below
                    GMailSender sender = new GMailSender("YOUR_GMAIL_ADDRESS",
                            "YOUR_GMAIL_PASSWORD");
                    sender.sendMail("Hello from JavaMail", "Body from JavaMail",
                            "uferepeace@gmail.com", "peace.ufere@kodehauz.com");
                } catch (Exception e) {
                    Log.e("SendMail", e.getMessage(), e);
                }
            }

        }).start();
    }
}
