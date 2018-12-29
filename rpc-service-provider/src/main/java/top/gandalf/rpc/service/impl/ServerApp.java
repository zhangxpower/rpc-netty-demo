package top.gandalf.rpc.service.impl;

import top.gandalf.rpc.server.impl.NioRpcServer;
import top.gandalf.rpc.service.CalcService;
import top.gandalf.rpc.service.PrintService;

/**
 * Created by gandalf on 2018/12/29
 */
public class ServerApp {
    public static void main(String[] args) {
        NioRpcServer nioRpcServer = new NioRpcServer("localhost", 8421);
        nioRpcServer.register(PrintService.class.getName(), HelloPrintService.class);
        nioRpcServer.register(CalcService.class.getName(), CalcServiceImpl.class);
        nioRpcServer.startup();
    }
}
