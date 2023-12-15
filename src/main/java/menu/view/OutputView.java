package menu.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import menu.domain.CategoryResult;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.domain.RecommendResult;

public class OutputView {

    public static final String OPEN_SQUARE_BRACKET = "[ ";
    public static final String CLOSE_SQUARE_BRACKET = " ]";
    public static final String SEPARATOR = " | ";
    public static final String CATEGORY_TITLE = "카테고리";
    
    public void printStartMessage(){
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }
    
    public void printResult(CategoryResult categoryResult,RecommendResult recommendResult){
        System.out.println("메뉴 추천 결과입니다.\n"
                + "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        printCategoryResult(categoryResult);
        printRecommendResult(recommendResult);
        System.out.println("\n추천을 완료했습니다.");
    }

    private void printCategoryResult(CategoryResult categoryResult) {
        StringBuilder output = new StringBuilder();
        output.append(OPEN_SQUARE_BRACKET+CATEGORY_TITLE+ SEPARATOR);
        output.append(String.join(SEPARATOR,categoryResult.getCategoryNames()));
        output.append(CLOSE_SQUARE_BRACKET);
        System.out.println(output);
    }

    private void printRecommendResult(RecommendResult recommendResult) {
        for (Entry<Coach, List<Menu>> entry : recommendResult.getResults().entrySet()) {
            StringBuilder output = new StringBuilder();
            output.append(OPEN_SQUARE_BRACKET);
            output.append(entry.getKey().getName()+ SEPARATOR);
            output.append(String.join(SEPARATOR,getMenuNames(entry.getValue())));
            output.append(CLOSE_SQUARE_BRACKET);
            System.out.println(output);
        }
    }

    private List<String> getMenuNames(List<Menu> menus) {
        List<String> names = new ArrayList<>();
        menus.forEach(menu -> names.add(menu.getName()));
        return names;
    }

}
