<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일정관리</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<link href="https://fonts.googleapis.com/css?family=Jua&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<jsp:include page="./css/css.jsp"></jsp:include>
<style type="text/css">
h1, h3, #myUL {
	font-family: 'Jua', sans-serif;
	text-align: center;
}

.clearfix:after {
	content: '';
	display: block;
	clear: both;
	float: none;
}

/* ======== Calendar ======== */
.my-calendar {
	width: 700px;
	margin: 30px;
	padding: 20px 20px 10px;
	text-align: center;
	font-weight: 800;
	border: 1px solid #ddd;
	cursor: default;
}

.my-calendar .clicked-date {
	border-radius: 25px;
	margin-top: 36px;
	float: left;
	width: 42%;
	padding: 46px 0 26px;
	background: #ddd;
}

.my-calendar .calendar-box {
	float: right;
	width: 58%;
	padding-left: 30px;
}

.clicked-date .cal-day {
	font-size: 24px;
}

.clicked-date .cal-date {
	font-size: 130px;
}

.ctr-box {
	padding: 0 16px;
	margin-bottom: 20px;
	font-size: 20px;
}

.ctr-box .btn-cal {
	position: relative;
	float: left;
	width: 25px;
	height: 25px;
	margin-top: 5px;
	font-size: 16px;
	cursor: pointer;
	border: none;
	background: none;
}

.ctr-box .btn-cal:after {
	content: '<';
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	line-height: 25px;
	font-weight: bold;
	font-size: 20px;
}

.ctr-box .btn-cal.next {
	float: right;
}

.ctr-box .btn-cal.next:after {
	content: '>';
}

.cal-table {
	width: 100%;
}

.cal-table th {
	width: 14.2857%;
	padding-bottom: 5px;
	font-size: 16px;
	font-weight: 900;
}

.cal-table td {
	padding: 3px 0;
	height: 50px;
	font-size: 15px;
	vertical-align: middle;
}

.cal-table td.day {
	position: relative;
	cursor: pointer;
}

.cal-table td.today {
	background: #ff6863;
	border-radius: 50%;
	color: #fff;
}

.cal-table td.day-active {
	background: #ffd255;
	border-radius: 50%;
	color: #fff;
}

.timeline {
	list-style: none;
	padding: 20px 0 20px;
	position: relative;
}

.timeline:before {
	top: 0;
	bottom: 0;
	position: absolute;
	content: " ";
	width: 3px;
	background-color: #eeeeee;
	left: 50%;
	margin-left: -1.5px;
}

.timeline>li {
	margin-bottom: 20px;
	position: relative;
}

.timeline>li:before, .timeline>li:after {
	content: " ";
	display: table;
}

.timeline>li:after {
	clear: both;
}

.timeline>li:before, .timeline>li:after {
	content: " ";
	display: table;
}

.timeline>li:after {
	clear: both;
}

.timeline>li>.timeline-panel {
	width: 46%;
	float: left;
	border: 1px solid #d4d4d4;
	border-radius: 2px;
	padding: 20px;
	position: relative;
	-webkit-box-shadow: 0 1px 6px rgba(0, 0, 0, 0.175);
	box-shadow: 0 1px 6px rgba(0, 0, 0, 0.175);
}

.timeline>li>.timeline-panel:before {
	position: absolute;
	top: 26px;
	right: -15px;
	display: inline-block;
	border-top: 15px solid transparent;
	border-left: 15px solid #ccc;
	border-right: 0 solid #ccc;
	border-bottom: 15px solid transparent;
	content: " ";
}

.timeline>li>.timeline-panel:after {
	position: absolute;
	top: 27px;
	right: -14px;
	display: inline-block;
	border-top: 14px solid transparent;
	border-left: 14px solid #fff;
	border-right: 0 solid #fff;
	border-bottom: 14px solid transparent;
	content: " ";
}

.timeline>li>.timeline-badge {
	color: #fff;
	width: 50px;
	height: 50px;
	line-height: 50px;
	font-size: 1.4em;
	text-align: center;
	position: absolute;
	top: 16px;
	left: 50%;
	margin-left: -25px;
	background-color: #999999;
	z-index: 100;
	border-top-right-radius: 50%;
	border-top-left-radius: 50%;
	border-bottom-right-radius: 50%;
	border-bottom-left-radius: 50%;
}

.timeline>li.timeline-inverted>.timeline-panel {
	float: right;
}

.timeline>li.timeline-inverted>.timeline-panel:before {
	border-left-width: 0;
	border-right-width: 15px;
	left: -15px;
	right: auto;
}

