package com.example.homework4;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.homework4.adapters.LeadersAdapter;
import com.example.homework4.adapters.WondersAdapter;

public class WondersActivity extends AppCompatActivity {

    private TextView tvFranceWonder, tvUkWonder, tvItalyWonder;
    private ViewPager2 viewPager;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wonders);

        // Khởi tạo các TextView trong header
        tvFranceWonder = findViewById(R.id.tv_france_wonder);
        tvUkWonder = findViewById(R.id.tv_uk_wonder);
        tvItalyWonder = findViewById(R.id.tv_italy_wonder);
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
                    viewPager.setAdapter(new WondersAdapter(this));
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
                        tvFranceWonder.setTextColor(getResources().getColor(android.R.color.white));
                        break;
                    case 1:
                        tvUkWonder.setTextColor(getResources().getColor(android.R.color.white));
                        break;
                    case 2:
                        tvItalyWonder.setTextColor(getResources().getColor(android.R.color.white));
                        break;
                }
            }
        });
    }

    // Hàm reset màu sắc về mặc định
    private void resetTextColors() {
        tvFranceWonder.setTextColor(getResources().getColor(android.R.color.darker_gray));
        tvUkWonder.setTextColor(getResources().getColor(android.R.color.darker_gray));
        tvItalyWonder.setTextColor(getResources().getColor(android.R.color.darker_gray));
    }
}