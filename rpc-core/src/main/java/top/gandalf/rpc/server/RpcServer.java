package top.gandalf.rpc.server;

/**
 * Created by gandalf on 2018/12/29
 */
public interface RpcServer {

    void startup();

    void shutdown();

    void register(String serviceName, Class<?> clazz);

    void unregister(String serviceName);

    boolean isAlive();
}
