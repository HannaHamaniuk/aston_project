import java.util.Comparator;

public class QuickSorter<T>{


    public void quickSort(T[] array, int min, int max, Comparator<? super T> comparator){
          if(min<max){
              int pivotIndex=divider(array, min,max,comparator);
              quickSort(array, min, pivotIndex-1,comparator);
              quickSort(array,pivotIndex+1,max,comparator);
          }
    }

    private int divider(T[] array, int min, int max, Comparator<? super T> comparator){
        T pivot = array[max];
        int i = min-1;
        for(int j = min;j<=max-1;j++){
            if(comparator.compare(array[j],pivot)<=0){
                i++;
                swap(array,i,j );
            }
        }
        swap(array,i+1,max);
        return i+1;
    }
    private void swap(T[]array, int i,int j){
       T temp = array[i];
       array[i] = array[j];
       array[j] = temp;
    }
}
