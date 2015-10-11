namespace java info.developerblog.services.user

include "auth.thrift"

struct TFee {
    1: required i32 fee
}

service TFeeService {
    TFee calculateFee(1: required auth.TUser user, 2: required i32 hippoCount)
}