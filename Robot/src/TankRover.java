import java.util.ArrayList;

public class TankRover extends Robot{
    private int life = 100;
    public int life(){
        return life;
    }
    private int speed = 40;
    public int speed(){
        return speed;
    }
    public int maximumWeaponWeight(){
        return 200;
    }
    public void reduceSpeed(Weapon weapons) {
        speed -= weapons.speedSlowdown();
    }
    @Override
    public void receiveAttack(Weapon weapon) {
        weapon.reduceLifeWithTankRover(this);
    }
    @Override
    public void reduceLife(int i) {
        life -= i;
    }
}
