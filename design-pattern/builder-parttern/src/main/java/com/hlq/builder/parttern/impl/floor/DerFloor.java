package com.hlq.builder.parttern.impl.floor;

import com.hlq.builder.parttern.Matter;

import java.math.BigDecimal;

/**
 * @program: DerFloor
 * @description:
 * @author: hanLinQi
 * @create: 2022-02-28 15:37
 **/

public class DerFloor implements Matter {
    @Override
    public String scene() {
        return "地板";
    }

    @Override
    public String brand() {
        return "德尔(Der)";
    }

    @Override
    public String model() {
        return "A+";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal(119);
    }

    @Override
    public String desc() {
        return "DER德尔集团是全球领先的专业木地板制造商，北京2008年奥运会家装和公装地板供应商";
    }
}
