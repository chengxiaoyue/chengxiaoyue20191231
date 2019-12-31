package com.bawei.chengxiaoyue20191231.contract;

/**
 * date:2019/12/31
 * author:程小越
 * function:契约类
 */
public interface IContract {
    interface IModel {
        void getInfo(String url, MyCallBack callBack);
    }

    interface IView {
        void onSuccess(String json);

        void onError(Throwable throwable);
    }

    interface IPresenter {
        void getInfoParams(String url);
    }

    interface MyCallBack {
        void onSuccess(String json);

        void onError(Throwable throwable);
    }
}
