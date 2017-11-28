package zhaoxixiang.bwie.com.lexuezxx.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by admin on 2017/11/28/028.
 */

public class MyFragAdapter extends FragmentPagerAdapter{

    private List<Fragment> list;
    public MyFragAdapter(FragmentManager fm,List<Fragment> list) {
        super(fm);
        this.list=list;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
       /* switch (position){
            case 0:
                fragment=list.get(position);
                break;

        }*/
       fragment=list.get(position);
        return fragment;
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
