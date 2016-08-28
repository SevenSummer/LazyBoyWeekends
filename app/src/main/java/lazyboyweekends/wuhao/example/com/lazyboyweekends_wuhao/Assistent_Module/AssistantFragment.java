package lazyboyweekends.wuhao.example.com.lazyboyweekends_wuhao.Assistent_Module;

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
public class AssistantFragment extends Fragment {
    private Context mContext;

   public static AssistantFragment newInstance(){
        AssistantFragment assistantFragment =new AssistantFragment();
        return assistantFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = LayoutInflater.from(mContext).inflate(R.layout.assistant_fragment,container,false);
        return view;
    }
}
