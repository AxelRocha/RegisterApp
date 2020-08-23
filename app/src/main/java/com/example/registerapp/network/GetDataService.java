package com.example.registerapp.network;

import com.example.registerapp.model.Address;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetDataService {

    @GET("{cep}/json")
    Call<Address> getAddressByCep(@Path("cep") String cep);
}
