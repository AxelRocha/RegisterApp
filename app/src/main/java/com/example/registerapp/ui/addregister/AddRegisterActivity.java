package com.example.registerapp.ui.addregister;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.registerapp.R;
import com.example.registerapp.database.RegisterRoomDatabase;
import com.example.registerapp.model.Address;
import com.example.registerapp.model.PersonalData;
import com.example.registerapp.utils.Constants;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

public class AddRegisterActivity extends AppCompatActivity implements AddRegisterContract.View{

    private AddRegisterContract.Presenter mPresenter;

    private TextView mIdentifierTextView;

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

    private PersonalData mRegister;

    private boolean mEditMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_register);

        RegisterRoomDatabase db = RegisterRoomDatabase.getDatabase(getApplication());
        mPresenter = new AddRegisterPresenter(this, db.dataDao());

        mRegister = new PersonalData();

        checkMode();

        initViews();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(mEditMode){
            populateViews(mRegister);
        }
    }

    private void populateViews(PersonalData mRegister) {
        mNameEditText.setText(mRegister.getName());
        mAgeEditText.setText(Integer.toString(mRegister.getAge()));
        mPhoneEditText.setText(mRegister.getPhone());
        mCepEditText.setText(mRegister.getCep());
        mStreetEditText.setText(mRegister.getStreet());
        mDistrictEditText.setText(mRegister.getDistrict());
        mCityEditText.setText(mRegister.getCity());
        mUfEditText.setText(mRegister.getUf());
    }

    private void checkMode() {
        if (getIntent().getExtras() != null) {
            mRegister = (PersonalData) getIntent().getSerializableExtra(Constants.PERSONAL_DATA_ID);
            mEditMode = true;
        }
    }

    private void initViews() {
        mIdentifierTextView = findViewById(R.id.identifierTextView);
        setActivityIdentifier();

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
        mFab.setImageResource(mEditMode ? R.drawable.ic_baseline_edit_24 : R.drawable.ic_baseline_done_24);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mRegister.setName(mNameEditText.getText().toString());
                mRegister.setAge(getIntFromEditText(mAgeEditText.getText().toString()));
                mRegister.setPhone(mPhoneEditText.getText().toString());
                mRegister.setCep(mCepEditText.getText().toString());
                mRegister.setStreet(mStreetEditText.getText().toString());
                mRegister.setDistrict(mDistrictEditText.getText().toString());
                mRegister.setCity(mCityEditText.getText().toString());
                mRegister.setUf(mUfEditText.getText().toString());

                boolean valid = mPresenter.validate(mRegister);

                if (!valid){
                    return;
                }

                if (mEditMode){
                    mPresenter.updateRegister(mRegister);
                } else {
                    mPresenter.addRegister(mRegister);
                }
            }
        });

        mCepEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 8){
                    mPresenter.completeAddressWithCep(charSequence);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void setActivityIdentifier() {
        if (mEditMode){
            mIdentifierTextView.setText("Editar Cadastro");
        } else {
            mIdentifierTextView.setText("Novo Cadastro");
        }
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

    @Override
    public void populateAddressEditTexts(Address address) {
        mStreetEditText.setText(address.getStreet());
        mDistrictEditText.setText(address.getDistrict());
        mCityEditText.setText(address.getCity());
        mUfEditText.setText(address.getUf());
    }
}