import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.Assert.*;

public class QuickSorterTest {
    private QuickSorter sorter = new QuickSorter();

    @Test
    public void quickSort() {
        String[] array1 ={"London","Minsk", "Astana", "New York", "Mexico"};
        sorter.quickSort(array1,0,array1.length-1, Comparator.naturalOrder());
        String[] array2 = {"London", "Minsk", "Astana","New York", "Mexico"};
        Arrays.sort(array2);
        assertArrayEquals(array1,array2);
    }
}