package nz.co.alumi.designSmart.odoo.service;

import com.odoojava.api.OdooXmlRpcProxy;
import com.odoojava.api.Session;
import org.apache.xmlrpc.XmlRpcException;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

  public Session startOdooSession() throws XmlRpcException {

    Session odooSession = new Session(OdooXmlRpcProxy.RPCProtocol.RPC_HTTPS,
        "alumi-test-20210827.odoo.com", 443, "alumi-test-20210827",
        "sahilkapoor1987@gmail.com", "Sahil@1987");
    if (odooSession.getServerVersion() != null) {
      try {
        odooSession.startSession();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return odooSession;
  }
}
