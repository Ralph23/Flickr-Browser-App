package com.ralphevmanzano.flickrbrowser;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class PhotoDetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_detail);

        activateToolbar(true);

        Intent intent = getIntent();
        Photo photo = (Photo) intent.getSerializableExtra(PHOTO_TRANSFER);
        if (photo != null) {
            TextView photoTitle = findViewById(R.id.photo_title);
            TextView photoTags = findViewById(R.id.photo_tags);
            TextView photoAuthor = findViewById(R.id.photo_author);

            Resources resources = getResources();

            photoTitle.setText(resources.getString(R.string.photo_title_text, photo.getTitle()));
            photoTags.setText(resources.getString(R.string.photo_tags_text, photo.getTags()));
            photoAuthor.setText(resources.getString(R.string.photo_author_text, photo.getAuthor()));

            ImageView photoImage = findViewById(R.id.photo_image);

            Picasso.with(this)
                    .load(photo.getLink())
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.placeholder)
                    .into(photoImage);

        }
    }

}
