package com.example.registerapp.ui.addregister;

import com.example.registerapp.BasePresenter;
import com.example.registerapp.BaseView;
import com.example.registerapp.model.Address;
import com.example.registerapp.model.PersonalData;

public interface AddRegisterContract {

    interface Presenter extends BasePresenter {
        void addRegister(PersonalData personalData);

        void updateRegister(PersonalData personalData);

        boolean validate(PersonalData personalData);

        void completeAddressWithCep(CharSequence charSequence);
    }

    interface View extends BaseView<AddRegisterContract.Presenter>{
        void showErrorMessage(int fieldId);

        void clearErrors();

        void finishActivity();

        void populateAddressEditTexts(Address address);

        void closeKeyboard();
    }
}
