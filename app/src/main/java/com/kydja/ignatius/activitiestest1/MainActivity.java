package com.kydja.ignatius.activitiestest1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
    private EditText enterColor;
    private Button nextActivity;
    private InterstitialAd interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        interstitialAd.loadAd(new AdRequest.Builder().build());

        enterColor = findViewById(R.id.enterColor);
        nextActivity = findViewById(R.id.nextActivity);
        nextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String color = enterColor.getText().toString();
            if (color.isEmpty()) {
                color = "blue";
            }
            Intent intent = new Intent(MainActivity.this, NextActivity.class);
            intent.putExtra("color", color);
            startActivity(intent);
                if (interstitialAd.isLoaded()) {
                    interstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        TextView headerView = findViewById(R.id.header);
        switch(id){
            case R.id.action_settings :
                headerView.setText("Настройки");
                return true;
            case R.id.open_settings:
                headerView.setText("Открыть");
                return true;
            case R.id.save_settings:
                headerView.setText("Сохранить");
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
