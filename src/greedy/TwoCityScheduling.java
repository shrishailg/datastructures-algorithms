package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class TwoCityScheduling {

    public static void main(String[] args){
        int[][] costs = new int[][]{{259,770}, {448,54}, {926,667}, {184,139}, {840,118}, {577,469}};
        System.out.println(twoCityScheduling(costs));
    }

    public static int twoCityScheduling(int[][] costs) {
        int totalCost = 0;

        Arrays.sort(costs, (a,b) -> (a[0]-a[1]) - (b[0]-b[1]));


        for(int i = 0; i < costs.length/2 ; i++) {
            totalCost += costs[i][0] + costs[costs.length - i - 1][1];
        }

        return totalCost;
    }
}
