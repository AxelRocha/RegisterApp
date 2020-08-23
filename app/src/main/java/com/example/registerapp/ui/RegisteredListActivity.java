package com.example.registerapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.registerapp.R;

public class RegisteredListActivity extends AppCompatActivity implements RegisterListContract.View{

    private RegisterListContract.Presenter mPresenter;
    private RegisterListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter);

        mPresenter = new RegisterListPresenter(this);
    }

    @Override
    public void setPresenter(RegisterListContract.Presenter presenter) {
        mPresenter = presenter;
    }
}