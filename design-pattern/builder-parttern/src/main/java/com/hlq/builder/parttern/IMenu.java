package com.hlq.builder.parttern;

/**
 * @program: Imenu
 * @author: hanLinQi
 * @create: 2022-02-28 15:04
 **/
public interface IMenu {

    IMenu appendCeiling(Matter matter); // 吊顶

    IMenu appendCoat(Matter matter);    // 涂料

    IMenu appendFloor(Matter matter);   // 地板

    IMenu appendTile(Matter matter);    // 地砖

    String getDetail();                 // 明细

}
