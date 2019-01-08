package me.lzb.network.netty.demo.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * @author LZB
 */
public class EchoServer {
    private final int port;


    public EchoServer(int port) {
        this.port = port;
    }


    public static void main(String[] args) throws Exception {
//        if (args.length != 1) {
//            System.err.print("Usage: " + EchoServer.class.getSimpleName() + " <port>");
//            return;
//        }
//
//        int port = Integer.parseInt(args[0]);
        int port = 65111;
        new EchoServer(port).start();
    }

    public void start() throws Exception {
        final EchoServerHandler serverHandler = new EchoServerHandler();
        //创建EventGroup
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            //创建ServerBootstrap
            ServerBootstrap b = new ServerBootstrap();
            b.group(group)
                //指定所使用的NIO传输channel
                .channel(NioServerSocketChannel.class)
                //使用指定的端口设置socket地址
                .localAddress(new InetSocketAddress(port))
                //添加一个EchoServerHandler到子Channel的ChannelPipeline
                .childHandler(new ChannelInitializer<SocketChannel>() {

                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(serverHandler);
                    }
                });
            //异步绑定服务器，低啊用sync()方法阻塞等待直到绑定完成
            ChannelFuture f = b.bind().sync();
            //获取Channel的CloseFuture，并且阻塞当前线程，直到完成
            f.channel().closeFuture().sync();
        } finally {
            //关闭EventLoopGroup，释放所有资源
            group.shutdownGracefully().sync();
        }
    }


}
