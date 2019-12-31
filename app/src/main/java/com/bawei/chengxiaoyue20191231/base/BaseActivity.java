package com.bawei.chengxiaoyue20191231.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bawei.chengxiaoyue20191231.contract.IContract;

import butterknife.ButterKnife;

/**
 * date:2019/12/31
 * author:程小越
 * function:
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IContract.IView {
    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (layoutId() != 0) {
            setContentView(layoutId());
            //绑定
            ButterKnife.bind(this);
            initView();
            presenter = initPresenter();
            if (presenter != null) {
                presenter.onAttch(this);
                startCoding();
            }
        }
    }

    protected abstract void startCoding();

    protected abstract P initPresenter();

    protected abstract void initView();

    protected abstract int layoutId();

    //防止内存泄漏
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.onDeAttch();
            presenter = null;
        }
    }
}
