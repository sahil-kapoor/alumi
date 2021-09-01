package nz.co.alumi.designSmart.inventory.helper;

import java.util.function.BiFunction;
import nz.co.alumi.designSmart.inventory.model.Constants;
import nz.co.alumi.designSmart.inventory.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductHelper {

  public BiFunction<Integer, Integer, Boolean> compareIntegers = (x1, x2) -> x1 != null
      && x2 != null && x1.equals(x2);
  public BiFunction<String, String, Boolean> compareStrings = (x1, x2) -> x1 != null && x2 != null
      && x1.equalsIgnoreCase(x2);

  public Product mapProduct(Product product) {
    product.setColorName(Constants.WINDOW_COLOR_MAP.get(product.getKey()));
    product.setOpenSideDescription(Constants.WINDOW_SASH_MAP.get(product.getOpenSideKey()));
    return product;
  }

  public boolean completeMatch(Integer width, Integer height, String color, String openSide,
      Product product) {
    return (compareIntegers.apply(width, product.getSizeW()) &&
        compareIntegers.apply(height, product.getSizeH()) &&
        compareStrings.apply(color, product.getColorKey()) &&
        compareStrings.apply(openSide, product.getOpenSideKey()));
  }

  public boolean partialMatchWithHeightColorOpenSide(Integer height, String color, String openSide,
      Product product) {
    return (compareIntegers.apply(height, product.getSizeH()) &&
        compareStrings.apply(color, product.getColorKey()) &&
        compareStrings.apply(openSide, product.getOpenSideKey()));
  }

  public boolean partialMatchWithWidthColorOpenSide(Integer width, String color, String openSide,
      Product product) {
    return (compareIntegers.apply(width, product.getSizeW()) &&
        compareStrings.apply(color, product.getColorKey()) &&
        compareStrings.apply(openSide, product.getOpenSideKey()));
  }

  public boolean partialMatchWithWidthHeight(Integer width, Integer height, Product product) {
    return (compareIntegers.apply(width, product.getSizeW()) &&
        compareIntegers.apply(height, product.getSizeH()));
  }

  public boolean partialMatchWithWidthColor(Integer width, String color, Product product) {
    return (compareIntegers.apply(width, product.getSizeW()) &&
        compareStrings.apply(color, product.getColorKey()));
  }

  public boolean partialMatchWithHeightColor(Integer height, String color, Product product) {
    return (compareIntegers.apply(height, product.getSizeW()) &&
        compareStrings.apply(color, product.getColorKey()));
  }

}
