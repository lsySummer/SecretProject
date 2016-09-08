package edu.nju.service.InvestAdvisorService;

import edu.nju.model.UserTemperPrefer;
import edu.nju.service.ExceptionsAndError.NotAllConfigurationSetException;
import edu.nju.service.ExceptionsAndError.NotLoginException;
import edu.nju.service.POJO.InvestResult;
import edu.nju.service.SearchService.SearchService;
import edu.nju.service.Sessions.FinanceCityUser;
import edu.nju.vo.TemperPreferVO;
import org.springframework.stereotype.Service;


/**
 * Created by Sun YuHao on 2016/7/25.
 */
@Service
public interface InvestAdvisorService {
    /**
     * set preference
     *
     * @param temperPreferVO preference .
     * @return if it's successful
     */
    boolean setTemperPrefer(TemperPreferVO temperPreferVO, FinanceCityUser financeCityUser) throws NotLoginException;

    /**
     * get temper preference
     * @return temper preference
     */
    TemperPreferVO getTemperPreferVO(FinanceCityUser financeCityUser) throws NotLoginException;

    /**
     * create investment portfolio
     * @param preference
     * @return invest result
     * @throws NotAllConfigurationSetException
     */
    InvestResult createInvestmentPortFolio(UserTemperPrefer preference) throws NotAllConfigurationSetException;

    /**
     * bind search service
     * @param searchService .
     */
    void bindSearchService(SearchService searchService);
}
