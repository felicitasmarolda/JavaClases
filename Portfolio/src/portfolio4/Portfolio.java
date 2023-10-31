package portfolio4;
import java.util.ArrayList;
import java.util.List;

public class Portfolio extends Accountable {
    private List<Accountable> accountables = new ArrayList();
    public int balance() {
        return accountables.stream().map( each -> {
            if(each.getClass().equals( Account.class)){
     //       if (Account.class.isInstance( each))
     //       if (Account.GetClass().equals(Account.class))
                return ((Account)each).balance();// castado account con each
            }
            else{
                return Portfolio.class.cast(each).balance();
            }
                })
                                .reduce(0, (aBalance, acc) -> aBalance + acc);
     //  return accounts.stream().map(Account :: balance)
                            //   . reduce(0, Integer :: sum);
    }
    // balance y reporte
public void add( Accountable anAccountable ){
    if (accountables.contains( anAccountable )) throw new RuntimeException();
    accountables.add( anAccountable );
}
public boolean contains(Accountable anAccountable) {
    List<Account> reminder = accounts();
    reminder.retainAll(anAccountable.accounts());
    return !reminder.isEmpty();

}

public String report(String prefix) {
    List<String> report = new ArrayList<String>();
    report.add(prefix + "Portfolio:");
    accountables.forEach((accountable)-> {report.add(accountable.report(prefix + " "));});

    return String.join("\n", report);
}

public List<Account> accounts(){
    return accountables.stream().map((accountable) -> accountable.accounts())
            .reduce(new ArrayList<Account>(),(a,b) -> {a.addAll(b); return a;});

}

    public boolean equals(Accountable anAccountable) {
        return accountables.stream().anyMatch(each -> each.equals(anAccountable));
    }
    public Account deposit(int anAmount) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Account withdraw(int anAmount) {
        // TODO Auto-generated method stub
        return null;
    }
}
