public class Person {
    private String fName ;
    private String sName;

    public Person(String fName,String sName){
        setfName(fName);
        setsName(sName);
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    @Override
    public String toString() {
        return "Клиент: Имя - " + fName + "\n Фамилия - " + sName + "\n";
    }
}

