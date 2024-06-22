package com.example.basic.lesson14.example.nio.book;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class NIOUtil {
    public static InputStream openStream(String uri) throws Exception {
        // Java 11 新增的 HttpClient API
        return HttpClient
                .newHttpClient()
                .send(
                        HttpRequest.newBuilder(URI.create(uri)).build(),
                        HttpResponse.BodyHandlers.ofInputStream()
                )
                .body();
    }

    public static void dump(ReadableByteChannel src,
                            WritableByteChannel dest) throws IOException {
        var buffer = ByteBuffer.allocate(1024);
        try (src; dest) {
            while (src.read(buffer) != -1) {
                buffer.flip();
                dest.write(buffer);
                buffer.clear();
            }
        }
    }

    // 測試用的 main
    public static void main(String[] args) {
        ReadableByteChannel src = null;
        try {
            src = Channels.newChannel(openStream("https://openhome.cc"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try (var in = new FileOutputStream("index.html")) {
            NIOUtil.dump(src, in.getChannel());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
