package two_heaps.max_capital;

public class MaximizeCapitalTest {

    public static void main(String[] args){
        MaximizeCapitalBruteForce maximizeCapital = new MaximizeCapitalBruteForce();
        int[] projectCapital = new int[]{0,1,2};
        int[] projectProfit = new int[]{1,2,3};
        int initialCapital = 1;
        int maxProjects =2;

        int result;

//       result = maximizeCapital.maximizeCapital(projectCapital, projectProfit,maxProjects, initialCapital);
//       System.out.println(result);

//        System.out.println("result 2 is");

        MaximizeCapital maximizeCapital1 = new MaximizeCapital();

        result = maximizeCapital1.maximizeCapital(projectCapital, projectProfit, maxProjects, initialCapital);

        System.out.println(result);

    }
}
