package coreJava;
import java.util.ArrayList;
import java.util.List;

public class TestClass {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(1000000);
        fillUp(list);
        arrangeIntegers(list);
    }

    private static void arrangeIntegers(List<Integer> list) {
        System.out.println("arrangeIntegers function called");
        // this will sort using insertion sort
        long initValue = System.currentTimeMillis();
        for (int i=1; i<list.size(); i++) {
            int j = i;
            while (j > 0 && list.get(j-1) > list.get(j)) {
                var tmp = list.get(j-1);
                list.add(j-1, list.get(j));
                list.add(j, tmp);
                j--;
            }
        }
        System.out.println(System.currentTimeMillis() - initValue);
    }

    private static void fillUp(List<Integer> list) {
        System.out.println("fillUp function called");
        long initValue = System.currentTimeMillis();
        int value = list.size();
        for (int i=0; i<list.size(); i++) {
            list.add(value--);
        }
        System.out.println(System.currentTimeMillis() - initValue);
    }

}
