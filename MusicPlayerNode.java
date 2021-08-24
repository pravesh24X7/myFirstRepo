package files_of_java;

public class MusicPlayerNode {

    static void traverse(DoublyLinkedList node) {
        if (node == null) return;
        var tmpNode = node;
        while (tmpNode.link != null) {
            traverse(tmpNode.node);
            tmpNode = tmpNode.link;
        }
    }

    static DoublyLinkedList add(DoublyLinkedList nodeOfDLL, CircularDoublyLinkedList nodeOfCDLL) {
        if (nodeOfDLL == null) {
            return new DoublyLinkedList(nodeOfCDLL);
        }

        var tmpNode = nodeOfDLL;
        while (tmpNode.link != null) {
            tmpNode = tmpNode.link;
        }

        var newNode = new DoublyLinkedList(nodeOfCDLL);
        tmpNode.link = newNode;
        newNode.prev = tmpNode;

        return nodeOfDLL;
    }

    static void traverse(CircularDoublyLinkedList node) {
        var newNode = node;
        if (newNode == null) return;
        while (newNode.link != node.prev) {
            System.out.print(newNode.item + " " );
            newNode = newNode.link;
        }
        System.out.print(newNode.item);
    }

    static CircularDoublyLinkedList add(CircularDoublyLinkedList node, int item) {
        if (node == null) {
            return new CircularDoublyLinkedList(item);
        }

        var tmpNode = node;
        while (tmpNode.link != node.prev) {
            tmpNode = tmpNode.link;
        }

        CircularDoublyLinkedList newNode = new CircularDoublyLinkedList(item);
        newNode.link = node.prev;
        tmpNode.link = newNode;
        newNode.prev = tmpNode;
        node.prev = newNode;

        return node;
    }

    static class CircularDoublyLinkedList {
        int item;
        CircularDoublyLinkedList prev;
        CircularDoublyLinkedList link;

        CircularDoublyLinkedList(int item) {
            this.item = item;
            link = null;
            prev = null;
        }




    }

    static class DoublyLinkedList {
        CircularDoublyLinkedList node;
        DoublyLinkedList prev;
        DoublyLinkedList link;

        DoublyLinkedList(CircularDoublyLinkedList node) {
            this.node = node;
            link = null;
            prev = null;
        }

    }

}
