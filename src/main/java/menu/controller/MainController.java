package menu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import menu.domain.CategoryResult;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.domain.RecommendResult;
import menu.service.CategoryService;
import menu.service.MenuService;
import menu.view.OutputView;

public class MainController {

    private final InputController inputController = new InputController();
    private final OutputView outputView = new OutputView();
    private final CategoryService categoryService = new CategoryService();
    private final MenuService menuService = new MenuService();

    public void run() {
        startRecommendation();
        List<Coach> coaches = getInputs();
        CategoryResult categoryResult = categoryService.recommendCategories();
        RecommendResult recommendResult = recommendMenusForCoaches(categoryResult, coaches);
        terminate(categoryResult, recommendResult);
    }

    private void startRecommendation() {
        outputView.printStartMessage();
    }

    private List<Coach> getInputs() {
        List<Coach> coaches = new ArrayList<>();
        List<String> coachNames = inputController.inputCoachNamesUntilNoError();
        for (String coachName : coachNames) {
            List<Menu> menus = inputController.getCannotEatMenusUntilNoError(coachName);
            coaches.add(new Coach(coachName, menus));
        }
        return coaches;
    }

    private RecommendResult recommendMenusForCoaches(CategoryResult categoryResult,
            List<Coach> coaches) {
        HashMap<Coach, List<Menu>> recommendResults = new HashMap<>();
        for (Coach coach : coaches) {
            recommendResults.put(coach, menuService.recommendMenus(coach, categoryResult));
        }
        return new RecommendResult(recommendResults);
    }

    private void terminate(CategoryResult categoryResult, RecommendResult recommendResult) {
        outputView.printResult(categoryResult, recommendResult);
    }

}
