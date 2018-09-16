package com.z.exercise1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button previewButton = findViewById(R.id.preview_button);
        final EditText msgEdit = findViewById(R.id.msg_edit);

        previewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String msg = msgEdit.getText().toString();
                if (msg.isEmpty()){
                    Toast.makeText(MainActivity.this, R.string.warning_empty_message, Toast.LENGTH_LONG).show();
                    return;
                }
                PreviewActivity.start(MainActivity.this, msg);
            }
        });
    }
}
