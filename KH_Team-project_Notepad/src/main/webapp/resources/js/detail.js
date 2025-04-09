document.addEventListener("DOMContentLoaded", function() {
    // 목록으로 버튼
    const goToListBtn = document.getElementById("goToList");
    if (goToListBtn) {
        goToListBtn.addEventListener("click", function() {
            location.href = "/";
        });
    }
    
    // 체크 상태 변경 버튼
    const toggleCheckBtn = document.getElementById("toggleCheckBtn");
    if (toggleCheckBtn) {
        toggleCheckBtn.addEventListener("click", function() {
            const postNo = new URLSearchParams(location.search).get("postNo");
            
            if (confirm("체크 상태를 변경하시겠습니까?")) {
                location.href = `/post/toggleCheck?postNo=${postNo}`;
            }
        });
    }
    
    // 수정 버튼
    const updateBtn = document.getElementById("updateBtn");
    if (updateBtn) {
        updateBtn.addEventListener("click", function() {
            const postNo = new URLSearchParams(location.search).get("postNo");
            location.href = `/post/update?postNo=${postNo}`;
        });
    }
    
    // 삭제 버튼
    const deleteBtn = document.getElementById("deleteBtn");
    if (deleteBtn) {
        deleteBtn.addEventListener("click", function() {
            const postNo = new URLSearchParams(location.search).get("postNo");
            
            if (confirm("정말 삭제하시겠습니까?")) {
                location.href = `/post/delete?postNo=${postNo}`;
            }
        });
    }
});