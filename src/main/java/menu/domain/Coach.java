package menu.domain;

import static menu.util.ExceptionEnum.INVALID_NAME_LENGTH;

import java.util.List;

public class Coach {

    private final String name;
    private final List<Menu> cannotEatMenus;
    private static final int MINIMUM_NAME_LENGTH = 2;
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final int MINIMUM_CANNOT_EAT_MENUS_COUNT = 0;
    private static final int MAXIMUM_CANNOT_EAT_MENUS_COUNT = 2;


    public Coach(String name, List<Menu> cannotEatMenus) {
        validate(name,cannotEatMenus);
        this.name = name;
        this.cannotEatMenus = cannotEatMenus;
    }

    public String getName() {
        return name;
    }

    private void validate(String name, List<Menu> cannotEatMenus){
        throwIfInvalidNameLength(name);
        throwIfInvalidMenusCount(cannotEatMenus);
    }

    private void throwIfInvalidNameLength(String name) {
        if(name.length()<MINIMUM_NAME_LENGTH||name.length()>MAXIMUM_NAME_LENGTH){
            throw new IllegalArgumentException(INVALID_NAME_LENGTH.getMessage());
        }
    }

    private void throwIfInvalidMenusCount(List<Menu> menus) {
    }

    public boolean cannotEatMenusContain(Menu menu){
        return cannotEatMenus.contains(menu);
    }

}
