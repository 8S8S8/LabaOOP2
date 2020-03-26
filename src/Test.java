import List.LinkedList;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Test {
    public static void lab1tests(){
        IndividualsTariff tariff = new IndividualsTariff();
        Service firstService = new Service("VIP",1500);
        Service secondService = new Service("Комфорт",1000);
        Service thirdService = new Service("Эконом",300);

        System.out.println(tariff);

        tariff.add(firstService,3);
        tariff.add(secondService);
        System.out.println(tariff);


        tariff.delete(secondService.getTitle());
        //tariff.delete(3);
        System.out.println(tariff);

        tariff.add(thirdService,7);
        tariff.trim();
        System.out.println(tariff);
    }

    public static void listTest(){
        LinkedList<String> list = new LinkedList<>();
        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.delete(2);
        System.out.println(list.toString());
        System.out.println(list.getSize());
        System.out.println("После удаления ");
        list.add("9",3);
        System.out.println(list.toString());
        System.out.println(list.getSize());
        System.out.println("После добавления ");
    }
}
