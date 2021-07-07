# JMeter를 활용한 성능 테스트

![image-20210701102542849](C:\Users\hotoron\AppData\Roaming\Typora\typora-user-images\image-20210701102542849.png)

![image-20210701102651404](C:\Users\hotoron\AppData\Roaming\Typora\typora-user-images\image-20210701102651404.png)

일반적으로 성능을 말할때 10TPS이렇게 말한다 성능을 말할때 정확한 단위

사용자수 <= 트랜잭션수



- 성능테스트 도구
  - 마이크로포커스
  - locust
  - nGrinder
  - JMeter

![image-20210701103050226](C:\Users\hotoron\AppData\Roaming\Typora\typora-user-images\image-20210701103050226.png)

레코딩이 뭔가? 모든 일련의 로그들을 기록하는 것

![image-20210701103250779](C:\Users\hotoron\AppData\Roaming\Typora\typora-user-images\image-20210701103250779.png)

- 한계부하 측정해보기
- 100TPS에서 시작해서 50씩 올려보기
- 오느 시점에서 응답시간 그래프가 치솟으면 부하가 한계에 다다랐다는 뜻
- 대상페이지를 고를 때 정적페이지를 고르면 의미없음 (제일 많이 사용할거같은 페이지로 설정 로그인, 등)
- 게임서버의 경우 200,000를 커버 SNS(페북) 4000TPS 그외 일반적인 웹페이지 3-500TPS

