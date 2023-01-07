package io.projects.sortingapi.sorting;

import java.util.Collections;
import java.util.List;

public class InsertionSorter implements Sorter {
    public void sort(List<Integer> list) {
        int n = list.size();
        // iterate through all elements
        //System.out.println(list);
        for (int currIdx = 1; currIdx < n; currIdx++) {
            int right = currIdx;
            int left = right - 1;
            // while current element is less than the one before it
            while ((left > -1) && (list.get(right) < list.get(left))) {
                //System.out.println(list.get(right) + " is less than " + list.get(left) + ". Swapping!");
                // swap the items at current index and previous index
                Collections.swap(list, left, right);
                //System.out.println(list);
                // update pointers so that we can check again but with updated vals.
                left--;
                right--;
            }
        }
    }
}
