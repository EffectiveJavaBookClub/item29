package effectivejava.item29;

import java.util.Arrays;
import java.util.EmptyStackException;

//Object-based collection - a prime candidate for generics
public class MyStack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPTIVITY = 16;

    public MyStack() {
        elements = new Object[DEFAULT_INITIAL_CAPTIVITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if(size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null; //Eliminate obsolete reference
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if(elements.length == size)
            elements = Arrays.copyOf(elements, 2*size+1); //expands array
    }
}