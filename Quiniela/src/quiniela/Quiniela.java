package quiniela;

import java.util.ArrayList;
import java.util.Arrays;

public class Quiniela {
    ArrayList<Bet> betsForWeek = new ArrayList<Bet>();
    ArrayList<Integer> quinielaWinningNumbers = new ArrayList<Integer>();
    private StatusQuinela quinielaIsClosed = new OpenQuinela();
    public Quiniela(){
        this.quinielaIsClosed = new OpenQuinela();
    }
    public int getMoneyPozo() {
        return betsForWeek.stream()
                .mapToInt(Bet::getMoneyPutOnBet)
                .sum();
    }
    public void betWithHeadNumber(Gambler name, int amount, int betNumber) {
        canBet(name);
        betsForWeek.add(new BetOnHeadNumber(name,amount, betNumber));
    }

    public void betWithFirstFiveNumbers(Gambler name, int amount, int betNumber) {
        canBet(name);
        betsForWeek.add(new BetOnFirstFiveNumbers(name,amount, betNumber));
    }
    public void betWithFirstTenNumbers(Gambler name, int amount, int betNumber) {
        canBet(name);
        betsForWeek.add(new BetOnFirstTenNumbers(name,amount, betNumber));
    }
    public void betWithLastThreeDigitsOfFirstNumber(Gambler name, int amount, int betNumber) {
        canBet(name);
        betsForWeek.add(new BetOnLastThreeDigitsOfFirstNumber(name,amount, betNumber));
    }
    public void betWithLastTwoDigitsOfFirstNumber(Gambler name, int amount, int betNumber) {
        name.canBet();
        betsForWeek.add(new BetOnLastTwoDigitsOfFirstNumber(name,amount, betNumber));
    }
    public void closeBets(int... winningNumbers) {
        Arrays.stream(winningNumbers)
                .forEach(quinielaWinningNumbers::add);
        quinielaIsClosed = new ClosedQuinela();
    }

    public int getReward(Gambler name) {
        quinielaIsClosed.canGetReward();
        return betsForWeek.stream()
                .filter(bet -> bet.getGambler().equals(name))
                .findFirst()
                .map(bet -> bet.getReward(quinielaWinningNumbers))
                .orElseThrow(() -> new RuntimeException("Person did not bet"));
    }

    private void canBet(Gambler name) {
        quinielaIsClosed.canBet();
        name.canBet();
    }
}
