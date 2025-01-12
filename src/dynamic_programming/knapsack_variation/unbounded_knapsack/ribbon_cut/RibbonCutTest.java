package dynamic_programming.knapsack_variation.unbounded_knapsack.ribbon_cut;

public class RibbonCutTest {

    public static void main(String... args){
        RibbonCut ribbonCut = new RibbonCut();
        RibbonCutTopDown ribbonCutTopDown = new RibbonCutTopDown();
        RibbonCutBottomUp ribbonCutBottomUp = new RibbonCutBottomUp();

        int[] arr = new int[]{2, 3};

        System.out.println(ribbonCut.countRibbons(arr, arr.length, 7));
        System.out.println(ribbonCutTopDown.countRibbons(arr, arr.length, 8));
        System.out.println(ribbonCutBottomUp.countRibbons(arr, arr.length, 8));
    }
}
