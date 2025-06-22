package com.qingfan.thrift.server;

import com.qingfan.thrift.iface.CouponService;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

public class ThriftCouponServer {

    public static void main(String[] args) {
        try {
            CouponService.Processor<CouponService.Iface> processor = new CouponService.Processor<>(new CouponServiceImpl());
            TServerTransport serverTransport = new TServerSocket(9090);
            TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));
//            System.out.println("Coupon Thrift Server started on port 9090");
            server.serve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
