package com.rpc.framework;

public interface Client {

    Object send(String host,int port,Invocation invocation);
}
