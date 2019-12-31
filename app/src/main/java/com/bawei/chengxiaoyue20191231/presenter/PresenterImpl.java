package com.bawei.chengxiaoyue20191231.presenter;

import com.bawei.chengxiaoyue20191231.base.BasePresenter;
import com.bawei.chengxiaoyue20191231.contract.IContract;
import com.bawei.chengxiaoyue20191231.model.ModelImpl;

/**
 * date:2019/12/31
 * author:程小越
 * function:
 */
public class PresenterImpl extends BasePresenter {
    private ModelImpl model;

    @Override
    protected void initModel() {
        model = new ModelImpl();
    }

    @Override
    public void getInfoParams(String url) {
        model.getInfo(url, new IContract.MyCallBack() {
            @Override
            public void onSuccess(String json) {
                getView().onSuccess(json);
            }

            @Override
            public void onError(Throwable throwable) {
                getView().onError(throwable);
            }
        });
    }
}
