package com.hlq.builder.parttern.impl.ceiling;

import com.hlq.builder.parttern.Matter;

import java.math.BigDecimal;

/**
 * @program: LevelTwoCeiling
 * @description:
 * @author: hanLinQi
 * @create: 2022-02-28 15:34
 **/

public class LevelTwoCeiling implements Matter {

    @Override
    public String scene() {
        return "吊顶";
    }

    @Override
    public String brand() {
        return "装修公司自带";
    }

    @Override
    public String model() {
        return "二级顶";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal(850);
    }

    @Override
    public String desc() {
        return "两个层次的吊顶，二级吊顶高度一般就往下吊20cm，要是层高很高，也可增加每级的厚度";
    }
}
