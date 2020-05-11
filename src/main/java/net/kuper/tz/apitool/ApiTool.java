package net.kuper.tz.apitool;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ApiTool {

    private static Map<String, Object> services = new HashMap<>();

    private static HttpLoggingInterceptor loggingInterceptor() {
        //Log相关
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String s) {
                log.info(s);
            }
        });
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        return logging;
    }

    /**
     * OKHttp配置
     *
     * @return
     */
    private static OkHttpClient.Builder getDefOkhttp() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(20, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        builder.addInterceptor(loggingInterceptor());
        //失败重连
        builder.retryOnConnectionFailure(true);
        return builder;
    }


    public static <T> T createService(Class<T> serviceClass, String baseUrl, ObjectMapper objectMapper) {
        T service = (T) services.get(serviceClass.getName() + baseUrl);
        if (service == null) {
            OkHttpClient.Builder builder = getDefOkhttp();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    //设置OKHttpClient
                    .client(builder.build())
                    .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//
                    .build();
            service = retrofit.create(serviceClass);
            services.put(serviceClass.getName() + baseUrl, service);
        }
        return service;
    }


}
