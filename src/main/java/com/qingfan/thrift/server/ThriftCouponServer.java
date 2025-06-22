package com.qingfan.thrift.server;

import com.qingfan.thrift.iface.CouponService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

public class ThriftCouponServer {

    public static void main(String[] args) {
        try {
            TServerTransport serverTransport = new TServerSocket(9090);
            TBinaryProtocol.Factory protocolFactory = new TBinaryProtocol.Factory();

            CouponService.Processor<CouponService.Iface> processor =
                    new CouponService.Processor<>(new CouponServiceImpl());

            TServer server = new TThreadPoolServer(
                    new TThreadPoolServer.Args(serverTransport)
                            .processor(processor)
                            .protocolFactory(protocolFactory)
            );

            System.out.println("Coupon Thrift Server started on port 9090");
            server.serve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
