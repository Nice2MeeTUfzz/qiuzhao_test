package 保融科技线下面试;

import java.util.Arrays;
public class MyArrayList<E> {
    private Object[] elementData;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public boolean add(E e) {
        if (size == elementData.length) {
            grow();
        }
        elementData[size++] = e;
        return true;
    }

    private void grow() {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        E oldvalue = (E) elementData[index];

        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null;
        return oldvalue;
    }
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        return (E) elementData[index];
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        System.out.println(list.size);
        System.out.println(list.get(1));

        list.remove(1);
        System.out.println(list.get(1));
    }
}
