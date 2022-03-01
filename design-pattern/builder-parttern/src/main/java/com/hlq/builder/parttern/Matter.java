package com.hlq.builder.parttern;

import java.math.BigDecimal;

/**
 * @program: Matter
 * @author: hanLinQi
 * @create: 2022-02-28 15:05
 **/
public interface Matter {

    String scene(); // 场景：地板、地砖、涂料、吊顶

    String brand(); // 品牌

    String model(); // 型号

    BigDecimal price(); // 价格

    String desc(); //描述
}
