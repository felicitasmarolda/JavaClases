import java.util.ArrayList;
import java.util.List;

public abstract class Robot {
    List<Weapon> weaponsCarrying;

    public Robot(){
        weaponsCarrying = new ArrayList<Weapon>();
    }
    protected abstract int life();
    protected abstract int speed();
    protected abstract int maximumWeaponWeight();
    public void carryWeaponWith(Weapon weapon){
        weaponsCarrying.stream()
                .filter(w -> w.equals(weapon))
                .findAny()
                .ifPresentOrElse(
                        w -> {
                            throw new RuntimeException("Robot is already carrying this weapon");
                        },
                        () -> {
                            if (weapon.weight() > maximumWeaponWeight()) {
                                throw new RuntimeException("Robot cannot carry this weapon");
                            } else {
                                weaponsCarrying.add(weapon);
                                this.reduceSpeed(weapon);
                            }
                        }
                );

    }
    public abstract void reduceSpeed(Weapon weapons);
    public void attack(Robot robot, Weapon weapon){
        if (weaponsCarrying.contains(weapon)){
            robot.receiveAttack(weapon);
        } else {
            throw new RuntimeException("Robot is not carrying this weapon");
        }
    }

    public abstract void receiveAttack(Weapon weapon);

    public abstract void reduceLife(int i);


}
