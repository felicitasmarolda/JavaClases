package campoLindero;

import java.util.ArrayList;

public class Member extends Car{
    public int peopleInCar;
    public Member(int peopleInCar){
        this.peopleInCar = peopleInCar;
    }

    @Override
    public int peopleInCar() {
        return peopleInCar;
    }

    @Override
    public Integer price() {
        return 100;
    }
}
