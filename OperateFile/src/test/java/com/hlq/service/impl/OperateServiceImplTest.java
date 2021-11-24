package com.hlq.service.impl;

import com.hlq.entity.FileInfoBase64;
import com.hlq.service.OperateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OperateServiceImplTest {

    // 保存文件路径
    private static final String path = System.getProperty("user.dir") + "\\src\\main\\resources\\";

    @Resource
    private OperateService operateService;

    @Test
    public void should_save_base64_file_to_local_resource() {
        // base64转文件，并保存本地
        FileInfoBase64 fileInfoBase64 = new FileInfoBase64();
        fileInfoBase64.setFileName("test.md");
        fileInfoBase64.setFileContent("IyMgS2Fma2Hmtojmga/kuKLlpLHkuI7nsr7noa7mtojotLnkuIDmrKHmgKcNCg0KIyMjIOa2iOaBr+S4ouWkseeahOWcuuaZrw0KDQpLYWZrYSBQcm9kdWNlciDkvb/nlKjlj5HpgIHljbPlv5jnmoTmlrnlvI/lj5HpgIHmtojmga/vvIzosIPnlKhgcHJvZHVjZXIuc2VuZCgpYOaWueazleadpeWPkemAgea2iOaBr++8jOWPkemAgea2iOaBr+WQjuS8mueri+WNs+i/lOWbnu+8jOS9huaYr+W5tuS4jeiDveS/neivgea2iOaBr+WPkemAgeaIkOWKnw0KDQrlpoLmnpzlnKjlj5HpgIHov4fnqIvkuK3lj5HnlJ/kuobnvZHnu5zmipbliqjvvIzmtojmga/lsLHkvJrkuKLlpLHvvJvlpoLmnpzmtojmga/mnKzouqvkuI3nrKblkIjopoHmsYLvvIzlpoLotoXov4dgYnJva2VyYOeahOaJv+i9veiDveWKm++8iOa2iOaBr+WkquWkp++8jOWPr+S7pemHh+eUqOWIhuWMheeahOW9ouW8j++8iQ0KDQrop6PlhrPpl67popjmlrnms5XvvJrkvb/nlKggYFByb2R1Y2VyYCDnmoTmnInlm57osIPnmoTmlrnms5XpgJrnn6Xmtojmga/vvIzljbMgYFByb2R1Y2VyLnNlbmQobXNnLCBjYWxsYmFjaylgIO+8jOWbnuiwg+aWueazleS8muWRiuivieaIkeS7rOa2iOaBr+aYr+WQpuWPkemAgeaIkOWKnw0KDQojIyMjIOa2iOi0ueiAheS4ouWkseaVsOaNrg0KDQpDb25zdW1lcuerr+S4ouWksea2iOaBr+S4u+imgeS9k+eOsOWcqO+8muaLieWPluS6hua2iOaBr++8jOW5tuaPkOS6pOS6huS9jeenu++8jOS9huaYr+WcqOWkhOeQhua2iOaBr+eahOaXtuWAmeWHuueOsOS6huWuleacuuetieaVhemanO+8jOa2iOi0ueiAhemHjeeUn+WQju+8jOS8muS7juWJjemdouW3sue7j+aPkOS6pOi/h+eahOS4i+S4gOS4quS9jee9rue7p+e7rea2iOi0ue+8jOS5i+WJjeacquWkhOeQhuWujOaIkOeahOa2iOaBr+S4jeS8muWGjeasoeWkhOeQhu+8jOWNs+ebuOW9k+S6jua2iOi0ueiAheS4ouWkseS6hua2iOaBrw0KDQrop6PlhrPmlrnms5XvvJrlsIbmj5DkuqTkvY3np7vnmoTml7bpl7Tkv67mlLnkuLrlpITnkIbmtojmga/lrozmiJDlkI7vvIznoa7orqTmtojmga/lpITnkIblrozmiJDlkI7lho3mj5DkuqTlk43lupTnmoTkvY3np7vjgILov5nmoLfljbPkvb/lpITnkIbmtojmga/nmoTov4fnqIvkuK3lj5HnlJ/kuoblvILluLjvvIznlLHkuo7msqHmnInmj5DkuqTkvY3np7vvvIzkuIvkuIDmrKHnmoTmtojotLnov5jmmK/kvJrku47kuYvliY3nmoTkvY3np7vlpITnu6fnu63mtojotLnjgIINCg0KQ29uc3VtZXLmtojotLnmtojmga/ml7bvvIzlhbPpl63oh6rliqjmj5DkuqTkvY3np7vvvIznlLHlupTnlKjnqIvluo/miYvliqjmj5DkuqTkvY3np7sNCg0KIyMjIyBCcm9rZXLnq6/kuKLlpLHmlbDmja4NCg0KQnJva2Vy5Lii5aSx5raI5oGv5Li76KaB5L2T546w5Zyo77yaDQoNCjEuIOWOn+adpeeahEJyb2tlcuWuleacuuS6hu+8jOS9huaYr+mAieS4vuWHuuS4gOS4quiQveWQjuWkquWkmiBgTGVhZGVyYCDnmoQgYGJyb2tlcmAg5L2c5Li6IGBMZWFkZXJg77yM6YKj5LmI6L+Z5Lqb6JC95ZCO55qE5raI5oGv6YO95Lya5Lii5aSx77yM5Y+v5Lul56aB5q2i6L+Z5LqbIGB1bmNsZWFuYCDnmoQgYGJyb2tlcmAg56ue6YCJ5oiQ5Li6IGBMZWFkZXJgDQoyLiBLYWZrYeS9v+eUqOmhtee8k+WtmOacuuWItu+8jOWwhua2iOaBr+WGmeWFpemhtee8k+WtmOiAjOmdnuaMgeS5heWMluWIsOejgeebmO+8jOWwhuWIt+ebmOeahOW3peS9nOS6pOeUseaTjeS9nOezu+e7n+adpeWBmu+8jOS7peatpOadpeS/neivgemrmOaViOeOh+WSjOmrmOWQnuWQkOOAguS9huaYr+WmguaenOacieS4gOmDqOWIhueahOWIhumhtea2iOaBr+i/mOWcqOWIhumhtee8k+WtmOS4re+8jOacquaMgeS5heWMluWIsOejgeebmOS4re+8jOatpOaXtkJyb2tlcuWuleacuu+8jOmHjeWQr+WQjui/memDqOWIhueahOa2iOaBr+S8muS4ouWkse+8jOWPr+S7pemHh+eUqOWkmuWJr+acrOacuuWItumBv+WFjei/meS6m+a2iOaBr+S4ouWksQ0KDQojIyMg6YG/5YWN5raI5oGv5Lii5aSx5a6e6Le1DQoNCjEuIOS4jeS9v+eUqCBgcHJvZHVjZXIuc2VuZChtc2cpYCDvvIzogIzkvb/nlKggYHByb2R1Y2VyLnNlbmQobXNnLCBjYWxsYmFjaylgDQoyLiDorr7nva4gYGFja3MgPSBhbGxgICwgYWNrc+WPguaVsOaYryBgUHJvZHVjZXJgIOeahOS4gOS4quWPguaVsO+8jOS7o+ihqOWvueW3sue7j+aPkOS6pOa2iOaBr+eahOWumuS5ie+8jOWmguaenOiuvue9ruaIkGFsbO+8jOihqOekuuaJgOaciSBCcm9rZXIg5Ymv5pys6YO96KaB5o6l5pS25Yiw5raI5oGv5omN566XIOKAnOW3suaPkOS6pOKAne+8jOaYr+acgOmrmOetiee6p+eahCDigJzlt7Lmj5DkuqTigJ0g5qCH5YeGIA0KMy4g6K6+572uIGByZXRyaWVzYOS4uuS4gOS4qui+g+Wkp+eahOWAvO+8jGByZXRyaWVzYCDooajnpLpQcm9kdWNlcuWPkemAgea2iOaBr+WQjuWksei0peeahOmHjeivleasoeaVsO+8jOWmguaenOWPkeeUn+S6hue9kee7nOaKluWKqO+8jOWPr+S7pemAmui/h+mHjeivleacuuWItumHjeaWsOWPkemAgea2iOaBr++8jOmBv+WFjea2iOaBr+S4ouWksQ0KNC4g6K6+572uIGB1bmNsZWFuLmxlYWRlci5lbGVjdGlvbi5lbmFibGUgPSBmYWxzZWAgIOi/meaYr0Jyb2tlcuerr+eahOWPguaVsO+8jOihqOekuuWTquS6myBCcm9rZXIg5Y+v5Lul57K+6YCJ5oiQ5Li6IExlYWRlcu+8jOWmguaenOafkOS4gOS4quWIhuWMuuiQveWQjuWkquWkmueahCBgQnJva2VyIGDmiJDkuLogYExlYWRlcmAg77yM5b+F54S25Lya5a+86Ie05raI5oGv55qE5Lii5aSx77yM6YKj5LmI5bCx6ZyA6KaB6K6+572u5YC85Li6IGZhbHNl77yMIOmBv+WFjei/meagt+eahOeKtuWGteWPkeeUnw0KNS4g6K6+572uIGByZXBsaWNhdGlvbi5mYWN0b3IgPj0gM2DvvIxCcm9rZXLnq6/lj4LmlbDvvIzmr4/kuKrliIbljLrnmoTlia/mnKzmlbDlpKfkuo7nrYnkuo4z77yM6L+Z5piv5YaX5L2Z6YG/5YWN5pWw5o2u5Lii5aSxDQo2LiDorr7nva4gYG1pbi5pbnN5bmMucmVwbGljYXMgPjFg77yMQnJva2Vy56uv5Y+C5pWw77yM5o6n5Yi25raI5oGv6KKr5YaZ5YWl5aSa5bCR5Liq5Ymv5pys5omN6KGo56S64oCc5bey5o+Q5Lqk4oCdDQo3LiDnoa7kv50gYHJlcGxpY2F0aW9uLmZhY3RvciA+IG1pbi5pbnN5bmMucmVwbGljYXNgIO+8jOiLpeS4pOiAheebuOetie+8jOWImeWmguaenOacieS4gOS4quWJr+acrOaMguS6hu+8jOaVtOS4quWIhuWMuuWwseaXoOazleato+W4uOW3peS9nOS6huOAguaOqOiNkOiuvue9ruS4uu+8mmByZXBsaWNhdGlvbi5mYWN0b3IgPSBtaW4uaW5zeW5jLnJlcGxpY2FzICsgMWDvvJsNCjguIGBlbmFibGUuYXV0by5jb21taXQgPSBmYWxzZWDvvIxDb25zdW1lcuerr+WPguaVsO+8jOWFs+mXreS9jeenu+iHquWKqOaPkOS6pO+8jOS9v+eUqOaJi+WKqOaPkOS6pOeahOW9ouW8jw0KDQojIyMg57K+56Gu5LiA5qyh5raI6LS5DQoNCkthZmth6buY6K6k5o+Q5L6b55qE5raI5oGv5Y+v6Z2g5py65Yi25piv4oCc6Iez5bCR5LiA5qyh4oCd77yM5Y2z5raI5oGv5LiN5Lya5Lii5aSx44CC6IulYFByb2R1Y2VyYOa2iOaBr+ayoeacieWPkemAgeaIkOWKn++8jOmCo+S5iOS8muWGjeasoemHjeWPke+8jOiLpSBCcm9rZXIg56uv55qE5bqU562U5pyq5oiQ5Yqf5Y+R6YCB57uZIFByb2R1Y2VyIO+8iOWmgue9kee7nOaKluWKqO+8ie+8jFByb2R1Y2Vy5Lmf5Lya6L+b6KGM6YeN6K+V77yM5YaN5qyh5Y+R6YCB5raI5oGv77yM6YKj5LmI6L+Z5qC35bCx5Lya5a+86Ie05raI5oGv55qE6YeN5aSN5Y+R6YCBDQoNCkthZmth6YCa6L+H5Lik56eN5py65Yi256Gu5L+d5raI5oGv55qE57K+56Gu5LiA5qyh5raI6LS5DQoNCjEuIOW5guetieaApyhpZGVtcG90ZW5jZSkNCjIuIOS6i+WKoSh0cmFuc2FjdGlvbikNCg0KIyMjIyDluYLnrYnmgKcNCg0KKirlr7nmjqXlj6PnmoTlpJrmrKHosIPnlKjlkozlr7nmjqXlj6PnmoTkuIDmrKHosIPnlKjkuqfnlJ/nmoTnu5PmnpzmmK/kuIDoh7TnmoQqKu+8jEthZmthMC4xMS4wLjDniYjmnKzlvJXlhaXmraTnibnmgKfvvIzorr7nva7lj4LmlbAgYGVuYWJsZS5pZGVtcG90ZW5jZSA9IHRydWVg5Y2z5Y+v5oyH5a6aUHJvZHVjZXLnmoTluYLnrYnnrpfms5XjgILlvIDlkK/luYLnrYnnrpfms5XlkI7vvIxQcm9kdWNlcuS8muiHquWKqOi/m+ihjOWOu+mHjeWPkemAgeWkhOeQhu+8jOWunueOsOWPkemAgeiAheeahOW5guetieaAp++8jEthZmth5byV5YWl5LqGYFByb2R1Y2VyIGlkYO+8iFBJRO+8ieWSjOW6j+WIl+WPt++8iHNlcXVlbmNlIG51bWJlcu+8iQ0KDQrnlJ/kuqfogIXvvIhgcHJvZHVjZXJg77yJ6KKr5Yib5bu65pe25Lya55Sf5oiQ5LiA5LiqUElE77yI5a+55aSW6YCP5piO77yJ77yM5q+P5LiA5LiqUElE5Y+R6YCB5Yiw5q+P5LiA5Liq5YiG5Yy66YO95pyJ5a+55bqU55qE5bqP5YiX5Y+377yM6L+Z5Lqb5bqP5YiX5Y+35LuOMOW8gOWni+WNleiwg+mAkuWing0KDQpCcm9rZXLnq6/kvJrlr7nmr4/kuIDlr7k8UElELCDliIbljLo+57u05oqk5LiA5Liq5bqP5YiX5Y+3YFNOX29sZGDvvIzpkojlr7nnlJ/kuqfogIXlj5HpgIHov4fmnaXnmoTmtojmga/vvIzlr7nlhbbluo/liJflj7cgYFNOX25ld2Ag6L+b6KGM5Yik5pat77yM5bm25YGa55u45bqU5aSE55CGDQoNCuW9kyBgU05fbmV3YCA9IGBTTl9vbGRgICsgMSDml7bvvIxicm9rZXLmiY3kvJrmjqXmlLbmtojmga8NCg0K5b2TIGBTTl9uZXdgID4gYFNOX29sZGAgKyAxIOaXtu+8jOivtOaYjuacieaVsOaNruayoeacieWGmeWFpe+8jOWHuueOsOS6hua2iOaBr+S5seW6j+eahOeKtuWGte+8jOWvueW6lOeahOa2iOi0ueiAheS8muaKm+WHuiBgT3V0T2ZPcmRlclNlcXVlbmNlRXhjZXB0aW9uYA0KDQrlvZMgYFNOX25ld2AgPCBgU05fb2xkYCArIDEg5pe277yM6K+05piO5pWw5o2u6YeN5aSN5Y+R6YCB77yMYnJva2Vy55u05o6l5Lii5byD6K+l5raI5oGvDQoNCioq5rOo5oSP77ya5bqP5YiX5Y+36ZKI5a+5PFBJRCwg5YiG5Yy6Pu+8jOi/meaEj+WRs+edgOW5guetieeUn+S6p+iAheWPquiDveS/neivgeWNleS4quS4u+mimOeahOWNleS4gOWIhuWMuuWGhea2iOaBr+S4jemHjeWkje+8m+WFtuasoe+8jOWug+WPquiDveWunueOsOWNleS8muivneS4iueahOW5guetieaAp++8jOS4jeiDveWunueOsOi3qOS8muivneeahOW5guetieaAp++8jOi/memHjOeahOS8muivneWNs+WPr+S7peeQhuino+S4uu+8mlByb2R1Y2Vy6L+b56iL55qE5LiA5qyh6L+Q6KGM44CC5b2T6YeN5ZCv5LqGUHJvZHVjZXLov5vnqIvkuYvlkI7vvIzliJnluYLnrYnmgKfkv53or4HlsLHlpLHmlYjkuobjgIIqKg0KDQojIyMjIOS6i+WKoQ0KDQrluYLnrYnmgKfkuI3og73ot6jliIbljLrov5DkvZzvvIzkvYbmmK8gS2Fma2Eg55qE5LqL54mp5Y+v5Lul5byl6KGl6L+Z5Liq57y66Zm377yM5om56YeP55qE5L+h5oGv6KaB5LmI5YWo6YOo5YaZ5YWl77yM6KaB5LmI5YWo6YOo5aSx6LSl77yM5bm25LiU5ZyoIGBQcm9kdWNlcmAg6YeN5ZCv5ZCO5L6d54S26IO95aSf5L+d6K+B5raI5oGv55qE57K+56Gu5LiA5qyh5aSE55CGDQoNCiMjIyMjIFByb2R1Y2VyIOS6i+WKoeWunui3tQ0KDQoxLiBlbmFibGUuaWRlbXBvdGVuY2UgPSB0cnVlDQoNCjIuIOiuvue9rlByb2R1Y2Vy56uv5Y+C5pWwdHJhbnNjYXRpb25hbC5pZOOAguacgOWlveS4uuWFtuiuvue9ruS4gOS4quacieaEj+S5ieeahOWQjeWtl+OAgg0KDQozLiDosIPnlKjkuovliqFBUEkNCg0KYGBgamF2YQ0KcHJvZHVjZXIuaW5pdFRyYW5zYWN0aW9ucygpOw0KdHJ5IHsNCglwcm9kdWNlci5iZWdpblRyYW5zYWN0aW9uKCk7DQogCXByb2R1Y2VyLnNlbmQocmVjb3JkMSk7DQogICAgcHJvZHVjZXIuc2VuZChyZWNvcmQyKTsNCglwcm9kdWNlci5jb21taXRUcmFuc2FjdGlvbigpOw0KfSBjYXRjaCAoS2Fma2FFeGVjcHRpb24gZSkgew0KCXByb2R1Y2VyLmFib3J0VHJhbnNhY3Rpb24oKTsNCn0NCmBgYA0KDQrlrp7pmYXkuIrvvIzljbPkvb/lhpnlhaXlpLHotKXvvIxLYWZrYeS5n+S8muWwhuWug+S7rOWGmeWFpeWIsOW6leWxgueahOaXpeW/l+S4re+8jOS5n+WwseaYr+ivtENvbnN1bWVy6L+Y5piv5Lya55yL5Yiw6L+Z5Lqb5raI5oGv77yM5YW35L2TQ29uc3VtZXLnq6/or7vlj5bkuovliqHlnotQcm9kdWNlcuWPkemAgeeahOa2iOaBr+mcgOimgeWPpuihjOmFjee9ruOAgg0KDQojIyMjIyBDb25zdW1lcuS6i+WKoeWunui3tQ0KDQror7vlj5bkuovliqHlnosgUHJvZHVjZXIg5Y+R6YCB55qE5raI5oGv5pe277yMQ29uc3VtZXIg56uv55qEIGBpc29sYXRpb24ubGV2ZWxgIOWPguaVsOihqOW+geedgOS6i+WKoeeahOmalOemu+e6p+WIq++8jOWNs+WGs+WumuS6hiBDb25zdW1lciDku6XmgI7moLfnmoTnuqfliKvljrvor7vlj5bmtojmga/jgILor6Xlj4LmlbDmnInku6XkuIvkuKTkuKrlj5blgLzvvJogDQoNCnJlYWRfdW5jb21taXR0ZWTvvJrpu5jorqTlgLzvvIzooajpnaIgQ29uc3VtZXIg6IO95aSf6K+75YiwS2Fma2HlhpnlhaXnmoTku7vkvZXmtojmga/vvIzkuI3orrrkuovliqHlnosgUHJvZHVjZXIg5piv5ZCm5q2j5bi45o+Q5Lqk5LqG5LqL5Yqh44CC5pi+54S277yM5aaC5p6c5ZCv55So5LqG5LqL5Yqh5Z6L55qEIFByb2R1Y2Vy77yM5YiZIENvbnN1bWVyIOerr+WPguaVsOWwseS4jeimgeS9v+eUqOivpeWAvO+8jOWQpuWImeS6i+WKoeaYr+aXoOaViOeahOOAgiANCg0KcmVhZF9jb21taXR0ZWTvvJrooajpnaIgQ29uc3VtZXIg5Y+q5Lya6K+75Y+W5LqL5Yqh5Z6LIFByb2R1Y2VyIOaIkOWKn+aPkOS6pOeahOS6i+WKoeS4reWGmeWFpeeahOa2iOaBr++8jOWQjOaXtu+8jOmdnuS6i+WKoeWei1Byb2R1Y2Vy5YaZ5YWl55qE5omA5pyJ5raI5oGv5a+5IENvbnN1bWVyIOS5n+aYr+WPr+ingeeahOOAgg0KDQojIyMg57K+56Gu5LiA5qyh5raI6LS55oC757uTDQoNCkthZmth5omA5o+Q5L6b55qE5raI5oGv57K+56Gu5LiA5qyh5raI6LS555qE5omL5q615pyJ5Lik5Liq77ya5bmC562J5oCnUHJvZHVjZXLlkozkuovliqHlnotQcm9kdWNlcuOAgiDluYLnrYnmgKdQcm9kdWNlcuWPquiDveS/neivgeWNleS8muivneOAgeWNleWIhuWMuuS4iueahOa2iOaBr+W5guetieaAp++8myDkuovliqHlnotQcm9kdWNlcuWPr+S7peS/neivgei3qOWIhuWMuuOAgei3qOS8muivnemXtOeahOW5guetieaAp++8myDkuovliqHlnotQcm9kdWNlcuWKn+iDveabtOS4uuW8uuWkp++8jOS9huaYr+WQjOaXtu+8jOWFtuaViOeOh+S5n+S8muavlOi+g+S9juS4i+OAgg==");
        operateService.readBase64File(fileInfoBase64, path);
    }

    @Test
    public void should_read_base64_file_from_local_resource() {
        // 文件转base64
        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\Kafka常见问题";
        String base64 = operateService.saveFileToBase64(path);
//        System.out.println(base64);
        // base64转文件，并保存本地
        FileInfoBase64 fileInfoBase64 = new FileInfoBase64();
        fileInfoBase64.setFileName("test2.pdf");
        fileInfoBase64.setFileContent(base64);
        operateService.readBase64File(fileInfoBase64, path);
    }
}