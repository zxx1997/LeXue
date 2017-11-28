package zhaoxixiang.bwie.com.lexuezxx;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.style.BackgroundColorSpan;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import zhaoxixiang.bwie.com.lexuezxx.Adapter.MyFragAdapter;
import zhaoxixiang.bwie.com.lexuezxx.Fragment.FragIndex;
import zhaoxixiang.bwie.com.lexuezxx.Fragment.FragMy;
import zhaoxixiang.bwie.com.lexuezxx.Fragment.FragTuijian;

public class MainActivity extends FragmentActivity {

    private ViewPager mainVp;
    private RadioGroup mainRg;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private List<Fragment> list=new ArrayList<>();
    private MyFragAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        list.add(new FragIndex());
        list.add(new FragTuijian());
        list.add(new FragMy());

        adapter=new MyFragAdapter(getSupportFragmentManager(),list);

        mainVp.setAdapter(adapter);

        rb1.setChecked(true);
        mainRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i){
                    case R.id.rb1:
                        mainVp.setCurrentItem(0);

                        break;
                    case R.id.rb2:
                        mainVp.setCurrentItem(1);

                        break;
                    case R.id.rb3:
                        mainVp.setCurrentItem(2);

                        break;
                }
            }
        });

        mainVp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        rb1.setChecked(true);
                        break;
                    case 1:
                        rb2.setChecked(true);
                        break;
                    case 2:
                        rb3.setChecked(true);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initView() {
        mainVp = (ViewPager) findViewById(R.id.main_vp);
        mainRg = (RadioGroup) findViewById(R.id.main_rg);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        rb3 = (RadioButton) findViewById(R.id.rb3);
    }
}
