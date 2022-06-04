package com.homel.interviews.vtb.interfaces;

// Что произойдет при попытке выполнения данного кода:
public class TwoImpl implements Two {
    public void method2() {
        System.out.println("TwoImpl::method2");
    }

    public static void main(String[] args) {
        new TwoImpl().method1();
    }
}

//Ошибка компиляции
//На консоли появится «One::method1»
//На консоли появится «Two::method1»
