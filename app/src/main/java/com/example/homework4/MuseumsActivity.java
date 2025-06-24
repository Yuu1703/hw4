package com.example.homework4;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.homework4.adapters.LeadersAdapter;
import com.example.homework4.adapters.MuseumsAdapter;

public class MuseumsActivity extends AppCompatActivity {

    private TextView tvFranceMuseum, tvUkMuseum, tvItalyMuseum;
    private ViewPager2 viewPager;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museums);

        // Khởi tạo các TextView trong header
        tvFranceMuseum = findViewById(R.id.tv_france_museum);
        tvUkMuseum = findViewById(R.id.tv_uk_museum);
        tvItalyMuseum = findViewById(R.id.tv_italy_museum);
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
                    viewPager.setAdapter(new MuseumsAdapter(this));
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        // Đặt adapter cho ViewPager2


        // Thêm listener để thay đổi màu sắc khi kéo
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                resetTextColors(); // Reset tất cả về màu mặc định
                switch (position) {
                    case 0:
                        tvFranceMuseum.setTextColor(getResources().getColor(android.R.color.white));
                        break;
                    case 1:
                        tvUkMuseum.setTextColor(getResources().getColor(android.R.color.white));
                        break;
                    case 2:
                        tvItalyMuseum.setTextColor(getResources().getColor(android.R.color.white));
                        break;
                }
            }
        });
    }

    // Hàm reset màu sắc về mặc định
    private void resetTextColors() {
        tvFranceMuseum.setTextColor(getResources().getColor(android.R.color.darker_gray));
        tvUkMuseum.setTextColor(getResources().getColor(android.R.color.darker_gray));
        tvItalyMuseum.setTextColor(getResources().getColor(android.R.color.darker_gray));
    }
}