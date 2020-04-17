package com.yzc.spring.service.impl;

import com.yzc.spring.service.base.Server;

//@Component
public class HttpServer implements Server {
    @Override
    public void start() {
        System.err.println("HTTP服务器启动重...");
    }

    @Override
    public void stop() {
        System.err.println("HTTP服务器关闭中...");
    }
}




