package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class CategoryResult {

    private List<Category> categories;

    public CategoryResult(List<Category> categories) {
        this.categories = categories;
    }

    public Category getCategory(int day){
        return categories.get(day);
    }

}
