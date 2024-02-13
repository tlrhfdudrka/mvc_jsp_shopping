/**
 * 
 */
 
 let cart_cnt = 1;
 
/* 수량 변경(증가/감소) */
function count(type) {
   let debottom_count = document.getElementById("debottom_count");
   let count = parseInt(debottom_count.innerText);
   if(type == "debottom_minus") {
      count -= 1
      if(cart_cnt == 1) return;
   }
   else if(type == "debottom_plus") {
      count += 1
   }
   
   debottom_count.innerText = count;
   cart_cnt = count;
}
