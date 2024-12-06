package merge_intervals.tasks_min_machines;

import java.util.ArrayList;
import java.util.List;

public class MinMachinesTest {

    public static void main(String... args){
        MinMachines minMachines = new MinMachines();
        List<List<Integer>> tasksList = new ArrayList<>();
//        List<Integer> list = new ArrayList<>();
//        list.add(2);
//        list.add(5);
//        tasksList.add(list);
//        tasksList.add(list);
//        tasksList.add(list);
//        tasksList.add(list);

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(7);
        List<Integer> list2 = new ArrayList<>();
        list2.add(8);
        list2.add(13);
        List<Integer> list3 = new ArrayList<>();
        list3.add(5);
        list3.add(6);
        List<Integer> list4 = new ArrayList<>();
        list4.add(10);
        list4.add(14);
        List<Integer> list5 = new ArrayList<>();
        list5.add(6);
        list5.add(7);

        tasksList.add(list1);
        tasksList.add(list2);
        tasksList.add(list3);
        tasksList.add(list4);
        tasksList.add(list5);


        System.out.println(minMachines.getMinMachines(tasksList));
    }
}
