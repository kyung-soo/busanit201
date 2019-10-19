package kr.co.jks.todosample.logic.remote.services;

import org.json.JSONObject;

import kr.co.jks.todosample.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

// Retrofit 통신용
public interface UserApiService {
    @POST("users/auth")
    Call<JSONObject> login(@Body User user);
}
