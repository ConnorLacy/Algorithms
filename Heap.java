/*
  This class serves to demonstrate minHeapify on a minHeap
  minHeapfiy is a recursive call with O(logn) runtime

  This example shows a bubble-down heap repair by calling minHeapfiy
  after removing root element and replacing with last element (poll)
*/
import java.util.*;

public class Heap {

  public static void main(String[] args) {

    int[] values = new int[] {1, 3, 2, 7, 10, 4, 8, 9, 16, 14};
    System.out.println(Arrays.toString(values));

    Heap heap = new Heap();

    int root = values[0];
    heap.swap(values, 0, values.length-1);
    System.out.println(Arrays.toString(values));

    heap.minHeapify(values, 0, values.length-1);
    System.out.println(Arrays.toString(values));

  }

  public void minHeapify(int[] values, int index, int heapSize){
    int leftChildIndex = ( index * 2 ) + 1;
    int rightChildIndex = ( index * 2 ) + 2;

    Integer smallerChildIndex = null;
    if ( leftChildIndex < heapSize && values[leftChildIndex] < values[index] ) smallerChildIndex = leftChildIndex;
    else smallerChildIndex = index;
    if ( rightChildIndex < heapSize && values[rightChildIndex] < values[index]) smallerChildIndex = rightChildIndex;

    if (smallerChildIndex != null && smallerChildIndex != index){
      swap(values, index, smallerChildIndex);
      minHeapify(values, smallerChildIndex, heapSize);
    }
  }

  private void swap(int[] values, int parentNode, int childNode){
    int temp = values[parentNode];
    values[parentNode] = values[childNode];
    values[childNode] = temp;
  }
}
