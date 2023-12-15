package menu.controller;

import static menu.util.Constants.BLANK;
import static menu.util.Constants.MAXIMUM_CANNOT_EAT_MENUS_COUNT;
import static menu.util.Constants.MAXIMUM_NAME_COUNT;
import static menu.util.Constants.MAXIMUM_NAME_LENGTH;
import static menu.util.Constants.MINIMUM_CANNOT_EAT_MENUS_COUNT;
import static menu.util.Constants.MINIMUM_NAME_COUNT;
import static menu.util.Constants.MINIMUM_NAME_LENGTH;
import static menu.util.Constants.SEPARATOR;
import static menu.util.ExceptionEnum.DUPLICATED_MENU;
import static menu.util.ExceptionEnum.INVALID_FORMAT;
import static menu.util.ExceptionEnum.INVALID_MENU_COUNT;
import static menu.util.ExceptionEnum.INVALID_NAME_COUNT;
import static menu.util.ExceptionEnum.INVALID_NAME_LENGTH;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Menu;
import menu.view.InputView;

public class InputController {

    private static InputView inputView = new InputView();

    public List<String> inputCoachNamesUntilNoError() {
        while (true) {
            String input = inputView.inputCoachNames();
            try {
                return getCoachNames(input);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<String> getCoachNames(String input) {
        validateFormat(input);
        throwIfInvalidNameCount(input.split(SEPARATOR));
        List<String> names = List.of(input.split(SEPARATOR));
        for (String name : names) {
            throwIfInvalidNameLength(name);
        }
        return names;
    }

    private void throwIfInvalidNameCount(String[] names) {
        if (names.length < MINIMUM_NAME_COUNT || names.length > MAXIMUM_NAME_COUNT) {
            throw new IllegalArgumentException(INVALID_NAME_COUNT.getMessage());
        }
    }

    private void throwIfInvalidNameLength(String name) {
        if (name.length() < MINIMUM_NAME_LENGTH || name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH.getMessage());
        }
    }

    public List<Menu> getCannotEatMenusUntilNoError(String coachName) {
        while (true) {
            String input = inputView.inputCannotEatMenus(coachName);
            try {
                return getCannotEatMenus(input);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Menu> getCannotEatMenus(String input) {
        validateFormat(input);
        List<String> menuNames = List.of(input.split(SEPARATOR));
        throwIfDuplicatedMenus(menuNames);
        throwIfInvalidMenusCount(menuNames);
        return convertToMenus(menuNames);
    }

    private void validateFormat(String input) {
        throwIfInputStartWithBlank(input);
        throwIfEmptyInput(input);
    }

    private void throwIfInputStartWithBlank(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(INVALID_FORMAT.getMessage());
        }
    }

    private void throwIfEmptyInput(String input) {
        if (input.charAt(0) == BLANK) {
            throw new IllegalArgumentException(INVALID_FORMAT.getMessage());
        }
    }

    private void throwIfDuplicatedMenus(List<String> cannotEatMenus) {
        if (cannotEatMenus.size() != cannotEatMenus.stream().distinct().count()) {
            throw new IllegalArgumentException(DUPLICATED_MENU.getMessage());
        }
    }

    private void throwIfInvalidMenusCount(List<String> menus) {
        if (menus.size() < MINIMUM_CANNOT_EAT_MENUS_COUNT
                || menus.size() > MAXIMUM_CANNOT_EAT_MENUS_COUNT) {
            throw new IllegalArgumentException(INVALID_MENU_COUNT.getMessage());
        }
    }

    private List<Menu> convertToMenus(List<String> menuNames) {
        List<Menu> menus = new ArrayList<>();
        menuNames.forEach(menuName -> menus.add(Menu.findMenuByName(menuName)));
        return menus;
    }


}
