package menu.service;

import static menu.util.Constants.FRIDAY;
import static menu.util.Constants.MONDAY;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import menu.domain.Category;
import menu.domain.CategoryResult;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.domain.RandomMachine;

public class MenuService {

    private static final RandomMachine machine = RandomMachine.getInstance();

    public HashMap<Coach,List<Menu>> recommendMenus(List<Coach> coaches, CategoryResult categoryResult){
        HashMap<Coach,List<Menu>> recommendResults = initRecommendResults(coaches);
        for(int i=MONDAY;i<=FRIDAY;i++){
            List<String> menuNames = Menu.getMenusByCategory(categoryResult.getCategory(i));
            for (Coach coach : coaches) {
                List<Menu> menus = recommendResults.get(coach);
                menus.add(recommendMenu(coach,menuNames,menus));
                recommendResults.replace(coach,menus);
            }
        }
        return recommendResults;
    }

    private HashMap<Coach,List<Menu>> initRecommendResults(List<Coach> coaches) {
        HashMap<Coach,List<Menu>> recommendResults= new HashMap<>();
        coaches.forEach(coach -> recommendResults.put(coach,new ArrayList<>()));
        return recommendResults;
    }

    private Menu recommendMenu(Coach coach, List<String> menuNames, List<Menu> menus) {
        while(true){
            String menuName = machine.shuffle(menuNames).get(0);
            Menu menu = Menu.findMenuByName(menuName);
            if(!isAlreadyRecommended(menus,menu)&&!isInCannotEatMenu(coach,menu)){
                return Menu.findMenuByName(menuName);
            }
        }
    }

    private boolean isAlreadyRecommended(List<Menu> menus, Menu menu) {
        return menus.contains(menu);
    }

    private boolean isInCannotEatMenu(Coach coach, Menu menu) {
        return coach.cannotEatMenusContain(menu);
    }

}
