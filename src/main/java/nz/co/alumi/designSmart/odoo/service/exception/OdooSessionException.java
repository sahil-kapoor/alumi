package nz.co.alumi.designSmart.odoo.service.exception;

public class OdooSessionException extends Exception{

    String message;
  public OdooSessionException (String str)
  {

    super(str);
    message=str;
  }

   public String toString(){
      return ("MyException message: "+message) ;
    }
  }


