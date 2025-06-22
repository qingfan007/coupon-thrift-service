package com.qingfan.thrift.server;

import com.qingfan.thrift.iface.CouponService;
import org.apache.thrift.TException;

public class CouponServiceImpl implements CouponService.Iface {

    @Override
    public boolean validateCoupon(String code) throws TException {
        return code.equals("DISCOUNT10") || code.equals("WELCOME5");
    }

    @Override
    public double calculateDiscount(String code, double amount) throws TException {
        if (code.equals("DISCOUNT10")) return amount * 0.10;
        if (code.equals("WELCOME5")) return 5.0;
        return 0.0;
    }
}
