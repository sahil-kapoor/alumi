import com.odoojava.api.FilterCollection;
import com.odoojava.api.ObjectAdapter;
import com.odoojava.api.OdooApiException;
import com.odoojava.api.OdooXmlRpcProxy;
import com.odoojava.api.RowCollection;
import com.odoojava.api.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"nz.co.alumi.*"})
@EnableMongoRepositories
@EnableMongoAuditing
public class AlumiApplication {

  public static void main(String[] args) {
    SpringApplication.run(AlumiApplication.class, args);
    test();
  }

  public static void test() {
    Session odooSession = new Session(OdooXmlRpcProxy.RPCProtocol.RPC_HTTPS,
        "alumi-test-20210827.odoo.com", 443, "alumi-test-20210827",
        "sahilkapoor1987@gmail.com", "Sahil@1987");

    try {
      odooSession.startSession();
      ObjectAdapter partnerAd = odooSession.getObjectAdapter("res.partner");
      FilterCollection filters = new FilterCollection();
      filters.add("name", "=", "Fortress");
      RowCollection partners = partnerAd
          .searchAndReadObject(filters, new String[]{"id", "name", "email"});
      System.out.println(partners.get(0).getID() + "--" + partners.get(0).get("name"));

    } catch (OdooApiException ex) {
      ex.printStackTrace();
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    System.out.println(odooSession.getContext());
  }

}
