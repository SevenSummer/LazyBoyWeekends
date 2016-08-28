package lazyboyweekends.wuhao.example.com.lazyboyweekends_wuhao.Search_Module;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import lazyboyweekends.wuhao.example.com.lazyboyweekends_wuhao.R;

/**
 * Created by Administrator on 2016/8/25.
 */
public class SearchFragment extends Fragment {
    private Context mContext;
    private GridView mGridView;
    private ImageView gridview_item_iv;
    private TextView gridview_item_tv;
    private List<String> content_list = new ArrayList<>();
    private List<Integer> pic_list = new ArrayList<>();
    private MyGridViewAdapter adapter;

   public static SearchFragment newInstance(){
        SearchFragment searchFragment =new SearchFragment();
        return  searchFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.search_fragment,container,false);
        mGridView = (GridView) view.findViewById(R.id.search_fragment_gridview);
        initDatas();
        adapter =new MyGridViewAdapter();
        mGridView.setAdapter(adapter);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                }
            }
        });
        return view;
    }

    private void initDatas() {
        content_list.clear();
        pic_list.clear();
        content_list.add("全部类目");
        content_list.add("沙龙学堂");
        content_list.add("DIY手作");
        content_list.add("派对聚会");
        content_list.add("暂不开放");
        content_list.add("运动健身");
        content_list.add("户外活动");
        content_list.add("茶会雅集");
        content_list.add("文艺生活");

        pic_list.add(R.drawable.ic_c_bag);
        pic_list.add(R.drawable.ic_c_stage);
        pic_list.add(R.drawable.ic_c_movie);
        pic_list.add(R.drawable.ic_c_persons);
        pic_list.add(R.drawable.ic_c_music);
        pic_list.add(R.drawable.ic_c_backetball);
        pic_list.add(R.drawable.ic_c_montain);
        pic_list.add(R.drawable.ic_c_bar);
        pic_list.add(R.drawable.ic_c_leaf);
    }


    public class MyGridViewAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return content_list.size();
        }

        @Override
        public Object getItem(int i) {
            return content_list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int position, View convertview, ViewGroup parent) {
            View view2 = LayoutInflater.from(mContext).inflate(R.layout.search_fragment_gridview_item,parent,false);
            gridview_item_iv = (ImageView) view2.findViewById(R.id.search_fragment_gridview_item_iv);
            gridview_item_tv = (TextView) view2.findViewById(R.id.search_fragment_gridview_item_tv);
            gridview_item_iv.setImageResource(pic_list.get(position));
            gridview_item_tv.setText(content_list.get(position));
            return view2;
        }
    }
}
