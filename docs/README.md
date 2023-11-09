# 미션 - 12월 이벤트 플래너

## 기능 요구사항

- [X] 사용자에게 12월 중 식당 예상 방문 날짜를 입력받는다.
    - [X] 입력은 숫자만 가능하며 1 이상 31 이하의 범위여야 한다.
    - [ ] 유효하지 않은 입력일 경우 에러 메시지를 출력하고 다시 입력받는다.
- [ ] 사용자에게 주문할 메뉴와 개수를 입력받는다.
    - [X] 유효하지 않은 입력일 경우 에러 메시지를 출력하고 다시 입력받는다.
    - [ ] 메뉴는 메뉴판에 존재하는 것만 가능하다.
    - [ ] 메뉴의 개수는 1 이상의 숫자여야 한다.
    - [ ] 음료만 주문 시, 주문할 수 없다.
    - [ ] 메뉴는 한 번에 최대 20개까지만 주문할 수 있다.
    - [ ] 메뉴 형식이 잘못된 경우 에러 메시지를 출력하고 다시 입력받는다.
    - [ ] 중복 메뉴 입력 시 에러 메시지를 출력하고 다시 입력받는다.
- [ ] 12월 이벤트 플래너가 입력 받은 정보를 기반으로 이벤트 혜택을 계산한다.
    - [ ] 일정 이상 금액부터 이벤트를 적용한다.
    - [ ] 크리스마스 디데이 할인 적용 기간 내 주문에 대한 할인을 계산한다.
    - [ ] 평일 할인 및 주말 할인을 계산한다.
    - [ ] 특별 할인이 적용되는 경우 할인을 계산한다.
    - [ ] 증정 이벤트가 적용되는 경우 증정 메뉴를 부여한다.
    - [ ] 총혜택 금액을 계산한다.
    - [ ] 할인 후 예상 결제 금액을 계산한다.
    - [ ] 12월 이벤트 배지를 부여한다.
- [ ] 사용자에게 결과를 출력한다.
    - [ ] 주문 메뉴 출력
    - [ ] 할인 전 총주문 금액 출력
    - [ ] 증정 메뉴 출력
    - [ ] 혜택 내역 출력
    - [ ] 총혜택 금액 출력
    - [ ] 할인 후 예상 결제 금액 출력
    - [ ] 12월 이벤트 배지 출력
    - [ ] 출력 순서는 자유롭게

## 프로그래밍 요구사항

- [ ] System.exit()를 호출하지 않는다.
- [ ] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다.
- [ ] 3항 연산자를 쓰지 않는다.
- [ ] 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- [ ] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만든다.
- [ ] Exception이 아닌 IllegalArgumentException 등과 같은 명확한 유형을 처리한다.
- [ ] ParameterizedTest로 값만이 변경되는 테스트를 테스트한다.