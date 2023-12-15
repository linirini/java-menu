package menu.domain;

import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.Map;

public class RandomMachine {

    private static final RandomMachine instance = new RandomMachine();

    public static RandomMachine getInstance() {
        return instance;
    }

    private RandomMachine() {}

}
