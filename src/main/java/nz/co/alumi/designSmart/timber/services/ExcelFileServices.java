package nz.co.alumi.designSmart.timber.services;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import nz.co.alumi.designSmart.timber.document.Customer;
import nz.co.alumi.designSmart.timber.utils.ExcelUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ExcelFileServices {

/*
	@Autowired
	ProjectRepository customerRepository;
*/

  // Store File Data to Database
  public void store(MultipartFile file) {
    try {
      List<Customer> lstCustomers = ExcelUtils.parseExcelFile(file.getInputStream());
      // Save Customers to DataBase
      //	customerRepository.saveAll(lstCustomers);
    } catch (IOException e) {
      throw new RuntimeException("FAIL! -> message = " + e.getMessage());
    }
  }

  // Load Data to Excel File
  public ByteArrayInputStream loadFile() {
    List<Customer> customers = null;//(List<Customer>) customerRepository.findAll();

    try {
      ByteArrayInputStream in = ExcelUtils.customersToExcel(customers);
      return in;
    } catch (IOException e) {
    }

    return null;
  }
}