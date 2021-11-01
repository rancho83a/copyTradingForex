$(document).ready(function() {

	$('.jsPopupDynstat').bPopup({
		speed: 450,
	});	
});

// =========================== DYNAMIC CHARTS ======================================================
	// Grafics with AMCHARTS.js      for dynamic 'Revenue from reinvesting profits'
	    // Themes begin
	am4core.useTheme(am4themes_animated);
		// Themes end

	var chart3 = am4core.create("chartdiv_dyn_profit_1", am4charts.XYChart);
	chart3.paddingRight = 15;
	chart3.paddingLeft = 0;

	// Create axes
	var dateAxis3 = chart3.xAxes.push(new am4charts.DateAxis());
	dateAxis3.renderer.minGridDistance = 35;
	dateAxis3.renderer.grid.template.location = 0.5;
	
	// Create value axis
	var valueAxis3 = chart3.yAxes.push(new am4charts.ValueAxis());
	valueAxis3.title.text = "USD";

	// Create series	 
	var series3 = chart3.series.push(new am4charts.LineSeries());
	series3.dataFields.valueY = "value";
	series3.dataFields.dateX = "date";
	series3.strokeWidth = 2;
	series3.tensionX = 0.88;
	series3.tensionY = 0.9;

	// gradient for fill
	series3.fillOpacity = 0.6;
	var fillModifier3 = new am4core.LinearGradientModifier();
	fillModifier3.opacities = [1, 0];
	fillModifier3.offsets = [0, 1];
	fillModifier3.gradient.rotation = 90;
	series3.segments.template.fillModifier = fillModifier3;

	//tooltips
	series3.tooltipText = "{valueY}";
	series3.tooltip.pointerOrientation = "vertical";
	series3.tooltip.background.cornerRadius = 20;
	series3.tooltip.background.fillOpacity = 0.5;
	series3.tooltip.label.padding(5,12,5,12);
	
	// Create a horizontal scrollbar with previe and place it underneath the date axis
	chart3.scrollbarX = new am4charts.XYChartScrollbar();
	chart3.scrollbarX.series.push(series3);
	chart3.scrollbarX.parent = chart3.bottomAxesContainer;
	// chart3.scrollbarX.stroke = am4core.color("red");     работает!!!!)))
	chart3.scrollbarX.fontSize = 14;

	series3.data = [

	{ "date": new Date(2018, 11), "value": 10000},
	{ "date": new Date(2018, 12), "value": 11028},
	{ "date": new Date(2019, 1), "value": 16770},
	{ "date": new Date(2019, 2), "value": 14678},
	{ "date": new Date(2019, 3), "value": 18780},
	{ "date": new Date(2019, 4), "value": 9803},
	{ "date": new Date(2019, 5), "value": 10443},
	{ "date": new Date(2019, 6), "value": 11164},
	{ "date": new Date(2019, 7), "value": 4242},
	{ "date": new Date(2019, 8), "value": 6855},
	{ "date": new Date(2019, 9), "value": 7534},
	{ "date": new Date(2019, 10), "value": 4596},
	{ "date": new Date(2019, 11), "value": 4793},
	{ "date": new Date(2019, 12), "value": 3945},
	{ "date": new Date(2020, 1), "value": 3093},
	{ "date": new Date(2020, 2), "value": 3529},
	];

	// Add simple bullet
	var circleBullet3 = series3.bullets.push(new am4charts.CircleBullet());
	circleBullet3.circle.stroke = am4core.color("#fff");
	circleBullet3.circle.strokeWidth = 0.7;
	circleBullet3.tooltipText = "[bold]{value}[/]";
	var bullethover3 = circleBullet3.states.create("hover");
	bullethover3.properties.scale = 1.3;

	// Add cursor
	chart3.cursor = new am4charts.XYCursor();
	chart3.cursor.xAxis = dateAxis3;
	chart3.cursor.snapToSeries = series3;
// ================== end of graphics===========================

