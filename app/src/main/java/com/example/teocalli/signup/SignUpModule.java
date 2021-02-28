package com.example.teocalli.signup;

import dagger.Module;
import dagger.Provides;

@Module
public class SignUpModule {

    @Provides
    public SignupMVP.Presenter providePresenter(SignupMVP.Interactor interactor) {
        return new SignUpPresenter(interactor);
    }

    @Provides
    public SignupMVP.Interactor provideInteractor(SignUpRepository repository) {
        return new SignUpInteractor(repository);
    }

    public SignUpRepository provideSignUpRepository() {
        return new ApiSignUpRepository();
    }
}
