package kr.co.jks.todosample.logic.remote;

import android.util.Log;

import org.json.JSONObject;

import kr.co.jks.todosample.logic.DataSource;
import kr.co.jks.todosample.logic.Repository;
import kr.co.jks.todosample.logic.UserRepository;
import kr.co.jks.todosample.logic.remote.services.UserApiService;
import kr.co.jks.todosample.model.Item;
import kr.co.jks.todosample.model.User;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteDataSourceImpl implements DataSource {

    final private static String baseurl = "https://33a25912.ngrok.io/";
    final private static String _TAG = "Callback TAG =====>";

    UserRepository userRepository;
    Retrofit retrofit;

    public RemoteDataSourceImpl() {
        initRetrofit();
    }

    public void initRetrofit() {

        retrofit = new Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    @Override
    public void setRepository(Repository repository) {

    }

    @Override
    public Single<Long> save(Item item) {

        return null;
    }

    @Override
    public Flowable<List<Item>> fetchItems() {
        return null;
    }

    @Override
    public Single<Item> fetchItem(int no) {
        return null;
    }

    @Override
    public void setUserRepository(UserRepository repository) {

    }

    @Override
    public Single<Long> signUp(User user) {
        return null;
    }

    @Override
    public Single<User> checkUser(String id, String pwd) {
        User user = new User();
        user.setId(id);
        user.setPwd(pwd);
        //TODO implementation Retrofit
        UserApiService userApiService = retrofit.create(UserApiService.class);
        Call<JSONObject> call = userApiService.login(user);
        call.enqueue(new Callback<JSONObject>() {
            @Override
            public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                Log.d(_TAG, response.toString());
                Log.d(_TAG, String.valueOf(response.body()));
            }

            @Override
            public void onFailure(Call<JSONObject> call, Throwable t) {
                Log.d(_TAG, t.toString());
            }
        });


        return null;
    }
}
