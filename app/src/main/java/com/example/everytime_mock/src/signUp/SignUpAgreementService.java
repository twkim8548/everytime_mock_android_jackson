package com.example.everytime_mock.src.signUp;

import com.example.everytime_mock.src.signIn.interfaces.SignInRetrofitInterface;
import com.example.everytime_mock.src.signIn.models.DefaultResponse;
import com.example.everytime_mock.src.signUp.interfaces.SignUpAgreementActivityView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.everytime_mock.src.ApplicationClass.getRetrofit;

class SignUpAgreementService {
    private final SignUpAgreementActivityView mSignUpAgreementActivity__View;

    SignUpAgreementService(final SignUpAgreementActivityView signUpAgreementActivity__view) {
        this.mSignUpAgreementActivity__View = signUpAgreementActivity__view;
    }

    void getTest() {
        final SignInRetrofitInterface signInRetrofitInterface = getRetrofit().create(SignInRetrofitInterface.class);
        signInRetrofitInterface.getTest().enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                final DefaultResponse defaultResponse = response.body();
                if (defaultResponse == null) {
                    mSignUpAgreementActivity__View.validateFailure(null);
                    return;
                }

                mSignUpAgreementActivity__View.validateSuccess(defaultResponse.getMessage());
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                mSignUpAgreementActivity__View.validateFailure(null);
            }
        });
    }
}
