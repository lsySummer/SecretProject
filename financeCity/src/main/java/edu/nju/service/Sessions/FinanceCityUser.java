package edu.nju.service.Sessions;

/**
 * Created by Sun YuHao on 2016/8/31.
 */
public class FinanceCityUser {
    private Integer ID;
    private String loginSession;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getLoginSession() {
        return loginSession;
    }

    public void setLoginSession(String loginSession) {
        this.loginSession = loginSession;
    }
}
