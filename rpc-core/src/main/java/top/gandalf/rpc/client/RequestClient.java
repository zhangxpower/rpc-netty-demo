package top.gandalf.rpc.client;

import top.gandalf.rpc.RpcRequest;
import top.gandalf.rpc.RpcResponse;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * BIO方式去网络上请求服务器，传递需要调用服务的参数
 * Created by gandalf on 2018/12/29
 */
public class RequestClient {

    public static RpcResponse send(RpcRequest rpcRequest, InetSocketAddress socketAddress) {
        try {
            Socket socket = new Socket();
            socket.connect(socketAddress);
            ObjectOutputStream write = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream read = new ObjectInputStream(socket.getInputStream());
            write.writeObject(rpcRequest);
            while(true){
                RpcResponse rpcResponse = (RpcResponse) read.readObject();
                if(rpcResponse != null && rpcResponse.getResult() != null){
                    return rpcResponse;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
