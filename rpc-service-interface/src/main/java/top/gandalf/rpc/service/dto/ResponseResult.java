package top.gandalf.rpc.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author: gandalf
 * @Date: 2018/12/28 16:06
 */
@AllArgsConstructor
@Getter
@Setter
public class ResponseResult implements Serializable {

    private String invokeTargetName;

    private Integer data;

    private long invokeTimestamp;

}
