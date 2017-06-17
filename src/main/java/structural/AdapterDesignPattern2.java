package structural;

import javafx.print.Collation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by govind.bhone on 6/17/2017.
 */

/*  * This is our adaptee, a third party implementation of a  * number sorter that deals with Lists, not arrays. */

class NumberSorter {
    public List<Integer> sort(List<Integer> numbers) {
        //sort and return
        numbers.sort((a, b) -> Integer.compare(a,b));
        //numbers.sort(Comparator.comparing(className::fieldName));
        return numbers;
    }
}


//this is our Target interface
interface Sorter{
    public int[] sort(int[] numbers);
}

class SortListAdapter implements Sorter{
    @Override
    public int[] sort(int[] numbers) {
        //convert the array to a List
        List<Integer> numberList = new ArrayList<>();
        for(int number :numbers){
            numberList.add(number);
        }
        //call the adapter
        NumberSorter sorter = new NumberSorter();
        numberList = sorter.sort(numberList);
        //convert the list back to an array and return
        return numberList.stream().mapToInt(i->i).toArray();
    }
}

public class AdapterDesignPattern2 {
    public static void main(String args[]){
        int[] numbers = new int[]{34, 2, 4, 12, 1};
        Sorter sorter = new SortListAdapter();
        int [] sorted =sorter.sort(numbers);

        for(int ele:sorted){
            System.out.println(ele);
        }
    }
}
