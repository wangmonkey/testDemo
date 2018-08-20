package com.wang.demotest;

import org.junit.Test;

public class FunctionInterfaceTest implements FunctionInterface {
    @Override
    public void test() {

    }

    @Test
    public void testLambda(){
        System.out.println("hello,world !");
    }
}
