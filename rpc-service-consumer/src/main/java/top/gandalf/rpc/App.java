package top.gandalf.rpc;

import top.gandalf.rpc.service.PrintService;
import top.gandalf.rpc.service.impl.HelloPrintService;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        PrintService printService = new HelloPrintService();
        String result = printService.say("Gandalf rpc demo");
        System.out.println(result);
    }
}
