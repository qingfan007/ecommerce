package com.simple.ecommerce.mysql.service;

import com.qingfan.thrift.iface.CouponService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

@Service
public class CouponThriftClientService {

    @Value("${coupon.thrift.host}")
    private String thriftHost;

    @Value("${coupon.thrift.port}")
    private int thriftPort;

    public boolean validateCoupon(String code) throws Exception {
        try (TTransport transport = new TSocket(thriftHost, thriftPort)) {
            transport.open();
            TBinaryProtocol protocol = new TBinaryProtocol(transport);
            CouponService.Client client = new CouponService.Client(protocol);
            return client.validateCoupon(code);
        }
    }

    public double calculateDiscount(String code, double amount) throws Exception {
        try (TTransport transport = new TSocket(thriftHost, thriftPort)) {
            transport.open();
            TBinaryProtocol protocol = new TBinaryProtocol(transport);
            CouponService.Client client = new CouponService.Client(protocol);
            return client.calculateDiscount(code, amount);
        }
    }

}
