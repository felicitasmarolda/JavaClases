package quiniela;

import java.util.ArrayList;

public class BetOnFirstFiveNumbers extends Bet {
    public BetOnFirstFiveNumbers(Gambler name, int moneyPutOnBet, int betNumber) {
        super(name, moneyPutOnBet, betNumber);
    }
    public int getMoneyPutOnBet() {
        return super.getMoneyPutOnBet();
    }

    @Override
    public int getRewardAccordingToTypeOfBet() {
        return this.getMoneyPutOnBet() * 14;
    }
    public boolean wonWith(ArrayList<Integer> quinielaWinningNumbers) {
        return quinielaWinningNumbers.stream()
                .limit(5)
                .anyMatch(number -> number == this.getBetNumber());
    }
}
