drop database if exists final_bjh;
CREATE DATABASE final_bjh;

use final_bjh;

CREATE TABLE user (
    id VARCHAR(100) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE video (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    part VARCHAR(20) NOT NULL,
    url VARCHAR(255),
    count INT UNSIGNED DEFAULT 0
);

CREATE TABLE review (
    review_id INT AUTO_INCREMENT PRIMARY KEY,
    video_id INT NOT NULL,
    title VARCHAR(100) NOT NULL,
    content VARCHAR(900) NOT NULL,
    writed_time TIMESTAMP DEFAULT NOW(),
    click_count INT UNSIGNED NOT NULL DEFAULT 0,
    writer VARCHAR(100) DEFAULT '익명의 누군가',
    writer_id VARCHAR(100) NOT NULL
);

-- video_id 외래 키: 비디오 삭제 시 관련 리뷰 삭제
ALTER TABLE review 
ADD CONSTRAINT FK_review_video FOREIGN KEY (video_id) REFERENCES video(id) 
ON DELETE CASCADE
ON UPDATE CASCADE;

-- writer_id 외래 키: 사용자 삭제 시 NULL로 변경하여 리뷰 보존
ALTER TABLE review 
ADD CONSTRAINT FK_review_user FOREIGN KEY (writer_id) REFERENCES user(id) 
ON DELETE CASCADE
ON UPDATE CASCADE;


INSERT INTO user (id, name, email, password) 
VALUES ("junn4580", "김준영", "junn4580@gmail.com", "1234"), 
("ssafy", "ssafy", "ssafy@ssafy.com", "ssafy"),
("123", "123", "123@ssafy.com", "123");


INSERT INTO video(title, part, url) 
VALUES ("전신 다이어트 최고의 운동 [칼소폭 찐 핵핵매운맛]", "whole", "https://www.youtube.com/embed/gMaB-fG4u4g"), 
("하루 15분! 전신 칼로리 불태우는 다이어트 운동", "whole","https://www.youtube.com/embed/swRNeYw1JkY"), 
("상체 다이어트 최고의 운동 BEST [팔뚝살/겨드랑이살/등살/가슴어깨라인]", "upper","https://www.youtube.com/embed/54tTYO-vU2E"), 
("상체비만 다이어트 최고의 운동 [상체 핵매운맛]", "upper", "https://www.youtube.com/embed/QqqZH3j_vH0"),
("하체운동이 중요한 이유? 이것만 보고 따라하자 ! [하체운동 교과서]", "lower", "https://www.youtube.com/embed/tzN6ypk6Sps"),
("저는 하체 식주의자 입니다", "lower", "https://www.youtube.com/embed/u5OgcZdNbMo"),
("11자복근 복부 최고의 운동 [복근 핵매운맛]", "abdomen","https://www.youtube.com/embed/PjGcOP-TQPE"),
("(Sub)누워서하는 5분 복부운동!! 효과보장! (매일 2주만 해보세요!)", "abdomen", "https://www.youtube.com/embed/7TLk7pscICk");

INSERT INTO review(video_id, title, content, click_count, writer, writer_id) 
VALUES 
(1, "정말 힘들지만 효과 좋아요!", "운동 강도가 높아서 따라하기 힘들었지만 끝까지 하면 땀이 엄청 나요!", 15, "김준영", "junn4580"),
(1, "핵매운맛 인정!", "처음 해봤는데 너무 힘들어요 ㅠㅠ 그래도 효과는 확실한 듯!", 20, "ssafy", "ssafy"),
(1, "운동 후 땀이 쏟아져요", "진짜 온몸이 후들거릴 정도네요. 하지만 개운합니다!", 12, "김준영", "junn4580"),
(1, "매운맛 맞네요", "이거 하면서 중간에 포기할 뻔했어요. 그래도 끝까지 하면 효과가 확실하겠죠?", 18, "김준영", "junn4580"),
(2, "15분이라서 부담 없어요", "운동 루틴이 좋아서 꾸준히 따라하고 있어요.", 10, "김준영", "junn4580"),
(2, "짧지만 강렬한 운동", "시간이 짧아서 좋지만 운동 강도는 만만치 않네요!", 14, "김준영", "junn4580"),
(2, "하루 15분 루틴으로 딱!", "헬스장 가기 귀찮은 날에 이거 하나로 해결해요!", 22, "김준영", "junn4580"),
(3, "팔뚝살 빠지는 느낌!", "상체비만이라 고민이었는데 진짜 도움 돼요!", 18, "김준영", "junn4580"),
(3, "팔뚝살이 줄어든 것 같아요!", "일주일 따라 했는데 팔이 가늘어진 느낌!", 16, "김준영", "junn4580"),
(3, "어깨라인도 예뻐지는 듯", "운동하면서 어깨도 펴지고 라인이 살아나는 것 같아요!", 19, "ssafy", "ssafy"),
(4, "진짜 힘듦.. 하지만 효과 확실", "와 진짜 상체 핵매운맛 맞네요 ㅋㅋㅋ", 12, "ssafy", "ssafy"),
(4, "등살이 빠지는 것 같아요", "등 라인이 점점 정리되는 느낌! 꾸준히 해볼게요!", 20, "김준영", "junn4580"),
(4, "겨드랑이 살도 잡아줘요!", "겨드랑이살 없애는 데 최고!", 15, "김준영", "junn4580"),
(5, "하체 운동은 필수!", "이 영상 보고 하체 운동의 중요성을 깨달았어요!", 25, "김준영", "junn4580"),
(5, "하체운동 루틴으로 최고", "진짜 하체운동이 이렇게 중요한 줄 몰랐어요.", 14, "ssafy", "ssafy"),
(5, "이거 하면 다리 힘 엄청 길러질 듯", "하체운동 중요하다던데 이걸로 꾸준히 해볼 생각!", 16, "김준영", "junn4580"),
(6, "하체운동의 진리!", "진짜 하체운동이 중요하다는 걸 알게 됐어요!", 22, "김준영", "junn4580"),
(6, "하체가 단단해지는 느낌!", "꾸준히 하면 하체가 정말 강해질 듯!", 20, "ssafy", "ssafy"),
(6, "하체가 탄탄해지고 있어요", "운동한 지 일주일째, 벌써 변화가 보이네요!", 18, "ssafy", "ssafy"),
(7, "복근 운동으로 최고", "꾸준히 하면 진짜 효과 있을 듯!", 30, "ssafy", "ssafy"),
(7, "복근에 자극 제대로 옵니다!", "운동하면서 복근에 불타는 느낌!", 17, "ssafy", "ssafy"),
(7, "복부 라인 정리되는 듯", "배가 좀 들어간 것 같아요! 꾸준히 할 예정!", 15, "ssafy", "ssafy"),
(8, "누워서 하기 좋은 운동", "편하게 할 수 있어서 매일 따라 하고 있어요!", 17, "ssafy", "ssafy"),
(8, "5분만 해도 땀나요", "짧지만 효과 좋은 운동! 매일 할 수 있어서 좋아요!", 13, "김준영", "junn4580"),
(8, "짧고 간편해서 좋아요", "운동 귀찮을 때 이거 하나라도 하려구요!", 12, "김준영", "junn4580"),
(8, "매일 하면 효과 확실한 듯", "5분이라 부담 없어서 꾸준히 할 수 있어요!", 19, "김준영", "junn4580"),
(8, "누워서 해도 힘들어요!", "짧아서 쉬울 줄 알았는데 은근 힘드네요!", 14, "김준영", "junn4580"),
(8, "운동 초보에게 딱!", "누워서 할 수 있는 운동이라서 부담 없어요!", 18, "ssafy", "ssafy");

select * from user;