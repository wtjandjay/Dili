package com.diligroup;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.diligroup.utils.ToastUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.BitmapCallback;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;

public class MainActivity extends AppCompatActivity {
    //    @Bind(R.id.bt_curry)
//    Button bt_ok;
    @Bind(R.id.id_imageview)
    ImageView iv_show;
    @Bind(R.id.id_textview)
    TextView tv_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    public void getImage(View view) {
        String img_url="http://images.csdn.net/20160621/VR.jpg";
        OkHttpUtils.get().url(img_url)
                .tag(this)
                .build()
                .execute(new BitmapCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(Bitmap response, int id) {
                        iv_show.setImageBitmap(response);
                    }
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        OkHttpUtils.getInstance().cancelTag(this);
    }
    public void getHtml(View view) {
        String url = "http://www.csdn.net/";
        OkHttpUtils.get()
                .url(url)
                .addParams("username", "wtjandjay")
                .addParams("password", "wtjandjay")
                .tag(this)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        ToastUtil.showLong(MainActivity.this, response);
                    }
                });
    }

}
