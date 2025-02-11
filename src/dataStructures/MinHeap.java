package dataStructures;

public class MinHeap {
    //heap using array
    private int[] heapArray;
    private final int maxHeapSize;
    private int currentHeapSize;

    public MinHeap(int size) {
        heapArray = new int[size];
        maxHeapSize = size;
        currentHeapSize = 0;
    }

    private int parent(int key) {
        return (key - 1) / 2;
    }

    private int left(int key) {
        return key * 2 + 1;
    }

    private int right(int key) {
        return key * 2 + 2;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // insert new element to heap
    public boolean insertKey(int ele) {
        if (currentHeapSize == maxHeapSize)
            return false;
        int i = currentHeapSize;
        heapArray[i] = ele;
        currentHeapSize++;

        while (i != 0 && heapArray[i] < heapArray[parent(i)]) {
            swap(heapArray, i, parent(i));
            i = parent(i);
        }
        return true;
    }

    //    modify the value at given position in heap assume the value is smaller then original
    private void decreaseKey(int i, int value) {
        heapArray[i] = value;
        while (i != 0 && heapArray[i] < heapArray[parent(i)]) {
            swap(heapArray, i, parent(i));
            i = parent(i);
        }
    }

    private void increaseKey(int i, int value) {
        heapArray[i] = value;
        heapify(i);
    }

    private void changeValue(int i, int value) {
        if (value > heapArray[i])
            increaseKey(i, value);
        else if (value < heapArray[i])
            decreaseKey(i, value);
    }

    //    return minimum value in heap if present else returns -1;
    public int getMin() {
        if (currentHeapSize <= 0)
            return -1;
        return heapArray[0];
    }

    public int extractMin() {
        if (currentHeapSize <= 0)
            return -1;
        if (currentHeapSize == 1) {
            return heapArray[--currentHeapSize];
        }
        int data = heapArray[0];
        heapArray[0] = heapArray[--currentHeapSize];
        heapify(0);
        return data;
    }

    private void deleteKey(int pos) {
        decreaseKey(pos, Integer.MIN_VALUE);
        extractMin();
    }

    //    heapify (make the heap follow the principles)
//    only works for specified subtree assuming others are in order
    private void minHeapify(int pos) {
        int left = left(pos);
        int right = right(pos);
        int smallest = pos;
        if (left < currentHeapSize && heapArray[left] < heapArray[smallest])
            smallest = left;
        if (right < currentHeapSize && heapArray[right] < heapArray[smallest])
            smallest = right;

        if (pos != smallest) {
            swap(heapArray, pos, smallest);
            minHeapify(smallest);
        }
    }

    private void convertToMinHeap(int pos){
        int rightMostParent = currentHeapSize / 2 - 1;
        for (int i = rightMostParent; i >=0; i--) {
            minHeapify(i);
        }
    }

    private void maxHeapify(int pos) {
        int left = left(pos);
        int right = right(pos);
        int largest = pos;
        if (left < currentHeapSize && heapArray[left] > heapArray[largest])
            largest = left;
        if (right < currentHeapSize && heapArray[right] > heapArray[largest])
            largest = right;

        if (pos != largest) {
            swap(heapArray, pos, largest);
            maxHeapify(largest);
        }
    }

    private void convertToMaxHeap() {
        int rightMostParent = currentHeapSize / 2 - 1;
        for (int i = rightMostParent; i >=0; i--) {
            maxHeapify(i);
        }
    }

    public static void main(String[] args) {
    }

}
