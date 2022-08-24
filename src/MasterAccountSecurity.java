public class MasterAccountSecurity {
    protected String masterAccountName;
    protected String masterAccountPassword;

    public MasterAccountSecurity(String masterAccountName, String masterAccountPassword){
        this.masterAccountName = masterAccountName;
        this.masterAccountPassword = masterAccountPassword;
    }

    public String getMasterAccountName() {
        return masterAccountName;
    }

    public void setMasterAccountName(String masterAccountName) {
        this.masterAccountName = masterAccountName;
    }

    public String getMasterAccountPassword() {
        return masterAccountPassword;
    }

    public void setMasterAccountPassword(String masterAccountPassword) {
        this.masterAccountPassword = masterAccountPassword;
    }
}
