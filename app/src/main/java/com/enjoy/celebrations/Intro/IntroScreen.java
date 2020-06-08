package com.enjoy.celebrations.Intro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.enjoy.celebrations.LoginScreen;
import com.enjoy.celebrations.R;
import com.google.android.material.tabs.TabLayout;

public class IntroScreen extends AppCompatActivity {

    ViewPager introViewPager;
    IntroViewPagerAdapter introViewPagerAdapter;
    TabLayout introTabLayout;
    TextView introSkip;
    Button introGetStarted,introNextButton;
    Animation btnAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if (restorePrefData()) {
            Intent mainActivity = new Intent(getApplicationContext(), LoginScreen.class );
            startActivity(mainActivity, ActivityOptionsCompat.makeSceneTransitionAnimation(IntroScreen.this).toBundle());
            finish();
        }
        setContentView(R.layout.activity_intro_screen);
        introViewPager=findViewById(R.id.introViewPager);
        introViewPagerAdapter =new IntroViewPagerAdapter(this);

        introViewPager.setAdapter(introViewPagerAdapter);

        introTabLayout=findViewById(R.id.introTabLayout);
        introTabLayout.setupWithViewPager(introViewPager);
        ParallaxPageTransformer pageTransformer = new ParallaxPageTransformer()
                .addViewToParallax(new ParallaxPageTransformer.ParallaxTransformInformation(R.id.introImageView, -0.65f, -10f))
                .addViewToParallax(new ParallaxPageTransformer.ParallaxTransformInformation(R.id.introHeading, -2f, -2f))
                .addViewToParallax(new ParallaxPageTransformer.ParallaxTransformInformation(R.id.introBody, -2f, -2f));

        introViewPager.setPageTransformer(true, pageTransformer);
        introGetStarted=findViewById(R.id.introGetStarted);
        introSkip=findViewById(R.id.introTextView);
        introNextButton=findViewById(R.id.introNextButton);
        btnAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_animation);


        introNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = introViewPager.getCurrentItem();
                if (position < 3) {
                    position++;
                    introViewPager.setCurrentItem(position);
                }else if(position == 2) loaddLastScreen();
            }
        });


        introGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivity = new Intent(getApplicationContext(), LoginScreen.class);
                startActivity(mainActivity, ActivityOptionsCompat.makeSceneTransitionAnimation(IntroScreen.this).toBundle());
                savePrefsData();
                finish();
            }
        });

        introSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                introViewPager.setCurrentItem(3);
            }
        });
      introTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition()==2) loaddLastScreen();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    private void loaddLastScreen() {

        introNextButton.setVisibility(View.INVISIBLE);
        introGetStarted.setVisibility(View.VISIBLE);
        introSkip.setVisibility(View.INVISIBLE);
        introTabLayout.setVisibility(View.INVISIBLE);
        introGetStarted.setAnimation(btnAnim);
    }

    private void savePrefsData() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isIntroOpnend",true);
        editor.commit();
    }

    private boolean restorePrefData() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        Boolean isIntroActivityOpnendBefore = pref.getBoolean("isIntroOpnend",false);
        return  isIntroActivityOpnendBefore;
    }
}
