package com.example.registerapp.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.registerapp.model.PersonalData;

import java.util.List;

@Dao
public interface DataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPersonalData(PersonalData personalData);

    @Query("SELECT * from personal_data ORDER BY name ASC")
    LiveData<List<PersonalData>> getAllPersonalData();

    @Delete
    void deletePersonalData(PersonalData personalData);

    @Update
    void updatePersonalData(PersonalData personalData);

    @Query("DELETE FROM personal_data")
    void deleteAllPersonalData();
}

