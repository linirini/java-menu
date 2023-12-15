package menu.domain;

import java.util.ArrayList;
import java.util.List;

public enum Menu {

    GYUDON("규동"),
    UDON("우동"),
    MISHOSHIRU("미소시루"),
    SUSHI("스시"),
    KATSUDONG("가츠동"),
    ONIGIRI("오니기리"),
    HIGHRICE("하이라이스"),
    RAMEN("라멘"),
    OKONOMIYAKI("오코노미야끼"),
    GIMBAP("김밥"),
    KIMCHI_STEW("김치찌개"),
    SSAMBAP("쌈밥"),
    SOYBEAN_STEW("된장찌개"),
    BIBIMBAP("비빔밥"),
    KALGUKSU("칼국수"),
    BULGOGI("불고기"),
    TTEOKBOKKI("떡볶이"),
    PORK_FRIED("제육볶음"),
    KKANPUNGGI("깐풍기"),
    NOODLES_FRIED("볶음면"),
    DONGPAYUK("동파육"),
    BLACK_NOODLES("짜장면"),
    JJAMPPONG("짬뽕"),
    MAPA_TOFU("마파두부"),
    SWEET_PORK("탕수육"),
    TOMATO_EGGS_FRIED("토마토 달걀볶음"),
    CHILI_JAPCHAE("고추잡채"),
    PADTHAI("팟타이"),
    KAOPAD("카오 팟"),
    NASHIGOREONG("나시고랭"),
    PINEAPPLE_FRIED_RICE("파인애플 볶음밥"),
    RICE_NOODLES("쌀국수"),
    TOMYAMKUNG("똠얌꿍"),
    BANH_MI("반미"),
    SPRING_ROLLS("월남쌈"),
    BUNCHA("분짜"),
    LASAGNA("라자냐"),
    GRATIN("그라탱"),
    GNOCCHI("뇨끼"),
    KISHU("끼슈"),
    FRENCH_TOAST("프렌치 토스트"),
    BAGUETTE("바게트"),
    SPAGHETTI("스파게티"),
    PIZZA("피자"),
    PANINI("파니니");

    private final String name;

    Menu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<String> getMenusByCategory(Category category) {
        List<String> menuNames = new ArrayList<>();
        category.getMenus().stream().forEach(menu -> menuNames.add(menu.name));
        return menuNames;
    }

}
