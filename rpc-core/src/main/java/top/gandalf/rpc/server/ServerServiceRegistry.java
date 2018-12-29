package top.gandalf.rpc.server;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 服务注册中心
 * Created by gandalf on 2018/12/29
 */
public class ServerServiceRegistry {

    private static ConcurrentHashMap<String, Class<?>> services = new ConcurrentHashMap<>();

    public static void register(String serviceName, Class<?> clazz){
        services.put(serviceName, clazz);
        System.out.println("注册服务["+ serviceName +"]=["+ clazz +"]!");
    }

    public static Class<?> getService(String serviceName){
        return services.get(serviceName);
    }

    public static void unregister(String serviceName) {
        if(services.size() > 0 && services.containsKey(serviceName)){
            services.remove(serviceName);
        }
    }
}
