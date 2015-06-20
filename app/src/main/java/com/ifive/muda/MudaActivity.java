package com.ifive.muda;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MudaActivity extends AppCompatActivity {

    ViewPager mViewPager;
    MudaPagerAdapter mMudaPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muda);

        mMudaPagerAdapter = new MudaPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mMudaPagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            private boolean flag = false;

            @Override
            public void onPageScrolled(int i, float v, int i2) {
                switch (i) {
                    case 0:
                        break;
                    default:
                }
            }

            @Override
            public void onPageSelected(int i) {
                switch (i) {
                    case 0:
                        break;
                    default:
                        flag = true;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {
                switch (i) {
                    case ViewPager.SCROLL_STATE_IDLE:
                        if (flag) {
                            mViewPager.setCurrentItem(0, false);
                            mMudaPagerAdapter.update();
                            flag = false;
                        }
                        break;
                    default:
                }
            }
        });
    }

}
