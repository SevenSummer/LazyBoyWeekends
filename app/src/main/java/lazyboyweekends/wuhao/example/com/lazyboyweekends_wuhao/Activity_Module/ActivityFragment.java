package lazyboyweekends.wuhao.example.com.lazyboyweekends_wuhao.Activity_Module;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.androidxx.yangjw.httplibrary.HttpUtils;
import com.androidxx.yangjw.httplibrary.ICallback;
import com.androidxx.yangjw.imageloader.ImageLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import lazyboyweekends.wuhao.example.com.lazyboyweekends_wuhao.JavaBean_Module.Activity_Info;
import lazyboyweekends.wuhao.example.com.lazyboyweekends_wuhao.R;

/**
 * Created by Administrator on 2016/8/25.
 */
public class ActivityFragment extends Fragment{
    public static final String ACTIVITY_URL="http://api.lanrenzhoumo.com/main/recommend/index?v=3&session_id=000040a3fb7d64ce1737c6c7bb3c7e4e157c91&lon=114.30963859310197&page=1&lat=30.575388756810078";
    private Context mContext;
    private ListView mListView;
    private MyAdapter adapter;
    private List<String> url_list = new ArrayList<>();
    private List<Activity_Info.ResultBean> info_list =new ArrayList<>();
    private Handler mhandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String jsonstring = (String) msg.obj;

            try {
                JSONObject obj = new JSONObject(jsonstring);
                JSONArray jsonArray= obj.getJSONArray("result");
                int len =jsonArray.length();
                for (int i = 0; i <len ; i++) {
                    JSONObject jsonobject = jsonArray.getJSONObject(i);
                    String address = jsonobject.getString("address");
                    String poi =jsonobject.getString("poi");
                    String  category = jsonobject.getString("category");
                    int collected_num = jsonobject.getInt("collected_num");
                    String title =jsonobject.getString("title");
                    int leo_id = jsonobject.getInt("leo_id");
                    double price = jsonobject.getDouble("price");
                    String time_info = jsonobject.getString("time_info");
                    String time_desc = jsonobject.getString("time_desc");
                    int distance = jsonobject.isNull("distance")?0:jsonobject.getInt("distance");
                    List<String> front_cover_image_list = new ArrayList<>();
                    JSONArray jsonArray2 = jsonobject.getJSONArray("front_cover_image_list");
                    int len2 = jsonArray2.length();
                    for (int j = 0; j <len2 ; j++) {
                        front_cover_image_list.add((String) jsonArray2.get(j));
                    }
                    url_list = front_cover_image_list;
                    Activity_Info.ResultBean info  = new Activity_Info.ResultBean(address,category,collected_num,distance,front_cover_image_list,leo_id,poi,price,time_desc,time_info,title);
                    info_list.add(info);

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            adapter.notifyDataSetChanged();
        }
    };
    private View empty_tv;

    public static ActivityFragment newInstance(){
        ActivityFragment activityFragment =new ActivityFragment();
        return  activityFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_fragment,container,false);
        mListView = (ListView)view.findViewById(R.id.activity_fragment_listview);
        empty_tv = view.findViewById(R.id.activity_fragment_listview_empty_tv);
        mListView.setEmptyView(empty_tv);
        loadDatas();
        adapter = new MyAdapter();
        mListView.setAdapter(adapter);
        return view;
    }

    private void loadDatas() {
        HttpUtils.loadGet(ACTIVITY_URL).Callback(new ICallback() {
            @Override
            public void success(String result, int requestCode) {
                Message msg =new Message();
                msg.obj = result;
                mhandler.sendMessage(msg);
            }
        },1);
    }

    public class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return info_list==null?0:info_list.size();
        }

        @Override
        public Object getItem(int i) {
            return info_list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int position, View convertview, ViewGroup parent) {
            View view = convertview;
            ViewHolder viewHolder =null;
            if(convertview ==null){
                view = LayoutInflater.from(mContext).inflate(R.layout.avtivity_fragment_listview_item,parent,false);
                viewHolder = new ViewHolder(view);
            }else{
                viewHolder= (ViewHolder) view.getTag();
            }
            Activity_Info.ResultBean info_bean = info_list.get(position);
            viewHolder.list_item_iv.setImageResource(R.mipmap.ic_launcher);
            viewHolder.list_item_title_tv.setText(info_bean.getTitle());
            viewHolder.list_item_poi_tv.setText(info_bean.getPoi());
            viewHolder.list_item_distance_tv.setText(info_bean.getDistance()+"m");
            viewHolder.list_item_type_tv.setText(info_bean.getCategory());
            viewHolder.list_item_deadline_btn.setText(info_bean.getTime_info());
            viewHolder.list_item_collection_btn.setText(info_bean.getCollected_num()+"人收藏");
            viewHolder.list_item_price_btn.setText("¥"+(int)info_bean.getPrice());
            ImageLoader.init(mContext).load(info_bean.getFront_cover_image_list().get(0),viewHolder.list_item_iv);
            return view;
        }

    }
    class ViewHolder implements View.OnClickListener
    {
        public ImageView list_item_iv;
        public TextView list_item_title_tv;
        public TextView list_item_poi_tv;
        public TextView list_item_distance_tv;
        public TextView list_item_type_tv;
        public TextView list_item_deadline_btn;
        public TextView list_item_collection_btn;
        public TextView list_item_price_btn;

        public ViewHolder(View view){
            view.setTag(this);
            list_item_iv= (ImageView) view.findViewById(R.id.activity_fragment_listview_item_iv);
            list_item_title_tv= (TextView) view.findViewById(R.id.activity_fragment_listview_item_title_tv);
            list_item_poi_tv= (TextView) view.findViewById(R.id.activity_fragment_listview_item_poi_tv);
            list_item_distance_tv= (TextView) view.findViewById(R.id.activity_fragment_listview_item_distance_tv);
            list_item_type_tv= (TextView) view.findViewById(R.id.activity_fragment_listview_item_type_tv);
            list_item_deadline_btn= (TextView) view.findViewById(R.id.activity_fragment_listview_item_deadline_tv);
            list_item_collection_btn= (TextView) view.findViewById(R.id.activity_fragment_listview_item_collection_tv);
            list_item_price_btn= (TextView) view.findViewById(R.id.activity_fragment_listview_item_price_tv);
            view.setOnClickListener(this);
            list_item_collection_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }

        @Override
        public void onClick(View view) {

        }
    }
}


