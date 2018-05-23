package info.udaysingh.payment;

public class OfferCard {
    String title;
    String subtitle;
    String price;

    public OfferCard(String title, String subtitle, String price) {
        this.title = title;
        this.subtitle = subtitle;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
