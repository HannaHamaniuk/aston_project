

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class MyArrayList<T> {

    private Object array[];
    public static final int CAPACITY = 5;
    private int size;
    private QuickSorter<T> quickSorter;


    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        array = new Object[capacity];
    }

    public MyArrayList() {
        this(CAPACITY);
        quickSorter=new QuickSorter<>();
    }

    public void add(T object) {
        increaseSize();
        array[size] = object;
        size++;
    }

    public void increaseSize() {
        if (array.length == size) {
            Object[] newArray = new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    public void add(int index, T object) {
        Objects.checkIndex(index, size + 1);
        increaseSize();
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = object;
        size++;
    }

    public void addAll(MyArrayList<? extends T> list) {

        for (int i = 0; i < list.getSize(); i++) {
            add(list.get(i));
        }
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) array[index];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @SuppressWarnings("unchecked")
    public T remove(int index) {
        Objects.checkIndex(index, size);
        T removedObject = (T) array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        return removedObject;
    }

    public T remove(T object) {
        T removed = null;
        for (int i = 0; i < size; i++) {
            if (array[i].equals(object)) {
                return remove(i);
            }
        }
        return removed;
    }

    public void clear() {
        size = 0;
        array = new Object[CAPACITY];
    }
    public void sort(Comparator<? super T> comparator){
        quickSorter.quickSort((T[]) array,0,size-1,comparator);
    }

    public int getSize(){
        return size;
    }

    public void printElements(){
        for(int i=0;i<size;i++){
            System.out.print(array[i] +" ");
        }
    }

}
