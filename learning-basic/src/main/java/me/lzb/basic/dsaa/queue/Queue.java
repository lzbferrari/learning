package me.lzb.basic.dsaa.queue;

import me.lzb.basic.dsaa.list.LinkedList;

/**
 * 先进先出
 *
 * @author LZB
 */
public class Queue {
    LinkedList elementData = new LinkedList();

    public void enQueue(Object o) {
        elementData.add(o);
    }

    public Object deQueue() throws IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("index boom");
        }
        return elementData.remove(elementData.size() - 1);
    }

    public boolean isEmpty() {
        if (elementData.size() <= 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return elementData.size();
    }
}
