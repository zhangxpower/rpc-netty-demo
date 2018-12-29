package top.gandalf.rpc;

import lombok.*;

import java.io.Serializable;

/**
 * Created by gandalf on 2018/12/29
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RpcResponse implements Serializable {

    private Object result;

}
