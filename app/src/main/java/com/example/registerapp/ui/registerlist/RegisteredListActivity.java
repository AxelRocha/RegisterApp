package com.example.registerapp.ui.registerlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.registerapp.R;
import com.example.registerapp.database.RegisterRoomDatabase;
import com.example.registerapp.model.PersonalData;
import com.example.registerapp.ui.addregister.AddRegisterActivity;
import com.example.registerapp.utils.Constants;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class RegisteredListActivity extends AppCompatActivity implements RegisterListContract.View, RegisterListContract.OnItemClickListener, RegisterListContract.DeleteListener {

    private RegisterListContract.Presenter mPresenter;
    private RegisterListAdapter mAdapter;

    TextView noRegisterTextView;

    RecyclerView recyclerView;

    FloatingActionButton mFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdapter = new RegisterListAdapter(this);

        noRegisterTextView = findViewById(R.id.noRegisterTextView);

        recyclerView = findViewById(R.id.registerRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter);

        RegisterRoomDatabase db = RegisterRoomDatabase.getDatabase(getApplication());
        mPresenter = new RegisterListPresenter(this, db.dataDao());

        mFab = findViewById(R.id.fab);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.addRegister();
            }
        });
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

    @Override
    public void showDeleteConfirmDialog(PersonalData personalData) {
        DeleteDialogFragment fragment = new DeleteDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("personalDataObj", personalData);
        fragment.setArguments(bundle);
        fragment.show(getSupportFragmentManager(), "confirmDialog");
    }

    @Override
    public void callAddRegisterActivity() {
        Intent intent = new Intent(this, AddRegisterActivity.class);
        startActivity(intent);
    }

    @Override
    public void showEmptyMessage() {
        noRegisterTextView.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void showRegisterList() {
        noRegisterTextView.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void callEditRegisterActivity(PersonalData personalData) {
        Intent intent = new Intent(this, AddRegisterActivity.class);
        intent.putExtra(Constants.PERSONAL_DATA_ID, personalData);
        startActivity(intent);
    }

    @Override
    public void clickLongItem(PersonalData personalData) {
        mPresenter.openConfirmDeleteDialog(personalData);
    }

    @Override
    public void clickItem(PersonalData personalData) {
        mPresenter.editRegister(personalData);
    }

    @Override
    public void setConfirm(boolean confirm, PersonalData personalData) {
        if (confirm){
            mPresenter.deleteRegister(personalData);
        }
    }
}