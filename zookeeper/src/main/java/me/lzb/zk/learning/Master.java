package me.lzb.zk.learning;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * Created by lzb on 17-5-12.
 */
public class Master implements Watcher {

    ZooKeeper zk;

    String hostPort;

    Master(String hostPort) {

        this.hostPort = hostPort;
    }


    void startZk() {
        try {
            this.zk = new ZooKeeper(hostPort, 15000, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println(watchedEvent);
    }


    public static void main(String[] args) throws InterruptedException {
        Master m = new Master("127.0.0.1:2181");
        m.startZk();
        Thread.sleep(60000);
    }
}
