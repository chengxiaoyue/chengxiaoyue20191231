package com.bawei.chengxiaoyue20191231;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.chengxiaoyue20191231.adapter.MyAdapter;
import com.bawei.chengxiaoyue20191231.base.BaseActivity;
import com.bawei.chengxiaoyue20191231.base.BasePresenter;
import com.bawei.chengxiaoyue20191231.bean.UserBean;
import com.bawei.chengxiaoyue20191231.presenter.PresenterImpl;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @BindView(R.id.recy)
    RecyclerView recy;
    @BindView(R.id.textview)
    TextView textview;
    private List<UserBean.RankingBean> list = new ArrayList<>();
    private MyAdapter myAdapter;

    @Override
    protected void startCoding() {
        myAdapter = new MyAdapter(list, this);
        recy.setAdapter(myAdapter);
        presenter.getInfoParams("http://blog.zhaoliang5156.cn/api/news/ranking.json");
    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected void initView() {
        recy.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(String json) {
        Gson gson = new Gson();
        UserBean userBean = gson.fromJson(json, UserBean.class);
        list.addAll(userBean.getRanking());
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @OnClick(R.id.textview)
    public void onViewClicked() {
        startActivity(new Intent(MainActivity.this,Main2Activity.class));
    }
}
