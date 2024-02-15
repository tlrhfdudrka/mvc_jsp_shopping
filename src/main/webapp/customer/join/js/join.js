/**
 * 
 */


 // JavaScript를 사용하여 아코디언 토글 구현
  function toggleAccordion(sectionId) {
    const section = document.getElementById(sectionId);
    section.classList.toggle('active');
  }
  
  //sign in 버튼 클릭시 넘어가기
        function login() {
            // JOIN US 버튼 클릭 시 회원가입 페이지로 이동
            let link = "../login/login.jsp";
        	window.open(link);
        }
        
     
    function validateForm() {
        var agreementChecked = document.getElementById("check_all").checked;
        if (!agreementChecked) {
            alert("체크박스에 체크해야 회원가입할 수 있습니다.");
            return false; // 폼 제출을 막음
        }
        return true; // 폼을 제출함
    }


        
 
  
  
/*function join(){
	alert("!");
}
*/