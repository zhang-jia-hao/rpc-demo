package com.rpc.protocol;

import com.rpc.framework.Url;

/**
 * 协议服务端
 *
 * @author zhang
 */
public interface ProtocolServer {

    void startup(Url url);
}
