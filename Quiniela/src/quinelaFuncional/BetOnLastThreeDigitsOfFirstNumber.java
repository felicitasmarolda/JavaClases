package quinelaFuncional;

import java.util.ArrayList;

public class BetOnLastThreeDigitsOfFirstNumber extends Bet {
    public BetOnLastThreeDigitsOfFirstNumber(Gambler name, int moneyPutOnBet, int betNumber) {
        super(name, moneyPutOnBet, betNumber);
    }

    @Override
    public int getRewardAccordingToTypeOfBet() {
        return this.getMoneyPutOnBet() * 9;
    }

    @Override
    public boolean wonWith(ArrayList<Integer> quinielaWinningNumbers) {
        int lastThreeDigitsOfFirstNumber = quinielaWinningNumbers.get(0) % 1000;
        return lastThreeDigitsOfFirstNumber == this.getBetNumber();
    }
}
