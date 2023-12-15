package menu.domain;

import static menu.util.Constants.END_NUMBER;
import static menu.util.Constants.START_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomMachine {

    private static final RandomMachine instance = new RandomMachine();

    public static RandomMachine getInstance() {
        return instance;
    }

    private RandomMachine() {}

    public int createRandomNumber(){
        return Randoms.pickNumberInRange(START_NUMBER,END_NUMBER);
    }

    public List<String> shuffle(List<String> menus){
        return Randoms.shuffle(menus);
    }

}
