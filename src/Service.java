public class Service {
    private String title;
    private double cost;

    public Service() {
        setTitle("интернет 100мб\\сек");
        setCost(300);
    }

    public Service(String title, double cost) {
        setTitle(title);
        setCost(cost);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {

        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Наименование услуги: " + getTitle() + " (" + getCost() + "р/м)";
    }
}
