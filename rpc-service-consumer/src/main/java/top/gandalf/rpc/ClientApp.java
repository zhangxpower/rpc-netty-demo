package top.gandalf.rpc;

import top.gandalf.rpc.client.RemoteServiceProxy;
import top.gandalf.rpc.service.CalcService;
import top.gandalf.rpc.service.PrintService;
import top.gandalf.rpc.service.dto.ResponseResult;

/**
 * Hello world!
 *
 */
public class ClientApp
{
    public static void main( String[] args )
    {
        PrintService printService = RemoteServiceProxy.newRemoteProxyObject(PrintService.class);
        String result = printService.say("Gandalf rpc demo");
        System.out.println(result);

        CalcService calcService = RemoteServiceProxy.newRemoteProxyObject(CalcService.class);
        ResponseResult responseResult = calcService.add(3, 5);
        System.out.println("3 + 5 = " + responseResult.getData());
    }
}
