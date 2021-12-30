package com.kamolovproducts.dagger2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class NewDetails extends AppCompatActivity {
    ImageView image;
    TextView title;
    TextView auth;
    TextView date;
    TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_details);

        image = findViewById(R.id.image_details);
        title = findViewById(R.id.title);
        auth = findViewById(R.id.author);
        date = findViewById(R.id.date);
        description = findViewById(R.id.article);
        //get the intent to get the extra string that contain the url
        Intent intent = getIntent();

        String TITLE = intent.getExtras().getString("name");
        String IMG = intent.getExtras().getString("image");
        String DESCRIPTION = intent.getExtras().getString("description");

        Glide.with(this)
                .load(IMG)
                .into(image);
        title.setText(TITLE);
        description.setText(DESCRIPTION);

    }
}