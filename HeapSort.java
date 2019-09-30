import java.util.*;

public class HeapSort {

  public static void main(String[] args) {

    int[] values = new int[] {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
    System.out.println(Arrays.toString(values));

    HeapSort heapsort = new HeapSort();
    heapsort.sort(values);

    System.out.println(Arrays.toString(values));
  }

  private void sort(int[] values) {
    //build the heap in maxHeap
    buildMaxHeap(values);

    int size = values.length;
    for( int i = size-1; i > 0; i-- ) {
      swap(values, 0, i);
      maxHeapify(values, 0, i);
    }

  }

  private void buildMaxHeap(int[] values){
    //Determine middle array element
    int middle = (int)values.length/2;

    for( int i = middle; i >= 0; i-- ){
      maxHeapify(values, i, values.length);
    }
  }

  public void maxHeapify(int[] values, int index, int heapSize){
    int leftChildIndex = ( index * 2 ) + 1;
    int rightChildIndex = ( index * 2 ) + 2;

    Integer largerChildIndex = null;
    if ( leftChildIndex < heapSize && values[leftChildIndex] > values[index] ) largerChildIndex = leftChildIndex;
    else largerChildIndex = index;
    if ( rightChildIndex < heapSize && values[rightChildIndex] > values[largerChildIndex]) largerChildIndex = rightChildIndex;

    if (largerChildIndex != null && largerChildIndex != index){
      swap(values, index, largerChildIndex);
      maxHeapify(values, largerChildIndex, heapSize);
    }
  }

  private void swap(int[] values, int parentNode, int childNode){
    int temp = values[parentNode];
    values[parentNode] = values[childNode];
    values[childNode] = temp;
  }
}
