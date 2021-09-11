package nz.co.alumi.designSmart.odoo.service;

import com.odoojava.api.OdooXmlRpcProxy;
import com.odoojava.api.Session;
import nz.co.alumi.designSmart.odoo.service.exception.OdooSessionException;
import org.apache.xmlrpc.XmlRpcException;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

  private Session odooSession;

  public Session getOdooSession() throws XmlRpcException,OdooSessionException {

    if(odooSession==null || odooSession.getContext()==null){
      Session odooSession = new Session(OdooXmlRpcProxy.RPCProtocol.RPC_HTTPS,
          "alumi-test-20210906.odoo.com", 443, "alumi-test-20210906",
          "sahilkapoor1987@gmail.com", "Sahil@1987");
      if (odooSession.getServerVersion() != null) {
        try {
          odooSession.startSession();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }else{
        throw new OdooSessionException("Session could not be established");
      }
      return odooSession;
    }else
    return odooSession;
  }
}
