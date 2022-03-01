package com.hlq.factory.partern.factory.adapter;

import com.hlq.factory.partern.factory.adapter.impl.EgmAdapter;
import com.hlq.factory.partern.factory.adapter.impl.IrrAdapter;

import java.util.Arrays;

import static org.junit.Assert.*;

public class JDKInvocationHandlerTest {

    @org.junit.Test
    public void invoke() throws Exception {
        ICacheAdapter proxy_egm = JDKProxy.getProxy(EgmAdapter.class, new EgmAdapter());
        proxy_egm.set("hanlinqi", "123546");
        proxy_egm.get("hanlinqi");
        proxy_egm.get("hlq");
        ICacheAdapter proxy_irr = JDKProxy.getProxy(IrrAdapter.class, new IrrAdapter());
        proxy_irr.set("hanlinqi", "123546");
        proxy_irr.get("hanlinqi");
        proxy_irr.get("hlq");
    }

}