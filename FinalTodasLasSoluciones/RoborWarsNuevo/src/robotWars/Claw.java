package robotWars;

public class Claw extends Weapon {
    int countTimesUsed;
    public Claw() {
        countTimesUsed = 0;
    }

    public int getWeight() {
        return 10;
    }

    public int speedImpact() {
        return 5;
    }

    @Override
    public void attacksAtAluminium(Aluminium3000 robot, Robot attacker) {
        robot.affectLife(25);
        countTimesUsed++;
        if(countTimesUsed == 2) {
            attacker.removeWeapon(this);
        }
    }

    @Override
    public void attacksAtTank(TankRover tankRover, Robot attacker) {
        attacker.removeWeapon(this);
        tankRover.affectLife(5);
    }
}
