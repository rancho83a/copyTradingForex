$(document).ready(function() {

	$('.jsPopupBalstat').bPopup({
		speed: 450,
	});	
});

// =========================== BALANCED CHARTS ======================================================
	// Grafics with AMCHARTS.js      for dynamic 'Revenue from reinvesting profits'
	    // Themes begin
	am4core.useTheme(am4themes_animated);
		// Themes end

	var chart5 = am4core.create("chartdiv_bal_profit_1", am4charts.XYChart);
	chart5.paddingRight = 15;
	chart5.paddingLeft = 0;

	// Create axes
	var dateAxis5 = chart5.xAxes.push(new am4charts.DateAxis());
	dateAxis5.renderer.minGridDistance = 35;
	dateAxis5.renderer.grid.template.location = 0.5;
	
	// Create value axis
	var valueAxis5 = chart5.yAxes.push(new am4charts.ValueAxis());
	valueAxis5.title.text = "USD";

	// Create series	 
	var series5 = chart5.series.push(new am4charts.LineSeries());
	series5.dataFields.valueY = "value";
	series5.dataFields.dateX = "date";
	series5.strokeWidth = 2;
	series5.tensionX = 0.88;
	series5.tensionY = 0.9;

	// gradient for fill
	series5.fillOpacity = 0.6;
	var fillModifier5 = new am4core.LinearGradientModifier();
	fillModifier5.opacities = [1, 0];
	fillModifier5.offsets = [0, 1];
	fillModifier5.gradient.rotation = 90;
	series5.segments.template.fillModifier = fillModifier5;

	//tooltips
	series5.tooltipText = "{valueY}";
	series5.tooltip.pointerOrientation = "vertical";
	series5.tooltip.background.cornerRadius = 20;
	series5.tooltip.background.fillOpacity = 0.5;
	series5.tooltip.label.padding(5,12,5,12);
	
	// Create a horizontal scrollbar with previe and place it underneath the date axis
	chart5.scrollbarX = new am4charts.XYChartScrollbar();
	chart5.scrollbarX.series.push(series5);
	chart5.scrollbarX.parent = chart5.bottomAxesContainer;
	// chart3.scrollbarX.stroke = am4core.color("red");     работает!!!!)))
	chart5.scrollbarX.fontSize = 14;

	series5.data = [
	{ "date": new Date(2018, 2), "value": 10000},
	{ "date": new Date(2018, 3), "value": 11978},
	{ "date": new Date(2018, 4), "value": 13728},
	{ "date": new Date(2018, 5), "value": 14591},
	{ "date": new Date(2018, 6), "value": 14874},
	{ "date": new Date(2018, 7), "value": 13248},
	{ "date": new Date(2018, 8), "value": 10037},
	{ "date": new Date(2018, 9), "value": 12752},
	{ "date": new Date(2018, 10), "value": 11298},
	{ "date": new Date(2018, 11), "value": 17212},
	{ "date": new Date(2018, 12), "value": 16095},
	{ "date": new Date(2019, 1), "value": 22676},
	{ "date": new Date(2019, 2), "value": 19769},
	{ "date": new Date(2019, 3), "value": 23897},
	{ "date": new Date(2019, 4), "value": 14837},
	{ "date": new Date(2019, 5), "value": 15784},
	{ "date": new Date(2019, 6), "value": 16657},
	{ "date": new Date(2019, 7), "value": 8380},
	{ "date": new Date(2019, 8), "value": 11067},
	{ "date": new Date(2019, 9), "value": 10906},
	{ "date": new Date(2019, 10), "value": 7783},
	{ "date": new Date(2019, 11), "value": 8154},
	{ "date": new Date(2019, 12), "value": 6922},
	{ "date": new Date(2020, 1), "value": 5832},
	{ "date": new Date(2020, 2), "value": 6903},
	];

	// Add simple bullet
	var circleBullet5 = series5.bullets.push(new am4charts.CircleBullet());
	circleBullet5.circle.stroke = am4core.color("#fff");
	circleBullet5.circle.strokeWidth = 0.7;
	circleBullet5.tooltipText = "[bold]{value}[/]";
	var bullethover5 = circleBullet5.states.create("hover");
	bullethover5.properties.scale = 1.3;

	// Add cursor
	chart5.cursor = new am4charts.XYCursor();
	chart5.cursor.xAxis = dateAxis5;
	chart5.cursor.snapToSeries = series5;
// ================== end of graphics===========================

