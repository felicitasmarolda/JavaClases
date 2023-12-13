package robotWars;

public class Blaster extends Weapon {

    public int getWeight() {
        return 20;
    }

    public int speedImpact() {
        return 10;
    }

    @Override
    public void attacksAtAluminium(Aluminium3000 robot, Robot attacker) {
        robot.affectLife(5);
    }

    @Override
    public void attacksAtTank(TankRover tankRover, Robot attacker) {
        tankRover.affectLife(50);
    }
}
