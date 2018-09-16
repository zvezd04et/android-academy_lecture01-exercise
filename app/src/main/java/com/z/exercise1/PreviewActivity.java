package com.z.exercise1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PreviewActivity extends AppCompatActivity {

    private static final String EXTRA_MSG = "EXTRA_MSG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        final String msg = getIntent().getStringExtra(EXTRA_MSG);
        final TextView previewText = findViewById(R.id.preview_text);
        previewText.setText(msg);

        final Button emailButton = findViewById(R.id.email_button);
        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEmailApp(msg);
            }
        });
    }

    public static void start(Activity activity, String previewMsg) {
        final Intent intent = new Intent(activity, PreviewActivity.class);
        intent.putExtra(EXTRA_MSG, previewMsg);
        activity.startActivity(intent);
    }

    private void openEmailApp(String msg) {

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.default_subject));
        intent.putExtra(Intent.EXTRA_TEXT, msg);
        if (intent.resolveActivity(getPackageManager()) == null) {
            Toast.makeText(PreviewActivity.this, R.string.warning_no_email_app, Toast.LENGTH_LONG).show();
            return;
        }

        startActivity(intent);

    }
}


