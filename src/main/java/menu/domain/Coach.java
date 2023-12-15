package menu.domain;

import java.util.List;

public class Coach {

    private final String name;
    private final List<Menu> cannotEatMenus;

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
    }

    private void throwIfInvalidMenusCount(List<Menu> menus) {
    }

    public boolean cannotEatMenusContain(Menu menu){
        return cannotEatMenus.contains(menu);
    }

}
