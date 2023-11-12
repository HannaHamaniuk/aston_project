import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class MyArrayListTest  {
    private MyArrayList<String> list1;
    private MyArrayList<String> list2;


    @Before
    public void setUp() throws Exception {
        list1 = new MyArrayList<>();
        list1.add("Spain");
        list1.add("Kazakhstan");
        list1.add("Germany");
        list1.add("Italy");

        list2 = new MyArrayList<>();


    }


    @Test
    public void add() {
        list1.add("Canada");
        assertEquals(list1.getSize(),4+1);
    }



    @Test
    public void addAll() {
      list2.addAll(list1);
      assertEquals(list1.getSize(),list2.getSize());
    }

    @Test
    public void get(){
        assertEquals(list1.get(0),"Spain");
    }





   @Test
   public void remove() {
       String removed = list1.remove(0);
       assertEquals(removed,"Spain");
       assertEquals(list1.getSize(),3);
   }

    @Test
   public void removeObject() {
        String removed = list1.remove("Germany");
        assertEquals(removed,"Germany");
        assertEquals(list1.getSize(),3);
    }

   @Test
   public void clear() {
        list1.clear();
        assertEquals(list1.getSize(),0);
    }



}