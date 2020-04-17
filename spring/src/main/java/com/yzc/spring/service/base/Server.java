package com.yzc.spring.service.base;

/**
 * 服务器抽象
 */
public interface Server {

    void start();

    void stop();

    // 服务器类型
    enum Type {
        HTTP,

        FTP
    }
}
