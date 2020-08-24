package com.example.registerapp.ui.registerlist;

import androidx.lifecycle.Observer;

import com.example.registerapp.database.DataDao;
import com.example.registerapp.database.RegisterRepository;
import com.example.registerapp.model.PersonalData;

import java.util.List;

public class RegisterListPresenter implements RegisterListContract.Presenter {

    private final RegisterListContract.View mView;
    private final RegisterRepository mRegisterRepository;

    public RegisterListPresenter(RegisterListContract.View view, DataDao dataDao) {
        this.mView = view;
        this.mView.setPresenter(this);
        this.mRegisterRepository = new RegisterRepository(dataDao);
    }

    @Override
    public void start() {

    }

    @Override
    public void populateRegisterList() {
        mRegisterRepository.getAllPersonalData().observeForever(new Observer<List<PersonalData>>() {
            @Override
            public void onChanged(List<PersonalData> personalData) {
                mView.setRegisters(personalData);
                if (personalData  == null || personalData.size() < 1){
                    mView.showEmptyMessage();
                } else {
                    mView.showRegisterList();
                }
            }
        });
    }

    @Override
    public void openConfirmDeleteDialog(PersonalData personalData) {
        mView.showDeleteConfirmDialog(personalData);
    }

    @Override
    public void deleteRegister(PersonalData personalData) {
        mRegisterRepository.deletePersonalData(personalData);
    }

    @Override
    public void addRegister() {
        mView.callAddRegisterActivity();
    }

    @Override
    public void editRegister(PersonalData personalData) {
        mView.callEditRegisterActivity(personalData);
    }
}
