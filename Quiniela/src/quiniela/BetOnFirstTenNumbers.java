package quiniela;

import java.util.ArrayList;

public class BetOnFirstTenNumbers extends Bet {
    public BetOnFirstTenNumbers(Gambler name, int moneyPutOnBet, int betNumber) {
        super(name, moneyPutOnBet, betNumber);
    }

    @Override
    public int getRewardAccordingToTypeOfBet() {
        return this.getMoneyPutOnBet() * 10;
    }

    public boolean wonWith(ArrayList<Integer> quinielaWinningNumbers) {
        return quinielaWinningNumbers.stream()
                .anyMatch(number -> number == this.getBetNumber());
    }
}
