package top.gandalf.rpc.server;

import top.gandalf.rpc.RpcRequest;
import top.gandalf.rpc.RpcResponse;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * @Author: gandalf
 * @Date: 2018/12/28 17:55
 */
public class NioSocketHandler implements Runnable{

    private Socket clientSocket;

    public NioSocketHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream write = new ObjectOutputStream(clientSocket.getOutputStream());
            RpcRequest request = (RpcRequest) ois.readObject();
            RpcResponse rpcResponse = this.invokeRequest(request);
            write.writeObject(rpcResponse);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public RpcResponse invokeRequest(RpcRequest request){
        try {
            System.out.println(request);
            String serviceName = request.getServiceName();
            Class<?> service = ServerServiceRegistry.getService(serviceName);
            Method method = service.getMethod(request.getMethodName(), request.getParameterTypes());
            Object result = method.invoke(service.newInstance(), request.getArgs());
            return new RpcResponse(result);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
