package me.lzb.basic.download;

import me.lzb.basic.download.api.Connection;

import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CyclicBarrier;

/**
 * @author LZB
 */
public class DownloadThread extends Thread {

    Connection conn;
    int startPos;
    int endPos;
    CyclicBarrier barrier;
    String localFile;

    public DownloadThread(Connection conn, int startPos, int endPos, String localFile, CyclicBarrier barrier) {

        this.conn = conn;
        this.startPos = startPos;
        this.endPos = endPos;
        this.localFile = localFile;
        this.barrier = barrier;
    }

    public void run() {

        System.out.println("开始读取:" + startPos + "-" + endPos);

        try {
            byte[] data = conn.read(startPos, endPos);
            RandomAccessFile file = new RandomAccessFile(localFile, "rw");
            file.seek(startPos);
            file.write(data);
            file.close();
            conn.close();
            barrier.await();
        } catch (Exception e) {

        }


        System.out.println("读取结束:" + startPos + "-" + endPos);
    }
}
