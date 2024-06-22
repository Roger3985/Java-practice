package com.example.basic.lesson15.example.httpclient;

import java.io.UncheckedIOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

import static java.net.URLEncoder.encode;

public class RequestHelper {
    public static String queryString(
            Map<String, String> params, String enc) {
        return params.keySet()
                .stream()
                .map(name -> "%s=%s".formatted(
                        encode(name, enc),
                        encode(params.get(name), enc)
                    )
                )
                .collect(Collectors.joining("&"));
    }

    private static String encode(String str, String enc) {
        try {
            return URLEncoder.encode(str, enc);
        } catch (UnsupportedEncodingException e) {
            throw new UncheckedIOException(e);
        }
    }
}
