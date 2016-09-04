package edu.nju.action;

import edu.nju.service.ExceptionsAndError.ErrorManager;
import edu.nju.service.SearchService.SearchService;
import edu.nju.service.ServiceManagerImpl;

import java.util.List;

/**
 * Created by Sun YuHao on 2016/9/4.
 */
public class SearchAction extends BaseAction {
    @SuppressWarnings("unchecked")
    public String getInstitutionList() {
        //TODO:set category
        String productCategory = "";

        SearchService searchService = ServiceManagerImpl.getInstance().getSearchService();
        List<String> institutionList = searchService.getInstitutionNameList(productCategory);

        if (institutionList == null) {
            ErrorManager.setError(request, ErrorManager.errorDataNotFound);
            session.put("institutionList", new String[0]);
        }
        else {
            ErrorManager.setError(request, ErrorManager.errorNormal);
            session.put("institutionList", institutionList.toArray());
        }

        return SUCCESS;
    }
}
