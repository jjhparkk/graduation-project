package kr.ac.skuniv.jihyunproject1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home); // activity_main.xml을 기본 레이아웃으로 설정

        // 각 버튼에 대한 클릭 리스너 설정
        ImageButton buttonUpload = findViewById(R.id.button_upload);
        ImageButton buttonHome = findViewById(R.id.button_home);
        ImageButton buttonCalendar = findViewById(R.id.button_calendar);
        ImageButton buttonRoutine = findViewById(R.id.button_routine);

        buttonUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UploadBeforeActivity.class);
                startActivity(intent);
            }
        });

        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        buttonCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalendarActivity.class);
                startActivity(intent);
            }
        });

        buttonRoutine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RoutineSettingActivity.class);
                startActivity(intent);
            }
        });
    }
}
