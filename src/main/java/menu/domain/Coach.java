package menu.domain;

import static menu.util.ExceptionEnum.DUPLICATED_MENU;
import static menu.util.ExceptionEnum.INVALID_MENU_COUNT;
import static menu.util.ExceptionEnum.INVALID_NAME_LENGTH;

import java.util.List;

public class Coach {

    private final String name;
    private final List<Menu> cannotEatMenus;

    public Coach(String name, List<Menu> cannotEatMenus) {
        this.name = name;
        this.cannotEatMenus = cannotEatMenus;
    }

    public String getName() {
        return name;
    }

    public boolean cannotEatMenusContain(Menu menu){
        return cannotEatMenus.contains(menu);
    }

}
