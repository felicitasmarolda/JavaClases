public class Blaster extends Weapon{
    @Override
    protected int weight() {
        return 20;
    }
    @Override
    protected int speedSlowdown() {
        return 10;
    }
    public void reduceLifeWithAluminuim3000(Aluminium3000 aluminium3000) {
        aluminium3000.reduceLife(5);
    }

    @Override
    public void reduceLifeWithTankRover(TankRover tankRover) {
        tankRover.reduceLife(50);
    }
}
