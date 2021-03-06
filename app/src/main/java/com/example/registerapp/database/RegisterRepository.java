package com.example.registerapp.database;

import androidx.lifecycle.LiveData;

import com.example.registerapp.model.PersonalData;

import java.util.List;

public class RegisterRepository {
    private DataDao mDataDao;
    private LiveData<List<PersonalData>> mAllData;

    public RegisterRepository(DataDao dataDao) {
        mDataDao = dataDao;
        mAllData = mDataDao.getAllPersonalData();
    }

    public LiveData<List<PersonalData>> getAllPersonalData() {
        return mAllData;
    }

    public void insertRegister(PersonalData personalData) {
        RegisterRoomDatabase.databaseWriteExecutor.execute(() -> {
            mDataDao.insertPersonalData(personalData);
        });
    }

    public void deletePersonalData(PersonalData personalData) {
        RegisterRoomDatabase.databaseWriteExecutor.execute(() -> {
            mDataDao.deletePersonalData(personalData);
        });
    }

    public void updateRegister(PersonalData personalData) {
        RegisterRoomDatabase.databaseWriteExecutor.execute(() -> {
            mDataDao.updatePersonalData(personalData);
        });
    }
}
