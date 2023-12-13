package quinelaFuncional;

import java.util.ArrayList;

public class BetOnLastTwoDigitsOfFirstNumber extends Bet {
    public BetOnLastTwoDigitsOfFirstNumber(Gambler name, int moneyPutOnBet, int betNumber) {
        super(name, moneyPutOnBet, betNumber);
    }

    @Override
    public int getRewardAccordingToTypeOfBet() {
        return this.getMoneyPutOnBet() * 2;
    }

    @Override
    public boolean wonWith(ArrayList<Integer> quinielaWinningNumbers) {
        int lastTwoDigitsOfFirstNumber = quinielaWinningNumbers.get(0) % 100;
        return lastTwoDigitsOfFirstNumber == this.getBetNumber();
    }
}
