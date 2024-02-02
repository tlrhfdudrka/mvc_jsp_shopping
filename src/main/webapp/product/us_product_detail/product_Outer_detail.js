/**
 * 
 */
 
 let cart_cnt = 1;
 
/* 수량 변경(증가/감소) */
function count(type) {
   let deouter_count = document.getElementById("deouter_count");
   let count = parseInt(deouter_count.innerText);
   if(type == "deouter_minus") {
      count -= 1
      if(cart_cnt == 1) return;
   }
   else if(type == "deouter_plus") {
      count += 1
   }
   
   deouter_count.innerText = count;
   cart_cnt = count;
}
