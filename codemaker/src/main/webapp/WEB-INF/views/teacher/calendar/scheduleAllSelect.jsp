<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<link href='/fullcalendar/packages/core/main.css' rel='stylesheet' />
<link href='/fullcalendar/packages/daygrid/main.css' rel='stylesheet' />
<link href='/fullcalendar/packages/timegrid/main.css' rel='stylesheet' />
<link href='/fullcalendar/packages/list/main.css' rel='stylesheet' />

<script src='/fullcalendar/packages/core/main.js'></script>
<script src='/fullcalendar/packages/interaction/main.js'></script>
<script src='/fullcalendar/packages/daygrid/main.js'></script>
<script src='/fullcalendar/packages/timegrid/main.js'></script>
<script src='/fullcalendar/packages/list/main.js'></script>

<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
<script>
document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');
    var flag = true;
    var calendar = new FullCalendar.Calendar(calendarEl, {
      plugins: [ 'dayGrid', 'list', 'interaction' ],
      header: {
    	 left: 'prev,next today',
         center: 'title',
         right: 'dayGridMonth,listWeek'
      },
      navLinks: true, // can click day/week names to navigate views
      selectable: true,
      selectMirror: true,
      editable: false,
   	  eventLimit: true,
      events: ${jarray}
      
    })
    calendar.render();
  });
  
</script>
<style>
body {
	margin: 40px 10px;
	padding: 0;
	font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
	font-size: 14px;
}
#calendar {
	max-width: 900px;
	margin: 0 auto;
}
</style>
</head>
<body>
	<div id='calendar'></div>

</body>
</html>
