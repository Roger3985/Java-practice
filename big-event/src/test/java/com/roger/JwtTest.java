package com.roger;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    @Test
    public void testGen() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("name", "roger");
        // 生成 jwt 的使用
        String token = JWT.create()
                .withClaim("user", claims) // 添加載荷
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 12)) // 添加過期時間
                .sign(Algorithm.HMAC256("roger")); // 指定演算法，配置密鑰

        System.out.println(token);
    }

    @Test
    public void testParse() {
        // 定義字符串ㄝ，模擬會員傳過來了 token
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9" +
                ".eyJ1c2VyIjp7Im5hbWUiOiJyb2dlciIsImlkIjoxfSwiZXhwIjoxNzIwMDAzNzU5fQ" +
                ".8xWRxZFS6VESdzjw6PkU_mNUe6RkIKX8P9PH2ZH6NMI";

        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("roger")).build();

        // 驗證 token ，生成一個解析後的 JWT 物件
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        Map<String, Claim>  claims = decodedJWT.getClaims();
        System.out.println(claims.get("user"));

        // 如果竄改頭部和載荷的資料，校驗失敗
        // 如果密鑰修改，校驗失敗
        // token 過期，校驗失敗
    }
}
