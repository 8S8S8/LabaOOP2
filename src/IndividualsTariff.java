import java.util.Arrays;

public class IndividualsTariff implements  Tariff{
    private Service[] services;
    private int size;

    public IndividualsTariff() {
        setServices(new Service[8]);
        setSize(0);
    }

    public IndividualsTariff(int size) {
        setServices(new Service[size]);
        setSize(size);
    }

    public IndividualsTariff(Service[] services) {
        setServices(services);
        size = services.length;
    }

    public boolean add(Service service){
        if(checkFreeSpace()){
            extend();
            return false;
        }else{
            addService(service);
            size++;
            return true;
        }
    }

    private void addService(Service service){
        for(int i = 0; i<services.length;i++){
            if(services[i] == null){
                services[i] = service;
                return;
            }
        }
    }

    private  boolean checkFreeSpace(){
        return  size == services.length;
    }

    public boolean add(Service service, int number){
        if(number<0 || number>services.length-1) throw new ArrayIndexOutOfBoundsException();
        else{
            if(services[number]==null){
                services[number] = service;
                size++;
                return true;
            }else{
                return false;
            }
        }
    }

    public Service get(int index){
        return services[index];
    }

    public Service get(String title){
        for(Service service : services){
            if(service.getTitle().equals(title))
                return service;
        }
        return  null;
    }

    public  boolean isContain(String  title){
        for(Service service : services){
            if(service.getTitle().equals(title))
                return true;
        }
        return  false;
    }

    public  Service set(int index,Service service){

        Service returnService = services[index];
        services[index] = service;
        return returnService;
    }

    public Service delete(int index){
        Service returnService = services[index];
        services[index] = null;
        return returnService;
    }

    public Service delete(String title){
        for(int i = 0; i<services.length;i++){
            if(services[i].getTitle().equals(title)){
                Service returnService = services[i];
                services[i]= null;
                size--;
                return returnService;
            }
        }
       return null;
    }

    public Service[] getServices() {
        trim();
        Service[] returnService = new Service[size];
        for(int i=0;i<returnService.length;i++){
            returnService[i] = services[i];
        }
        return returnService;
    }

    private void extend(){
        Service[] newServices = new Service[services.length*2];
        for(int i = 0; i<services.length;i++){
            newServices[i] = services[i];
        }
        services = newServices;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void trim(){
        for(int i = 0; i<services.length;i++){
            for (int j= 0; j<services.length-1;j++){
               if(services[j]==null && services[j+1]!=null){
                   services[j] = services[j+1];
                   services[j+1]= null;
               }
            }
        }
    }

    public void setServices(Service[] services) {
        this.services = services;
    }

    public Service[] SortedServicesByCost(){
        Service[] newServices = getServices();
        for(int i = 0; i<newServices.length;i++){
            for(int j = 0; j<newServices.length-1;j++){
                if(newServices[j].getCost()>newServices[j+1].getCost()){
                    Service C = newServices[j];
                    newServices[j] = newServices[j+1];
                    newServices[j+1] = C;
                }
            }
        }
        return newServices;
    }

    public double cost(){
        double cost = 50;
        Service[] newService = getServices();
        for(int i = 0; i<newService.length;i++){
            cost+=newService[i].getCost();
        }
        return cost;
    }

    @Override
    public String toString() {
        String str = "Индивидуальнный тариф("+size+" услуг):\n";
        for(int i = 0; i<services.length;i++){
            if(services[i]!=null){
                str+=(i+1)+") "+services[i].toString() +"\n";
            }else{
                str+=(i+1)+")-------------\n";
            }
        }
        return str;
    }
}
