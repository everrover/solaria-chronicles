package leetcode.prob1046;

import java.util.Arrays;

public class BinaryHeap {
    private int []heap;
    private int size;
    private int left(int i){
        return (2*i+1);
    }
    private int right(int i){
        return (2*i+2);
    }
    private int parent(int i){
        return (i-1)/2;
    }
    private void swap(int l, int r){
        int tmp = heap[r];
        heap[r] = heap[l];
        heap[l] = tmp;
    }

    public BinaryHeap(int capacity){
        this.heap = new int[capacity];
        Arrays.fill(this.heap, Integer.MAX_VALUE);
        this.size = 0;
    }

    private void heapIfy(int idx){
        int smallest;
        while(idx<(size/2)){
            smallest = idx;
            if(heap[idx]>heap[left(idx)])
                smallest = left(idx);
            if(heap[smallest]>heap[right(idx)]) {
                smallest = right(idx);
            }
            if(smallest!=idx){
                swap(idx, smallest);
                idx = smallest;
            }else {
                break;
            }
        }
    }

    public int getMin(){
        return size==0?-1:heap[0];
    }
    public int extractMin(){
        if(size==0) return -1;
        int ret = heap[0];
        heap[0] = Integer.MAX_VALUE;
        swap(0, --size);
        heapIfy(0);
        return ret;
    }
    public boolean insertKey(int val){
        if(size == heap.length) return false;
        int idx = size++;
        heap[idx] = val;
        while(heap[idx] < heap[parent(idx)]){
            swap(idx, parent(idx));
            idx = parent(idx);
        }
        return true;
    }



}