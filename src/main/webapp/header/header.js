/**
 * 
 */

/* 드롭다운메뉴 */
var dropdown1 = document.getElementsByClassName("dropdown_bar1")[0];
var dropdownContent1 = document.getElementsByClassName("dropdown_content1")[0];

if (dropdown1 && dropdownContent1) {
  dropdown1.addEventListener("click", function() {
    if (dropdownContent1.style.display === "block") {
      dropdownContent1.style.display = "none";
    } else {
      dropdownContent1.style.display = "block";
    }
  });
} else {
  console.error("Dropdown elements not found");
}

var dropdown2 = document.getElementsByClassName("dropdown_bar2")[0];
var dropdownContent2 = document.getElementsByClassName("dropdown_content2")[0];

if (dropdown2 && dropdownContent2) {
  dropdown2.addEventListener("click", function() {
    if (dropdownContent2.style.display === "block") {
      dropdownContent2.style.display = "none";
    } else {
      dropdownContent2.style.display = "block";
    }
  });
} else {
  console.error("Dropdown elements not found");
}

var dropdown3 = document.getElementsByClassName("dropdown_bar3")[0];
var dropdownContent3 = document.getElementsByClassName("dropdown_content3")[0];

if (dropdown3 && dropdownContent3) {
  dropdown3.addEventListener("click", function() {
    if (dropdownContent3.style.display === "block") {
      dropdownContent3.style.display = "none";
    } else {
      dropdownContent3.style.display = "block";
    }
  });
} else {
  console.error("Dropdown elements not found");
}

/* 메뉴 클릭시 폰트 컬러 변경 */

var dropdownBar1 = document.querySelector('.dropdown_bar1');
var originalColor = 'black'; // 원래 색상을 저장할 변수

function changeFontColor1() {
    var currentColor = dropdownBar1.style.color;

    // 원래 색상이 없으면 저장
    if (!originalColor) {
        originalColor = currentColor;
    }

    if (currentColor === 'gray') {
        dropdownBar1.style.color = originalColor; // 원래 색상으로 변경
    } else {
        dropdownBar1.style.color = 'gray';
    }
}

var dropdownBar2 = document.querySelector('.dropdown_bar2');
var originalColor = 'black'; // 원래 색상을 저장할 변수

function changeFontColor2() {
    var currentColor = dropdownBar2.style.color;

    // 원래 색상이 없으면 저장
    if (!originalColor) {
        originalColor = currentColor;
    }

    if (currentColor === 'gray') {
        dropdownBar2.style.color = originalColor; // 원래 색상으로 변경
    } else {
        dropdownBar2.style.color = 'gray';
    }
}

var dropdownBar3 = document.querySelector('.dropdown_bar3');
var originalColor = 'black'; // 원래 색상을 저장할 변수

function changeFontColor3() {
    var currentColor = dropdownBar3.style.color;

    // 원래 색상이 없으면 저장
    if (!originalColor) {
        originalColor = currentColor;
    }

    if (currentColor === 'gray') {
        dropdownBar3.style.color = originalColor; // 원래 색상으로 변경
    } else {
        dropdownBar3.style.color = 'gray';
    }
}
