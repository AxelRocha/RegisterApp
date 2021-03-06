package com.example.registerapp.ui.addregister;

import android.util.Log;

import com.example.registerapp.database.DataDao;
import com.example.registerapp.database.RegisterRepository;
import com.example.registerapp.model.Address;
import com.example.registerapp.model.PersonalData;
import com.example.registerapp.network.GetDataService;
import com.example.registerapp.network.RetrofitClientInstance;
import com.example.registerapp.utils.Constants;

import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddRegisterPresenter implements AddRegisterContract.Presenter {

    private final AddRegisterContract.View mView;
    private final RegisterRepository mRegisterRepository;

    private boolean isCepValid = true;

    public AddRegisterPresenter(AddRegisterContract.View view, DataDao dataDao) {
        this.mView = view;
        this.mView.setPresenter(this);
        this.mRegisterRepository = new RegisterRepository(dataDao);
    }

    @Override
    public void addRegister(PersonalData personalData) {
        mRegisterRepository.insertRegister(personalData);
        mView.finishActivity();
    }

    @Override
    public void updateRegister(PersonalData personalData) {
        mRegisterRepository.updateRegister(personalData);
        mView.finishActivity();
    }

    @Override
    public boolean validate(PersonalData personalData) {

        mView.clearErrors();

        if (personalData.getName().isEmpty() || !isValidName(personalData.getName())){
            mView.showErrorMessage(Constants.FIELD_NAME);
            return false;
        }

        if (!isValidAge(personalData.getAge()) ){
            mView.showErrorMessage(Constants.FIELD_AGE);
            return false;
        }

        if (personalData.getPhone().isEmpty() || !isValidPhone(personalData.getPhone())){
            mView.showErrorMessage(Constants.FIELD_PHONE);
            return false;
        }

        if (personalData.getCep().isEmpty() || !isValidCep(personalData.getCep())){
            mView.showErrorMessage(Constants.FIELD_CEP);
            return false;
        }

        if (personalData.getStreet().isEmpty() || !isValidName(personalData.getStreet())){
            mView.showErrorMessage(Constants.FIELD_STREET);
            return false;
        }

        if (personalData.getNumber().isEmpty() || !isValidNumber(personalData.getNumber())){
            mView.showErrorMessage(Constants.FIELD_NUMBER);
            return false;
        }

        if (personalData.getDistrict().isEmpty() || !isValidName(personalData.getDistrict())){
            mView.showErrorMessage(Constants.FIELD_DISTRICT);
            return false;
        }

        if (personalData.getCity().isEmpty() || !isValidName(personalData.getCity())){
            mView.showErrorMessage(Constants.FIELD_CITY);
            return false;
        }

        if (personalData.getUf().isEmpty() || !isValidUf(personalData.getUf())){
            mView.showErrorMessage(Constants.FIELD_UF);
            return false;
        }

        return true;
    }

    @Override
    public void completeAddressWithCep(CharSequence charSequence) {
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<Address> call = service.getAddressByCep(charSequence.toString());
        call.enqueue(new Callback<Address>() {
            @Override
            public void onResponse(Call<Address> call, Response<Address> response) {
                Address address = response.body();
                if (address != null && address.getCep() != null){
                    mView.populateAddressEditTexts(address);
                    isCepValid = true;
                } else {
                    mView.showErrorMessage(Constants.FIELD_CEP);
                    isCepValid = false;
                }
                mView.closeKeyboard();
            }

            @Override
            public void onFailure(Call<Address> call, Throwable t) {

            }
        });
    }

    @Override
    public void start() {

    }

    public boolean isValidName(String name) {
        Pattern patron = Pattern.compile("[A-Za-zÀ-ÿ '-]*");
        return patron.matcher(name).matches();
    }

    public boolean isValidAge(int age){
        if(age == 0){
            return false;
        }
        return true;
    }

    public boolean isValidPhone(String phone) {
        Pattern patron = Pattern.compile("^[0-9]*$");
        if (phone.length() < 7 || !patron.matcher(phone).matches()){
            return false;
        }
        return true;
    }

    public boolean isValidNumber(String phone) {
        Pattern patron = Pattern.compile("^[0-9]*$");
        if (!patron.matcher(phone).matches()){
            return false;
        }
        return true;
    }

    private boolean isValidCep(String cep) {
        Pattern patron = Pattern.compile("^[0-9]*$");
        if(cep.length() < 8 || !patron.matcher(cep).matches() || !isCepValid){
            return false;
        }
        return true;
    }

    private boolean isValidUf(String uf){
        return Constants.listUf.contains(uf);
    }


}
