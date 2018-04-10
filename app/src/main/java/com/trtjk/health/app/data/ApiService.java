package com.trtjk.health.app.data;

import com.trtjk.health.app.config.Constants;
import com.trtjk.health.app.domain.User;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
/**
 * Created by WangChao on 18/3/6.
 */
public interface ApiService {
    @GET(Constants.API_URL_GET_USER_LIST)
    Observable<List<User>> getUserList();

    @GET(Constants.API_URL_GET_USER_DETAILS + "{id}.json")
    Observable<User> getUser(@Path("id") String userId);
}
