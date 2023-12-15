package menu.controller;

import static menu.util.Constants.MAXIMUM_NAME_COUNT;
import static menu.util.Constants.MAXIMUM_NAME_LENGTH;
import static menu.util.Constants.MINIMUM_NAME_COUNT;
import static menu.util.Constants.MINIMUM_NAME_LENGTH;
import static menu.util.Constants.NAME_SEPARATOR;
import static menu.util.ExceptionEnum.INVALID_NAME_COUNT;
import static menu.util.ExceptionEnum.INVALID_NAME_LENGTH;

import java.util.List;
import menu.domain.Coach;
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
        throwIfInvalidNameCount(input.split(NAME_SEPARATOR));
        List<String> names = List.of(input.split(NAME_SEPARATOR));
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

    private void validateFormat(String input) {

    }


}
