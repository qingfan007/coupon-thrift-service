namespace java com.qingfan.thrift.iface

service CouponService {
    bool validateCoupon(1:string code)
    double calculateDiscount(1:string code, 2:double amount)
}