package uren.com.seslirenelim;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.crashlytics.android.Crashlytics;

import java.util.Locale;

import io.fabric.sdk.android.Fabric;
import uren.com.seslirenelim.Activities.MainContentActivity;
import uren.com.seslirenelim.GeneralUtils.ShapeUtil;

import static uren.com.seslirenelim.Constants.NumericConstant.LANG_ENGLISH;
import static uren.com.seslirenelim.Constants.NumericConstant.LANG_TURKISH;
import static uren.com.seslirenelim.Constants.StringConstant.SELECTED_LANGUAGE;

public class MainActivity extends AppCompatActivity {

    ImageView turkishImgv;
    ImageView englishImgv;
    RelativeLayout mainLayout;
    private int selectedLanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fabric.with(this, new Crashlytics());
        initUIVariables();
        setShapes();
        setImages();
        setListeners();
    }

    private void setImages() {
        Glide.with(MainActivity.this)
                .load(R.drawable.tr)
                .apply(RequestOptions.circleCropTransform())
                .into(turkishImgv);

        Glide.with(MainActivity.this)
                .load(R.drawable.gb)
                .apply(RequestOptions.circleCropTransform())
                .into(englishImgv);
    }

    private void initUIVariables() {
        turkishImgv = findViewById(R.id.turkishImgv);
        englishImgv = findViewById(R.id.englishImgv);
        mainLayout = findViewById(R.id.mainLayout);
    }

    private void setShapes() {
        turkishImgv.setBackground(ShapeUtil.getShape(getResources().getColor(R.color.transparent, null),
                getResources().getColor(R.color.White, null), GradientDrawable.OVAL, 50, 3));
        englishImgv.setBackground(ShapeUtil.getShape(getResources().getColor(R.color.transparent, null),
                getResources().getColor(R.color.White, null), GradientDrawable.OVAL, 50, 3));
        mainLayout.setBackground(ShapeUtil.getGradientBackground(getResources().getColor(R.color.DarkBlue, null),
                getResources().getColor(R.color.DarkCyan, null)));
    }

    private void setListeners() {
        turkishImgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setLocale("tr");
                selectedLanguage = LANG_TURKISH;
                startContentActivity();
            }
        });

        englishImgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setLocale("en");
                selectedLanguage = LANG_ENGLISH;
                startContentActivity();
            }
        });
    }

    private void startContentActivity() {
        Intent intent = new Intent(MainActivity.this, MainContentActivity.class);
        intent.putExtra(SELECTED_LANGUAGE, selectedLanguage);
        startActivity(intent);
    }

    public void setLocale(String lang) {

        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
    }
}