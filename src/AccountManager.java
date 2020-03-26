public class AccountManager {
  private Account[] accounts;
  private int size;

    public AccountManager(int size) {
        setAccounts(new Account[size]);
        size = 0;
    }

    public AccountManager(Account[] accounts){
        setAccounts(accounts);
        size = accounts.length;
    }

    public boolean add(Account account){
        if(checkFreeSpace()){
            extend();
            return false;
        }else{
            addAccount(account);
            size++;
            return true;
        }
    }

    public boolean add(Account account, int index){
        if(accounts[index]!=null){
            return false;
        }else{
            accounts[index] = account;
            return true;
        }
    }

    private void addAccount(Account account){
        for(int i = 0; i<accounts.length;i++){
            if(accounts[i] == null){
                accounts[i] = account;
                return;
            }
        }
    }

    public Account get(int index){
        return accounts[index];
    }

    public Account change(int index, Account newAccount){
        Account forReturn = accounts[index];
        accounts[index] = newAccount;
        return forReturn;
    }

    public Account delete(int index){
        Account forReturn = accounts[index];
        accounts[index] = null;
        return forReturn;
    }

    private boolean checkFreeSpace(){
        return size == accounts.length;
    }

    private void extend(){
        Account[] newAccounts = new Account[accounts.length*2];
        for(int i = 0; i<accounts.length;i++){
            newAccounts[i] = accounts[i];
        }
        accounts = newAccounts;
    }

    public Account[] getAccounts() {
        trim();
        Account[] returnAccounts = new Account[size];
        for(int i=0;i<returnAccounts.length;i++){
            returnAccounts[i] = accounts[i];
        }
        return returnAccounts;
    }

    public Tariff getTariff(int accountIndex){
        if(accounts[accountIndex]!=null){
            return accounts[accountIndex].getTariff();
        }else{
            return null;
        }
    }

    public Tariff changeTariff(int accountIndex, Tariff newTariff){
        Tariff forReturn = getTariff(accountIndex);
        accounts[accountIndex].setTariff(newTariff);
        return forReturn;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    public int getAccountsCount() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private void trim(){
        for(int i = 0; i<accounts.length;i++){
            for (int j= 0; j<accounts.length-1;j++){
                if(accounts[j]==null){
                    accounts[j] = accounts[j+1];
                    accounts[j+1] = null;
                }
            }
        }
    }

}
