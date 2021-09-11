package nz.co.alumi.designSmart.odoo.service.report;

import com.odoojava.api.FilterCollection;
import com.odoojava.api.FilterCollection.FilterOperator;
import com.odoojava.api.ObjectAdapter;
import com.odoojava.api.RowCollection;
import com.odoojava.api.Session;
import nz.co.alumi.designSmart.odoo.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportHelper {

  @Autowired
  private SessionService sessionService;

  public void testStockReport(){

    try{
      Session odooSession=sessionService.getOdooSession();

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
