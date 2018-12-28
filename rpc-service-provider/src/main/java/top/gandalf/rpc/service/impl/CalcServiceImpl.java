package top.gandalf.rpc.service.impl;

import top.gandalf.rpc.service.CalcService;
import top.gandalf.rpc.service.dto.ResponseResult;

/**
 * @Author: gandalf
 * @Date: 2018/12/28 16:16
 */
public class CalcServiceImpl implements CalcService {
    @Override
    public ResponseResult add(int x, int y) {
        return new ResponseResult("CalcServiceImpl$add", x+y, System.currentTimeMillis());
    }

    @Override
    public ResponseResult minus(int x, int y) {
        return new ResponseResult("CalcServiceImpl$minus", x-y, System.currentTimeMillis());
    }
}
