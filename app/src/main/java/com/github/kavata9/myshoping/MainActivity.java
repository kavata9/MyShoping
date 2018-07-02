package com.github.kavata9.myshoping;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    public static final String TAG = MainActivity.class.getSimpleName();
    private Button mLetsshopButton;
    private EditText mProductEditText;
    private TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mAppNameTextView = (TextView) findViewById(R.id.appNameTextView);
        Typeface PacificoFont = Typeface.createFromAsset(getAssets(), "Pacifico.ttf");
        mAppNameTextView.setTypeface(PacificoFont);
        mProductEditText = (EditText) findViewById(R.id.ProductEditText);
        mLetsshopButton = (Button) findViewById(R.id.shoppingButton);
        mLetsshopButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String product = mProductEditText.getText().toString();
                Intent intent = new Intent(MainActivity.this, ShoppingActivity.class);
                intent.putExtra("product", product);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Shopping Time!", Toast.LENGTH_LONG).show();
            }
        });
    }



}
