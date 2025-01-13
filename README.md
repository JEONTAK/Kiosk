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
- [ ] MenuItem 클래스 생성
  - 개별 음식 항목을 관리하는 클래스
  - 필드 : 이름, 가격, 설명
- [ ] main에서 MenuItem 클래스를 활용하여 햄버거 메뉴를 출력
  - MenuItem 객체 생성을 통해 이름, 가격, 설명을 세팅
  - List를 활용하여 MenuItem 추가
- [ ] 반복문을 통해 menuItems를 탐색


#### Design (Class and Method)

- [ ] Main
  - 프로세스 컨트롤
  - Print 역할
    - MenuItem 출력, 예외 처리 출력
- [ ] MenuItem
  - 객체 역할
    - 이름, 가격, 설명 값 저장
    - 이름 : menuName (String)
    - 가격 : menuPrice (double)
    - 설명 : menuInfo (String)
---
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