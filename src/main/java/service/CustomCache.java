package service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by sallu on 10/30/2016.
 */
public class CustomCache {

    private Map<String,String> cache;
    private static CustomCache INSTANCE;
    private CustomCache(){
        cache = new ConcurrentHashMap<>();
    }

    public static synchronized CustomCache getInstance(){
        if(INSTANCE == null){
            INSTANCE = new CustomCache();
        }
            return INSTANCE;
    }
    public void put(String key,String value){
        cache.put(key,value);
    }
    public String get(String key){
        return cache.get(key);
    }
}
