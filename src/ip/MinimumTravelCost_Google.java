package src.ip;

import java.util.Arrays;

public class MinimumTravelCost_Google {
  private static class Station{
    public int loc, cost;

    public Station(int loc, int cost) {
      this.loc = loc;
      this.cost = cost;
    }
  }
  public int minCost(int A, int B, int V, int []dist, int []prices) {
    if(A == B) return 0;
    else if(A > B) return -1;
    else if(dist.length == 0 && (B-A)>V) return -1;

    // Creating station nodes with zero reference
    int size = 0;
    Station []stations = new Station[prices.length+2];
    stations[size++] = new Station(0, 0);
    for(int i=0; i<dist.length; i++){
      if(dist[i] > A && dist[i] < B){
        stations[size++] = new Station(dist[i]-A+1, prices[i]);
      }
    }
    stations[size++] = new Station(B-A+1, 0);
    Arrays.sort(stations, (a,b)->(a.loc-b.loc));

    if((B-A)>V && size==0) return -1;



    for (int i = 1; i < size; i++) {
      if(stations[i].loc-stations[i-1].loc>V) return -1;
    }

    return 0;
  }

  public int minCostDp(int A, int B, int V, int []dist, int[] prices){
    for(int i=0; i<dist.length; i++){
      dist[i] = dist[i]-A;
    }
    B = B-A+1;
    A = 0;
    int memo[][] = new int[dist.length][V+1];
    for(int m[]: memo){
      Arrays.fill(m, -2);
    }
    Arrays.fill(memo[dist.length-1], 0); // Cost at destination is 0
    return minCostDp(0, V, V, dist, prices, memo);
  }

  public int minCostDp(int i, int curr, int V, int []dist, int []prices, int [][]memo){
    if(memo[i][curr] != -2) return memo[i][curr];
    if(i>=(dist.length-1)){ // reached destination
      memo[i][curr] = 0;
      return 0;
    }
    int minCost = Integer.MAX_VALUE;
    for(int j=i+1; j<dist.length; j++){
      int distToNext = dist[j]-dist[i];
      if(distToNext > V) break;
      for(int fill=0; (fill+curr)<=V; fill++){
        int gasAfterRefill = fill+curr;
        if(gasAfterRefill<distToNext) continue;
        minCost = Integer.min(minCost, prices[i]*fill+minCostDp(
            j,
            gasAfterRefill-distToNext, V,
            dist, prices, memo
          )
        );
      }
    }
    memo[i][curr] = minCost;
    return minCost;
  }

  public static void main(String[] args) {
    MinimumTravelCost_Google minimumTravelCostGoogle = new MinimumTravelCost_Google();
    int res = minimumTravelCostGoogle.minCostDp(
        5, 25, 7,
        new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9},
        new int[]{0, 1, 2 ,3 ,4 ,5 ,6 ,7 ,0}
//    new int[]{5, 9, 10, 12, 14, 16, 22, 25},
//        new int[]{0, 2, 4 , 1 , 3 , 2 , 6 , 0}
//        new int[]{0, 3, 5, 9, 10, 12, 14, 16, 22, 27},
//        new int[]{4, 6, 1, 2, 4 , 1 , 3 , 2 , 6 , 8}
    );
    System.out.println(res);
  }

//  public int minCost(Station[] stations, int target, int capacity) {int[] dp = new int[d+1];	Collections.sort(stations, new Comparator<Station> () {		public int compareTo(Station a, Station b) {			return a.x - b.x;		}	});		int left = -V;     //Sliding window between left to ith index to consider the station for fuel	List<Station> list = new ArrayList();	index = 0;	for(int i=1;i<=d;i++) {		if(list.size() > 0) {			if(left > list.get(0).getX())				list.remove(0);		}		left++;		if(index < stations.length && left == stations[index].getX()) {			list.add(stations[index++]);		}		if(i <= capacity)			dp[i] = 0;		else {			if(list.size() != 0) {				dp[i] = dp[i-1] + cost(list);			} else {				System.out.println("Not possible to reach target");				return -1;			}		}	}	return dp[];}
//    private int cost(List<Station> list) {int min = Integer.MAX_VALUE;	for(Station s : list) {		min = Math.min(min, s.getPrice());
//    }
//    return min;
//    }
}
