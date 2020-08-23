package com.example.registerapp.ui;

import com.example.registerapp.BasePresenter;
import com.example.registerapp.BaseView;
import com.example.registerapp.model.PersonalData;

import java.util.List;

public interface RegisterListContract {
    interface Presenter extends BasePresenter{
        void populateRegisterList();

        void openConfirmDeleteDialog(PersonalData personalData);

        void deleteRegister(PersonalData personalData);
    }

    interface View extends BaseView<RegisterListContract.Presenter> {
        void setRegisters(List<PersonalData> personalData);

        void showDeleteConfirmDialog(PersonalData personalData);
    }

    interface OnItemClickListener {
        void clickLongItem(PersonalData personalData);
    }

    interface DeleteListener {

        void setConfirm(boolean confirm, PersonalData personalData);

    }
}
