package nz.co.alumi.designSmart.timber.errorhandler;

public class Error {

  private String errCode;
  private String errDesc;

  public Error(String errCode, String errDesc) {
    this.errCode = errCode;
    this.errDesc = errDesc;
  }

  public String getErrCode() {
    return this.errCode;
  }

  public void setErrCode(String errCode) {
    this.errCode = errCode;
  }

  public String getErrDesc() {
    return this.errDesc;
  }

  public void setErrDesc(String errDesc) {
    this.errDesc = errDesc;
  }
}