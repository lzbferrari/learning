package me.lzb.basic.download.impl;


import me.lzb.basic.download.api.Connection;
import me.lzb.basic.download.api.ConnectionException;
import me.lzb.basic.download.api.ConnectionManager;

/**
 * @author LZB
 */
public class ConnectionManagerImpl implements ConnectionManager {


    @Override
    public Connection open(String url) throws ConnectionException {
        return new ConnectionImpl(url);
    }


}
