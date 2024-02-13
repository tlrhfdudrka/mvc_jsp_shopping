/**
 * 
 */
 
/* let cart_cnt = 1; */
 
/* 수량 변경(증가/감소) */
/* function count(type) {
	let pd_count = document.getElementById("pd_count");
	let count = parseInt(pd_count.innerText);
	if(type == "minus") {
		count -= 1
		if(cart_cnt == 1) return;
	}
	else if(type == "plus") {
		count += 1
	}
	
	pd_count.innerText = count;
	cart_cnt = count;
} */

/* 삭제시 confirm */
/* function del_confirm() {
	confirm("삭제하시겠습니까?");
	/* window.location.href = ""; */
/*}*/ 

/* SELECT ORDER 버튼 클릭시 */
/*function select_ord() {
	let chkbox = document.getElementById('cart_chkbox');
	if(!chkbox.checked) {
		alert("선택한 상품이 없습니다.");
	}
	/* window.location.href = ""; */
/*}*/

/* ALL ORDER 버튼 클릭시 */
/* function all_ord() {
	let chkbox = document.getElementById('cart_chkbox');
	chkbox.checked = true;
	confirm("모든 상품을 구매하시겠습니까?");
	/* window.location.href = ""; */
/*}*/ 