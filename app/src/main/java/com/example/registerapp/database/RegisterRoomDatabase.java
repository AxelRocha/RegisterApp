package com.example.registerapp.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.registerapp.model.PersonalData;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {PersonalData.class}, version = 1, exportSchema = false)
public abstract class RegisterRoomDatabase extends RoomDatabase {

    public abstract DataDao dataDao();

    private static volatile RegisterRoomDatabase INSTANCE;

    private static final int NUMBER_OF_THREADS = 4;

    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static RegisterRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RegisterRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            RegisterRoomDatabase.class, "word_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

            databaseWriteExecutor.execute(() -> {
                DataDao dao = INSTANCE.dataDao();
                dao.deleteAllPersonalData();

                PersonalData personalData = new PersonalData("Axel", 22,"12345","99999999", "", "","", "");
                dao.insertPersonalData(personalData);
                personalData = new PersonalData("Rocha", 22,"1234","99999999", "", "","", "");
                dao.insertPersonalData(personalData);
            });
        }
    };
}
