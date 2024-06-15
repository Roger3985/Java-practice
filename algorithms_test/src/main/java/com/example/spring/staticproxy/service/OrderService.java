package com.example.spring.staticproxy.service;

/**
 * 訂單業務介面
 */
public interface OrderService {
    /**
     * 生成訂單訊息
     */
    void generate();

    /**
     * 修改訂單訊息
     */
    void modify();

    /**
     * 查看訂單明細（詳情）
     */
    void detail();
}
