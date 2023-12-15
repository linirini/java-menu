package menu.domain;

import static menu.domain.Category.ASIAN;
import static menu.util.Constants.ASIAN_NUMBER;
import static menu.util.Constants.FRIDAY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CategoryResultTest {

    @DisplayName("요일에 해당하는 카테고리 정보를 반환한다.")
    @Test
    void 카테고리_조회(){
        assertThat(new CategoryResult(List.of(Category.KOREAN,Category.WESTERN,Category.JAPANESE,Category.CHINESE,
                ASIAN)).getCategory(FRIDAY)).isEqualTo(ASIAN);
    }

}