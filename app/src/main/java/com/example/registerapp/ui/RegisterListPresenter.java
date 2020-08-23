package com.example.registerapp.ui;

public class RegisterListPresenter implements RegisterListContract.Presenter {

    private final RegisterListContract.View mView;

    public RegisterListPresenter(RegisterListContract.View view) {
        this.mView = view;
        this.mView.setPresenter(this);
    }

    @Override
    public void start() {

    }
}
