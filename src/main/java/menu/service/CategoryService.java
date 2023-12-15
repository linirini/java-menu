package menu.service;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Category;
import menu.domain.CategoryResult;
import menu.domain.RandomMachine;

public class CategoryService {

    private static final RandomMachine machine = RandomMachine.getInstance();
    private static final int MAXIMUM_SAME_CATEGORY_COUNT = 2;
    private static final int CATEGORIES_SIZE = 5;

    public CategoryResult recommendCategories(){
        List<Category> categories = new ArrayList<>();
        for(int i=0;i<CATEGORIES_SIZE;i++) {
            categories.add(recommendCategory(categories));
        }
        return new CategoryResult(categories);
    }

    private Category recommendCategory(List<Category> categories) {
        while(true){
            Category category = Category.findCategoryByOption(machine.createRandomNumber());
            if (canRecommend(category, categories)) {
                return category;
            }
        }
    }

    private boolean canRecommend(Category category, List<Category> categories) {
        return categories.stream().filter(selectedCategory -> selectedCategory == category).count()
                <= MAXIMUM_SAME_CATEGORY_COUNT;
    }

}
