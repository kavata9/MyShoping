package com.github.kavata9.myshoping.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.github.kavata9.myshoping.Constants;
import com.github.kavata9.myshoping.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity implements View.OnClickListener {
//
//    private SharedPreferences mSharedPreferences;
//    private SharedPreferences.Editor mEditor;
private DatabaseReference mSearchedProductReference;

    @BindView(R.id.shoppingButton) Button mLetsshopButton;
    @BindView(R.id.ProductEditText) EditText mProductEditText;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        mSearchedProductReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_SEARCHED_PRODUCT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mAppNameTextView = (TextView) findViewById(R.id.appNameTextView);
        Typeface PacificoFont = Typeface.createFromAsset(getAssets(), "Pacifico.ttf");

        mAppNameTextView.setTypeface(PacificoFont);

//        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        mEditor = mSharedPreferences.edit();


        mLetsshopButton.setOnClickListener(this);
//        mLetsshopButton.setOnClickListener(new View.OnClickListener() {
    }


    @Override
    public void onClick(View v) {
        if(v == mLetsshopButton) {
            String product= mProductEditText.getText().toString();

            saveProductToFirebase(product);

//            if(!(location).equals("")) {
//                addToSharedPreferences(location);
//            }

            Intent intent = new Intent(MainActivity.this, ShoppingListActivity.class);
            intent.putExtra("product", product);
            startActivity(intent);
        }
    }

    public void saveProductToFirebase(String product) {
        mSearchedProductReference.push().setValue(product);
    }


//    private void addToSharedPreferences(String product) {
//        mEditor.putString(Constants.PREFERENCES_PRODUCT_KEY, product).apply();
//    }
}






