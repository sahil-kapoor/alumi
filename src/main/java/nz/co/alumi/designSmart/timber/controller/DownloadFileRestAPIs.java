package nz.co.alumi.designSmart.timber.controller;

import nz.co.alumi.designSmart.timber.services.ExcelFileServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DownloadFileRestAPIs {

  @Autowired
  ExcelFileServices fileServices;

  /*
   * Download Files
   */
  @GetMapping("/api/download/excel/")
  public ResponseEntity<InputStreamResource> downloadFile() {

    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Disposition", "attachment; filename=customers.xlsx");

    return ResponseEntity.ok().headers(headers)
        .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
        .body(new InputStreamResource(fileServices.loadFile()));
  }
}