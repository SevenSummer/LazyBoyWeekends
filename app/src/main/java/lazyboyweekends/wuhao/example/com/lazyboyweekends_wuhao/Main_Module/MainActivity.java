package lazyboyweekends.wuhao.example.com.lazyboyweekends_wuhao.Main_Module;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import lazyboyweekends.wuhao.example.com.lazyboyweekends_wuhao.AboutMe_Module.AboutMeFragment;
import lazyboyweekends.wuhao.example.com.lazyboyweekends_wuhao.Activity_Module.ActivityFragment;
import lazyboyweekends.wuhao.example.com.lazyboyweekends_wuhao.Assistent_Module.AssistantFragment;
import lazyboyweekends.wuhao.example.com.lazyboyweekends_wuhao.R;
import lazyboyweekends.wuhao.example.com.lazyboyweekends_wuhao.Search_Module.SearchFragment;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private RadioGroup mRadioGroup;
    private ActivityFragment activityFragment;
    private SearchFragment searchFragment;
    private AssistantFragment assistantFragment;
    private AboutMeFragment aboutMeFragment;
    private List<Fragment> fragments=new ArrayList<>();
    private MyPagerAdapter adapter;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
        iniDatas();
        initView();

    }

    private void iniDatas() {
        fragments.add(activityFragment);
        fragments.add(searchFragment);
        fragments.add(assistantFragment);
        fragments.add(aboutMeFragment);

    }

    private void initFragment() {
        mFragmentManager = getSupportFragmentManager();
      activityFragment= new ActivityFragment().newInstance();
      searchFragment= new SearchFragment().newInstance();
       assistantFragment=new AssistantFragment().newInstance();
      aboutMeFragment=new AboutMeFragment().newInstance();
    }

    private void initView() {
        mRadioGroup = (RadioGroup) findViewById(R.id.main_activity_RG);
        mViewPager = (ViewPager) findViewById(R.id.main_activity_viewpager);

        adapter = new MyPagerAdapter(mFragmentManager);
        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(3);

        mRadioGroup.check(R.id.main_activity_aboutme_RB);

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId){
                    case R.id.main_activity_activity_RB:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.main_activity_search_RB:
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.main_activity_assistant_RB:
                        mViewPager.setCurrentItem(2);
                        break;
                    case R.id.main_activity_aboutme_RB:
                        mViewPager.setCurrentItem(3);
                        break;
                }
            }
        });



        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                    switch (position){
                        case 0:
                            mRadioGroup.check(R.id.main_activity_activity_RB);
                            break;
                        case 1:
                            mRadioGroup.check(R.id.main_activity_search_RB);
                            break;
                        case 2:
                            mRadioGroup.check(R.id.main_activity_assistant_RB);
                            break;
                        case 3:
                            mRadioGroup.check(R.id.main_activity_aboutme_RB);
                            break;
                    }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }



    class MyPagerAdapter extends FragmentPagerAdapter{

        public MyPagerAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}
