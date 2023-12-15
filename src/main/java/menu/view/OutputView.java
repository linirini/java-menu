package menu.view;

public class OutputView {
    
    public void printStartMessage(){
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }
    
    public void printResult(RecommendResult recommendResult){
        System.out.println("메뉴 추천 결과입니다.\n"
                + "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]\n"
                + "[ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]");
        printRecommendResult(recommendResult);
        System.out.println("\n추천을 완료했습니다.");
    }

    private void printRecommendResult(RecommendResult recommendResult) {
    }

}
