## 🔍 프로젝트 개요
- **개발 목적:** 구름 풀스택 과제 - 인스타그램 클론코딩
- **개발 기간:** `2023.08.02` ~ `2023.08.XX`
- **최종 배포:** `2023.08.XX`

<br />

## 😎 조원 소개

| 김경규 | 최자현 | 배진환 | 김재민 | 유지완 |
| :-: | :-: | :-: | :-: | :-: |
| ![@WhiteKIM](https://github.com/Goorm-helpme/youtube_clone/assets/123534245/3409dab9-dc57-484f-85d7-8952b7810ce8) | ![@JahyunChoi](https://github.com/Goorm-helpme/youtube_clone/assets/119170650/fa5e2234-c2b6-4839-83a7-b3a17d0a609a) | ![@JinhwanB](https://github.com/Goorm-helpme/youtube_clone/assets/123534245/ed9ba483-336b-4161-9e89-d57a3198e46d) | ![@K-Jae-min](https://github.com/Goorm-helpme/youtube_clone/assets/123534245/cae394c4-5cfd-4cb9-906e-0b983b09e61b) | ![@PerfectlyElastic](https://github.com/Goorm-helpme/youtube_clone/assets/123534245/d47107f9-e584-4fc3-8518-b14c42c34cbf) |
| [@WhiteKIM](https://github.com/WhiteKIM) | [@JahyunChoi](https://github.com/JahyunChoi) | [@JinhwanB](https://github.com/JinhwanB) | [@K-Jae-min](https://github.com/K-Jae-min) | [@PerfectlyElastic](https://github.com/PerfectlyElastic) |
| 조원 | 조원 | 조장 | 조원 | 조원 |
| 백엔드 개발자 | 풀스택 개발자 | 백엔드 개발자 | 풀스택 개발자 | 백엔드 개발자 |
| 대댓글 구현 | 피드 구현 | 댓글 구현 | 게시글 수정, 삭제 구현 | 좋아요 기능 구현 |

<br />

## 💻 개발 환경


### Front-End
<img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white"> <img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white"> <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black">


### Back-End
<img src="https://img.shields.io/badge/java 17-007396?style=for-the-badge&logo=java&logoColor=white"> <img src="https://img.shields.io/badge/spring 3.1.0-6DB33F?style=for-the-badge&logo=spring&logoColor=white">

### DataBase
나중에 추가

### Collaboration
<img src="https://img.shields.io/badge/Notion-000000?style=for-the-badge&logo=Notion&logoColor=white"> <img src="https://img.shields.io/badge/Discord-5865F2?style=for-the-badge&logo=Discord&logoColor=white"> <img src="https://img.shields.io/badge/Slack-4A154B?style=for-the-badge&logo=Slack&logoColor=white"> <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">

<br />

## 📝 화면 구성


<br />

## ✨ 주요 기능
- **댓글 CRUD:** 누구나 `생성, 수정, 삭제` 가능, 누구나 `읽기` 가능
- **대댓글 CRUD:** 누구나 `생성, 수정, 삭제` 가능, 누구나 `읽기` 가능
- **피드 CRUD:** API 호출을 통해 게시글 `조회, 수정, 삭제, 생성`이 가능
- **좋아요:** `좋아요` 버튼 클릭시 해당 영상에 대한 좋아요 클릭 갯수 표시

<br />

## 📁 아키텍쳐
├─Controller : API Controller를 모와둔 곳<br/>
│&nbsp;  └─Dto : API를 통해 받아올 데이터 모델<br/>
├─Domain : DB에 저장될 실제 데이터 모델<br/> 
├─Repository : DB와의 연동을 담당<br/>
└─Service : 요청 로직을 처리<br/>

<br />

## 📌 특이사항
- 변경/수정이 있는 경우 주석 또는 커밋 메시지, `README.md` 작성하기
- 그 외 프로젝트 관련 사항(기획서, 파일 공유 등)은 노션 페이지 프로젝트란에 기록하기
- 노션 페이지 정보 공유 시 확인이 필요한 내용은 슬랙으로 확인 요청하기

<br />

## 👩🏻‍💻👨🏻‍💻 작업 기록
- `2023.08.02` - 김경규 : Heart 관련 기능 틀만 구현하였음
- `2023.08.03` - 김경규 : Heart API 기능 구현 완료, API 호출 테스트 완료
<br />


## 주의 사항
- 커밋시 각자 브랜치를 사용해서 커밋해주시면 감사하겠습니다.
- 추가적으로 궁금한 사항은 슬랙이나 디스코드, Github의 Discussion를 확인해주세요

## 안내 사항
- 개발 단계에서는 실제 DB를 사용하지 않고, H2 인메모리를 이용해서 개발할 예정이고, 추후 MariaDB로 전환할 예정입니다.
- "https://docs.google.com/spreadsheets/d/1Gul1K1z4v76O_FINn6OUCSnvi_lO3gDUlwEpUvqFsbs/edit?usp=drive_link"
- 위의 링크에서 호출할 API URL의 명세와 엔티티에 대한 간단한 명세를 작성해주세요.
- 
