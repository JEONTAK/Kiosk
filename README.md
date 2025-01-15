# Kiosk

---
## Lv 1. 기본적인 키오스크를 프로그래밍해보자

### Requirement

#### Definition

- [X] 햄버거 메뉴 출력 및 선택하기
  - [X] 여러 햄버거 메뉴를 출력
    - 햄버거 메뉴는 String[] 배열에 미리 담아 사용
  - [X] 제시된 메뉴 중 입력받은 숫자에 따라 다른 로직을 실행하는 코드를 작성
    - 입력받은 숫자에 해당하는 메뉴를 출력
  - [X] 반복문을 이용하여 특정 번호가 입력되면 프로그램을 종료
    - 특정 번호는 0으로 설정
    - [X] 0 ~ 메뉴 번호 외의 번호 입력 시, 예외 처리


#### Design (Pseudocode)
```
String[] menu = {"menu1", "menu2", ..., "menuN"};
while(true){
            Print menus

            Get selectMenu(user input)
            
            if(selectMenu is between 1 and menu.length inclusive) then
                Print the menu[selectMenu - 1]
            else if(selectMenu is 0) then
                finish
            else
                Throw exception
        }
```
---
## Lv 2. 객체 지향 설계를 적용해 햄버거 메뉴를 클래스로 관리하기

### Requirement

#### Definition

- [X] MenuItem 클래스 생성
  - 개별 음식 항목을 관리하는 클래스
  - 필드 : 이름, 가격, 설명

- [X] main에서 MenuItem 클래스를 활용하여 햄버거 메뉴를 출력
  - MenuItem 객체 생성을 통해 이름, 가격, 설명을 세팅
  - List를 활용하여 MenuItem 추가

- [X] 반복문을 통해 menuItems를 탐색


#### Design (Class and Method)

- [X] Main
  - 프로세스 컨트롤
  - 사용자 입력 값 받음
  - 예외 처리 출력

- [X] MenuItem
  - 객체 역할
    - 이름, 가격, 설명 값 저장
    - 이름 : menuName (String)
    - 가격 : menuPrice (double)
    - 설명 : menuInfo (String)
  - [X] toString()
    - 객체 출력 역할
---
## Lv 3. 객체 지향 설계를 적용해 순서 제어를 클래스로 관리하기

### Requirement

- [X] Main에서 관리하던 전체 순서 제어를 Kiosk 클래스를 통해 관리

#### Definition
- [X] Kiosk 클래스 생성
  - 키오스크 프로그램의 메뉴를 관리하고 사용자 입력을 처리하는 클래스
  - MenuItem을 관리하는 리스트가 필드로 존재
  - Main 함수에서 관리하던 입력과 반복문 로직은 start 함수를 만들어 관리
  - List<MenuItem> menuItems는 Kiosk 클래스 생성자를 통해 값을 할당.
    - Kiosk 객체를 생성하고 사용하는 main 함수에서 객체를 생성할 때 값을 넘겨줌

- [X] 키오스크 프로그램을 시작하는 메서드가 구현되어야 함
  - [X] 콘솔에 햄버거 메뉴 출력
  - [X] 사용자의 입력을 받아 메뉴를 선택하거나 프로그램을 종료
    - [X] 유효하지 않은 입력에 대해 오류 메시지를 출력
    - [X] 0을 입력하면 프로그램이 종료

#### Design (Class and Method)

- [X] Main
  - Kiosk 객체 생성
  - 메뉴 저장
  - start() : 어플리케이션 실행 역할
    - 해당 메서드는 Kiosk 클래스에 존재

- [X] Kiosk
  - 필드 : List<MenuItem>
  - 프로세스 컨트롤
  - 사용자 입력 값 받음
  - 예외 처리 출력
  - add(MenuItem) : 메뉴아이템을 list에 저장

- [X] MenuItem
  - 객체 역할
    - 이름, 가격, 설명 값 저장
    - 이름 : menuName (String)
    - 가격 : menuPrice (double)
    - 설명 : menuInfo (String)
  - [X] toString()
    - 객체 출력 역할

- [X] InvaildInputException
  - 입력 받은 값이 숫자가 아닐 경우 예외 처리 위함
---
## Lv 4. 객체 지향 설계를 적용해 순서 제어를 클래스로 관리하기

### Requirement

- [X] Menu 클래스를 생성해 MenuItem 클래스를 관리


#### Definition
- [X] Menu 클래스 생성
  - MenuItem을 관리하는 클래스
    - 예를 들어, 버거 메뉴, 음료 메뉴 등 각 카테고리 내에 여러 MenuItem을 포함함
    - [X] List<MenuItem>은 Kiosk 클래스가 아닌 Menu 클래스가 관리하도록 변경
    - [X] 여러 버거들을 포함하는 상위 개념 `버거`같은 카테고리 이름 필드를 가짐
    - [X] 메뉴 카테고리 이름을 반환하는 메서드가 구현되어야 함

