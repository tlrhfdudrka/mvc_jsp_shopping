/**
 * 
 */
 
 let cart_cnt = 1;
 
/* 수량 변경(증가/감소) */
function count(type) {
   let detop_count = document.getElementById("detop_count");
   let count = parseInt(detop_count.innerText);
   if(type == "detop_minus") {
      count -= 1
      if(cart_cnt == 1) return;
   }
   else if(type == "detop_plus") {
      count += 1
   }
   
   detop_count.innerText = count;
   cart_cnt = count;
}
