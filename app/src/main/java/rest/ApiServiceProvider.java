package rest;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

public class ApiServiceProvider {
    private static String baseUrl = "http://www.technapse.com/" ;
    private ApiServiceProvider() {
    }

    public static RestClient.GitApiInterface initializeRetrofit(Context context) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(getOkHttpClient(context))
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io())).build().create(RestClient.GitApiInterface.class);
    }

    private static OkHttpClient getOkHttpClient(Context context) {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient .readTimeout(50, TimeUnit.SECONDS)
                .connectTimeout(50, TimeUnit.SECONDS)
        .addInterceptor(headerInterceptor);
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient.addInterceptor(httpLoggingInterceptor);

        final File baseDir = new File(android.os.Environment.getExternalStorageDirectory(),"IIIII");;
        Log.i("Fail",baseDir.toString());
        if (baseDir != null) {
            final File cacheDir = new File(baseDir, "HttpResponseCache");
            okHttpClient.cache(new Cache(cacheDir, 1024));
        }
        return okHttpClient.build();
    }

    static Interceptor headerInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Headers headers = request.headers().newBuilder().build();
            request = request.newBuilder().headers(headers).build();
            return chain.proceed(request);
        }
    };
}