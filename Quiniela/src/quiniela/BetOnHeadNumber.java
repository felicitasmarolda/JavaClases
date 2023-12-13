package quiniela;

import java.util.ArrayList;

public class BetOnHeadNumber extends Bet {
    public BetOnHeadNumber(Gambler name, Integer moneyPutOnBet, Integer betNumber) {
        super(name, moneyPutOnBet, betNumber);
    }

    @Override
    public int getRewardAccordingToTypeOfBet() {
        return this.getMoneyPutOnBet() * 20;
    }

    public boolean wonWith(ArrayList<Integer> quinielaWinningNumbers) {
        return quinielaWinningNumbers.get(0) == this.getBetNumber();
    }
}
