package menu.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import menu.domain.Coach;

public class InputView {

    public String inputCoachNames(){
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        return readLine();
    }

    public String inputCannotEatMenus(Coach coach){
        System.out.println(coach.getName()+"(이)가 못 먹는 메뉴를 입력해 주세요.");
        return readLine();
    }

}
