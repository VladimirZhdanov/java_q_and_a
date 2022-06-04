package com.homel.interviews.luxsoft;

//Дан односвязный список , найти n элемент с конца (элементов 1_500_300_001 например)
public class FindNElementFromLinkedList {

    public static void main(String[] args) {
        LinkedList llist = new LinkedList();
        llist.push(20);
        llist.push(4);
        llist.push(15);
        llist.push(35);

        solution1(llist.head, 1);
    }

    static void solution1(Node head, int n) {
        int size = 0;
        Node temp = head;

        while (temp != null) {
            temp = temp.next;
            size++;
        }

        if (size < n) return;

        temp = head;

        for (int i = 1; i < size - n + 1; i++) {
            temp = temp.next;
        }

        System.out.println(temp.data);
    }

    void solution2(Node head, int n) {
        Node main = head;
        Node ref = head;

        int count = 0;
        if (head != null) {
            while (count < n) {
                if (ref == null) {
                    System.out.println(n + " is greater than the no of nodes in the list");
                    return;
                }
                ref = ref.next;
                count++;
            }

            if (ref == null) {
                System.out.println("Node no. " + n + " from last is " + head.data);
            } else {
                while (ref != null) {
                    main = main.next;
                    ref = ref.next;
                }
                System.out.println("Node no. " + n + " from last is " + main.data);
            }
        }
    }

    static class LinkedList {
        Node head;

        public void push(int new_data) {
            Node new_node = new Node(new_data);
            new_node.next = head;
            head = new_node;
        }
    }

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
}
