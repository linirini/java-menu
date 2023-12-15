package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuTest {

    @DisplayName("카테고리에 해당하는 메뉴 이름 목록을 가져온다.")
    @Test
    void 카테고리로_메뉴_찾기(){
        assertThat(Menu.getMenusByCategory(Category.KOREAN)).contains("제육볶음");
    }

}