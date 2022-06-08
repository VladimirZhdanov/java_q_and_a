package com.homel.preparation.oop.test;

public class Instance {

   private static class A {

       final int a;

       public A(int a) {
           this.a = a;
       }
   }

   private static class A1 extends A {
       final int a;

       public A1(int a, int a1) {
           super(a);
           this.a = a1;
       }
   }

    public static void main(String[] args) {
        A a = new A(1);

        A1 a1 = new A1(1, 2);

        System.out.println(a1.a);

        System.out.println(a1 instanceof A);
        System.out.println(a instanceof A1);

        System.out.println(a.getClass().getName().equals(a1.getClass().getName()));
    }
}
