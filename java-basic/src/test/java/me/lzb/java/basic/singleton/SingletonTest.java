package me.lzb.java.basic.singleton;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

/**
 * @author LZB
 */
public class SingletonTest {


    @Test
    public void SingletonEnumTest() throws IOException, ClassNotFoundException {
        SingletonEnum s = SingletonEnum.INSTANCE;

        //序列化实现深拷贝
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(s);

        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        SingletonEnum x = (SingletonEnum)objectInputStream.readObject();




        Assert.assertEquals(s, x);
    }

}