package kr.ac.skuniv.jihyunproject1;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class UploadafterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uploadafter);

        ImageView uploadedImage = findViewById(R.id.uploaded_image);
        Uri imageUri = Uri.parse(getIntent().getStringExtra("imageUri"));

        uploadedImage.setImageURI(imageUri);
    }
}
