package zhaoxixiang.bwie.com.lexuezxx;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import zhaoxixiang.bwie.com.lexuezxx.Adapter.NavFragAdapter;

public class NavActivity extends AppCompatActivity {

    private ViewPager navVp;
    private List<Integer> list=new ArrayList<>();
    private NavFragAdapter adapter;
    private boolean bl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);

        initView();

        list.add(R.mipmap.welcom1);
        list.add(R.mipmap.welcom2);
        list.add(R.mipmap.welcom3);

        adapter=new NavFragAdapter(list,this);
        navVp.setAdapter(adapter);

        navVp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state) {
                    case ViewPager.SCROLL_STATE_DRAGGING:
                        bl = false;
                        break;
                    case ViewPager.SCROLL_STATE_SETTLING:
                        bl = true;
                        break;
                    case ViewPager.SCROLL_STATE_IDLE:
                        if (navVp.getCurrentItem() == navVp.getAdapter().getCount() - 1 && !bl) {
                            startActivity(new Intent(NavActivity.this, MainActivity.class));

                        }

                        break;
                }
            }
        });
    }


    private void initView() {
        navVp = (ViewPager) findViewById(R.id.nav_vp);
    }
}
