package menu.domain;

import java.util.List;

public class Coach {

    private final String name;
    private final List<Menu> menus;

    public Coach(String name, List<Menu> menus) {
        validate(name,menus);
        this.name = name;
        this.menus = menus;
    }

    public String getName() {
        return name;
    }

    private void validate(String name, List<Menu> menus){
        throwIfInvalidNameLength(name);
        throwIfInvalidMenusCount(menus);
    }

    private void throwIfInvalidNameLength(String name) {
    }

    private void throwIfInvalidMenusCount(List<Menu> menus) {
    }

}
