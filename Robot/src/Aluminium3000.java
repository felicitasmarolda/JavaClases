public class Aluminium3000 extends Robot{
    private int life = 100;
    public int life(){
        return life;
    }
    private int speed = 90;
    public int speed(){
        return speed;
    }

    public int maximumWeaponWeight(){
        return 50;
    }

    public void reduceSpeed(Weapon weapon) {
        speed -= weapon.speedSlowdown();

    }

    @Override
    public void receiveAttack(Weapon weapon) {
        weapon.reduceLifeWithAluminuim3000(this);
    }

    public void reduceLife(int i) {
        life -= i;
    }
}
