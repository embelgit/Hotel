<!DOCTYPE html>
<!-- <html lang="en"> -->
<%-- <%@page import="com.srb.hibernate.ClassInfoHibernate"%>
<%@page import="java.util.List"%>
<%@page import="com.srb.dao.ClassInfoDao"%> --%>
<%@page import="com.rms.hibernate.ItemEntry"%>
<%@page import="java.util.List"%>
<%@page import="com.rms.dao.ItemEntryDao"%>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Comoatible" content="IE=edge">
<title>Dashboard</title>
<link rel="stylesheet" type="text/css"
	href="/RMS/staticContent/css/bootstrap_aniket.css">
<link rel="stylesheet" type="text/css"
	href="/RMS/staticContent/css/style_aniket.css">
<script src="/srb/staticContent/JS/graph.js"></script>
</head>
<body onload="getTotalStudentCount()">

	<div class="container-fluid display-table">
		<div class="row display-table-row">
			<!-- Side menu -->
			<div
				class="col-md-2 col-sm-1 hidden-xs display-table-cell valign-top border-bottom"
				id="side-menu">
				<!--  <h1 class="hidden-xs hidden-sm">Admin</h1> -->
				<li class="sidebar-brand" style="background: #137CA4;"><img
					src="/RMS/staticContent/images/profile photo.png"
					class="img-circle img-responsive pro-image" alt="Pro img" />
				<p align="center" style="color: #FFFFFF; margin-top: -35px;">Admin</p>
				</li>
				<ul>
					<li class="link"><a href="/RMS/jsp/OrderBill.jsp"> <span
							class="glyphicon glyphicon-user" aria-hidden="true"></span> <span
							class="hidden-sm hidden-xs"> Home</span>
					</a></li>
					<li class="link active"><a href="/RMS/jsp/index.jsp"> <span
							class="glyphicon glyphicon-th" aria-hidden="true"></span> <span
							class="hidden-sm hidden-xs"> Dashboard</span>
					</a></li>

					<li class="link"><a href="#collapse-post"
						data-toggle="collapse" aria-controls="collapse-post"
						aria-expanded="false"> <span class="glyphicon glyphicon-file"
							aria-hidden="true"></span> <span class="hidden-sm hidden-xs">Item
								Reports</span> <span
							class="label label-success pull-right hidden-sm hidden-xs"></span>
					</a>
						<ul id="collapse-post" class="collapse collapseable">
							<li><a href="/RMS/jsp/ItemDetailsReport_ItemNameWise.jsp">
									Item Name Wise Report </a></li>
							<li><a href="/RMS/jsp/ItemDetailsReport_DrinkWise.jsp">
									Drink Wise Report </a></li>
						</ul></li>

					<li class="link"><a href="#collapse-sales"
						data-toggle="collapse" aria-controls="collapse-sales"
						aria-expanded="false"> <span class="glyphicon glyphicon-file"
							aria-hidden="true"></span> <span class="hidden-sm hidden-xs">Order
								Bill Reports</span> <span
							class="label label-success pull-right hidden-sm hidden-xs"></span>
					</a>
						<ul id="collapse-sales" class="collapse collapseable">
							<li><a href="/RMS/jsp/OrderBillReport.jsp"> Order Bill
									Report Date Wise </a></li>
							<li><a href="/RMS/jsp/OrderBillReportTableNoWise.jsp">
									Order Bill Report Table No. Wise </a></li>
							<!--  <li>
                    <a href="reports.html">
                      Report 3                       
                    </a>
                  </li>
                  <li>
                    <a href="reports.html">
                       Report 4                       
                    </a>
                  </li> -->
						</ul></li>

					<li class="link"><a href="/RMS/jsp/Goods_Receive_Report.jsp"><span
							class="glyphicon glyphicon-file"></span>Goods Receive Report <!-- <span class="glyphicon glyphicon-file" aria-hidden="true"></span>
                  <span class="hidden-sm hidden-xs">Certificate Issued Report</span>
                  <span class="label label-success pull-right hidden-sm hidden-xs"></span> -->
					</a> <!--                 <ul id="collapse-post" class="collapse collapseable">
                  <li>
                    <a href="/srb/JSP/stockReport.jsp">
                     Stock Report                     
                    </a>
                  </li>
                  <li>
                    <a href="reports.html">
                      Report 2                      
                    </a>
                  </li>
                  <li>
                    <a href="reports.html">
                      Report 3                       
                    </a>
                  </li>
                  <li>
                    <a href="reports.html">
                       Report 4                       
                    </a>
                  </li>
                </ul> --></li>

				</ul>
			</div>
			<!-- main content -->
			<div class="col-md-10 col-sm-11 display-table-cell valign-top box">
				<div class="row">
					<header id="nav-header" class="clearfix">
						<div class="col-md-5">
							<nav class="navbar-default pull-left">
								<button type="button" class="navbar-toggle collapsed"
									data-toggle="offcanvas" data-target="#side-menu">
									<span class="sr-only">Toggle Navigation</span> <span
										class="icon-bar"></span> <span class="icon-bar"></span> <span
										class="icon-bar"></span>
								</button>
							</nav>
							<h4 id="main-head" class="col-md-12" style="font-family:"ubantu;">
								<span class="sub-head"><i>Created By</i></span> <strong>EMBEL
									TECHNOLOGIES PVT LTD</strong>
							</h4>
						</div>
						<div class="col-md-7">
							<ul class="pull-right">
								<li id="welcome" class="hidden-xs"><input type="text"
									class="hidden-sm hidden-xs" id="header-feild-search"
									placeholder="search for something"></li>
								<!--  <li class="fixed-width">
                    <a href="#" ><span class="glyphicon glyphicon-envelope area-hidden="true"></span>
                    <span class="label label-message">3</span>
                    </a>
                  </li> -->
								<li><a href="#" class="logout"><span
										class="glyphicon glyphicon-log-out" area-hidden="true"></span></a>LogOut</li>
							</ul>
						</div>
					</header>
				</div>


				<div class="col-md-8">
					<div class="row">
						<div class="form-group">
							<div class="col-md-2 col-sm-offset-1" align="right">
								<label class="control-label">Item Name:</label>
							</div>
							<div class="col-md-3">
								<div class="input-group">
									<span class="input-group-addon"> <i
										class="glyphicon glyphicon-stats"></i>
									</span>

									<%
						ItemEntryDao itemEntryDao1 = new ItemEntryDao();
						List iList1= itemEntryDao1.getAllItemEntriesForOrderBill(request);
						%>

									<input list="fk_item_id_drop1" id="fk_item_id1"
										class="form-control" onchange="getGridForStoreManagement()" />
									<datalist id="fk_item_id_drop1">

										<%
					    for(int j=0;j<iList1.size();j++){
						ItemEntry itemEntry = (ItemEntry)iList1.get(j);
				        %>

										<option data-value="<%=itemEntry.getPk_item_entry_Id()%>"
											value="<%=itemEntry.getItemName() %>">
											<%
					     }
				         %>
										
									</datalist>
								</div>
							</div>
							<div class="col-sm-2 col-md-offset-1">
								<input type="button" id="btn" name="save"
									class="btn btn-lg btn-success btn-md button_hw button_margin_right"
									style="width: 170px;" onclick="studentResultForGraph()"
									value="Search" />
							</div>

						</div>
					</div>
					<div class="row">
						<div id="container"
							style="min-width: 310px; height: 400px; margin: 0 auto"></div>
						<!--  <section id="stats" class="clearfix">
              <div class="tab panel-header">
                <button class="tablinks active" onclick="openCity(event, 'Graph')">Graph</button>
                <button class="tablinks" href="#myChart1"onclick="openCity(event, 'Pie-Chart')">Bar-Graph</button>
              </div>
                    
              <div class="panel-content">

              <div id="Graph" class="tabcontent">
               <div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
              </div>

              <div id="Pie-Chart" class="tabcontent">
               
			<div id="container1" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>
              </div>
              </div>
            </section> -->

					</div>
				</div>
				<div class="col-md-4">
					<div class="row clearfix">
						<div class="panel list-search">
							<input type="text" id="myInput" onkeyup="myFunction()"
								placeholder="Search for Menu.." title="Type in a name">

							<ul id="myUL" class="clearfix">
								<li><a href="#">Veg</a></li>
								<li><a href="#">Non-Veg</a></li>

								<li><a href="#">BreakFast</a></li>
								<li><a href="#">Drinks</a></li>

								<li><a href="#">Starter</a></li>
								<li><a href="#">Ice crem</a></li>
								<li><a href="#">Chinese</a></li>
								<li><a href="#">Soup</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="col-md-6 ">
					<div class="row clearfix">
						<aside id="daily-stats">
							<div class="panel panel-left">
								<div class="panel-heading">
									<h4 class="panel-title">Today's Sale</h4>
								</div>
								<div class="panel-body">
									<span class="glyphicon glyphicon-stats"></span> <span><strong
										id="sales" data-max="10000"></strong></span>
								</div>
							</div>
						</aside>
					</div>
				</div>
				<div class="col-md-6 ">
					<div class="row clearfix">
						<aside id="daily-stats">
							<div class="panel panel-right">
								<div class="panel-heading">
									<h4 class="panel-title">Today's Purchase</h4>
								</div>
								<div class="panel-body">
									<span class="glyphicon glyphicon-stats"></span> <span><strong
										id="purchase" data-max="14400"></strong></span>
								</div>
							</div>
						</aside>
					</div>
				</div>

				<div class="row">
					<footer id="admin-footer" class="clearfix col-md-12">
						<div class="pull-left">
							<b>copyright</b> &copy; 2017
						</div>
						<div class="pull-right">Admin system</div>
					</footer>

				</div>
			</div>
		</div>
	</div>

	<script src="/RMS/staticContent/js/jquery_aniket.js"></script>
	<script src="/RMS/staticContent/js/bootstrap_aniket.js"></script>

	<script src="/RMS/staticContent/js/default_aniket.js"></script>
	<script src="/RMS/staticContent/js/charts_aniket.js"></script>
	<script src="/RMS/staticContent/js/drilldown.js"></script>
	<!-- <script src="https://code.highcharts.com/modules/exporting.js"></script> -->
	<script src="/RMS/staticContent/js/exporting.js"></script>
	<script>
