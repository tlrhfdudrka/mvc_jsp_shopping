/**
 * 
 */

var dropdown1 = document.querySelector(".dropdown_bar1");
var dropdownContent1 = document.querySelector(".dropdown_content1");

dropdown1.addEventListener("click", function() {
  if (dropdownContent1.style.display === "block") {
      dropdownContent1.style.display = "none";
  } else {
      dropdownContent1.style.display = "block";
  }
});

var dropdown2 = document.querySelector(".dropdown_bar2");
var dropdownContent2 = document.querySelector(".dropdown_content2");

dropdown2.addEventListener("click", function() {
  if (dropdownContent2.style.display === "block") {
      dropdownContent2.style.display = "none";
  } else {
      dropdownContent2.style.display = "block";
  }
});

var dropdown3 = document.querySelector(".dropdown_bar3");
var dropdownContent3 = document.querySelector(".dropdown_content3");

dropdown3.addEventListener("click", function() {
  if (dropdownContent3.style.display === "block") {
      dropdownContent3.style.display = "none";
  } else {
      dropdownContent3.style.display = "block";
  }
});

// 상단 메뉴 클릭시 폰트 컬러 변경됨
function changeFontColor() {
    var dropdownBar = document.querySelector(".dropdown_bar1");
    // 원하는 폰트 색상으로 변경
    dropdownBar.style.color = "gray"; // 여기에 원하는 색상을 지정하세요.
  }
  
// 상단 메뉴 클릭시 폰트 컬러 변경됨
function changeFontColor() {
    var dropdownBar = document.querySelector(".dropdown_bar2");
    // 원하는 폰트 색상으로 변경
    dropdownBar.style.color = "gray"; // 여기에 원하는 색상을 지정하세요.
  }
  
// 상단 메뉴 클릭시 폰트 컬러 변경됨
function changeFontColor() {
    var dropdownBar = document.querySelector(".dropdown_bar3");
    // 원하는 폰트 색상으로 변경
    dropdownBar.style.color = "gray"; // 여기에 원하는 색상을 지정하세요.
  }


