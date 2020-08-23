package com.example.registerapp.ui;

import androidx.lifecycle.Observer;

import com.example.registerapp.database.DataDao;
import com.example.registerapp.model.PersonalData;

import java.util.List;

public class RegisterListPresenter implements RegisterListContract.Presenter {

    private final RegisterListContract.View mView;
    private final DataDao mDataDao;

    public RegisterListPresenter(RegisterListContract.View view, DataDao dataDao) {
        this.mView = view;
        this.mView.setPresenter(this);
        this.mDataDao = dataDao;
    }

    @Override
    public void start() {

    }

    @Override
    public void populateRegisterList() {
        mDataDao.getAllPersonalData().observeForever(new Observer<List<PersonalData>>() {
            @Override
            public void onChanged(List<PersonalData> personalData) {
                mView.setRegisters(personalData);
            }
        });
    }
}
