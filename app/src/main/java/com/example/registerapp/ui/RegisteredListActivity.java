package com.example.registerapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.registerapp.R;
import com.example.registerapp.database.RegisterRoomDatabase;
import com.example.registerapp.model.PersonalData;

import java.util.List;

public class RegisteredListActivity extends AppCompatActivity implements RegisterListContract.View{

    private RegisterListContract.Presenter mPresenter;
    private RegisterListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdapter = new RegisterListAdapter();

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter);

        RegisterRoomDatabase db = RegisterRoomDatabase.getDatabase(getApplication());
        mPresenter = new RegisterListPresenter(this, db.dataDao());
    }

    @Override
    public void setPresenter(RegisterListContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.populateRegisterList();
    }

    @Override
    public void setRegisters(List<PersonalData> personalData) {
        mAdapter.setDatas(personalData);
    }
}