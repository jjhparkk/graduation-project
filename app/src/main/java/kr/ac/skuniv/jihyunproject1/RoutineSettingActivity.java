package kr.ac.skuniv.jihyunproject1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

    public class RoutineSettingActivity extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.routinesetting); // routinerewrite.xml을 기본 레이아웃으로 설정

            // 각 버튼에 대한 클릭 리스너 설정
            ImageButton buttonUpload = findViewById(R.id.button_upload);
            ImageButton buttonHome = findViewById(R.id.button_home);
            ImageButton buttonCalendar = findViewById(R.id.button_calendar);
            ImageButton buttonRoutine = findViewById(R.id.button_routine);
            ImageButton buttonEdit = findViewById(R.id.button_edit);

            Button saveButton = findViewById(R.id.savebutton);
            buttonEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(RoutineSettingActivity.this, RoutineRewriteActivity.class);
                    startActivity(intent);
                }
            });

            buttonUpload.setOnClickListener(v -> {
                Intent intent = new Intent(kr.ac.skuniv.jihyunproject1.RoutineSettingActivity.this, UploadBeforeActivity.class);
                startActivity(intent);
            });

            buttonHome.setOnClickListener(v -> {
                Intent intent = new Intent(kr.ac.skuniv.jihyunproject1.RoutineSettingActivity.this, MainActivity.class);
                startActivity(intent);
            });

            buttonCalendar.setOnClickListener(v -> {
                Intent intent = new Intent(kr.ac.skuniv.jihyunproject1.RoutineSettingActivity.this, CalendarActivity.class);
                startActivity(intent);
            });

            buttonRoutine.setOnClickListener(v -> {
                Intent intent = new Intent(kr.ac.skuniv.jihyunproject1.RoutineSettingActivity.this, RoutineSettingActivity.class);
                startActivity(intent);
            });

        }
    }
