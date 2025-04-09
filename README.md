# Git add . 금지!
```bash
git add [파일 이름1]             // stage에 추가
git commit -m "Type: Content1"  // stage 파일 commit

git add [파일 이름2]             // stage에 추가
git commit -m "Type: Content2"  // stage 파일 commit

git push                        // commit 한 파일들 github에 push
```
## Git commit message 작성법 참고
### 기본 규칙
- 제목과 본문을 **빈 행으로 구분**
- 제목은 영문 기준 **50글자 이하**
- 첫 글자는 **대문자**로 작성
- 제목 끝에 **마침표X**
- 제목은 **명령문**으로 사용, 과거형X
- 본문의 각 행은 영문 기준 **72글자 이하**
- 어떻게 보다는 **무엇과 왜**
### Commit Message 구조
> type(타입) : title(제목)  
>   
> body(본문, 생략 가능)  
>   
> Resolves : (해결한 이슈 , 생략 가능)  
>   
> See also : (참고 이슈, 생략 가능)

### Type 키워드 표
| Type 키워드 | 사용 시점                                           |
| -------- | ----------------------------------------------- |
| feat     | 새로운 기능 추가                                       |
| fix      | 버그 수정                                           |
| docs     | 문서 수정                                           |
| style    | 코드 스타일 변경 (코드 포매팅, 세미콜론 누락 등)  <br>기능 수정이 없는 경우 |
| design   | 사용자 UI 디자인 변경 (CSS 등)                           |
| test     | 테스트 코드, 리팩토링 테스트 코드 추가                          |
| refactor | 코드 리팩토링                                         |
| build    | 빌드 파일 수정                                        |
| ci       | CI 설정 파일 수정                                     |
| perf     | 성능 개선                                           |
| chore    | 빌드 업무 수정, 패키지 매니저 수정 (gitignore 수정 등)           |
| rename   | 파일 혹은 폴더명을 수정만 한 경우                             |
| remove   | 파일을 삭제만 한 경우                                    |