// =================================================================================
	// Grafics with AMCHARTS.js      ==== for dynamic 'Revenue profit's withdraw' ====
	    // Themes begin
	am4core.useTheme(am4themes_animated);
		// Themes end

	var chart4 = am4core.create("chartdiv_dyn_profit_2", am4charts.XYChart);
	chart4.paddingRight = 15;
	chart4.paddingLeft = 0;

	// Create axes
	var dateAxis4 = chart4.xAxes.push(new am4charts.DateAxis());
	dateAxis4.renderer.minGridDistance = 35;
	dateAxis4.renderer.grid.template.location = 0.5;
	
	// Create value axis
	var valueAxis4 = chart4.yAxes.push(new am4charts.ValueAxis());
	valueAxis4.title.text = "USD";

	// Create series	 
	var series4_1 = chart4.series.push(new am4charts.LineSeries());
	series4_1.dataFields.valueY = "value";
	series4_1.dataFields.dateX = "date";
	series4_1.strokeWidth = 2;
	series4_1.tensionX = 0.88;
	series4_1.tensionY = 0.9;
	series4_1.stroke = am4core.color("#073763"); // blue
	series4_1.fill = am4core.color("#073763"); // blue

	var series4_2 = chart4.series.push(new am4charts.LineSeries());
	series4_2.dataFields.valueY = "value";
	series4_2.dataFields.dateX = "date";
	series4_2.strokeWidth = 2;
	series4_2.tensionX = 0.88;
	series4_2.tensionY = 0.9;
	series4_2.stroke = am4core.color("#bf9000"); // golden
	series4_2.fill = am4core.color("#bf9000"); // golden

	var series4_3 = chart4.series.push(new am4charts.LineSeries());
	series4_3.dataFields.valueY = "value";
	series4_3.dataFields.dateX = "date";
	series4_3.strokeWidth = 2;
	series4_3.tensionX = 0.88;
	series4_3.tensionY = 0.9;
	series4_3.stroke = am4core.color("#ff0000"); // red
	series4_3.fill = am4core.color("#ff0000"); // red

	// gradient for fill
	series4_1.fillOpacity = 0.3;
	var fillModifier4_1 = new am4core.LinearGradientModifier();
	fillModifier4_1.opacities = [1, 0];
	fillModifier4_1.offsets = [0, 1];
	fillModifier4_1.gradient.rotation = 90;
	series4_1.segments.template.fillModifier = fillModifier4_1;

	series4_2.fillOpacity = 0.3;
	var fillModifier4_2 = new am4core.LinearGradientModifier("red");
	fillModifier4_2.opacities = [1, 0];
	fillModifier4_2.offsets = [0, 1];
	fillModifier4_2.gradient.rotation = 90;
	series4_2.segments.template.fillModifier = fillModifier4_2;

	series4_3.fillOpacity = 0.3;
	var fillModifier4_3 = new am4core.LinearGradientModifier();
	fillModifier4_3.opacities = [1, 0];
	fillModifier4_3.offsets = [0, 1];
	fillModifier4_3.gradient.rotation = 90;
	series4_3.segments.template.fillModifier = fillModifier4_3;

	//tooltips
	series4_1.tooltipText = "{valueY}";
	series4_1.tooltip.pointerOrientation = "vertical";
	series4_1.tooltip.background.cornerRadius = 20;
	series4_1.tooltip.background.fillOpacity = 0.5;
	series4_1.tooltip.label.padding(5,12,5,12);

	series4_2.tooltipText = "{valueY}";
	series4_2.tooltip.pointerOrientation = "vertical";
	series4_2.tooltip.background.cornerRadius = 20;
	series4_2.tooltip.background.fillOpacity = 0.5;
	series4_2.tooltip.label.padding(5,12,5,12);

	series4_3.tooltipText = "{valueY}";
	series4_3.tooltip.pointerOrientation = "vertical";
	series4_3.tooltip.background.cornerRadius = 20;
	series4_3.tooltip.background.fillOpacity = 0.5;
	series4_3.tooltip.label.padding(5,12,5,12);
	
	// Create a horizontal scrollbar with previe and place it underneath the date axis
	chart4.scrollbarX = new am4charts.XYChartScrollbar();
	chart4.scrollbarX.series.push(series4_1);
	chart4.scrollbarX.series.push(series4_2);
	chart4.scrollbarX.series.push(series4_3);
	chart4.scrollbarX.parent = chart4.bottomAxesContainer;
	// chart4.scrollbarX.stroke = am4core.color("red");     работает!!!!)))
	chart4.scrollbarX.fontSize = 14;
	
	// Add simple bullet
	var circleBullet4_1 = series4_1.bullets.push(new am4charts.CircleBullet());
	circleBullet4_1.fill = am4core.color("#073763");
	circleBullet4_1.circle.stroke = am4core.color("#fff");
	circleBullet4_1.circle.strokeWidth = 0.7;
	circleBullet4_1.tooltipText = "[bold]{value}[/]";	
	var bullethover4_1 = circleBullet4_1.states.create("hover");
	bullethover4_1.properties.scale = 1.3;
	

	var circleBullet4_2 = series4_2.bullets.push(new am4charts.CircleBullet());
	circleBullet4_2.fill = am4core.color("#bf9000");
	circleBullet4_2.circle.stroke = am4core.color("#fff");
	circleBullet4_2.circle.strokeWidth = 0.7;
	circleBullet4_2.tooltipText = "[bold]{value}[/]";
	var bullethover4_2 = circleBullet4_2.states.create("hover");
	bullethover4_2.properties.scale = 1.3;

	var circleBullet4_3 = series4_3.bullets.push(new am4charts.CircleBullet());
	circleBullet4_3.fill = am4core.color("#ff0000");
	circleBullet4_3.circle.stroke = am4core.color("#fff");
	circleBullet4_3.circle.strokeWidth = 0.7;
	circleBullet4_3.tooltipText = "[bold]{value}[/]";
	var bullethover4_3 = circleBullet4_3.states.create("hover");
	bullethover4_3.properties.scale = 1.3;

	// Add cursor
	chart4.cursor = new am4charts.XYCursor();
	chart4.cursor.xAxis = dateAxis4;
	chart4.cursor.snapToSeries = series4_1;

	// series4_1 - Trading Capital, USD
	series4_1.data = [

	{ "date": new Date(2018, 12), "value": 10000},
	{ "date": new Date(2019, 1), "value": 10000},
	{ "date": new Date(2019, 2), "value": 8753},
	{ "date": new Date(2019, 3), "value": 10000},
	{ "date": new Date(2019, 4), "value": 5220},
	{ "date": new Date(2019, 5), "value": 5561},
	{ "date": new Date(2019, 6), "value": 5945},
	{ "date": new Date(2019, 7), "value": 2259},
	{ "date": new Date(2019, 8), "value": 3650},
	{ "date": new Date(2019, 9), "value": 4012},
	{ "date": new Date(2019, 10), "value": 2447},
	{ "date": new Date(2019, 11), "value": 2552},
	{ "date": new Date(2019, 12), "value": 2101},
	{ "date": new Date(2020, 1), "value": 1647},
	{ "date": new Date(2020, 2), "value": 1879},
	];

	// series4_2 - Total Withdraw, USD
	series4_2.data = [
	
	{ "date": new Date(2018, 12), "value": 1028},
	{ "date": new Date(2019, 1), "value": 6234},
	{ "date": new Date(2019, 2), "value": 6234},
	{ "date": new Date(2019, 3), "value": 7433},
	{ "date": new Date(2019, 4), "value": 7433},
	{ "date": new Date(2019, 5), "value": 7433},
	{ "date": new Date(2019, 6), "value": 7433},
	{ "date": new Date(2019, 7), "value": 7433},
	{ "date": new Date(2019, 8), "value": 7433},
	{ "date": new Date(2019, 9), "value": 7433},
	{ "date": new Date(2019, 10), "value": 7433},
	{ "date": new Date(2019, 11), "value": 7433},
	{ "date": new Date(2019, 12), "value": 7433},
	{ "date": new Date(2020, 1), "value": 7433},
	{ "date": new Date(2020, 2), "value": 7433},

	];

	// series4_3 - General Capital, USD
	series4_3.data = [

	{ "date": new Date(2018, 12), "value": 11028},
	{ "date": new Date(2019, 1), "value": 16234},
	{ "date": new Date(2019, 2), "value": 14987},
	{ "date": new Date(2019, 3), "value": 17433},
	{ "date": new Date(2019, 4), "value": 12653},
	{ "date": new Date(2019, 5), "value": 12994},
	{ "date": new Date(2019, 6), "value": 13378},
	{ "date": new Date(2019, 7), "value": 9692},
	{ "date": new Date(2019, 8), "value": 11084},
	{ "date": new Date(2019, 9), "value": 11445},
	{ "date": new Date(2019, 10), "value": 9880},
	{ "date": new Date(2019, 11), "value": 9986},
	{ "date": new Date(2019, 12), "value": 9534},
	{ "date": new Date(2020, 1), "value": 9080},
	{ "date": new Date(2020, 2), "value": 9312},

	];

// ================== end of graphics===========================