// =================================================================================
	// Grafics with AMCHARTS.js      for dynamic 'Revenue profit's withdraw'
	    // Themes begin
	am4core.useTheme(am4themes_animated);
		// Themes end

	var chart6 = am4core.create("chartdiv_bal_profit_2", am4charts.XYChart);
	chart6.paddingRight = 15;
	chart6.paddingLeft = 0;

	// Create axes
	var dateAxis6 = chart6.xAxes.push(new am4charts.DateAxis());
	dateAxis6.renderer.minGridDistance = 35;
	dateAxis6.renderer.grid.template.location = 0.5;
	
	// Create value axis
	var valueAxis6 = chart6.yAxes.push(new am4charts.ValueAxis());
	valueAxis6.title.text = "USD";

	// Create series	 
	var series6_1 = chart6.series.push(new am4charts.LineSeries());
	series6_1.dataFields.valueY = "value";
	series6_1.dataFields.dateX = "date";
	series6_1.strokeWidth = 2;
	series6_1.tensionX = 0.88;
	series6_1.tensionY = 0.9;
	series6_1.stroke = am4core.color("#073763"); // blue
	series6_1.fill = am4core.color("#073763"); // blue

	var series6_2 = chart6.series.push(new am4charts.LineSeries());
	series6_2.dataFields.valueY = "value";
	series6_2.dataFields.dateX = "date";
	series6_2.strokeWidth = 2;
	series6_2.tensionX = 0.88;
	series6_2.tensionY = 0.9;
	series6_2.stroke = am4core.color("#bf9000"); // golden
	series6_2.fill = am4core.color("#bf9000"); // golden

	var series6_3 = chart6.series.push(new am4charts.LineSeries());
	series6_3.dataFields.valueY = "value";
	series6_3.dataFields.dateX = "date";
	series6_3.strokeWidth = 2;
	series6_3.tensionX = 0.88;
	series6_3.tensionY = 0.9;
	series6_3.stroke = am4core.color("#ff0000"); // red
	series6_3.fill = am4core.color("#ff0000"); // red

	// gradient for fill
	series6_1.fillOpacity = 0.3;
	var fillModifier6_1 = new am4core.LinearGradientModifier();
	fillModifier6_1.opacities = [1, 0];
	fillModifier6_1.offsets = [0, 1];
	fillModifier6_1.gradient.rotation = 90;
	series6_1.segments.template.fillModifier = fillModifier6_1;

	series6_2.fillOpacity = 0.3;
	var fillModifier6_2 = new am4core.LinearGradientModifier("red");
	fillModifier6_2.opacities = [1, 0];
	fillModifier6_2.offsets = [0, 1];
	fillModifier6_2.gradient.rotation = 90;
	series6_2.segments.template.fillModifier = fillModifier6_2;

	series6_3.fillOpacity = 0.3;
	var fillModifier6_3 = new am4core.LinearGradientModifier();
	fillModifier6_3.opacities = [1, 0];
	fillModifier6_3.offsets = [0, 1];
	fillModifier6_3.gradient.rotation = 90;
	series6_3.segments.template.fillModifier = fillModifier6_3;

	//tooltips
	series6_1.tooltipText = "{valueY}";
	series6_1.tooltip.pointerOrientation = "vertical";
	series6_1.tooltip.background.cornerRadius = 20;
	series6_1.tooltip.background.fillOpacity = 0.5;
	series6_1.tooltip.label.padding(5,12,5,12);

	series6_2.tooltipText = "{valueY}";
	series6_2.tooltip.pointerOrientation = "vertical";
	series6_2.tooltip.background.cornerRadius = 20;
	series6_2.tooltip.background.fillOpacity = 0.5;
	series6_2.tooltip.label.padding(5,12,5,12);

	series6_3.tooltipText = "{valueY}";
	series6_3.tooltip.pointerOrientation = "vertical";
	series6_3.tooltip.background.cornerRadius = 20;
	series6_3.tooltip.background.fillOpacity = 0.5;
	series6_3.tooltip.label.padding(5,12,5,12);
	
	// Create a horizontal scrollbar with previe and place it underneath the date axis
	chart6.scrollbarX = new am4charts.XYChartScrollbar();
	chart6.scrollbarX.series.push(series6_1);
	chart6.scrollbarX.series.push(series6_2);
	chart6.scrollbarX.series.push(series6_3);
	chart6.scrollbarX.parent = chart6.bottomAxesContainer;
	// chart4.scrollbarX.stroke = am4core.color("red");     работает!!!!)))
	chart6.scrollbarX.fontSize = 14;
	
	// Add simple bullet
	var circleBullet6_1 = series6_1.bullets.push(new am4charts.CircleBullet());
	circleBullet6_1.fill = am4core.color("#073763");
	circleBullet6_1.circle.stroke = am4core.color("#fff");
	circleBullet6_1.circle.strokeWidth = 0.7;
	circleBullet6_1.tooltipText = "[bold]{value}[/]";	
	var bullethover6_1 = circleBullet6_1.states.create("hover");
	bullethover6_1.properties.scale = 1.3;	

	var circleBullet6_2 = series6_2.bullets.push(new am4charts.CircleBullet());
	circleBullet6_2.fill = am4core.color("#bf9000");
	circleBullet6_2.circle.stroke = am4core.color("#fff");
	circleBullet6_2.circle.strokeWidth = 0.7;
	circleBullet6_2.tooltipText = "[bold]{value}[/]";
	var bullethover6_2 = circleBullet6_2.states.create("hover");
	bullethover6_2.properties.scale = 1.3;

	var circleBullet6_3 = series6_3.bullets.push(new am4charts.CircleBullet());
	circleBullet6_3.fill = am4core.color("#ff0000");
	circleBullet6_3.circle.stroke = am4core.color("#fff");
	circleBullet6_3.circle.strokeWidth = 0.7;
	circleBullet6_3.tooltipText = "[bold]{value}[/]";
	var bullethover6_3 = circleBullet6_3.states.create("hover");
	bullethover6_3.properties.scale = 1.3;

	// Add cursor
	chart6.cursor = new am4charts.XYCursor();
	chart6.cursor.xAxis = dateAxis6;
	chart6.cursor.snapToSeries = series6_1;

	// series6_1 - Trading Capital, USD
	series6_1.data = [
	{ "date": new Date(2018, 3), "value": 10000},
	{ "date": new Date(2018, 4), "value": 10000},
	{ "date": new Date(2018, 5), "value": 10000},
	{ "date": new Date(2018, 6), "value": 10000},
	{ "date": new Date(2018, 7), "value": 8907},
	{ "date": new Date(2018, 8), "value": 6748},
	{ "date": new Date(2018, 9), "value": 8573},
	{ "date": new Date(2018, 10), "value": 7596},
	{ "date": new Date(2018, 11), "value": 10000},
	{ "date": new Date(2018, 12), "value": 9351},
	{ "date": new Date(2019, 1), "value": 10000},
	{ "date": new Date(2019, 2), "value": 8718},
	{ "date": new Date(2019, 3), "value": 10000},
	{ "date": new Date(2019, 4), "value": 6209},
	{ "date": new Date(2019, 5), "value": 6605},
	{ "date": new Date(2019, 6), "value": 6970},
	{ "date": new Date(2019, 7), "value": 3507},
	{ "date": new Date(2019, 8), "value": 4631},
	{ "date": new Date(2019, 9), "value": 4564},
	{ "date": new Date(2019, 10), "value": 3257},
	{ "date": new Date(2019, 11), "value": 3412},
	{ "date": new Date(2019, 12), "value": 2897},
	{ "date": new Date(2020, 1), "value": 2441},
	{ "date": new Date(2020, 2), "value": 2889},

	];

	// series6_2 - Total Withdraw, USD
	series6_2.data = [
	{ "date": new Date(2018, 2), "value": 0},
	{ "date": new Date(2018, 3), "value": 1978},
	{ "date": new Date(2018, 4), "value": 3439},
	{ "date": new Date(2018, 5), "value": 4068},
	{ "date": new Date(2018, 6), "value": 4262},
	{ "date": new Date(2018, 7), "value": 4262},
	{ "date": new Date(2018, 8), "value": 4262},
	{ "date": new Date(2018, 9), "value": 4262},
	{ "date": new Date(2018, 10), "value": 4262},
	{ "date": new Date(2018, 11), "value": 5834},
	{ "date": new Date(2018, 12), "value": 5834},
	{ "date": new Date(2019, 1), "value": 9293},
	{ "date": new Date(2019, 2), "value": 9293},
	{ "date": new Date(2019, 3), "value": 9832},
	{ "date": new Date(2019, 4), "value": 9832},
	{ "date": new Date(2019, 5), "value": 9832},
	{ "date": new Date(2019, 6), "value": 9832},
	{ "date": new Date(2019, 7), "value": 9832},
	{ "date": new Date(2019, 8), "value": 9832},
	{ "date": new Date(2019, 9), "value": 9832},
	{ "date": new Date(2019, 10), "value": 9832},
	{ "date": new Date(2019, 11), "value": 9832},
	{ "date": new Date(2019, 12), "value": 9832},
	{ "date": new Date(2020, 1), "value": 9832},
	{ "date": new Date(2020, 2), "value": 9832},

	];

	// series6_3 - General Capital, USD
	series6_3.data = [
	{ "date": new Date(2018, 2), "value": 0},
	{ "date": new Date(2018, 3), "value": 11978},
	{ "date": new Date(2018, 4), "value": 13439},
	{ "date": new Date(2018, 5), "value": 14068},
	{ "date": new Date(2018, 6), "value": 14262},
	{ "date": new Date(2018, 7), "value": 13169},
	{ "date": new Date(2018, 8), "value": 11010},
	{ "date": new Date(2018, 9), "value": 12835},
	{ "date": new Date(2018, 10), "value": 12835},
	{ "date": new Date(2018, 11), "value": 15834},
	{ "date": new Date(2018, 12), "value": 15185},
	{ "date": new Date(2019, 1), "value": 19293},
	{ "date": new Date(2019, 2), "value": 18011},
	{ "date": new Date(2019, 3), "value": 19832},
	{ "date": new Date(2019, 4), "value": 16041},
	{ "date": new Date(2019, 5), "value": 16437},
	{ "date": new Date(2019, 6), "value": 16802},
	{ "date": new Date(2019, 7), "value": 13339},
	{ "date": new Date(2019, 8), "value": 14463},
	{ "date": new Date(2019, 9), "value": 14396},
	{ "date": new Date(2019, 10), "value": 13089},
	{ "date": new Date(2019, 11), "value": 13244},
	{ "date": new Date(2019, 12), "value": 12728},
	{ "date": new Date(2020, 1), "value": 12272},
	{ "date": new Date(2020, 2), "value": 12721},
	
	];

// ================== end of  BALANCED graphics===========================