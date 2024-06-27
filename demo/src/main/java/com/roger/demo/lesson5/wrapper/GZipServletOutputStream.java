package com.roger.demo.lesson5.wrapper;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.WriteListener;

import java.io.IOException;

public class GZipServletOutputStream extends ServletOutputStream { // 繼承 ServletOutputStream 來進行擴充
    private ServletOutputStream servletOutputStream;
    private GZipServletOutputStream gZipServletOutputStream;

    public GZipServletOutputStream(ServletOutputStream servletOutputStream) throws IOException {
        this.servletOutputStream = servletOutputStream;
        this.gZipServletOutputStream = new GZipServletOutputStream(servletOutputStream); // 使用 GZIPOutputStream 來增加壓縮功能
    }

    /**
     * 輸出時透過 GZIPOutputStream 的 write() 來壓縮輸出
     */
    public void write(int b) throws IOException {
        this.gZipServletOutputStream.write(b);
    }

    public GZipServletOutputStream gZipServletOutputStream() {
        return gZipServletOutputStream;
    }

    @Override
    public boolean isReady() {
        return gZipServletOutputStream.isReady();
    }

    @Override
    public void setWriteListener(WriteListener writeListener) {
        gZipServletOutputStream.setWriteListener(writeListener);
    }

    @Override
    public void close() throws IOException {
        this.gZipServletOutputStream.close();
    }

    @Override
    public void flush() throws IOException {
        this.gZipServletOutputStream.flush();
    }

    public void finish() throws IOException {
        this.gZipServletOutputStream.finish();
    }
}
