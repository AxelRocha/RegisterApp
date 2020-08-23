package com.example.registerapp.ui.addregister;

import com.example.registerapp.BasePresenter;
import com.example.registerapp.BaseView;
import com.example.registerapp.model.PersonalData;

public interface AddRegisterContract {

    interface Presenter extends BasePresenter {
        void addRegister(PersonalData personalData);

        boolean validate(PersonalData personalData);
    }

    interface View extends BaseView<AddRegisterContract.Presenter>{
        void showErrorMessage(int fieldId);

        void clearErrors();

        void finishActivity();
    }
}
