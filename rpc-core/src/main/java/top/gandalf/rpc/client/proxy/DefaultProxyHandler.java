package top.gandalf.rpc.client.proxy;

import top.gandalf.rpc.RpcRequest;
import top.gandalf.rpc.RpcResponse;
import top.gandalf.rpc.client.RequestClient;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;

/**
 * Created by gandalf on 2018/12/29
 */
public class DefaultProxyHandler implements InvocationHandler {

    private Class<?> service;

    private InetSocketAddress socketAddress = new InetSocketAddress("localhost", 8421);

    public DefaultProxyHandler(Class<?> service) {
        this.service = service;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setServiceName(service.getName());
        rpcRequest.setMethodName(method.getName());
        rpcRequest.setParameterTypes(method.getParameterTypes());
        rpcRequest.setArgs(args);
        RpcResponse rpcResponse = RequestClient.send(rpcRequest, socketAddress);
        return rpcResponse.getResult();
    }
}
