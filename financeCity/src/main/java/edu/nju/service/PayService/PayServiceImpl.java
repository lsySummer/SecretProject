package edu.nju.service.PayService;

import edu.nju.service.BaseService.BaseFunctionService;
import edu.nju.service.POJO.Payment;

import java.util.List;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
public class PayServiceImpl extends BaseFunctionService implements PayService {

    @Override
    public boolean bindCards() {
        return false;
    }

    @Override
    public boolean payForProducts(List<Payment> payments) {
        return false;
    }
}