package edu.nju.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.nju.model.ProductBank;
import edu.nju.service.AssetManagementService.AssetManagementService;
import edu.nju.service.CategoryAndProduct.Product;
import edu.nju.service.CategoryAndProduct.ProductCategoryManager;
import edu.nju.service.ExceptionsAndError.ErrorManager;
import edu.nju.service.ExceptionsAndError.NoSuchProductException;
import edu.nju.service.ExceptionsAndError.NotLoginException;
import edu.nju.service.InvestAdvisorService.InvestAdvisorService;
import edu.nju.service.POJO.Investment_portfolio;
import edu.nju.service.POJO.RecommendVOFactory;
import edu.nju.service.POJO.SimpleTradeInfo;
import edu.nju.service.POJO.TradeInfoWithCheckCode;
import edu.nju.service.SearchService.SearchService;
import edu.nju.service.Sessions.FinanceCityUser;
import edu.nju.service.UserService.UserService;
import edu.nju.vo.CurrentInvestmentVO;
import edu.nju.vo.ProductDetailVO;
import edu.nju.vo.RecommendedPortfolioVO;
import edu.nju.vo.TradeHistoryListVO;


@Controller
public class Assets extends BaseAction{
	@Autowired
	SearchService searchService;
	@Autowired
	InvestAdvisorService investAdvisorService;
	@Autowired
	AssetManagementService assetManagementService;
	@Autowired
	UserService userService;

	public String execute() throws ServletException, IOException {
		try {
			return SUCCESS;
		}
		catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	@SuppressWarnings("unchecked")
	public String getRecommend(){

		try {
			FinanceCityUser financeCityUser = (FinanceCityUser)session.get("user");
			if (financeCityUser == null) {
				throw new NotLoginException();
			}

			//UserTemperPrefer userTemperPrefer = userService.getUserTemper(financeCityUser);
			//List<TradeInfoWithCheckCode> lists = investAdvisorService.createInvestmentPortFolio(userTemperPrefer);
			List<TradeInfoWithCheckCode> lists = getDemo();
			RecommendedPortfolioVO recommendedPortfolioVO = RecommendVOFactory.createRecommend(lists, searchService, investAdvisorService);
			session.put("investResult", recommendedPortfolioVO);

			return SUCCESS;
		}
		catch (NotLoginException e) {
			e.printStackTrace();
			ErrorManager.setError(request, ErrorManager.errorNotLogin);
			return LOGIN;
		}
		catch (NoSuchProductException n) {
			n.printStackTrace();
			ErrorManager.setError(request, ErrorManager.errorNoSuchProduct);
			return ERROR;
		}
		/*
		catch (NotAllConfigurationSetException t) {
			t.printStackTrace();
			ErrorManager.setError(request, ErrorManager.errorUserInfoNotSet);
			return ERROR;
		}
		catch (InvalidUserPreferenceException i) {
			i.printStackTrace();
			ErrorManager.setError(request, ErrorManager.errorInvalidUserPreference);
			return ERROR;
		}
		*/
	}

	@SuppressWarnings("unchecked")
	public String getProduct(){
		try {
			int pid = Integer.valueOf(request.getParameter("pid"));
			String days_s = request.getParameter("days");
			int days = Integer.MAX_VALUE;
			if (days_s != null) {
				days = Integer.valueOf(days_s);
			}

			ProductDetailVO productDetailVO = new ProductDetailVO();
			Product product = searchService.getProductByID(pid);

			productDetailVO.setType(product.getCategory().getChineseName());
			productDetailVO.setData(product.getProduct());
			if (product.getCategory().belongTo(ProductCategoryManager.categoryBank) &&
					ProductCategoryManager.ifNetBankProduct((ProductBank)product.getProduct())) {
				productDetailVO.setHistory(searchService.getBankValueHistory(product.getID(), days));
			}
			if (product.getCategory().belongTo(ProductCategoryManager.categoryFund)) {
				productDetailVO.setHistory(searchService.getFundValueHistory(product.getID(), days));
			}

			session.put("productDetail", productDetailVO);
			ErrorManager.setError(request, ErrorManager.errorNormal);

			return SUCCESS;
		}
		catch (Exception e) {
			e.printStackTrace();
			ErrorManager.setError(request, ErrorManager.errorInvalidParameter);
			return ERROR;
		}
	}

	@SuppressWarnings("unchecked")
	public String getCurrentInvestment() {
		try {
			FinanceCityUser financeCityUser = (FinanceCityUser) session.get("user");
			if (financeCityUser == null) {
				throw new NotLoginException();
			}

			CurrentInvestmentVO currentInvestment = assetManagementService.getInvestProductVOList(financeCityUser);
			List<Investment_portfolio> investList=currentInvestment.getInvestmentPortfolioList();
			request.setAttribute("investList", investList);

			return SUCCESS;
		}
		catch (NotLoginException n) {
			n.printStackTrace();
			ErrorManager.setError(request, ErrorManager.errorNotLogin);
			return LOGIN;
		}
		catch (Exception e) {
			e.printStackTrace();
			ErrorManager.setError(request, ErrorManager.errorInnerDataError);
		}

		return ERROR;
	}

	@SuppressWarnings("unchecked")
	public String getTradeHistory() {
		try {
			FinanceCityUser financeCityUser = (FinanceCityUser)session.get("user");
			if (financeCityUser == null) {
				throw new NotLoginException();
			}

			TradeHistoryListVO tradeHistoryVO = assetManagementService.getTradeHistory(financeCityUser);
			session.put("tradHistory", tradeHistoryVO);
			ErrorManager.setError(request, ErrorManager.errorNormal);
			return SUCCESS;
		}
		catch (NotLoginException n) {
			n.printStackTrace();
			ErrorManager.setError(request, ErrorManager.errorNotLogin);
		}
		catch (Exception e) {
			e.printStackTrace();
			ErrorManager.setError(request, ErrorManager.errorInnerDataError);
		}

		return ERROR;
	}

	List<TradeInfoWithCheckCode> getDemo() {
		List<TradeInfoWithCheckCode> list = new ArrayList<>();
		TradeInfoWithCheckCode tradeInfoWithCheckCode = new TradeInfoWithCheckCode();
		tradeInfoWithCheckCode.setCheckCode("adfasd13sda23dasd");
		List<SimpleTradeInfo> simpleTradeInfoList = new ArrayList<>();

		//product1
		SimpleTradeInfo simpleTradeInfo = new SimpleTradeInfo();
		simpleTradeInfo.setProductId(1);
		simpleTradeInfo.setAmount(10000);
		simpleTradeInfoList.add(simpleTradeInfo);
		//product2
		simpleTradeInfo = new SimpleTradeInfo();
		simpleTradeInfo.setProductId(10000001);
		simpleTradeInfo.setAmount(2000000);
		simpleTradeInfoList.add(simpleTradeInfo);

		tradeInfoWithCheckCode.setTradeInfos(simpleTradeInfoList);
		list.add(tradeInfoWithCheckCode);

		return list;
	}
}
