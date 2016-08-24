package rest;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Ashiq Uz Zoha on 9/13/15.
 * Dhrubok Infotech Services Ltd.
 * ashiq.ayon@gmail.com
 */
public class RestClient {

    private static GitApiInterface gitApiInterface;
    private static String baseUrl = "http://www.technapse.com/";

    public static GitApiInterface getClient() {
        if (gitApiInterface == null) {

            OkHttpClient okClient = new OkHttpClient();
            okClient.interceptors().add(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Response response = chain.proceed(chain.request());
                    return response;
                }
            });

            Retrofit client = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                   /* .addConverter(String.class, new ToStringConverter())*/
                    .client(okClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            gitApiInterface = client.create(GitApiInterface.class);
        }
        return gitApiInterface;
    }

    public interface GitApiInterface {


        @FormUrlEncoded
        @POST("jawad/ibank/bank_json.php")
        Observable<BankResult> syncContacts(
                @Field("City") String city
        );

        @GET("jawad/ibank/postad_json.php")
        Observable<Resultss> getData(
        );


       /* @FormUrlEncoded
        @POST("jawad/ibank/bank_json.php")
        Call<BankResult> syncCont(
                @Field("City") String city
        );

        @GET("jawad/ibank/postad_json.php")
        Call<Resultss> getDat(
        );*/

    }

}
