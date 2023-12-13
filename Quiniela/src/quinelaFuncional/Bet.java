package quinelaFuncional;

import java.util.ArrayList;

public abstract class Bet {
    private int moneyPutOnBet;
    private Gambler name;
    private int betNumber;
    public Bet(Gambler name, Integer moneyPutOnBet, Integer betNumber) {
        this.moneyPutOnBet = moneyPutOnBet;
        this.name = name;
        this.betNumber = betNumber;
    }
    public int getMoneyPutOnBet() {
        return moneyPutOnBet;
    }

    public Gambler getGambler() {
        return name;
    }

    public int getReward(ArrayList<Integer> quinielaWinningNumbers){
        if(this.wonWith(quinielaWinningNumbers)){
            return this.getRewardAccordingToTypeOfBet();
        }
        return 0;
    }

    public abstract int getRewardAccordingToTypeOfBet();

    public abstract boolean wonWith(ArrayList<Integer> quinielaWinningNumbers);

    protected int getBetNumber() {
        return betNumber;
    }
}
