package com.example.ssv2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainApp extends AppCompatActivity {
    private TextView tvText;
    private EditText etText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main_app);

        tvText = findViewById(R.id.tvText);
        etText = findViewById(R.id.etText);

        etText.addTextChangedListener(new TextWatcher()
        {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                String abc = etText.getText().toString();
                tvText.setText(abc);
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });
    }

}