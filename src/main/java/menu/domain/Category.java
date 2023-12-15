package menu.domain;

import static menu.domain.Menu.BAGUETTE;
import static menu.domain.Menu.BANH_MI;
import static menu.domain.Menu.BIBIMBAP;
import static menu.domain.Menu.BLACK_NOODLES;
import static menu.domain.Menu.BULGOGI;
import static menu.domain.Menu.BUNCHA;
import static menu.domain.Menu.CHILI_JAPCHAE;
import static menu.domain.Menu.DONGPAYUK;
import static menu.domain.Menu.FRENCH_TOAST;
import static menu.domain.Menu.GIMBAP;
import static menu.domain.Menu.GNOCCHI;
import static menu.domain.Menu.GRATIN;
import static menu.domain.Menu.GYUDON;
import static menu.domain.Menu.HIGHRICE;
import static menu.domain.Menu.JJAMPPONG;
import static menu.domain.Menu.KALGUKSU;
import static menu.domain.Menu.KAOPAD;
import static menu.domain.Menu.KATSUDONG;
import static menu.domain.Menu.KIMCHI_STEW;
import static menu.domain.Menu.KISHU;
import static menu.domain.Menu.KKANPUNGGI;
import static menu.domain.Menu.LASAGNA;
import static menu.domain.Menu.MAPA_TOFU;
import static menu.domain.Menu.MISHOSHIRU;
import static menu.domain.Menu.NASHIGOREONG;
import static menu.domain.Menu.NOODLES_FRIED;
import static menu.domain.Menu.OKONOMIYAKI;
import static menu.domain.Menu.ONIGIRI;
import static menu.domain.Menu.PADTHAI;
import static menu.domain.Menu.PANINI;
import static menu.domain.Menu.PINEAPPLE_FRIED_RICE;
import static menu.domain.Menu.PIZZA;
import static menu.domain.Menu.PIZZE;
import static menu.domain.Menu.PORK_FRIED;
import static menu.domain.Menu.RAMEN;
import static menu.domain.Menu.RICE_NOODLES;
import static menu.domain.Menu.SOYBEAN_STEW;
import static menu.domain.Menu.SPAGHETTI;
import static menu.domain.Menu.SPRING_ROLLS;
import static menu.domain.Menu.SSAMBAP;
import static menu.domain.Menu.SUSHI;
import static menu.domain.Menu.SWEET_PORK;
import static menu.domain.Menu.TOMATO_EGGS_FRIED;
import static menu.domain.Menu.TOMYAMKUNG;
import static menu.domain.Menu.TTEOKBOKKI;
import static menu.domain.Menu.UDON;
import static menu.util.Constants.ASIAN_NUMBER;
import static menu.util.Constants.CHINESE_NUMBER;
import static menu.util.Constants.JAPANESE_NUMBER;
import static menu.util.Constants.KOREAN_NUMBER;
import static menu.util.Constants.WESTERN_NUMBER;

import java.util.List;

public enum Category {

    JAPANESE("일식",JAPANESE_NUMBER,List.of(GYUDON, UDON,MISHOSHIRU, SUSHI, KATSUDONG, ONIGIRI, HIGHRICE, RAMEN, OKONOMIYAKI)),
    KOREAN("한식",KOREAN_NUMBER,List.of( GIMBAP, KIMCHI_STEW, SSAMBAP, SOYBEAN_STEW, BIBIMBAP, KALGUKSU, BULGOGI, TTEOKBOKKI, PORK_FRIED)),
    CHINESE("중식",CHINESE_NUMBER,List.of(KKANPUNGGI, NOODLES_FRIED, DONGPAYUK, BLACK_NOODLES, JJAMPPONG, MAPA_TOFU, SWEET_PORK, TOMATO_EGGS_FRIED, CHILI_JAPCHAE)),
    ASIAN("아시안",ASIAN_NUMBER,List.of(PADTHAI, KAOPAD, NASHIGOREONG, PINEAPPLE_FRIED_RICE,RICE_NOODLES, TOMYAMKUNG,BANH_MI, SPRING_ROLLS, BUNCHA)),
    WESTERN("양식",WESTERN_NUMBER,List.of(LASAGNA, GRATIN, GNOCCHI, KISHU, FRENCH_TOAST, BAGUETTE, SPAGHETTI, PIZZA, PANINI));

    private final String name;
    private final String option;
    private final List<Menu> menus;

    Category(String name, String option, List<Menu> menus) {
        this.name = name;
        this.option = option;
        this.menus = menus;
    }
}
