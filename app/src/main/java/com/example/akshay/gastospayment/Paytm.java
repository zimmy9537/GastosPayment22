package com.example.akshay.gastospayment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
//successful
public class Paytm extends AppCompatActivity {

    private EditText amount;
    private EditText description;
    private Button googlePay;
    private TextView transactionStatus;



    private String baseUpiString = "upi://pay?pa=paytmqr281005050101mm617cyacrl1@paytm&pn=Paytm%20Merchant&am=&mc=5499&mode=02&orgid=000000&paytmqr=281005050101MM617CYACRL1&sign=MEQCID0NFi3MYLXf8Yqjqwp7AqyIM7K0nlnQNBmke8X6Ou0fAiBErCzcP25K2wUYvXyt8nJG2OOqoDEAYyVkFKVjhloZYQ==";
  //  String rawStringGpay = "upi://pay?pa=9988890048@okbizaxis&pn=N.K%20MEDICOS&mc=5912&aid=uGICAgIC3joqcAQ&tr=BCR2DN6TR6SKRMR2";
 //   String rawStringPaytm = "upi://pay?pa=paytmqr281005050101mm617cyacrl1@paytm&pn=Paytm%20Merchant&mc=5499&mode=02&orgid=000000&paytmqr=281005050101MM617CYACRL1&sign=MEQCID0NFi3MYLXf8Yqjqwp7AqyIM7K0nlnQNBmke8X6Ou0fAiBErCzcP25K2wUYvXyt8nJG2OOqoDEAYyVkFKVjhloZYQ==";
    String upiId2 = "paytmqr281005050101mm617cyacrl1@paytm";
    String upiId = "9872598189@okbizaxis";
    String merchantId = "JsuLrn83183937545946";
    String merchantPn = "Paytm Merchant";
    String accountName = "SAHGAL KUMAR";

    private String GOOGLE_PAY = "com.google.android.apps.nbu.paisa.user";
    private int REQUEST_CODE = 125;
    private static final int TEZ_REQUEST_CODE = 123;
    private static final String GOOGLE_TEZ_PACKAGE_NAME = "com.google.android.apps.nbu.paisa.user";

    private String LOG_CAT = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paytm);
        amount = findViewById(R.id.amount);
        description = findViewById(R.id.description);
        googlePay = findViewById(R.id.googlePay);
        transactionStatus = findViewById(R.id.transaction_status);


        ArrayList<String> upiApps = new ArrayList<>();
        upiApps.add(new String(GOOGLE_PAY));

        googlePay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseUpiString=baseUpiString+"&am=";
                baseUpiString = baseUpiString + amount.getText().toString().trim();

                Log.v(MainActivity.class.getSimpleName(),"base "+baseUpiString);

                Log.v(MainActivity.class.getSimpleName(), "amount " + amount.getText().toString());

                Log.v(MainActivity.class.getSimpleName(), "base " + baseUpiString);

                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(baseUpiString));

                intent.setPackage("com.google.android.apps.nbu.paisa.user");

                startActivityForResult(intent,TEZ_REQUEST_CODE);

            }
        });
    }

    String getTransactionId() {
        String transactionId = "TID" + System.currentTimeMillis();
        return transactionId;
    }

    boolean isAppInstalled(String packageName) {
        PackageManager pm = getPackageManager();
        try {
            pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    boolean isUpiReady(String packageName) {
        boolean appUpiReady = false;
        Intent upiIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("upi://pay"));
        PackageManager pm = getPackageManager();
        List<ResolveInfo> upiActivities = pm.queryIntentActivities(upiIntent, 0);
        for (ResolveInfo a : upiActivities) {
            if (a.activityInfo.packageName.equals(packageName)) {
                appUpiReady = true;
            }
        }
        return appUpiReady;
    }

    boolean viewsEmpty() {
        if (amount.getText().toString().trim().isEmpty()
                || description.getText().toString().trim().isEmpty()) {

            Toast.makeText(this, "Fill all the details", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }

    Uri getUpiUri() {
        Uri uri = new Uri.Builder()
                .scheme("upi")
                .authority("pay")
                .appendQueryParameter("pa", upiId)
                .appendQueryParameter("pn", accountName)
                .appendQueryParameter("mc", "7372")
                .appendQueryParameter("tr", "2123123434423458786")
                .appendQueryParameter("tn", "test transaction note")
               .appendQueryParameter("am", "1.00")
                .appendQueryParameter("cu", "INR")
                .appendQueryParameter("url", "https://www.gastos.in/")
                .build();
        return uri;
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEZ_REQUEST_CODE) {

            // Process based on the data in response.
            Log.d("result", data.getStringExtra("Status"));
            Toast.makeText(this, "status " + data.getStringExtra("Status"), Toast.LENGTH_SHORT).show();
            return;
        }


        if (requestCode == this.REQUEST_CODE) {
            Log.d("result", String.valueOf(data));
            String var10000;
            String var4;
            if (data != null) {
                var10000 = data.getStringExtra("Status");
                if (var10000 != null) {
                    var4 = var10000;
                    Log.d("result is ", var4);
                }
            }

            if (data != null) {
                var10000 = data.getStringExtra("Status");
                if (var10000 != null) {
                    var4 = var10000;
                    Toast.makeText(this.getApplicationContext(), "here " + (CharSequence) var4, Toast.LENGTH_LONG).show();
                }
            }
        }
    }


}