.timeline>li.timeline-inverted>.timeline-panel:after {
	border-left-width: 0;
	border-right-width: 14px;
	left: -14px;
	right: auto;
}

.timeline-badge.primary {
	background-color: #2e6da4 !important;
}

.timeline-badge.success {
	background-color: #ff6863 !important;
}

.timeline-badge.info {
	background-color: #2C7402 !important;
}

.timeline-title {
	margin-top: 0;
	color: inherit;
}

.timeline-body>p, .timeline-body>ul {
	margin-bottom: 0;
}

.timeline-body>p+p {
	margin-top: 5px;
}


@media ( max-width : 767px) {
	ul.timeline:before {
		left: 40px;
	}
	ul.timeline>li>.timeline-panel {
		width: calc(100% - 90px);
		width: -moz-calc(100% - 90px);
		width: -webkit-calc(100% - 90px);
	}
	ul.timeline>li>.timeline-badge {
		left: 15px;
		margin-left: 0;
		top: 16px;
	}
	ul.timeline>li>.timeline-panel {
		float: right;
	}
	ul.timeline>li>.timeline-panel:before {
		border-left-width: 0;
		border-right-width: 15px;
		left: -15px;
		right: auto;
	}
	ul.timeline>li>.timeline-panel:after {
		border-left-width: 0;
		border-right-width: 14px;
		left: -14px;
		right: auto;
	}
}
/* Include the padding and border in an element's total width and height */
#myUL {
  box-sizing: border-box;
}

/* Remove margins and padding from the list */
#myUL ul {
  margin: 0;
  padding: 0;
}

/* Style the list items */
#myUL ul, #myUL li {
  cursor: pointer;
  position: relative;
  padding: 12px 8px 12px 40px;
  list-style-type: none;
  background: #eee;
  font-size: 18px;
  transition: 0.2s;
  
  /* make the list items unselectable */
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}

/* Set all odd list items to a different color (zebra-stripes) */
#myUL ul, #myUL li:nth-child(odd) {
  background: #f9f9f9;
}

/* Darker background-color on hover */
#myUL ul, #myUL li:hover {
  background: #ddd;
}

/* When clicked on, add a background color and strike out text */
#myUL li .checked {
  background: #888;
  color: #fff;
  text-decoration: line-through;
}

/* Add a "checked" mark when clicked on */
#myUL li.checked::before {
  content: '';
  position: absolute;
  border-color: #fff;
  border-style: solid;
  border-width: 0 2px 2px 0;
  top: 10px;
  left: 16px;
  transform: rotate(45deg);
  height: 15px;
  width: 7px;
}

/* Style the close button */
#myUL .close {
  position: absolute;
  right: 0;
  top: 0;
  padding: 12px 16px 12px 16px;
}

#myUL .close:hover {
  background-color: #f44336;
  color: white;
}

</style>
</head>
<body data-spy="scroll" data-target=".navbar-collapse">
	<div class="culmn">

		<!-- Top jsp -->
		<nav class="navbar navbar-light navbar-expand-lg  navbar-fixed ivory no-background bootsnav">
			<jsp:include page="./include/Top.jsp"></jsp:include>

			<!-- Side jsp -->
			<jsp:include page="./include/Side.jsp"></jsp:include>
		</nav>


		<section id="id" class="about roomy-100">
			<form action="Login_ok.jsp" method="post" name="loginForm">
				<div class="container-fluid">
					<br> <br>
					<h1>일정 관리</h1>
					<br>
					<hr>
					<br>
					<div class="row">
						<div class="col-md-6">
							<div class="page-header">
								<h3 id="timeline">달력</h3>
							</div>
							<div class="my-calendar clearfix">
								<div class="clicked-date">
									<div class="cal-day"></div>
									<div class="cal-date"></div>
								</div>
								<div class="calendar-box">
									<div class="ctr-box clearfix">
										<button type="button" title="prev" class="btn-cal prev">
										</button>
										<span class="cal-month"></span> <span class="cal-year"></span>
										<button type="button" title="next" class="btn-cal next">
										</button>
									</div>
									<table class="cal-table">
										<thead>
											<tr>
												<th>Sun</th>
												<th>Mon</th>
												<th>Tue</th>
												<th>Wen</th>
												<th>Tur</th>
												<th>Fri</th>
												<th>Sat</th>
											</tr>
										</thead>
										<tbody class="cal-body"></tbody>
									</table>
								</div>
							</div>

