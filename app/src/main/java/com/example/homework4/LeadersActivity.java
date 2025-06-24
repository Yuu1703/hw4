package com.example.homework4;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.homework4.adapters.CountriesAdapter;
import com.example.homework4.adapters.LeadersAdapter;

public class LeadersActivity extends AppCompatActivity {

    private TextView tvFranceLeader, tvUkLeader, tvItalyLeader;
    private ViewPager2 viewPager;

    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaders);

        // Khởi tạo các TextView trong header
        tvFranceLeader = findViewById(R.id.tv_france_leader);
        tvUkLeader = findViewById(R.id.tv_uk_leader);
        tvItalyLeader = findViewById(R.id.tv_italy_leader);
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
                    viewPager.setAdapter(new LeadersAdapter(this));
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        // Thêm listener để thay đổi màu sắc khi kéo
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                resetTextColors(); // Reset tất cả về màu mặc định
                switch (position) {
                    case 0:
                        tvFranceLeader.setTextColor(getResources().getColor(android.R.color.white));
                        break;
                    case 1:
                        tvUkLeader.setTextColor(getResources().getColor(android.R.color.white));
                        break;
                    case 2:
                        tvItalyLeader.setTextColor(getResources().getColor(android.R.color.white));
                        break;
                }
            }
        });
    }

    // Hàm reset màu sắc về mặc định
    private void resetTextColors() {
        tvFranceLeader.setTextColor(getResources().getColor(android.R.color.darker_gray));
        tvUkLeader.setTextColor(getResources().getColor(android.R.color.darker_gray));
        tvItalyLeader.setTextColor(getResources().getColor(android.R.color.darker_gray));
    }
}