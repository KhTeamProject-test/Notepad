// 주제별 필터링 기능
document.addEventListener("DOMContentLoaded", function() {
    const filterButtons = document.querySelectorAll(".topic-filter button");
    const postItems = document.querySelectorAll(".post-item");
    
    filterButtons.forEach(button => {
        button.addEventListener("click", function() {
            // 활성화 버튼 스타일 변경
            filterButtons.forEach(btn => btn.classList.remove("active"));
            this.classList.add("active");
            
            const topic = this.getAttribute("data-topic");
            
            // 메모 필터링
            postItems.forEach(item => {
                if (topic === "all" || item.getAttribute("data-topic") === topic) {
                    item.style.display = "";
                } else {
                    item.style.display = "none";
                }
            });
        });
    });
    
    // 로그아웃 버튼
    const logoutBtn = document.getElementById("logout");
    if (logoutBtn) {
        logoutBtn.addEventListener("click", function() {
            if (confirm("로그아웃 하시겠습니까?")) {
                location.href = "${pageContext.request.contextPath}/logout";
            }
        });
    }
    
    // 폼 유효성 검사
    const addForm = document.getElementById("addForm");
    if (addForm) {
        addForm.addEventListener("submit", function(e) {
            const title = this.querySelector("[name=title]").value.trim();
            const content = this.querySelector("[name=content]").value.trim();
            
            if (title.length === 0) {
                e.preventDefault();
                alert("제목을 입력해주세요.");
                return;
            }
            
            if (content.length === 0) {
                e.preventDefault();
                alert("내용을 입력해주세요.");
                return;
            }
        });
    }
});

const newMemo = document.querySelector("#newMemo");
newMemo.addEventListener("click", ()=>{
    location.href = "/newmemo";
});