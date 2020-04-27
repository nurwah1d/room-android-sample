package com.nurwahid.roomwordsample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewWordActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.nurwahid.roomwordsample.REPLY";

    private EditText edtWord;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);

        edtWord = findViewById(R.id.edit_word);
        btnSave = findViewById(R.id.button_save);

        btnSave.setOnClickListener(v -> {
            Intent replyIntent = new Intent();

            if (TextUtils.isEmpty(edtWord.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                String word = edtWord.getText().toString();
                replyIntent.putExtra(EXTRA_REPLY, word);
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }
}
