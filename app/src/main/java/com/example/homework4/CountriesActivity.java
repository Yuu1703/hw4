package com.example.homework4;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.homework4.adapters.CountriesAdapter;

public class CountriesActivity extends AppCompatActivity {

    private TextView tvUk, tvItaly, tvFrance;
    private ViewPager2 viewPager;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);

        // Khởi tạo các TextView trong header
        tvUk = findViewById(R.id.tv_uk);
        tvItaly = findViewById(R.id.tv_italy);
        tvFrance = findViewById(R.id.tv_france);
        viewPager = findViewById(R.id.viewPager);
        progressBar = findViewById(R.id.progressBar);

        progressBar.setVisibility(View.VISIBLE);

        // Giả lập tải dữ liệu (thay bằng logic thực tế nếu cần)
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                runOnUiThread(() -> {
                    // Sau khi tải xong, ẩn ProgressBar và gán Adapter
                    progressBar.setVisibility(View.GONE);
                    viewPager.setAdapter(new CountriesAdapter(this));
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                resetTextColors();
                switch (position) {
                    case 0:
                        tvUk.setTextColor(getResources().getColor(android.R.color.white));
                        break;
                    case 1:
                        tvItaly.setTextColor(getResources().getColor(android.R.color.white));
                        break;
                    case 2:
                        tvFrance.setTextColor(getResources().getColor(android.R.color.white));
                        break;
                }
            }
        });
    }

    // Hàm reset màu sắc về mặc định
    private void resetTextColors() {
        tvUk.setTextColor(getResources().getColor(android.R.color.darker_gray));
        tvItaly.setTextColor(getResources().getColor(android.R.color.darker_gray));
        tvFrance.setTextColor(getResources().getColor(android.R.color.darker_gray));
    }
}