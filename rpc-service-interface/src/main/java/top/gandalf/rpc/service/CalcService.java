package top.gandalf.rpc.service;

import top.gandalf.rpc.service.dto.ResponseResult;

/**
 * @Author: gandalf
 * @Date: 2018/12/28 16:05
 */
public interface CalcService {

    /**
     * 计算两个值相加
     * @param x
     * @param y
     * @return
     */
    ResponseResult add(int x, int y);

    /**
     * 计算x-y后的值
     * @param x
     * @param y
     * @return
     */
    ResponseResult minus(int x, int y);
}
