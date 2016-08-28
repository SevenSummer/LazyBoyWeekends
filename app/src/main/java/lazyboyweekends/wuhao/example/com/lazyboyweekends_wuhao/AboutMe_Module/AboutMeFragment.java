package lazyboyweekends.wuhao.example.com.lazyboyweekends_wuhao.AboutMe_Module;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lazyboyweekends.wuhao.example.com.lazyboyweekends_wuhao.R;

/**
 * Created by Administrator on 2016/8/25.
 */
public class AboutMeFragment extends Fragment {
    private Context mContext;

     public static AboutMeFragment newInstance(){
        AboutMeFragment aboutMeFragment =new AboutMeFragment();
        return  aboutMeFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext =getContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = LayoutInflater.from(mContext).inflate(R.layout.aboutme_fragment,container,false);
        return view;
    }
}
