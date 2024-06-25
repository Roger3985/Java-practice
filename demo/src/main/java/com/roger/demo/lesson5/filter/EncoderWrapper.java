package com.roger.demo.lesson5.filter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

import java.util.Optional;
import org.owasp.encoder.Encode;

public class EncoderWrapper extends HttpServletRequestWrapper {
    public EncoderWrapper(HttpServletRequest request) {
        super(request); // 必須呼叫父類別建構式，傳入 HttpServletRequest 實例
    }

    @Override
    public String getParameter(String name) {
        return Optional.ofNullable(getRequest().getParameter(name))
                .map(Encode::forHtml) // 將取得的請求參數值進行字元替換
                .orElse(null);
    }


}
