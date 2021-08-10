package nz.co.alumi.designSmart.inventory.model;

import java.util.Map;

public class Constants {

  public static Map<String,String> WINDOW_COLOR_MAP= Map.of("IS","Ironsand");
  public static Map<String,String> WINDOW_SASH_MAP= Map.of("OB","Open Both Sides","OR","Open Right Side",
      "OL","Open Left Side");
  public enum Type{ WINDOW,HINGE_DOOR,SLIDING_DOOR,ENTRANCE_DOOR};
}
