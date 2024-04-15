package com.example.myapplication.new_types;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;

import com.example.myapplication.R;
import com.example.myapplication.functions.AddInfomationAboutName_Activity;
import com.example.myapplication.functions.AddInfomationAboutPosition_Activity;

public class CustomEditText extends AppCompatEditText {

    private static final int REQUEST_CODE = 123;
    private boolean isConditionMet; // пример условия

    public CustomEditText(Context context) {
        super(context);
        init();
    }

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setFocusable(false); // чтобы не получать фокус и не показывать клавиатуру
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                if (getId() == R.id.spinner2) {
                    intent = new Intent(getContext(), AddInfomationAboutName_Activity.class);
                } else {
                    intent = new Intent(getContext(), AddInfomationAboutPosition_Activity.class);
                }
                ((Activity) getContext()).startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null) {
            String result = data.getStringExtra("result");
            setText(result);
        }
    }
}