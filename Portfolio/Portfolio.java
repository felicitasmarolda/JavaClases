package portfolio4;
import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    List<Object> accounts = new ArrayList();
    public int balance() {
        return accounts.stream().map( each -> {
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
public void add( Account anAccount ){
    if (accounts.contains( anAccount )) throw new RuntimeException();
    accounts.add( anAccount );
}

public void add( Portfolio aPortfolio ){
    if (accounts.contains( aPortfolio )) throw new RuntimeException();
    accounts.add( aPortfolio );
}
}
