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

- [ ] Main에서 관리하던 전체 순서 제어를 Kiosk 클래스를 통해 관리

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