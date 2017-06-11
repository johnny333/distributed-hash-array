package client;

import api.IHeartBeatApi;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

/**
 * Created by jakub on 02.06.17.
 */

public class HeartBeatClientBuilder {
    private IHeartBeatApi beatApi;

    public HeartBeatClientBuilder(Class<IHeartBeatApi> apiClass,String url) {
        beatApi = createClient(apiClass, url);
    };

    private static <T> T createClient(Class<T> type, String uri) {
        return Feign.builder().client(new OkHttpClient()).encoder(new GsonEncoder()).decoder(new GsonDecoder()).logger(new Slf4jLogger(type)).logLevel(Logger.Level.FULL).target(type, uri);
    }


    public IHeartBeatApi getBeatApi() {
        return beatApi;
    }

    public void setBeatApi(IHeartBeatApi beatApi) {
        this.beatApi = beatApi;
    }

    public static IHeartBeatApi heartBeatFactory(Class<IHeartBeatApi> apiClass,String url){
        return createClient(apiClass,url);
    }
}
