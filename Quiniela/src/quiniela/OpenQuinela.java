package quiniela;

public class OpenQuinela extends StatusQuinela {
    @Override
    public void canBet() {

    }

    @Override
    public void canGetReward() {
        throw new RuntimeException("Can not get reward when quiniela is open");
    }
}
