package pojo;

public class Products {
    private String product;
    private String imageURL;
    private double dollarPrice;
    private double euroPrice;
    private double poundPrice;

    public Products(String product, String imageURL, double dollarPrice, double euroPrice, double poundPrice) {
        this.product = product;
        this.imageURL = imageURL;
        this.dollarPrice = dollarPrice;
        this.euroPrice = euroPrice;
        this.poundPrice = poundPrice;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public double getDollarPrice() {
        return dollarPrice;
    }

    public void setDollarPrice(double dollarPrice) {
        this.dollarPrice = dollarPrice;
    }

    public double getEuroPrice() {
        return euroPrice;
    }

    public void setEuroPrice(double euroPrice) {
        this.euroPrice = euroPrice;
    }

    public double getPoundPrice() {
        return poundPrice;
    }

    public void setPoundPrice(double poundPrice) {
        this.poundPrice = poundPrice;
    }
}
