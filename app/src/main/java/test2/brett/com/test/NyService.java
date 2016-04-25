package test2.brett.com.test;

import retrofit.Call;
import retrofit.http.GET;
import test2.brett.com.test.model.APIResponse;

/**
 * Created by Brett on 4/25/16.
 */
public interface NyService {

    @GET("home.json?api-key=15629235341919a7b4b8b6e9344f9bca:6:72095783")
    Call<APIResponse> getResponse();
}
