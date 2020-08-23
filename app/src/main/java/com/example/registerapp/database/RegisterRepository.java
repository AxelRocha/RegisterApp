package com.example.registerapp.database;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.registerapp.model.PersonalData;

import java.util.List;

public class RegisterRepository {
    private DataDao mDataDao;
    private LiveData<List<PersonalData>> mAllData;

    public RegisterRepository(Context context) {
        RegisterRoomDatabase db = RegisterRoomDatabase.getDatabase(context);
        mDataDao = db.dataDao();
        mAllData = mDataDao.getAllPersonalData();
    }

    public LiveData<List<PersonalData>> getAllData() {
        return mAllData;
    }

    public void insert(PersonalData personalData) {
        RegisterRoomDatabase.databaseWriteExecutor.execute(() -> {
            mDataDao.insertPersonalData(personalData);
        });
    }

    public void delete(PersonalData personalData) {
        RegisterRoomDatabase.databaseWriteExecutor.execute(() -> {
            mDataDao.deletePersonalData(personalData);
        });
    }

    public void update(PersonalData personalData) {
        RegisterRoomDatabase.databaseWriteExecutor.execute(() -> {
            mDataDao.updatePersonalData(personalData);
        });
    }
}
