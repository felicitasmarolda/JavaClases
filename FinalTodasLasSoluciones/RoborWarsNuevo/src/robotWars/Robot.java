package robotWars;

public abstract class Robot {
    public abstract int getSpeed();

    public abstract int getLife();
    public abstract void affectLife(int life);

    public abstract int totalWeaponWeightLeft();
    public abstract void addWeapon(Weapon weapon);

    public abstract void attack(Robot aluminium2, Weapon blaster);

    protected abstract void getAttackedWith(Weapon weapon, Robot attacker);

    public abstract void removeWeapon(Claw claw);
}
