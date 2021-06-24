public class tester {


    public static void main(String[] args) {
        CompleteLinkedList.Node node = null;
        int[] keys = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        for (int key : keys)
            node = CompleteLinkedList.__add_(node, key);
        CompleteLinkedList.__print__(node);
        System.out.println();
        node = CompleteLinkedList.__rotate__(node, 2);
        CompleteLinkedList.__print__(node);
        System.out.println();
        CompleteLinkedList.__print__(CompleteLinkedList.__clone__(node));
        System.out.println();
        System.out.println(CompleteLinkedList.__palindrome__(node));
        System.out.println();
        System.out.println(CompleteLinkedList.__loopDetection__(node));

    }

}