<br>
<br>
<!-- to do list -->
<div class= "container-fluid">
<div id="myDIV" class="header">
<div class="page-header">
	<h3 id="timeline">To Do List</h3>
</div>
<div class="row" style="text-align: center">
<div class="col-md-9">
<input type="text" id="myInput" placeholder="일정 추가" style="color : black;">
</div>
<div class="col-md-3">
<button type="button" class="btn btn-primary" onclick="newElement()" >Add</button>
</div>
</div>
</div>

<ul id="myUL" style="font-size: 12px;">
  <li>11/21 이혜리 - 삼성아파트 매매 계약 (양타)</li>
  <li>11/22 김진호 - 상담 예약</li>
</ul>
</div>
						</div>
						<!-- // .my-calendar -->
						<div class="col-md-6">
							<div class="page-header">
								<h3 id="timeline">이번 주 스케줄</h3>
							</div>
							<ul class="timeline">
								<li>
									<div class="timeline-badge">
										<i class="fas fa-check"></i>
									</div>								
									<div class="timeline-panel">
										<div class="timeline-heading">
											<h4 class="timeline-title">2019.11.19 14:00</h4>
										</div>
										<div class="timeline-body">
											<p>이정은 - 비트아파트 매물 보기 예약</p>
										</div>
									</div>
								</li>
								<li class="timeline-inverted">
									<div class="timeline-badge success">
										<i class="fas fa-check"></i>
									</div>
									<div class="timeline-panel">
										<div class="timeline-heading">
											<h4 class="timeline-title">2019.11.21 18:30</h4>
										</div>
										<div class="timeline-body">
											<p>이혜리 - 삼성아파트 매매 계약 (양타)</p>
										</div>
									</div>
								</li>
								<li>
									<div class="timeline-badge">
										<i class="fas fa-check"></i>
									</div>
									<div class="timeline-panel">
										<div class="timeline-heading">
											<h4 class="timeline-title">2019.11.22 10:00</h4>
										</div>
										<div class="timeline-body">
											<p>김진호 - 상담 예약</p>
										</div>
									</div>
								</li>
								<li class="timeline-inverted">
									<div class="timeline-panel">
										<div class="timeline-heading">
											<h4 class="timeline-title">2019.11.22 15:15</h4>
										</div>
										<div class="timeline-body">
											<p>이정은 - 현대아파트 매물 보기 예약</p>
										</div>
									</div>
								</li>
								<li>
									<div class="timeline-badge info">
										<i class="fas fa-check"></i>
									</div>
									<div class="timeline-panel">
										<div class="timeline-heading">
											<h4 class="timeline-title">2019.11.23 11:00</h4>
										</div>
										<div class="timeline-body">
											<p>오형남 - 현대 아파트 전세 계약(캠프부동산)</p>
									</div>
									</div>
								</li>								
							</ul>
						</div>
					</div>
				</div>
			</form>
		</section>

		<!-- scroll up-->
		<jsp:include page="./include/ScrollUp.jsp"></jsp:include>
		<!-- End off scroll up -->
		<jsp:include page="./include/Bottom.jsp"></jsp:include>
	</div>

	<!-- JS includes -->
	<jsp:include page="./js/js.jsp"></jsp:include>

	<script>
	// Create a "close" button and append it to each list item
	var myNodelist = document.getElementById("myUL").getElementsByTagName("LI");
	var i;
	for (i = 0; i < myNodelist.length; i++) {
	  var span = document.createElement("SPAN");
	  var txt = document.createTextNode("\u00D7");
	  span.className = "close";
	  span.appendChild(txt);
	  myNodelist[i].appendChild(span);
	}

	// Click on a close button to hide the current list item
	var close = document.getElementsByClassName("close");
	var i;
	for (i = 0; i < close.length; i++) {
	  close[i].onclick = function() {
	    var div = this.parentElement;
	    div.style.display = "none";
	  }
	}

	// Add a "checked" symbol when clicking on a list item
	var list = document.querySelector('ul');
	list.addEventListener('click', function(ev) {
	  if (ev.target.tagName === 'LI') {
	    ev.target.classList.toggle('checked');
	  }
	}, false);

	// Create a new list item when clicking on the "Add" button
	function newElement() {
	  var li = document.createElement("li");
	  var inputValue = document.getElementById("myInput").value;
	  var t = document.createTextNode(inputValue);
	  li.appendChild(t);
	  if (inputValue === '') {
	    alert("You must write something!");
	  } else {
	    document.getElementById("myUL").appendChild(li);
	  }
	  document.getElementById("myInput").value = "";

	  var span = document.createElement("SPAN");
	  var txt = document.createTextNode("\u00D7");
	  span.className = "close";
	  span.appendChild(txt);
	  li.appendChild(span);

	  for (i = 0; i < close.length; i++) {
	    close[i].onclick = function() {
	      var div = this.parentElement;
	      div.style.display = "none";
	    }
	  }
	}
	
