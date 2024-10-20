package kr.ac.skuniv.jihyunproject1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CalendarActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar); // calendar.xml을 기본 레이아웃으로 설정

        // 각 버튼에 대한 클릭 리스너 설정
        ImageButton buttonUpload = findViewById(R.id.button_upload);
        ImageButton buttonHome = findViewById(R.id.button_home);
        ImageButton buttonCalendar = findViewById(R.id.button_calendar);
        ImageButton buttonRoutine = findViewById(R.id.button_routine);

        buttonUpload.setOnClickListener(v -> {
            Intent intent = new Intent(CalendarActivity.this, UploadBeforeActivity.class);
            startActivity(intent);
        });

        buttonHome.setOnClickListener(v -> {
            Intent intent = new Intent(CalendarActivity.this, MainActivity.class);
            startActivity(intent);
        });

        buttonCalendar.setOnClickListener(v -> {
            Intent intent = new Intent(CalendarActivity.this, CalendarActivity.class);
            startActivity(intent);
        });

        buttonRoutine.setOnClickListener(v -> {
            Intent intent = new Intent(CalendarActivity.this, RoutineSettingActivity.class);
            startActivity(intent);
        });

        // 전달된 기간을 받아서 캘린더에 추가
        Intent intent = getIntent();
        String startDate = intent.getStringExtra("startDate");
        String endDate = intent.getStringExtra("endDate");

        CalendarView calendarView = findViewById(R.id.calendarView3);
        if (startDate != null && endDate != null) {
            calendarView.setDate(parseDate(startDate).getTime(), false, true);
            calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
                Date selectedDate = new Date(year - 1900, month, dayOfMonth);
                if (!selectedDate.before(parseDate(startDate)) && !selectedDate.after(parseDate(endDate))) {
                    // 여기에 원하는 기능을 추가하세요. 예: 선택한 날짜에 맞는 약품 목록 표시
                    Toast.makeText(CalendarActivity.this, "Selected Date: " + selectedDate.toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }
}