- [X] Lv4를 구현하면 터미널에 아래와 같이 보여야 함.
```
[ MAIN MENU ]
1. Burgers
2. Drinks
3. Desserts
0. 종료      | 종료
1 <- // 1을 입력

[ BURGERS MENU ]
1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거
2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거
3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거
4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거
0. 뒤로가기
2 <- // 2를 입력
선택한 메뉴: SmokeShack | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거

[ MAIN MENU ]
1. Burgers
2. Drinks
3. Desserts
0. 종료      | 종료
0 <- // 0을 입력
프로그램을 종료합니다.
```
#### Design (Class and Method)

- [X] Main
  - Menu 객체 생성을 통해 카테고리 별 메뉴 생성
  - 카테고리별 메뉴 저장
  - Kiosk 객체 생성
  - Kiosk에 List<Menu>를 통해 메뉴 저장
  - start() : 어플리케이션 실행 역할
    - 해당 메서드는 Kiosk 클래스에 존재

- [X] Kiosk
  - 필드 : List<Menu>
  - 프로세스 컨트롤
  - 사용자 입력 값 받음
  - 입력 값 Menu에 전달
  - add(Menu) : 메뉴를 list에 저장

- [X] Menu
  - 필드 : List<MenuItem> "카테고리 이름"
  - add(MenuItem) : 메뉴아이템을 list에 저장
  - [X] toString() : 카테고리 출력 역할
  - 예외 처리 출력 메서드(1. 숫자인지, 2. 범위에 해당하는 숫자 인지)

- [X] MenuItem
  - 객체 역할
    - 이름, 가격, 설명 값 저장
    - 이름 : menuName (String)
    - 가격 : menuPrice (double)
    - 설명 : menuInfo (String)
  - [X] toString()
    - 객체 출력 역할

- [X] InvaildInputException
  - 입력 받은 값이 숫자가 아닐 경우 예외 처리 위함

- [X] InvaildRangeException
  - 입력 받은 값이 범위안에 들어있지 않은 숫자일 경우

**김수정 튜터님 피드백**
1. 에러의 책임을 분리
2. return이 있다면 아래 조건문을 분리하는 것이 좋음
---
## Lv 5. 캡슐화 적용하기

### Requirement

- [X] MenuItem, Menu, Kiosk 클래스의 필드에 직접 접근 불가능하게 설정
- [X] Getter, Setter 메서드를 사용해 데이터를 관리


#### Definition
- [X] Lv4 부분의 필드를 private로 설정
- [X] 간접 접근을 위한 Getter, Setter 메서드 사용

---

## Lv 6-1. 장바구니 및 구매하기 기능을 추가하기

### Requirement

#### Definition

- [X] 장바구니 생성 및 관리 기능
  - [X] 사용자가 선택한 메뉴를 장바구니에 추가할 수 있는 기능을 제공
  - [X] 장바구니는 메뉴명, 수량, 가격 정보를 저장
  - [X] 항목을 동적으로 추가 및 조회할 수 있어야 함
  - [X] 사용자가 잘못된 선택을 했을 경우 예외 처리

- [X] 장바구니 출력 및 금액 계산
  - [X] 사용자가 결제를 시도하기 전에, 장바구니에 담긴 모든 메뉴와 총 금액을 출력
  - 출력 예시
    - 각 메뉴의 이름, 가격, 수량
    - 총 금액 합계

- [X] 장바구니 담기 기능
  - 해당 메뉴를 선택 시, 장바구니에 추가할 지 물어보고, 입력값에 따라 "추가", "취소" 처리
  - 메뉴는 한 번에 1개만 담기 가능

- [X] 주문 기능
  - [X] 장바구니에 담긴 모든 항목을 출력
  - [X] 합산하여 총 금액을 계산하고, "주문하기" 선택시 장바구니 초기화

