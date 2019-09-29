public class MinIntHeap {
  //Set array capacity and current size
  private int capacity = 10;
  private int size = 0;

  //Our Heap
  int[] values = new int[capacity];

  //Helper Methods for getting node index
  private int getLeftChildIndex(int parentIndex) { return 2 * parentIndex + 1; }
  private int getRightChildIndex(int parentIndex) { return 2 * parentIndex + 2; }
  private int getParentIndex(int childIndex) { return (childIndex - 1)/2; }

  //Helper methods for determining if a node has children
  private boolean hasLeftChild(int index) { return getLeftChildIndex(index) < size; }
  private boolean hasRightChild(int index) { return getRightChildIndex(index) < size; }
  private boolean hasParent(int index) { return getParentIndex(index) >= 0; }

  //Helper methods for retrieving node value
  private int leftChild(int index) { return values[getLeftChildIndex(index)]; }
  private int rightChild(int index) { return values[getRightChildIndex(index)]; }
  private int parent(int index) { return values[getParentIndex(index)]; }


  //Helper method for swapping node values
  private void swap(int node1, int node2){
    int temp = values[node1];
    values[node1] = values[node2];
    values[node2] = temp;
  }

  //Helper method for dynamically resizing array
  private void monitorCapacity() {
    if (size == capacity){
      values = Arrays.copyOf(values, capcacity*2);
      capcacity *= 2;
    }
  }

  public int peek() {
    if( size == 0 ) throw new IllegalStateException();
    return values[0];
  }

  public int poll() {
    if( size == 0 ) throw new IllegalStateException();
    int value = values[0];
    values[0] = values[size-1];                       //replace root with last item added
    size--;
    heapifyDown();
    return value;
  }

  public void add(int value){
    monitorCapacity();
    values[size] = value;
    size++;
    heapifyUp();
  }

  public void heapifyUp(){
    int index = size-1;
    while(hasParent(index) && parent(index) < values[index]){
      swap(getParentIndex(index), index);
      index = getParentIndex(index);
    }
  }

  public void heapifyDown(){
    int index = 0;
    while(hasLeftChild(index)){
      int smallerChildIndex = getLeftChildIndex(index);
      if(hasRightChild(index) && rightChild(index) < leftChild(index)) {
          smallerChildIndex = getRightChildIndex(index);
      }
      if(values[index] > values[smallerChildIndex]){
        break;
      }
      else {
        swap(index, smallerChildIndex);
      }
      index = smallerChildIndex;
    }
  }
}
