package menu.service;

import menu.domain.Category;
import menu.domain.RandomMachine;

public class CategoryService {

    private static final RandomMachine machine = RandomMachine.getInstance();

    public Category recommendCategory(){
        return Category.findCategoryByOption(machine.createRandomNumber());
    }

}
