package com.bawei.chengxiaoyue20191231;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bawei.chengxiaoyue20191231.base.BaseActivity;
import com.bawei.chengxiaoyue20191231.base.BasePresenter;
import com.bawei.chengxiaoyue20191231.presenter.PresenterImpl;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main2Activity extends BaseActivity {
    @BindView(R.id.shengcheng)
    Button shengcheng;
    @BindView(R.id.weixin)
    Button weixin;
    @BindView(R.id.qq)
    Button qq;
    @BindView(R.id.edittext)
    EditText edittext;
    @BindView(R.id.imageview)
    ImageView imageview;

    @Override
    protected void startCoding() {
        CodeUtils.init(this);
    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected void initView() {
        imageview.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                CodeUtils.analyzeByImageView(imageview, new CodeUtils.AnalyzeCallback() {
                    @Override
                    public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                        Toast.makeText(Main2Activity.this, result, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnalyzeFailed() {
                        Toast.makeText(Main2Activity.this, "失败", Toast.LENGTH_SHORT).show();
                    }
                });
                return true;
            }
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main2;
    }

    @Override
    public void onSuccess(String json) {

    }

    @Override
    public void onError(Throwable throwable) {

    }

    @OnClick({R.id.shengcheng, R.id.weixin, R.id.qq})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.shengcheng:
                String s = edittext.getText().toString();
                Bitmap image = CodeUtils.createImage(s, 400, 400, BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
                imageview.setImageBitmap(image);
                break;
            case R.id.weixin:
                EventBus.getDefault().post("微信");
                break;
            case R.id.qq:
                EventBus.getDefault().post("QQ");
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void getWX(String str) {
        Toast.makeText(Main2Activity.this, str, Toast.LENGTH_SHORT).show();
    }

    @Subscribe
    public void getQQ(String strig) {
        Toast.makeText(Main2Activity.this, strig, Toast.LENGTH_SHORT).show();
    }
}
