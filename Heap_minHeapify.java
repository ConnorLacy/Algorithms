/*
  This class serves to demonstrate minHeapify on a minHeap
  minHeapfiy is a recursive call with O(logn) runtime

  This example shows a bubble-down heap repair by calling minHeapfiy
  after removing root element and replacing with last element (poll)
*/
import java.util.*;

public class Heap_minHeapify {

  public static void main(String[] args) {

    int[] values = new int[] {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
    System.out.println(Arrays.toString(values));

    Heap_minHeapify heap = new Heap_minHeapify();

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
    if ( rightChildIndex < heapSize && values[rightChildIndex] < values[smallerChildIndex]) smallerChildIndex = rightChildIndex;

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
