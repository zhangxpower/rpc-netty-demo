package top.gandalf.rpc.service;

/**
 * @Author: gandalf
 * @Date: 2018/12/28 16:04
 */
public interface PrintService {

    /**
     * 调用后输出时间，用户名称
     * @param name
     * @return
     */
    String say(String name);
}
