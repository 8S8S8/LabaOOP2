public interface Tariff {
    public boolean add(Service service);
    public boolean add(Service service, int number);
    public Service get(int index);
    public Service get(String title);
    public boolean isContain(String  title);
    public Service set(int index,Service service);
    public Service delete(int index);
    public int getSize();
    public Service[] getServices();
    public Service[] SortedServicesByCost();
    public double cost();


}
