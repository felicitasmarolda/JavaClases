package quinelaFuncional;

public class Gambler {
    String name;
    private boolean alreadyBet;
    public Gambler(String name) {
        this.name = name;
        this.alreadyBet = false;
    }
    public boolean hasAlreadyBet() {
        return alreadyBet;
    }
    public String getName(){
        return name;
    }

    public void canBet() {
        if(this.hasAlreadyBet()){
            throw new RuntimeException("This gambler has already bet");
        }
        this.alreadyBet = true;
    }
}
