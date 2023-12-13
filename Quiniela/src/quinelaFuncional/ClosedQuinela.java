package quinelaFuncional;

public class ClosedQuinela extends StatusQuinela {
    @Override
    public void canBet() {
        throw new RuntimeException("Can not bet when quiniela is closed");
    }
}
