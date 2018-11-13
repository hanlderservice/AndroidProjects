package com.yang.meiyue.androidprojects;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Description:
 * Created by 10296 on 2018/11/12.
 */

public class LauncherActivity extends AppCompatActivity implements Animation.AnimationListener {
    private static final int ANIM_TIME = 1000;
    private ImageView mIvLauncherBg;
    private ImageView mIvLauncherIcon;
    private TextView mIvLauncherName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        initView();
        initStartAnim();

    }

    /**
     * 启动动画
     */
    private void initStartAnim() {
        // 渐变展示启动屏
        AlphaAnimation aa = new AlphaAnimation(0.4f, 1.0f);
        aa.setDuration(ANIM_TIME * 2);
        aa.setAnimationListener(this);
        mIvLauncherBg.startAnimation(aa);

        ScaleAnimation sa = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        sa.setDuration(ANIM_TIME);
        mIvLauncherIcon.startAnimation(sa);

        RotateAnimation ra = new RotateAnimation(180, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        ra.setDuration(ANIM_TIME);
        mIvLauncherName.startAnimation(ra);
    }

    /**
     * 禁用返回键
     */
    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    private void initView() {
        mIvLauncherBg = (ImageView) findViewById(R.id.iv_launcher_bg);
        mIvLauncherIcon = (ImageView) findViewById(R.id.iv_launcher_icon);
        mIvLauncherName = (TextView) findViewById(R.id.iv_launcher_name);
    }
}
