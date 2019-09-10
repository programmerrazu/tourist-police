package com.tourist.police.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.animation.Animator;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;

import com.tourist.police.R;
import com.tourist.police.interfaces.FragmentChanger;
import com.tourist.police.view.fragment.HomeFragment;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements FragmentChanger {

    public static final String EXTRA_REVEAL_X = "EXTRA_REVEAL_X";
    public static final String EXTRA_REVEAL_Y = "EXTRA_REVEAL_Y";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        /*if (savedInstanceState == null) {
            revealAnimation();
        }*/
        loadFragment(HomeFragment.getInstance());
    }

    private void revealAnimation() {
        final View mainLayout = findViewById(R.id.main_layout);
        final Intent intent = getIntent();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && intent.hasExtra(EXTRA_REVEAL_X) && intent.hasExtra(EXTRA_REVEAL_Y)) {
            mainLayout.setVisibility(View.INVISIBLE);
            ViewTreeObserver viewTreeObserver = mainLayout.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        revealAnimator(mainLayout);
                        mainLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
            }
        } else {
            mainLayout.setVisibility(View.VISIBLE);
        }
    }

    private void revealAnimator(View rootLayout) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            float finalRadius = (float) (Math.max(rootLayout.getWidth(), rootLayout.getHeight()) * 1.1);
            Animator animator = ViewAnimationUtils.createCircularReveal(rootLayout, rootLayout.getMeasuredWidth() / 2, rootLayout.getMeasuredHeight() / 2, 50, finalRadius);
            animator.setDuration(800);
            animator.setInterpolator(new AccelerateInterpolator());
            rootLayout.setVisibility(View.VISIBLE);
            animator.start();
        } else {
            finish();
        }
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_layout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onChangeFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_layout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}