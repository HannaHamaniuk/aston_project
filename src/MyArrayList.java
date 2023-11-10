import java.lang.invoke.DelegatingMethodHandle$Holder;
import java.util.Objects;

public class MyArrayList<T>  {

    private Object array[];
    public static final int CAPACITY = 5;
    private int size;


    public MyArrayList(int capacity){
        if(capacity<=0){
            throw new IllegalArgumentException();
        }
        array = new Object[capacity];
    }

    public MyArrayList(){
        this(CAPACITY);
    }

    public void add(T object){
       increaseSize();
        array[size] = object;
        size++;
    }

    public void increaseSize(){
        if(array.length==size){
            Object[] newArray = new Object[array.length*2];
            System.arraycopy(array,0,newArray,0,size);
            array = newArray;
        }
    }

    public void add(int index, T object){
        Objects.checkIndex(index,size+1);
        increaseSize();
        System.arraycopy(array, index,array, index + 1, size-index);
        array[index] = object;
        size++;
    }

    public T get(int index){
        Objects.checkIndex(index,size);
        return (T) array[index];
    }

    public boolean isEmpty(){
      return size==0;
    }

    public T remove(int index){
        Objects.checkIndex(index,size);
        T removedObject = (T) array[index];
        System.arraycopy(array,index+1,array, index,size-index-1);
        size--;
        return removedObject;
    }

    public void clear(){
        size = 0;
        array = new Object[CAPACITY];
    }


}
