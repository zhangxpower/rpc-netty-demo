package top.gandalf.rpc.client;

import top.gandalf.rpc.client.proxy.DefaultProxyHandler;

import java.lang.reflect.Proxy;

/**
 * 获取接口对应的实例
 * Created by gandalf on 2018/12/29
 */
public class RemoteServiceProxy<T> {

    public static <T> T newRemoteProxyObject(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new DefaultProxyHandler(clazz));
    }
}
