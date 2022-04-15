package com.example.akshay.gastospayment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QrActivity extends AppCompatActivity {
    Button bharatpay;
    Button gpay;
    Button paytm;
    Button phonepay;
    Button amazonpay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);

        bharatpay = (Button) findViewById(R.id.bharatpay);
        bharatpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(QrActivity.this, MainActivity2.class);

                QrActivity.this.startActivity(intent);

            }
        });

        /*
        gpay = (Button) findViewById(R.id.gpay);

        gpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(QrActivity.this, MainActivity.class);

                QrActivity.this.startActivity(intent);

            }
        });

         */

        paytm = (Button) findViewById(R.id.paytm);

        paytm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(QrActivity.this, Paytm.class);

                QrActivity.this.startActivity(intent);

            }
        });

        amazonpay = (Button) findViewById(R.id.amazonpay);

        amazonpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(QrActivity.this, AmazonPay.class);

                QrActivity.this.startActivity(intent);

            }
        });
        phonepay = (Button) findViewById(R.id.phonepay);

        phonepay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(QrActivity.this, Phonepay.class);

                QrActivity.this.startActivity(intent);

            }
        });





    }








    }