public class IndividualAccount implements Account{
    long number;
    Person person;
    Tariff tariff;

    public IndividualAccount(long number, Person person) {
        setNumber(number);
        setPerson(person);
        Tariff tar = new IndividualsTariff();
        tar.add(new Service());
        setTariff(tar);
    }

    public IndividualAccount(long number, Person person, Tariff tariff) {
        setNumber(number);
        setPerson(person);
        setTariff(tariff);
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {

        this.person = person;
    }

    public Tariff getTariff() {

        return tariff;
    }

    public void setTariff(Tariff tariff)
    {
        this.tariff = tariff;
    }
}
