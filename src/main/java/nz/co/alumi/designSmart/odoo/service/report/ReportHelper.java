package nz.co.alumi.designSmart.odoo.service.report;

import com.odoojava.api.FilterCollection;
import com.odoojava.api.FilterCollection.FilterOperator;
import com.odoojava.api.ObjectAdapter;
import com.odoojava.api.RowCollection;
import com.odoojava.api.Session;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.logging.SocketHandler;
import nz.co.alumi.designSmart.odoo.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class ReportHelper {

  @Autowired
  private SessionService sessionService;

  public void testStockReport(){

    try{
/*

      models.execute_kw(db, uid, password,
          'report.stock.quantity', 'read_group',
          [[['product_id', '=', 1586]]],
      {'fields': ['id','date','product_id','product_qty','warehouse_id'],"groupby": [
        "date:day",
            "product_id"
            ]})
*/

      List domain=Arrays.asList(Arrays.asList("product_id", "=", 1586));
      List groupBy=Arrays.asList("date:day","product_id");
      List fields=Arrays.asList("id","date","product_id","product_qty","warehouse_id");
      Session odooSession=sessionService.getOdooSession();


      List obj=Arrays.asList((Object[])odooSession.executeCommand("report.stock.quantity", "read_group", new Object[]{domain,fields,groupBy}));

      System.out.println(CollectionUtils.isEmpty(obj));

      ObjectAdapter reportStockObjAdp = odooSession.getObjectAdapter("report.stock.quantity");
      FilterCollection filters = new FilterCollection();
      filters.add("state", "=", "forecast");
      filters.add(FilterOperator.AND);
      filters.add("warehouse_id", "=", "1");
      filters.add(FilterOperator.AND);
      filters.add("product_tmpl_id", "=", "2264");

      RowCollection stockQuantityRows = reportStockObjAdp
          .searchAndReadObject(filters, new String[]{});
      System.out.println(stockQuantityRows.get(0).get("date"));


      /*FilterCollection filters = new FilterCollection();
      RowCollection partners = reportAdapter.searchAndReadObject(
          filters, new String[] { "date", "product_id","product_qty" });

      "model": "report.stock.quantity",
          "method": "read_group",
          "kwargs": {
        "context": {
          "fill_temporal": true,
              "lang": "en_US",
              "tz": "Pacific/Auckland",
              "uid": 2,
              "allowed_company_ids": [
          1
                ]
        },
        "domain": [
        "&",
            "&",
                [
        "state",
            "=",
            "forecast"
                ],
                [
        "warehouse_id",
            "=",
            1
                ],
                [
        "product_tmpl_id",
            "=",
            2264
                ]
            ],
        "fields": [
        "date",
            "product_id",
            "product_qty"
            ],
        "groupby": [
        "date:day",
            "product_id"
            ],
        "lazy": false
      }
    },
    "id": 779002923


      filters.add("name", "=", "Fortress");
      RowCollection partners = reportAdapter
          .searchAndReadObject(filters, new String[]{"id", "name", "email"});*/
    }catch (Exception ex){
      System.out.println(ex);
    }
  }
}
