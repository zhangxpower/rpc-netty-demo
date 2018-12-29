package top.gandalf.rpc.server.impl;

import top.gandalf.rpc.server.NioSocketHandler;
import top.gandalf.rpc.server.RpcServer;
import top.gandalf.rpc.server.ServerServiceRegistry;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by gandalf on 2018/12/29
 */
public class NioRpcServer implements RpcServer {

    private String host = "127.0.0.1";
    private int port = 8421;
    private volatile boolean isStarted;
    private final static ExecutorService executorService = Executors.newFixedThreadPool(50);

    public NioRpcServer(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public void startup() {
        isStarted = true;
        try (ServerSocket serverSocket = new ServerSocket()) {
            serverSocket.bind(new InetSocketAddress(host, port));
            System.out.println("Server Started...");
            while(isStarted){
                Socket socket = serverSocket.accept();
                executorService.submit(new NioSocketHandler(socket));
            }
            System.out.println("Server Shutdown...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void shutdown() {
        if (isStarted) {
            isStarted = false;
        }
    }

    @Override
    public void register(String serviceName, Class<?> clazz) {
        ServerServiceRegistry.register(serviceName, clazz);
    }

    @Override
    public void unregister(String serviceName) {
        ServerServiceRegistry.unregister(serviceName);
    }

    @Override
    public boolean isAlive() {
        return false;
    }
}
