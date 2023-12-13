package robotWars;

public abstract class Weapon {
    public abstract int getWeight();

    public abstract int speedImpact();

    public abstract void attacksAtAluminium(Aluminium3000 robot,Robot attacker);

    public abstract void attacksAtTank(TankRover tankRover,Robot attacker);
}
