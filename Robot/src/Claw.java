public class Claw extends Weapon{

    @Override
    protected int weight() {
        return 10;
    }

    @Override
    protected int speedSlowdown() {
        return 5;
    }

    @Override
    public void reduceLifeWithAluminuim3000(Aluminium3000 aluminium3000) {
        aluminium3000.reduceLife(25);
    }

    @Override
    public void reduceLifeWithTankRover(TankRover tankRover) {
        tankRover.reduceLife(5);
    }
}
