package effectivejava.item29;

import java.util.Arrays;
import java.util.EmptyStackException;

class MyStackGenericAlternate<E> {  //Obseration Java defaults to <T>
                                    // T - type
                                    // E - element
                                    // Functionally the same
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPTIVITY = 16;

    public MyStackGenericAlternate() {
        elements = new Object[DEFAULT_INITIAL_CAPTIVITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if(size == 0)
            throw new EmptyStackException();

        // Causes error
        // E result = elements[--size];

        //push requires elements to be of type E so cast is correct
        @SuppressWarnings("unchecked") E result = (E) elements[--size];
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