//================================
//START YOUR APP HERE
//================================
const init = {
monList: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
dayList: ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'],
today: new Date(),
monForChange: new Date().getMonth(),
activeDate: new Date(),
getFirstDay: (yy, mm) => new Date(yy, mm, 1),
getLastDay: (yy, mm) =>new Date(yy, mm + 1, 0),
nextMonth: function () {
 let d = new Date();
 d.setDate(1);
 d.setMonth(++this.monForChange);
 this.activeDate = d;
 return d;
},
prevMonth: function () {
 let d = new Date();
 d.setDate(1);
 d.setMonth(--this.monForChange);
 this.activeDate = d;
 return d;
},
addZero: (num) =>(num < 10) ? '0' + num : num,
activeDTag: null,
getIndex: function (node) {
 let index = 0;
 while (node = node.previousElementSibling) {
   index++;
 }
 return index;
}
};

const $calBody = document.querySelector('.cal-body');
const $btnNext = document.querySelector('.btn-cal.next');
const $btnPrev = document.querySelector('.btn-cal.prev');

/**
* @param {number} date
* @param {number} dayIn
*/
function loadDate (date, dayIn) {
document.querySelector('.cal-date').textContent = date;
document.querySelector('.cal-day').textContent = init.dayList[dayIn];
}

/**
* @param {date} fullDate
*/
function loadYYMM (fullDate) {
let yy = fullDate.getFullYear();
let mm = fullDate.getMonth();
let firstDay = init.getFirstDay(yy, mm);
let lastDay = init.getLastDay(yy, mm);
let markToday;  // for marking today date

if (mm === init.today.getMonth() && yy === init.today.getFullYear()) {
 markToday = init.today.getDate();
}

document.querySelector('.cal-month').textContent = init.monList[mm];
document.querySelector('.cal-year').textContent = yy;

let trtd = '';
let startCount;
let countDay = 0;
for (let i = 0; i < 6; i++) {
 trtd += '<tr>';
 for (let j = 0; j < 7; j++) {
   if (i === 0 && !startCount && j === firstDay.getDay()) {
     startCount = 1;
   }
   if (!startCount) {
     trtd += '<td>'
   } else {
     let fullDate = yy + '.' + init.addZero(mm + 1) + '.' + init.addZero(countDay + 1);
     trtd += '<td class="day';
     trtd += (markToday && markToday === countDay + 1) ? ' today" ' : '"';
     trtd += ` data-date="${countDay + 1}" data-fdate="${fullDate}">`;
   }
   trtd += (startCount) ? ++countDay : '';
   if (countDay === lastDay.getDate()) { 
     startCount = 0; 
   }
   trtd += '</td>';
 }
 trtd += '</tr>';
}
$calBody.innerHTML = trtd;
}

/**
* @param {string} val
*/
function createNewList (val) {
let id = new Date().getTime() + '';
let yy = init.activeDate.getFullYear();
let mm = init.activeDate.getMonth() + 1;
let dd = init.activeDate.getDate();
const $target = $calBody.querySelector(`.day[data-date="${dd}"]`);

let date = yy + '.' + init.addZero(mm) + '.' + init.addZero(dd);

let eventData = {};
eventData['date'] = date;
eventData['memo'] = val;
eventData['complete'] = false;
eventData['id'] = id;
init.event.push(eventData);
$todoList.appendChild(createLi(id, val, date));
}

loadYYMM(init.today);
loadDate(init.today.getDate(), init.today.getDay());

$btnNext.addEventListener('click', ()=> loadYYMM(init.nextMonth()));
$btnPrev.addEventListener('click', ()=> loadYYMM(init.prevMonth()));

$calBody.addEventListener('click', (e)=> {
if (e.target.classList.contains('day')) {
 if (init.activeDTag) {
   init.activeDTag.classList.remove('day-active');
 }
 let day = Number(e.target.textContent);
 loadDate(day, e.target.cellIndex);
 e.target.classList.add('day-active');
 init.activeDTag = e.target;
 init.activeDate.setDate(day);
 reloadTodo();
}
});
</script>
</body>
</html>