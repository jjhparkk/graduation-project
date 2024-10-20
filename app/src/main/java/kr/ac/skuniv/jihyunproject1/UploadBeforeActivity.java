package kr.ac.skuniv.jihyunproject1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.widget.Toast;

public class UploadBeforeActivity extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST = 1;
    private static final int REQUEST_PERMISSIONS = 2;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uploadbefore);

        ImageButton buttonUpload = findViewById(R.id.button_upload);
        ImageButton buttonHome = findViewById(R.id.button_home);
        ImageButton buttonCalendar = findViewById(R.id.button_calendar);
        ImageButton buttonRoutine = findViewById(R.id.button_routine);
        Button buttonToUpload = findViewById(R.id.buttontoupload);

        buttonUpload.setOnClickListener(v -> {
            Intent intent = new Intent(UploadBeforeActivity.this, UploadBeforeActivity.class);
            startActivity(intent);
        });

        buttonHome.setOnClickListener(v -> {
            Intent intent = new Intent(UploadBeforeActivity.this, MainActivity.class);
            startActivity(intent);
        });

        buttonCalendar.setOnClickListener(v -> {
            Intent intent = new Intent(UploadBeforeActivity.this, CalendarActivity.class);
            startActivity(intent);
        });

        buttonRoutine.setOnClickListener(v -> {
            Intent intent = new Intent(UploadBeforeActivity.this, RoutineSettingActivity.class);
            startActivity(intent);
        });

        buttonToUpload.setOnClickListener(v -> {
            if (ContextCompat.checkSelfPermission(UploadBeforeActivity.this,
                    Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||
                    ContextCompat.checkSelfPermission(UploadBeforeActivity.this,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(UploadBeforeActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        REQUEST_PERMISSIONS);
            } else {
                openImagePicker();
            }
        });
    }

    private void openImagePicker() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            imageUri = data.getData();

            Intent intent = new Intent(UploadBeforeActivity.this, UploadafterActivity.class);
            intent.putExtra("imageUri", imageUri.toString());
            startActivity(intent);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSIONS) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED &&
                    grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                openImagePicker();
            } else {
                Toast.makeText(this, "권한이 필요합니다.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
