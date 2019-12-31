package com.bawei.chengxiaoyue20191231.base;

import com.bawei.chengxiaoyue20191231.contract.IContract;

import java.lang.ref.WeakReference;

/**
 * date:2019/12/31
 * author:程小越
 * function:
 */
public abstract class BasePresenter<V extends IContract.IView> implements IContract.IPresenter {
    private WeakReference<V> weak;

    public BasePresenter() {
        initModel();
    }

    protected void onAttch(V v) {
        weak = new WeakReference<>(v);
    }

    protected void onDeAttch() {
        if (weak != null) {
            weak.clear();
            weak = null;
        }
    }

    protected V getView() {
        return weak.get();
    }

    protected abstract void initModel();
}
