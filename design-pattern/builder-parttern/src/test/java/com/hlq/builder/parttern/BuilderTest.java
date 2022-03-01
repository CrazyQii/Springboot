package com.hlq.builder.parttern;

import static org.junit.Assert.*;

public class BuilderTest {

    private Builder builder = new Builder();

    @org.junit.Test
    public void levelOne() {
        // 豪华欧式
        System.out.println(builder.levelOne(132.52D).getDetail());
        // 轻奢田园
        System.out.println(builder.levelTwo(98.25D).getDetail());
        // 现代简约
        System.out.println(builder.levelThree(85.43D).getDetail());
    }
}