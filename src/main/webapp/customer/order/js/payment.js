/**
 * 
 */
function delivery_input_chk() {
	
	/* 받는 사람 입력 확인 */
	if(!document.paymentform.recipient.value) {
		alert("받는 사람을 입력하세요.");
		document.paymentform.recipient.focus();
		return false;
	}
	
	/* 주소 입력 확인 */
	if(!document.paymentform.address.value) {
		alert("주소를 입력하세요");
		document.paymentform.address.focus();
		return false;
	}
	
	/* 휴대전화 입력 확인 */
	if(!document.paymentform.phNum.value) {
		alert("휴대전화를 입력하세요");
		document.paymentform.phNum.focus();
		return false;
	}
	
	/* 입금은행 입력 확인 */
	if(!document.paymentform.bank_choice.value) {
		alert("입금 은행을 선택해주세요.");
		return false;
	}
	
	/* 입금자명 입력 확인 */
	if(!document.paymentform.depositor.value) {
		alert("입금자명을 입력해주세요.");
		document.paymentform.depositor.focus();
		return false;
	}
	
	/* 동의 체크박스 필수 체크 */
	if(!document.paymentform.agree_chkbox.checked) {
		alert("약관에 동의해주세요.");
		return false;
	}
	
	
}