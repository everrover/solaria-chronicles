package leetcode.prob1046;

public class Main {
    public static void main(String[] args) {
        BinaryHeap bh = new BinaryHeap(10);
        bh.insertKey(5);
        bh.insertKey(8);
        bh.insertKey(3);
        bh.insertKey(6);
        bh.insertKey(4);
        bh.insertKey(7);
        bh.insertKey(9);
        bh.insertKey(3);
        bh.insertKey(1);
        bh.insertKey(5);
        bh.getMin();
        bh.extractMin();
        bh.extractMin();
        bh.extractMin();
        bh.extractMin();
        bh.extractMin();
        bh.extractMin();

    }
}