```
[ MAIN MENU ]
1. Burgers
2. Drinks
3. Desserts
0. 종료      | 종료
1 <- // 1을 입력

[ BURGERS MENU ]
1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거
2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거
3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거
4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거
0. 뒤로가기
2 <- // 2를 입력
선택한 메뉴: SmokeShack | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거

// 2번을 누르면 나오는 메뉴입니다.
"SmokeShack | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"
위 메뉴를 장바구니에 추가하시겠습니까?
1. 확인        2. 취소
1 <-

// 1번을 누르면 나오는 메뉴입니다.
SmokeShack 이 장바구니에 추가되었습니다.

// 장바구니에 물건이 들어 있으면 아래와 같이 [ ORDER MENU ] 가 추가로 출력됩니다.
// 만약에 장바구니에 물건이 들어 있지 않다면 [ ORDER MENU ] 가 출력되지 않습니다. 
// 미출력일 때 4,5 번을 누르면 예외를 던저줘야 합니다.
아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.

[ MAIN MENU ]
1. Burgers
2. Drinks
3. Desserts
0. 종료      | 종료

[ ORDER MENU ]
4. Orders       | 장바구니를 확인 후 주문합니다.
5. Cancel       | 진행중인 주문을 취소합니다.
4 <- // 4를 입력

// 4번을 누르면 나오는 메뉴입니다.
아래와 같이 주문 하시겠습니까?

[ Orders ]
SmokeShack | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거

[ Total ]
W 8.9

1. 주문      2. 메뉴판
1 <-

// 1번을 누르면 나오는 메뉴입니다.
주문이 완료되었습니다. 금액은 W 8.9 입니다.
```
#### Design (Class and Method)

- [X] Order 클래스 생성
  - Order 클래스에는 Map<MenuItem, Integer>필드가 존재
    - 각 메뉴의 정보 및 수량 정보를 나타냄
  - [X] addOrder : Order에 아이템 담기
  - [X] printOrders : Order에 담은 모든 메뉴 및 총 합계 출력
  - [X] getTotalprice : 전체 메뉴 가격의 총합 계산 후 반환
  - [X] clear : 장바구니 초기화

- [X] Kiosk 클래스에 추가
  - [X] 장바구니 객체 생성
  - [X] 장바구니에 메뉴가 담겨 있을 경우, [ORDER MENU] 출력 -> printCategory 메서드에 추가
  - [X] 메인 메뉴 및 장바구니에서 메인 메뉴 선택시 세부 메뉴 출력, 장바구니 목록 선택시 해당 장바구니 수행
  - [X] 주문 확인 절차에서 1.주문 클릭시 장바구니 초기화, 2번 클릭시 다시 메인메뉴 보이게
---
## Commit Convention

### 형식

```
type(scope) : short summary

[body]

[footer]
```

<br>type : 커밋의 목적
<br>scope : 변경된 코드의 범위
<br>short summary : 커밋의 간략한 설명
<br>body : 커밋의 자세한 설명
<br>footer : 부가 정보

### type

<br>feat: 새로운 기능 추가.
<br>fix: 버그 수정.
<br>docs: 문서 수정 (README.md, 주석 등).
<br>style: 코드 포맷팅, 세미콜론 누락 등 기능에 영향을 미치지 않는 변경.
<br>refactor: 코드 리팩토링 (기능 변화 없음).
<br>test: 테스트 코드 추가/수정.
<br>chore: 빌드 프로세스 또는 패키지 매니저 설정 수정.
<br>perf: 성능 개선을 위한 변경.
<br>ci: CI 설정 변경.
<br>build: 빌드 관련 파일 변경.

#### Type Emoji

✨ : feat
<br>🐛 : fix
<br>📝 : docs
<br>🎨 : style
<br>🔨 : refactor
<br>🚀 : perf
<br>✅ : test
<br>📦 : chore
<br>🗑️ : delete
---

## Code Convention

<br>class name : PascalCase(ex: MyClass)
<br>method and var : camelCase(ex: userName)
<br>const : UPPER_SNAKE_CASE(ex: MAX_LENGTH)

class : 명사형
<br>interface : 형용사 or 명사형
<br>method : 동사형
<br>var : 명사형, 의미 알수 있도록 명확히
<br>들여 쓰기 : 4칸
<br>중괄호 : 한 줄 아래에서 시작
<br>공백 : 연산자, 피연산자 사이에 공백 사용 ex : total = price + tax; / calculateTotal(price, tax);

주석 : 가능하면 JavaDoc 형식 사용

코드 : 클래스 내부 코드는 const, field, constructor, method 순으로 작성

---

### Class Diagram 작성법

#### 클래스 표기

+: public
<br> -: private
<br> #: protected
<br> (공백) : default

#### Association
정확히 하나 : 1
<br> 0 or 1 : 0..1
<br> 0개 이상 : 0..
<br> 1개 이상 : 1..*
<br> 정확한 숫자 : 3..4 or 6
<br> 복잡한 관계 : 0..1, 3..4, 6.* -> 2,5 이외의 수 의미

#### Relation

Interface : << >>
<br> Abstract : Italic
<br> Dependency : 점선
<br> Association : 실선
<br> Inheritance : 속이 빈 화살표를 가진 실선
<br> Realization : 속이 빈 화살표를 가진 점선
<br> Aggregation : 속이 빈 마름모를 가진 실선
<br> Composition : 속이 찬 마름모를 가진 실선