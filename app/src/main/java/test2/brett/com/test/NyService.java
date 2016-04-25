package test2.brett.com.test;

import retrofit.Call;
import retrofit.http.GET;
import test2.brett.com.test.model.APIResponse;

/**
 * Created by Brett on 4/25/16.
 */
public interface NyService {

    @GET("home.json")
    Call<APIResponse> getResponse();
}