function openCity(evt, statsType) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(statsType).style.display = "block";
    evt.currentTarget.className += " active";
}
</script>

	<script type="text/javascript">
  var $length1 = $('#sales');
  var lengthMax1 = parseInt($length1.attr('data-max'), 10);
  var current1 = 0;

 var updateLength1 = function() {
  current1 += 100;
  $length1.html(current1 );
  updateTick1();
 };

 var updateTick1 = function(){
  if (current1 < lengthMax1){
   requestAnimationFrame(updateLength1);
  } 
  else{
    $length1.html('<i class="fa">&#xf156;</i>' +lengthMax1)
  }
 };

 updateLength1();

</script>

	<script type="text/javascript">

  var $length = $('#purchase');
  var lengthMax = parseInt($length.attr('data-max'), 10);
  var current = 0;

 var updateLength = function() {
  current += 100;
  $length.html(current );
  updateTick();
 };

 var updateTick = function(){
  if (current < lengthMax){
   requestAnimationFrame(updateLength);
  } 
  else{
    $length.html('<i class="fa">&#xf156;</i>' +lengthMax)
  }
 };

 updateLength();

</script>
	<script type="text/javascript">
 Highcharts.chart('container', {
    chart: {
        type: 'area'
    },
    title: {
        text: 'Sales , Purchase and Expences'
    },
    subtitle: {
        text: 'Source: <a href="https://http://www.embel.co.in">EMBEL TECHNOLOGIES</a>'
    },
    xAxis: {
        allowDecimals: false,
        labels: {
            formatter: function () {
                return this.value; // clean, unformatted number for year
            }
        }
    },
    yAxis: {
        title: {
            text: 'Figures (In Lakhs)'
        },
        labels: {
            formatter: function () {
                return this.value / 500 + 'k';
            }
        }
    },
    tooltip: {
        pointFormat: '{series.name} produced <b>{point.y:,.0f}</b><br/>warheads in {point.x}'
    },
    plotOptions: {
        area: {
            pointStart: 2015,
            marker: {
                enabled: false,
                symbol: 'circle',
                radius: 2,
                states: {
                    hover: {
                        enabled: true
                    }
                }
            }
        }
    },
    series: [{
        name: 'Year 2015',
        data: [133, 156, 947, ]
    }, {
        name: 'Year 2016 ',
        data: [1052, 954, 4250,]
    },
     {
        name: 'Year 2017',
        data: [152, 1954, 450, ]
    },]
});
</script>
	<script type="text/javascript">
  // Build the chart
