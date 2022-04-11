package leetcode.prob460;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    private class Node {
        public int val, key, count;
        public Node next, prev;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
            this.count = 1;
            this.next = this.prev = null;
        }
    }

    private class NodeQ{
        private Node start, end;
        public int count;
        public NodeQ(){
            start=new Node(-1, -1);
            end=new Node(-2, -2);
            start.next = end;
            end.prev = start;
            count = 0;
        }
        public void addNode(Node node){
            if(count == 0) {
                start.next = node;
                end.prev = node;
                node.prev = start;
                node.next = end;
            }else{
                start.next.prev = node;
                node.prev = start;
                node.next = start.next;
                start.next = node;
            }
            count++;
        }
        public void deleteNode(Node node){
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.next = node.prev = null;
            count--;
        }
        public Node deque(){ Node ret = end.prev; deleteNode(ret); return ret; }
//        public void iterate() {
//            Node s = start;
//            while(s.next!=null){
//                System.out.print(s.val+", ");
//                s = s.next;
//            }
//        }
    }

    private HashMap<Integer, Node> nodeHash;
    private HashMap<Integer, NodeQ> nodeHashQ;
    int currCount, capacity, leastFreq;

    public Solution(int capacity) {
        nodeHash = new HashMap<>();
        nodeHashQ = new HashMap<>();
        this.capacity = capacity;
        currCount = 0;
        leastFreq = Integer.MAX_VALUE;
    }

    public int get(int key) {
        if(nodeHash.containsKey(key)){
            Node node = nodeHash.get(key);
            incCount(node, false);
            return node.val;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(capacity == 0){
            return;
        }else if(nodeHash.containsKey(key)){
            incCount(nodeHash.get(key), false);
        }else {
            if (currCount >= capacity) {
                currCount--;
                NodeQ nq = nodeHashQ.get(leastFreq);
                Node toRemove = nq.deque();
                nodeHash.remove(toRemove.key);
            }
            Node node = new Node(key, value);
            nodeHash.put(key, node);
            incCount(node, true);
            currCount++;
        }
//        for(Map.Entry<Integer, NodeQ> m: nodeHashQ.entrySet()){
//            System.out.println("Queue::"+m.getKey()+">>");
//            m.getValue().iterate();
//        }
    }
    private void incCount(Node node, boolean isC){
        int count = node.count;
        if(isC){
            if(!nodeHashQ.containsKey(count)){
                nodeHashQ.put(count, new NodeQ());
            }
            NodeQ q = nodeHashQ.get(count);
            q.addNode(node);
            leastFreq = Integer.min(
                    nodeHashQ.containsKey(leastFreq)&&nodeHashQ.get(leastFreq).count==0?Integer.MAX_VALUE:leastFreq,
                    q.count==0?Integer.MAX_VALUE:count
            );
        }else{
            NodeQ oldQ = nodeHashQ.get(count);
            oldQ.deleteNode(node);
            node.count++;
            count++;
            if(!nodeHashQ.containsKey(count)){
                nodeHashQ.put(count, new NodeQ());
            }
            NodeQ newQ = nodeHashQ.get(count);
            newQ.addNode(node);
            int noMin = Integer.min(
                    newQ.count==0?Integer.MAX_VALUE:count,
                    oldQ.count==0?Integer.MAX_VALUE:count-1
            );
            leastFreq = Integer.min(nodeHashQ.containsKey(leastFreq)&&nodeHashQ.get(leastFreq).count==0?Integer.MAX_VALUE:leastFreq, noMin);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */