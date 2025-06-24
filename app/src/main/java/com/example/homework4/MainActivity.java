package com.example.homework4;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private CardView cardCountries, cardLeaders, cardMuseums, cardWonders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        initViews();
        setClickListeners();

    }
    private void initViews() {
        cardCountries = findViewById(R.id.card_countries);
        cardLeaders = findViewById(R.id.card_leaders);
        cardMuseums = findViewById(R.id.card_museums);
        cardWonders = findViewById(R.id.card_wonders);
    }
    private void setClickListeners(){
        cardCountries.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CountriesActivity.class);
            startActivity(intent);
        });
        cardLeaders.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LeadersActivity.class);
            startActivity(intent);
        });
        cardMuseums.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MuseumsActivity.class);
            startActivity(intent);
        });
        cardWonders.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, WondersActivity.class);
            startActivity(intent);
        });
    }
}