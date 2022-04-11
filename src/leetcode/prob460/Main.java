package leetcode.prob460;


public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution(1);
        String ops[] = new String[]{"LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"};
        int vals[][] = new int[][]{
                {2},
                {1,1},
                {2,2},
                {1},
                {3,3},
                {2},
                {3},
                {4,4},
                {1},{3},{4}
        };
        for(int i=0; i<ops.length; i++){
            if("LFUCache".equals(ops[i])){
                sol = new Solution(vals[i][0]);
                System.out.println("null");
            } else if ("put".equals(ops[i])) {
                sol.put(vals[i][0], vals[i][1]);
                System.out.println("null");
            } else {
                System.out.println(sol.get(vals[i][0]));
            }
        }
    }
}
