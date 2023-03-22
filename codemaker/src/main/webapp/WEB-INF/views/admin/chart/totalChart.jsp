<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
<script src="/js/admin/chart/Chart.min.js"></script>
<script src="/js/admin/chart/utils.js"></script>
<link rel="stylesheet" href="/css/admin/chart/style3.css">

<body>
	<div id="canvas-holder" style="width:40%;">
		<canvas id="chart-area"></canvas>
	</div>
<!-- 	<button id="randomizeData">Randomize Data</button> -->
<!-- 	<button id="addDataset">Add Dataset</button> -->
<!-- 	<button id="removeDataset">Remove Dataset</button> -->
<!-- 	<button id="addData">Add Data</button> -->
<!-- 	<button id="removeData">Remove Data</button> -->
<!-- 	<button id="changeCircleSize">Semi/Full Circle</button> -->
<script>

var a = new Array();
var b = new Array();

<c:forEach items="${lessonUserCnt}" var="lessonUserCnt" >	
	a.push("${lessonUserCnt.cnt}");
	b.push("${lessonUserCnt.lesNm}")
</c:forEach>
	console.log(a);

		var randomScalingFactor = function() {
			return Math.round(Math.random() * 100);
		};

		var config = {
				type: 'doughnut',
				data: {
					labels: b
					,
					datasets: [
						{
						data: 
							a
						,
						backgroundColor: [
							window.chartColors.red,
							window.chartColors.orange,
							window.chartColors.yellow,
							window.chartColors.green,
							window.chartColors.blue,
						],
						label: 'Dataset 1'
						}

						]
			},
			options: {
				responsive: true,
				legend: {
					position: 'top',
				},
				title: {
					display: true,
					text: '[강의별 학생 수]'
				},
				animation: {
					animateScale: true,
					animateRotate: true
				}
			}
		};

		window.onload = function() {
			var ctx = document.getElementById('chart-area').getContext('2d');
			window.myDoughnut = new Chart(ctx, config);
		};

		document.getElementById('randomizeData').addEventListener('click', function() {
			config.data.datasets.forEach(function(dataset) {
				dataset.data = dataset.data.map(function() {
					return randomScalingFactor();
				});
			});

			window.myDoughnut.update();
		});

		var colorNames = Object.keys(window.chartColors);
		document.getElementById('addDataset').addEventListener('click', function() {
			var newDataset = {
				backgroundColor: [],
				data: [],
				label: 'New dataset ' + config.data.datasets.length,
			};

			for (var index = 0; index < config.data.labels.length; ++index) {
				newDataset.data.push(randomScalingFactor());

				var colorName = colorNames[index % colorNames.length];
				var newColor = window.chartColors[colorName];
				newDataset.backgroundColor.push(newColor);
			}

			config.data.datasets.push(newDataset);
			window.myDoughnut.update();
		});

		document.getElementById('addData').addEventListener('click', function() {
			if (config.data.datasets.length > 0) {
				config.data.labels.push('data #' + config.data.labels.length);

				var colorName = colorNames[config.data.datasets[0].data.length % colorNames.length];
				var newColor = window.chartColors[colorName];

				config.data.datasets.forEach(function(dataset) {
					dataset.data.push(randomScalingFactor());
					dataset.backgroundColor.push(newColor);
				});

				window.myDoughnut.update();
			}
		});

		document.getElementById('removeDataset').addEventListener('click', function() {
			config.data.datasets.splice(0, 1);
			window.myDoughnut.update();
		});

		document.getElementById('removeData').addEventListener('click', function() {
			config.data.labels.splice(-1, 1); // remove the label first

			config.data.datasets.forEach(function(dataset) {
				dataset.data.pop();
				dataset.backgroundColor.pop();
			});

			window.myDoughnut.update();
		});

		document.getElementById('changeCircleSize').addEventListener('click', function() {
			if (window.myDoughnut.options.circumference === Math.PI) {
				window.myDoughnut.options.circumference = 2 * Math.PI;
				window.myDoughnut.options.rotation = -Math.PI / 2;
			} else {
				window.myDoughnut.options.circumference = Math.PI;
				window.myDoughnut.options.rotation = -Math.PI;
			}

			window.myDoughnut.update();
		});
</script>
	<br><br>
<div class="col-xl-4" >
       <!-- Page Views  -->
        <div class="card card-default table-borderless" id="page-views" data-scroll-height="580">
          <div class="card-header justify-content-between">
            <h2><b>강의별 학생 수</b></h2>
            
            <div class="date-range-report ">
<!--               <span></span> -->
            </div>
          </div>
          <div class="card-body slim-scroll py-0">
            <table class="table page-view-table ">
              <thead>
                <tr>
                  <th>강의명</th>
                  <th>강의ID</th>
                  <th>학생 수</th>
                </tr>
              </thead>
              <tbody id="lessonUserCnt">
              	<c:forEach items="${lessonUserCnt}" var="lessonUserCnt">
                <tr>
                  <td>${lessonUserCnt.lesNm}</td>
                  <td>${lessonUserCnt.lesId}</td>
                  <td>${lessonUserCnt.cnt}명</td>
                </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
      	  <div class="card-footer bg-white py-4">
          	총 학생 수 : ${lessonUserTotal} 명
          </div>
    	</div>
	</div>
</body>