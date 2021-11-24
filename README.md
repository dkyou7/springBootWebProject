# chapter02

### 키워드
jpa, mariadb

### 개발 환경
- grale project
- war
- jdk8

### 핵심 dependencies
- spring web
- spring data jpa

### 배운 것
- jpa 추가 시 관련 설정들을 가져올 수 있다.
- 이때, 적절한 db를 설정해주지 않으면 오류를 뱉어낸다.
- mariadb 설치 및 운영법
- JPA는 인터페이스 선언만으로도 자동으로 스프링의 빈으로 등록됩니다.
    - 스프링이 내부적으로 인터페이스 타입에 맞는 객체를 생성해서 빈으로 등록합니다.
- insert, update 작업 시 사용하는 메서드는 동일하게 save 이다.
    - Entity Manager가 객체를 비교해서 없다면 insert, 있다면 update를 동작시키기 때문에
- 테스트 코드 작성 시, Autowired 작성하면 동적 프록시가 이루어진다.
  - 스프링이 내부적으로 해당 클래스를 자동으로 생성한다.(AOP 기능)
  - com.sun.proxy.$ProxyXX 의 방식으로 생성된다.




