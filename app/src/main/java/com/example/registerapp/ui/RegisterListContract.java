package com.example.registerapp.ui;

import com.example.registerapp.BasePresenter;
import com.example.registerapp.BaseView;
import com.example.registerapp.model.PersonalData;

import java.util.List;

public interface RegisterListContract {
    interface Presenter extends BasePresenter{
        void populateRegisterList();
    }

    interface View extends BaseView<RegisterListContract.Presenter> {
        void setRegisters(List<PersonalData> personalData);
    }
}
