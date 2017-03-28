package eshop.mbeans;

import eshop.beans.EShopBean;
import eshop.entities.Products;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Cookie;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Apress
 */
@Named("cp")
@RequestScoped
public class CPBean {

    @Inject
    private EShopBean eShopBean;
    private int total;
    private String search;
    private List<Products> products = new ArrayList<Products>();

    public List<String> extractCategoriesAction() {
        return eShopBean.extractCategories();
    }

    public void extractProductsAction() {
        Map<Integer, List<Products>> results = eShopBean.extractProducts(getCategory(), getPageNumber());
        total = results.keySet().iterator().next();
        this.products = results.get(total);

        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("pagination('" + total + "')");
    }
    
    public List<Products> searchProductsAction(){
        if(search!= null){
            if(search.trim().length() > 0){
                products = eShopBean.searchProducts(search);
            }
        }        
        return products;
    }

    public List<Products> getProducts() {
        if (!isPostback()) {
            this.products = eShopBean.extractPromotionalProducts();
        }
        return products;
    }        

    private static boolean isPostback() {
        return FacesContext.getCurrentInstance().isPostback();
    }

    private String getCategory() {
        Object cat_cookie = FacesContext.getCurrentInstance().getExternalContext().getRequestCookieMap().get("category");
        if (cat_cookie != null) {
            String cat_cookie_value = (((Cookie) cat_cookie).getValue());
            if (!"nocookie".equals(cat_cookie_value)) {
                return cat_cookie_value;
            }
        }
        return "";
    }

    private int getPageNumber() {
        Object page_cookie = FacesContext.getCurrentInstance().getExternalContext().getRequestCookieMap().get("page");
        if (page_cookie != null) {
            String page_cookie_value = (((Cookie) page_cookie).getValue());
            if (!"nocookie".equals(page_cookie_value)) {
                return Integer.valueOf(page_cookie_value);
            }
        }
        return 0;
    }

    public int getTotal() {
        return total;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    } 
}