Highcharts.chart('container1', {
    chart: {
        type: 'bar'
    },
    title: {
        text: 'Sales , Purchase and Expences'
    },
    subtitle: {
        text: 'Source: <a href="https://http://www.embel.co.in">EMBEL TECHNOLOGIES</a>'
    },
    xAxis: {
        categories: ['Year 2015 ', 'Year 2016', 'Year 2017 ',],
        title: {
            text: null
        }
    },
    yAxis: {
        min: 0,
        title: {
            text: 'Sales (In Lakhs)',
            align: 'high'
        },
        labels: {
            overflow: 'justify' 
        }

    },
    tooltip: {
        valueSuffix: ' Lakhs'
    },
    plotOptions: {
        bar: {
            dataLabels: {
                enabled: true
            }
        }
    },
    legend: {
        layout: 'vertical',
        align: 'right',
        verticalAlign: 'top',
        x: -40,
        y: 80,
        floating: true,
        borderWidth: 1,
        backgroundColor: ((Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'),
        shadow: true
    },
    credits: {
        enabled: false
    },
    series: [ {
        name: 'Year 2015',
        data: [133, 156, 947, ]
    }, {
        name: 'Year 2016',
        data: [1052, 954, 4250, ]
    },
    {
        name: 'Year 2017',
        data: [152, 1954, 450, ]
    },]
});
</script>

	<script>
function myFunction() {
    var input, filter, ul, li, a, i;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    ul = document.getElementById("myUL");
    li = ul.getElementsByTagName("li");
    for (i = 0; i < li.length; i++) {
        a = li[i].getElementsByTagName("a")[0];
        if (a.innerHTML.toUpperCase().indexOf(filter) > -1) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";

        }
    }
}
</script>


</body>

