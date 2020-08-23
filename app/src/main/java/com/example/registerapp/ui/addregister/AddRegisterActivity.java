package com.example.registerapp.ui.addregister;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.registerapp.R;
import com.example.registerapp.database.RegisterRoomDatabase;
import com.example.registerapp.model.PersonalData;
import com.example.registerapp.utils.Constants;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

public class AddRegisterActivity extends AppCompatActivity implements AddRegisterContract.View{

    private AddRegisterContract.Presenter mPresenter;

    private EditText mNameEditText;
    private EditText mAgeEditText;
    private EditText mPhoneEditText;
    private EditText mCepEditText;
    private EditText mStreetEditText;
    private EditText mDistrictEditText;
    private EditText mCityEditText;
    private EditText mUfEditText;

    private TextInputLayout mNameTextInputLayout;
    private TextInputLayout mAgeTextInputLayout;
    private TextInputLayout mPhoneTextInputLayout;
    private TextInputLayout mCepTextInputLayout;
    private TextInputLayout mStreetTextInputLayout;
    private TextInputLayout mDistrictTextInputLayout;
    private TextInputLayout mCityTextInputLayout;
    private TextInputLayout mUfTextInputLayout;

    private FloatingActionButton mFab;

    private PersonalData register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_register);

        RegisterRoomDatabase db = RegisterRoomDatabase.getDatabase(getApplication());
        mPresenter = new AddRegisterPresenter(this, db.dataDao());

        register = new PersonalData();

        initViews();
    }

    private void initViews() {
        mNameEditText = findViewById(R.id.nameEditText);
        mAgeEditText = findViewById(R.id.ageEditText);
        mPhoneEditText = findViewById(R.id.phoneEditText);
        mCepEditText = findViewById(R.id.cepEditText);
        mStreetEditText = findViewById(R.id.streetEditText);
        mDistrictEditText = findViewById(R.id.districtEditText);
        mCityEditText = findViewById(R.id.cityEditText);
        mUfEditText = findViewById(R.id.ufEditText);

        mNameTextInputLayout = findViewById(R.id.nameTextInputLayout);
        mAgeTextInputLayout = findViewById(R.id.ageTextInputLayout);
        mPhoneTextInputLayout = findViewById(R.id.phoneTextInputLayout);
        mCepTextInputLayout = findViewById(R.id.cepTextInputLayout);
        mStreetTextInputLayout = findViewById(R.id.streetTextInputLayout);
        mDistrictTextInputLayout = findViewById(R.id.districtTextInputLayout);
        mCityTextInputLayout = findViewById(R.id.cityTextInputLayout);
        mUfTextInputLayout = findViewById(R.id.ufTextInputLayout);

        mFab = findViewById(R.id.fab);

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                register.setName(mNameEditText.getText().toString());
                register.setAge(getIntFromEditText(mAgeEditText.getText().toString()));
                register.setPhone(mPhoneEditText.getText().toString());
                register.setCep(mCepEditText.getText().toString());
                register.setStreet(mStreetEditText.getText().toString());
                register.setDistrict(mDistrictEditText.getText().toString());
                register.setCity(mCityEditText.getText().toString());
                register.setUf(mUfEditText.getText().toString());

                boolean valid = mPresenter.validate(register);

                if (!valid){
                    return;
                }

                mPresenter.addRegister(register);
            }
        });
    }


    @Override
    public void setPresenter(AddRegisterContract.Presenter presenter) {
        mPresenter = presenter;
    }

    private int getIntFromEditText(String editText){
        if (editText.isEmpty()){
            return 0;
        } else {
            return Integer.parseInt(editText);
        }
    }

    @Override
    public void showErrorMessage(int fieldId) {
        if (fieldId == Constants.FIELD_NAME){
            mNameTextInputLayout.setError("Nome Inválido");
        } else if (fieldId == Constants.FIELD_AGE){
            mAgeTextInputLayout.setError("Idade Inválida");
        } else if (fieldId == Constants.FIELD_PHONE){
            mPhoneTextInputLayout.setError("Telefone Inválido");
        } else if (fieldId == Constants.FIELD_CEP){
            mCepTextInputLayout.setError("CEP Inválido");
        } else if (fieldId == Constants.FIELD_STREET){
            mStreetTextInputLayout.setError("Rua Inválida");
        } else if (fieldId == Constants.FIELD_DISTRICT){
            mDistrictTextInputLayout.setError("Bairro Inválido");
        } else if (fieldId == Constants.FIELD_CITY){
            mCityTextInputLayout.setError("Cidade Inválida");
        } else if (fieldId == Constants.FIELD_UF){
            mUfTextInputLayout.setError("UF Inválido");
        }
    }

    @Override
    public void clearErrors() {
        mNameTextInputLayout.setErrorEnabled(false);
        mAgeTextInputLayout.setErrorEnabled(false);
        mPhoneTextInputLayout.setErrorEnabled(false);
        mCepTextInputLayout.setErrorEnabled(false);
        mStreetTextInputLayout.setErrorEnabled(false);
        mDistrictTextInputLayout.setErrorEnabled(false);
        mCityTextInputLayout.setErrorEnabled(false);
        mUfTextInputLayout.setErrorEnabled(false);
    }

    @Override
    public void finishActivity() {
        finish();
    }
}