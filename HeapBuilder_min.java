/*
  This example serves to demonstrate how buildMinHeap function
  will build a minHeap from a given array
*/
import java.util.*;

public class HeapBuilder_min {

  public static void main(String[] args) {
    System.out.println("O(n^2)");
    int[] values = new int[] {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
    System.out.println(Arrays.toString(values));

    HeapBuilder_min heap = new HeapBuilder_min();
    heap.buildMinHeap(values);

    System.out.println(Arrays.toString(values));
  }

  private void buildMinHeap(int[] values){
    //Determine middle array element
    int middle = (int)values.length/2;
    //from middle element to root ( or beginning of array ),
    //perform minHeapify
    // for( int i = middle; i >= 0; i-- ){
    //   minHeapify(values, i, values.length);
    // }
    for( int i = 0; i <= middle; i++ ){
      minHeapify(values, i, values.length);
    }
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
