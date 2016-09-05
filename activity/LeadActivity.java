package edu.feicui.app.phone.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import edu.feicui.app.phone.base.adapter.BasePagerAdapter;
import edu.feicui.app.phone.base.db.BaseActivity;

public class LeadActivity extends BaseActivity implements View.OnClickListener {
    TextView textView;
    private boolean isFromSetting;
    ImageView[] icons = new ImageView[3];
    ViewPager viewPager;
    BasePagerAdapter leadPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead);

        Intent intent = getIntent();
        String fromClassName = intent.getStringExtra("className");
        if (fromClassName != null && fromClassName.equals("SettingActivity")) {
            isFromSetting = true;
        }
        SharedPreferences preferences = getSharedPreferences("lead_config", Context.MODE_PRIVATE);
        boolean isFirstRun = preferences.getBoolean("isFirstRun", true);
        if (isFirstRun) {
            startActivityTest(LogoActivity.class);
            //finish();
        } else {
            setContentView(R.layout.activity_lead);
            initLeadIcon();
            initViewPager();
            initPagerData();
        }
    }

    private void savePreferences() {
        SharedPreferences preferences = getSharedPreferences("lead_config", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("isFirstRun", false);
        editor.commit();
    }

    @Override
    public void onClick(View view) {
        savePreferences();
        if (isFromSetting) {
            startActivityTest(LogoActivity.class);
        } else {
            startActivityTest(HomeActivity.class);
        }
        //finish();
    }

    //初始化引导图片
    private void initLeadIcon() {
        icons[0] = (ImageView) findViewById(R.id.icon1);
        icons[1] = (ImageView) findViewById(R.id.icon2);
        icons[2] = (ImageView) findViewById(R.id.icon3);
        icons[0].setImageResource(R.drawable.adware_style_selected);
        textView = (TextView) findViewById(R.id.textView3);
        textView.setVisibility(View.INVISIBLE);
        textView.setOnClickListener(this);
    }

    private void initViewPager() {
        viewPager = (ViewPager) findViewById(R.id.ViewPager);
        leadPagerAdapter = new BasePagerAdapter(this);
        viewPager.setAdapter(leadPagerAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                textView.setVisibility(View.INVISIBLE);
                if (position >= 2) {
                    textView.setVisibility(View.VISIBLE);
                }
                for (int i = 0; i < icons.length; i++) {
                    icons[i].setImageResource(R.drawable.adware_style_default);
                }
                icons[position].setImageResource(R.drawable.adware_style_selected);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initPagerData() {
        ImageView imageView = null;
        imageView = (ImageView) getLayoutInflater().inflate(R.layout.activity_lead_item, null);
        imageView.setImageResource(R.drawable.adware_style_applist);
        leadPagerAdapter.addViewToAdapter(imageView);

        imageView = (ImageView) getLayoutInflater().inflate(R.layout.activity_lead_item, null);
        imageView.setImageResource(R.drawable.adware_style_banner);
        leadPagerAdapter.addViewToAdapter(imageView);

        imageView = (ImageView) getLayoutInflater().inflate(R.layout.activity_lead_item, null);
        imageView.setImageResource(R.drawable.adware_style_creditswall);
        leadPagerAdapter.addViewToAdapter(imageView);

        leadPagerAdapter.notifyDataSetChanged();

    }


}
