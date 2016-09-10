package edu.nju.service.AssetManagementService;

import edu.nju.service.ExceptionsAndError.NotLoginException;
import edu.nju.service.Sessions.FinanceCityUser;
import edu.nju.vo.CurrentInvestmentVO;
import edu.nju.vo.TradeHistoryListVO;
import org.springframework.stereotype.Service;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
@Service
public interface AssetManagementService {

    /**
     * get InvestProductVOList
     * @return investProduct
     */
    CurrentInvestmentVO getInvestProductVOList(FinanceCityUser financeCityUser);

    /**
     * get trad history
     * @return trad history
     * @throws NotLoginException
     */
    TradeHistoryListVO getTradeHistory(FinanceCityUser financeCityUser);


}
