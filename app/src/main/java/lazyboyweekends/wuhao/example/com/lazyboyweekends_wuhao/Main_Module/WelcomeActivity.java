package lazyboyweekends.wuhao.example.com.lazyboyweekends_wuhao.Main_Module;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import lazyboyweekends.wuhao.example.com.lazyboyweekends_wuhao.R;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        mhandler.sendEmptyMessageDelayed(1,3000);

    }

    private Handler mhandler =new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Intent i =new Intent(WelcomeActivity.this,MainActivity.class);
            startActivity(i);
            finish();
        }
    };
}
