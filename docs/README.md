# 🚀기능 명세서

## 기능
- [x] 메뉴 카테고리 추천 기능 - CategoryService
  - [x] 요일마다 카테고리 추천 - CategoryService#recommendCategory
  - [x] 요일 별로 추천된 카테고리를 가져온다 - CategoryResult#getCategory
  - [x] camp.nextstep.edu.missionutils에서 제공하는 Randoms.pickNumberInRange()에서 생성해 준 값을 이용 - RandomMachine#createRandomNumber
    - [x] 결과가 1이면 일식, 2면 한식, 3이면 중식, 4면 아시안, 5면 양식을 추천 - CategoryEnum
      - [x] 순서 변경 금지
  - [x] 추천할 수 없는 메뉴인 카테고리인 경우 : 한 주에 같은 카테고리 최대 2회 선정 가능
    - [x] 일주일 간 선정된 카테고리 횟수 - CategoryService
    - [x] 다시 랜덤 값 생성 
- [x] 코치 메뉴 추천 기능 - MenuService
  - [x] 메뉴 순서를 섞어서 나오는 첫번째 메뉴 추천 - RandomMachine#shuffleMenus
  - [x] camp.nextstep.edu.missionutils에서 제공하는 Randoms.shuffle()을 통해 임의의 순서로 섞은 후, 첫 번째 값을 사용
    - [x] List<String> 형태로 카테고리 포함 메뉴 목록 준비 - MenuEnum#getMenusByCategory
      - [x] 최초에 제공한 목록을 그대로 전달
      - [x] 이미 추천한 메뉴, 먹지 못하는 메뉴도 포함된 리스트를 전달
  - [x] 추천하지 못하는 경우 
    - [x] 각 코치에게 한 주에 중복되지 않는 메뉴 추천 - RecommendResult#contains
    - [x] 코치가 못 먹는 메뉴 추천 - Coach#cannotEatMenusContain
    - [x] 다시 섞은 후 사용
- [x] 카테고리와 메뉴 요구사항 - CategoryEnum, MenuEnum
  - [x] 카테고리에 속한 메뉴들의 이름을 찾는다 - MenuEnum#getMenusByCategory
```
일식: 규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼
한식: 김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음
중식: 깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채
아시안: 팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜
양식: 라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니
```


## 입출력
- [x] 서비스 시작
  - [x] "점심 메뉴 추천을 시작합니다." 출력
- [x] 코치 이름 입력
  - [x] "코치의 이름을 입력해 주세요. (, 로 구분)" 출력
  - [x] ","로 구분
  - [x] 예외
    - [x] 형식에 맞지 않는 경우
    - [x] 코치가 2명 미만, 5명 초과인 경우
    - [x] 코치 이름이 2글자 미만, 4글자 초과인 경우
- [x] 각 코치가 못 먹는 메뉴 입력
  - [x] "코치명(이)가 못 먹는 메뉴를 입력해 주세요." 출력
  - [x] ","로 구분
  - [x] 예외
    - [x] 형식에 맞지 않는 경우
    - [x] 못 먹는 메뉴가 0개 미만 2개 초과인 경우
    - [x] 같은 메뉴를 중복해서 입력한 경우
- [x] 서비스 종료
  - [x] 메뉴 추천 결과 출력
    - [x] "메뉴 추천 결과입니다.\n
      [ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]\n
      [ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]\n
      [ 코치명 | 메뉴명1 | 메뉴명2 | 메뉴명3 | 메뉴명4 | 메뉴명5 ]\n\n
      추천을 완료했습니다."
- [x] 예외 문구 출력
  - [x] "[ERROR] 메세지 내용"
