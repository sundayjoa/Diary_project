# Diary_project
나만의 일기장 만들기 프로젝트

*개발환경*
언어: Java(JDK 17.0.6), HTML/CSS, JavaScript

서버: Apache Tomcat 10.1.19

프레임워크: Spring Boot

DB: MySQL 8.0.33

IDE: 이클립스 4.27.0

버전 관리: GitHub

*주요 기능*
1. 회원가입 및 로그인
2. 일기 작성
3. 일기 주제 추천
4. 공개 일기와 비공개 일기 선택
5. 일기 조회
6. 일기 수정 및 삭제
7. 교환 일기
8. 좋아요 기능

   

*트러블 슈팅*

문제 상황 1

-엔티티에 데이터베이스 필드명을 직접 설정했음에도 불구하고, Rest API를 실행시키면 필드명이 소문자와 언더바로 변환되어 호출. 해당 오류에서는 @Column(name="DiaryNumber", columnDefinition = "BIGINT")로 설정한 'DiaryNumber' 필드가 'diary_number'로 변환되어 호출.

원인 분석

-해당 문제는 JPA와 Hibernate가 기본적으로 사용하는 네이밍 전략 때문에 발생한 것으로 보임. Hibernate는 기본 설정으로 CamelCase 표기법을 Snake_Case 표기법으로 변환하는 네이밍 전략 사용.

-CamelCase 표기법: 각 단어의 첫 글자를 대문자로 쓰는 방식. 첫 단어의 첫 글자는 소문자로 시작하되, 그 이후의 단어들의 첫 글자는 대문자로 표시하는 LowerCamelCase와 모든 단어를 대문자로 시작하는 UpperCamelCase로 세분화됨.

-Snake_Case 표기법: 모든 단어를 소문자로 쓰고, 단어 사이를 언더바(_)로 구분하는 방식.

해결방법

-Hibernate의 네이밍 전략을 표준 네이밍 전략으로 번경.

-'application.properties' 파일에 다음 코드 추가.

 spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl

 해당 코드 추가 후 엔티티의 필드명을 변환하지 않고 호출.


 문제 상황 2

 -게시글의 좋아요 수를 가져오는 Rest API를 실행하던 중, 'Failed to complete request: java.lang.NullPointerException' 오류 발생. 해당 오류는 Service에서 null 값을 가져오면서 발생하는 것으로 보임.

 원인 분석
 
 -'@Autowired' 애너테이션이 제대로 적용되지 않아서 발생.
 
 -'@Autowired' 애너테이션을 한 번만 선언하면 해당 클래스의 모든 필드에 적용된다고 잘못 이해.
 
 -'@Autowired' 애너테이션은 각각의 필드에 대해 별도로 선언해야 함. 그렇지 않을 경우 Spring이 해당 필드를 주입하지 않기 때문에 null 값 반환.

 해결방법
 
 -각 private 필드에 '@Autowired' 애너테이션을 명시적으로 추가.

 수정 이전 코드:
 
   @Autowired
    private LikeRepository likeRepository;
    private LikeService likeService;

 수정된 코드:
 
  @Autowired
    private LikeRepository likeRepository;
  
  @Autowired
    private LikeService likeService;


 
