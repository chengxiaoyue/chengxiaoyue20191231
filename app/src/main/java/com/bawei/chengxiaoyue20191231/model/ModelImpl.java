package com.bawei.chengxiaoyue20191231.model;

import com.bawei.chengxiaoyue20191231.contract.IContract;
import com.bawei.chengxiaoyue20191231.util.NetUtil;

/**
 * date:2019/12/31
 * author:程小越
 * function:
 */
public class ModelImpl implements IContract.IModel {
    @Override
    public void getInfo(String url, IContract.MyCallBack callBack) {
        NetUtil.getInstance().getInfo(url, new NetUtil.ModelCallBack() {
            @Override
            public void onSuccess(String json) {
                callBack.onSuccess(json);
            }

            @Override
            public void onError(Throwable throwable) {
                callBack.onError(throwable);
            }
        });
    }
}
