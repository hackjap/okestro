

## 꿀 단축키 
   
 >  ctrl + alt + shift + t  : extract method
 
 >  ctrl + shift + t : create Test

 > ctrl + alt + v : auto return 
 
## 스프링 웹 개발 기초
### 정적 컨텐츠
- static.html
  
      @GetMapping("hello")
      public String hello(Model model){
      model.addAttribute("data","JAPJPAJPA!!");
      return "hello";
      // return 의 hello를  resource: template/ 에서 찾아 템플릿 엔진처리를 해줌
      // 컨트롤러에서 리턴 값으로 문자를 반환하면 '뷰 리졸버'가 화면을 찾아서 처리
      }
  
### MVC와 템플릿 엔진
- Model
  : 
- View
  : 화면을 그리는 역할 
- Controller 
  : 비즈니스 로직이나 내부적인 로직
  
      // MVC를 이용한 웹 개발
      // 웹 브라우저 -> 서버 -> 스프링 컨테이너(컨트롤러->뷰리졸브)->서버->웹 브라우저
      @GetMapping("hello-mvc")
      public String helloMvc(@RequestParam("name") String name, Model model){
      model.addAttribute("name",name); // key, value
      return "hello-template";
    }
### API 

    // JSON 객체로 넘겨주는 API 방식 ( 통상적인 방식 )
    // 객체가 리턴값으로 오면 JSON 방식으로 전달하도록 내장되어있음 (JsonConverter)
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name")String name){
    Hello hello = new Hello();
    hello.setName(name);
    return hello;
    }
  

## 일반적인 웹 애플리케이션 게층 구조 

 컨트롤러 -> 서비스 -> 리포지토리 -> DB
         -> 도메인 <-
 

### 테스트

  패턴

        //given

        //when
        
        //then


## 스프링 빈과 의존관계

### 스프링 빈을 등록하는 2가지 방법 
- 컴포넌트 스캔과 자동 의존관계 설정
  @Autowired ,@Controller, @Service, @Repository
  
- 자바 코드로 직접 스프링 빈 등록하기 
  
  SpringConfig 파일을 만들어 다음과 같이 정의


    @Configuration
    public class SpringConfiguration {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
    
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

}
  
 controller는 어노테이션을 통해 bean 등록을 해주어야함

  > DI에는 필드 주입, setter 주입, 생성자 주입이 있음

 의존관계가 동적으로 변하는 경우는 거의 없으므로 결론적으로 생성자 주입을 사용하는게 좋다.


 > ※ 상황에 따라 구현 클래스를 변경해야 하면 설정을 통해 스프링 빈으로 등록한다.


## 회원 관리 예제 - 웹 MVC 개발 

### GET
> 주로 조회용, 
### POST 
> 주로 작성, form으로 받아 @PostMapping 으로 전달



## JPA
 ORM (Object Relation Mapping):  

 jpa = interface (표준)
 hybernate jpa의 구현체이자 사용되는 기술
 여러 업체에서 구현한 것들을 사용

 ### 사용법
> 자바객체의 @Entity 어노테이션을 달아줌
> EntityManager를 주입 받아야 함 
> 


### 스프링 데이터 JPA
> 실무에서 RDB의 JPA 는 필수!! JPA에서의 편리성을 극대화 





 