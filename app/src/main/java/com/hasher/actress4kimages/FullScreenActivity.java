package com.hasher.actress4kimages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FullScreenActivity extends AppCompatActivity {

    Bundle bundle;
    Integer position;
    ImageView imageView;
    Uri imageUri;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Images");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        bundle = getIntent().getExtras();
        imageView = findViewById(R.id.fullscreenImageView);

        if (bundle != null) {
            position = bundle.getInt("position", 0);
        }

        imageUri = Uri.parse(bundle.getString("imageUri"));
        if (imageUri != null) {
            Glide.with(FullScreenActivity.this).load(imageUri).into(imageView);
        }


    }
}