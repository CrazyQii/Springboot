package com.hlq.builder.parttern;

import com.hlq.builder.parttern.impl.ceiling.LevelOneCeiling;
import com.hlq.builder.parttern.impl.ceiling.LevelTwoCeiling;
import com.hlq.builder.parttern.impl.coat.DuluxCoat;
import com.hlq.builder.parttern.impl.coat.LiBangCoat;
import com.hlq.builder.parttern.impl.floor.ShengXiangFloor;
import com.hlq.builder.parttern.impl.tile.DongPengTile;
import com.hlq.builder.parttern.impl.tile.MarcoPoloTile;

import java.math.BigDecimal;

/**
 * @program: Builder
 * @description:
 * @author: hanLinQi
 * @create: 2022-02-28 15:51
 **/

public class Builder {

    public IMenu levelOne(Double area) {
        return new DecorationPackageController(new BigDecimal(area), "豪华欧式")
                .appendCeiling(new LevelTwoCeiling())    // 吊顶，二级顶
                .appendCoat(new DuluxCoat())             // 涂料，多乐士
                .appendFloor(new ShengXiangFloor());     // 地板，圣象
    }

    public IMenu levelTwo(Double area){
        return new DecorationPackageController(new BigDecimal(area), "轻奢田园")
                .appendCeiling(new LevelTwoCeiling())   // 吊顶，二级顶
                .appendCoat(new LiBangCoat())           // 涂料，立邦
                .appendTile(new MarcoPoloTile());       // 地砖，马可波罗
    }

    public IMenu levelThree(Double area){
        return new DecorationPackageController(new BigDecimal(area), "现代简约")
                .appendCeiling(new LevelOneCeiling())   // 吊顶，二级顶
                .appendCoat(new LiBangCoat())           // 涂料，立邦
                .appendTile(new DongPengTile());        // 地砖，东鹏
    }
}
