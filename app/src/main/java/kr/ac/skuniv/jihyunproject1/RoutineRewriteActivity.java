package kr.ac.skuniv.jihyunproject1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class RoutineRewriteActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.routinerewrite); // routinerewrite.xml을 기본 레이아웃으로 설정

        // 각 버튼에 대한 클릭 리스너 설정
        ImageButton buttonUpload = findViewById(R.id.button_upload);
        ImageButton buttonHome = findViewById(R.id.button_home);
        ImageButton buttonCalendar = findViewById(R.id.button_calendar);
        ImageButton buttonRoutine = findViewById(R.id.button_routine);

        EditText editTextName = findViewById(R.id.editTextText1);
        EditText editTextStartDate = findViewById(R.id.editTextDate1);
        EditText editTextEndDate = findViewById(R.id.editTextDate2);
        Button saveButton = findViewById(R.id.savebutton);

        buttonUpload.setOnClickListener(v -> {
            Intent intent = new Intent(RoutineRewriteActivity.this, UploadBeforeActivity.class);
            startActivity(intent);
        });

        buttonHome.setOnClickListener(v -> {
            Intent intent = new Intent(RoutineRewriteActivity.this, MainActivity.class);
            startActivity(intent);
        });

        buttonCalendar.setOnClickListener(v -> {
            Intent intent = new Intent(RoutineRewriteActivity.this, CalendarActivity.class);
            startActivity(intent);
        });

        buttonRoutine.setOnClickListener(v -> {
            Intent intent = new Intent(RoutineRewriteActivity.this, RoutineSettingActivity.class);
            startActivity(intent);
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String startDate = editTextStartDate.getText().toString();
                String endDate = editTextEndDate.getText().toString();

                Intent homeIntent = new Intent(RoutineRewriteActivity.this, MainActivity.class);
                homeIntent.putExtra("medName", name);

                Intent calendarIntent = new Intent(RoutineRewriteActivity.this, CalendarActivity.class);
                calendarIntent.putExtra("startDate", startDate);
                calendarIntent.putExtra("endDate", endDate);

                startActivity(homeIntent);
                startActivity(calendarIntent);
            }
        });
    }
}
