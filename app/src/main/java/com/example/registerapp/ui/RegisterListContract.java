package com.example.registerapp.ui;

import com.example.registerapp.BasePresenter;
import com.example.registerapp.BaseView;

public interface RegisterListContract {
    interface Presenter extends BasePresenter{

    }

    interface View extends BaseView<RegisterListContract.Presenter> {

    }
}
