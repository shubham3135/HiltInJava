package com.lufick.hiltinjava.di;

import com.lufick.hiltinjava.network.RetroRepository;
import com.lufick.hiltinjava.network.RetroService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    @Singleton
    @Provides
    public static RetroService getRetroService(Retrofit retrofit){
        return retrofit.create(RetroService.class);
    }

    @Singleton
    @Provides
    public static Retrofit getRetroInstance() {
        String baseURL = "https://api.github.com/search/";
        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    public static RetroRepository getRetroRepository(RetroService retroService){
        return new RetroRepository(retroService);
    }
}
