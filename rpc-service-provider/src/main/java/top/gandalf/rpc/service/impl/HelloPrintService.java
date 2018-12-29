package top.gandalf.rpc.service.impl;

import top.gandalf.rpc.service.PrintService;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: gandalf
 * @Date: 2018/12/28 16:12
 */
public class HelloPrintService implements PrintService {
    @Override
    public String say(String name) {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
        return "[" + sdf.format(new Date()) + "] Hello, " + name;
    }
}
