// =================================================================================
	// Grafics with AMCHARTS.js
	    // Themes begin
	am4core.useTheme(am4themes_animated);
		// Themes end

	var chart1 = am4core.create("chartdiv_dyn", am4charts.XYChart);
	chart1.paddingRight = 15;
	chart1.paddingLeft = 0;

	// Create axes
	var dateAxis1 = chart1.xAxes.push(new am4charts.DateAxis());
	dateAxis1.renderer.minGridDistance = 35;
	dateAxis1.renderer.grid.template.location = 0.5;
	dateAxis1.renderer.labels.template.fontSize = 16;
	
	// Create value axis
	var valueAxis1 = chart1.yAxes.push(new am4charts.ValueAxis());
	valueAxis1.title.text = "Profit, %";

	// Create series	 
	// series1 ======= USD account
	var series1 = chart1.series.push(new am4charts.LineSeries());
	series1.dataFields.valueY = "value";
	series1.dataFields.dateX = "date";
	series1.name = "USD pool";
	series1.strokeWidth = 2;
	series1.tensionX = 0.88;
	series1.tensionY = 0.9;

	// series1_1 ======= EUR account
	var series1_1 = chart1.series.push(new am4charts.LineSeries());
	series1_1.dataFields.valueY = "value";
	series1_1.dataFields.dateX = "date";
	series1_1.name = "EUR pool";
	series1_1.strokeWidth = 2;
	series1_1.tensionX = 0.88;
	series1_1.tensionY = 0.9;
	series1_1.stroke = am4core.color("#ff0000"); // red
	series1_1.fill = am4core.color("#ff0000"); // red

	// gradient for fill
	series1.fillOpacity = 0.6;
	var fillModifier1 = new am4core.LinearGradientModifier();
	fillModifier1.opacities = [1, 0];
	fillModifier1.offsets = [0, 1];
	fillModifier1.gradient.rotation = 90;
	series1.segments.template.fillModifier = fillModifier1;

	series1_1.fillOpacity = 0.6;
	var fillModifier1_1 = new am4core.LinearGradientModifier("#ff0000");
	fillModifier1_1.opacities = [1, 0];
	fillModifier1_1.offsets = [0, 1];
	fillModifier1_1.gradient.rotation = 90;
	series1_1.segments.template.fillModifier = fillModifier1_1;

	//tooltips
	series1.tooltipText = "{valueY}";
	series1.tooltip.pointerOrientation = "vertical";
	series1.tooltip.background.cornerRadius = 20;
	series1.tooltip.background.fillOpacity = 0.5;
	series1.tooltip.label.padding(5,12,5,12);

	series1_1.tooltipText = "{valueY}";
	series1_1.tooltip.pointerOrientation = "vertical";
	series1_1.tooltip.background.cornerRadius = 20;
	series1_1.tooltip.background.fillOpacity = 0.5;
	series1_1.tooltip.label.padding(5,12,5,12);
	
	// Create a horizontal scrollbar with previe and place it underneath the date axis
	chart1.scrollbarX = new am4charts.XYChartScrollbar();
	chart1.scrollbarX.series.push(series1);
	chart1.scrollbarX.parent = chart1.bottomAxesContainer;
	// chart1.scrollbarX.stroke = am4core.color("red");     работает!!!!)))
	chart1.scrollbarX.fontSize = 14;

	series1.data = [

	// USD
	{ "date": new Date(2018, 11), "value": 0},
	{ "date": new Date(2018, 12), "value": 18.35},
	{ "date": new Date(2019, 1), "value": 111.33},
	{ "date": new Date(2019, 2), "value": 98.86},
	{ "date": new Date(2019, 3), "value": 137.5},
	{ "date": new Date(2019, 4), "value": 89.7},
	{ "date": new Date(2019, 5), "value": 96.2},
	{ "date": new Date(2019, 6), "value": 103.2},
	{ "date": new Date(2019, 7), "value": 41.2},
	{ "date": new Date(2019, 8), "value": 102.8},
	{ "date": new Date(2019, 9), "value": 112.7},
	{ "date": new Date(2019, 10), "value": 73.7},
	{ "date": new Date(2019, 11), "value": 78.0},
	{ "date": new Date(2019, 12), "value": 60.3},
	{ "date": new Date(2020, 1), "value": 38.8},
	{ "date": new Date(2020, 2), "value": 52.8},
	];

	// EUR
	series1_1.data = [
	{ "date": new Date(2018, 12), "value": 0},
	{ "date": new Date(2019, 1), "value": 62.9},
	{ "date": new Date(2019, 2), "value": 47.3},
	{ "date": new Date(2019, 3), "value": 85.4},
	{ "date": new Date(2019, 4), "value": 36.1},
	{ "date": new Date(2019, 5), "value": 39.1},
	{ "date": new Date(2019, 6), "value": 43.4},
	{ "date": new Date(2019, 7), "value": -19.8},
	{ "date": new Date(2019, 8), "value": 43.8},
	{ "date": new Date(2019, 9), "value": 48.5},
	{ "date": new Date(2019, 10), "value": 16.2},
	{ "date": new Date(2019, 11), "value": 14.0},
	{ "date": new Date(2019, 12), "value": -7.5},
	{ "date": new Date(2020, 1), "value": -32.5},
	{ "date": new Date(2020, 2), "value": -26.5},
	];

	// Add simple bullet
	var circleBullet1 = series1.bullets.push(new am4charts.CircleBullet());
	// circleBullet1.fill = am4core.color("#073763");
	circleBullet1.circle.stroke = am4core.color("#fff");
	circleBullet1.circle.strokeWidth = 0.7;
	circleBullet1.tooltipText = "[bold]{value}[/]";
	var bullethover1 = circleBullet1.states.create("hover");
	bullethover1.properties.scale = 1.3;

	var circleBullet1_1 = series1_1.bullets.push(new am4charts.CircleBullet());
	circleBullet1_1.fill = am4core.color("#d67272");
	circleBullet1_1.circle.stroke = am4core.color("#fff");
	circleBullet1_1.circle.strokeWidth = 0.7;
	circleBullet1_1.tooltipText = "[bold]{value}[/]";
	var bullethover1_1 = circleBullet1_1.states.create("hover");
	bullethover1_1.properties.scale = 1.3;

	// Add legend
	chart1.legend = new am4charts.Legend();
	chart1.legend.useDefaultMarker = true;
	var marker = chart1.legend.markers.template.children.getIndex(0);
	marker.cornerRadius(8, 8, 8, 8);
	marker.width = 20;
	marker.height = 20;

	// Add cursor
	chart1.cursor = new am4charts.XYCursor();
	chart1.cursor.xAxis = dateAxis1;
	chart1.cursor.snapToSeries = series1;

	// Enabling responsive features
//========================================================
chart1.responsive.enabled = true;

chart1.responsive.rules.push({
  relevant: function(target) {
	if (target.pixelWidth <= 485) {
	  return true;
	}
	return false;
	},
  state: function(target, stateId) {
	if (target instanceof am4charts.Chart) {
	  let state = target.states.create(stateId);
	  dateAxis1.renderer.minGridDistance = 35;
	  dateAxis1.renderer.labels.template.fontSize = 15;
	  // chart1.scrollbarX.disabled  = true;
	  return state;
	}
	return null;
  }
});
// ================== end of Dynamic graphics===========================

	// Grafics with AMCHARTS.js
	    // Themes begin
	am4core.useTheme(am4themes_animated);
		// Themes end

	var chart2 = am4core.create("chartdiv_bal", am4charts.XYChart);
	chart2.paddingRight = 15;
	chart2.paddingLeft = 0;

	// Create axes
	var dateAxis2 = chart2.xAxes.push(new am4charts.DateAxis());
	dateAxis2.renderer.minGridDistance = 40;
	dateAxis2.renderer.grid.template.location = 0.5;
	
	// Create value axis
	var valueAxis2 = chart2.yAxes.push(new am4charts.ValueAxis());
	valueAxis2.title.text = "Profit, %";

	// Create series	 
	var series2 = chart2.series.push(new am4charts.LineSeries());
	series2.dataFields.valueY = "value";
	series2.dataFields.dateX = "date";
	series2.name = "USD pool";
	series2.strokeWidth = 2;
	series2.tensionX = 0.88;
	series2.tensionY = 0.9;

	// gradient for fill
	series2.fillOpacity = 0.6;
	var fillModifier2 = new am4core.LinearGradientModifier();
	fillModifier2.opacities = [1, 0];
	fillModifier2.offsets = [0, 1];
	fillModifier2.gradient.rotation = 90;
	series2.segments.template.fillModifier = fillModifier2;

	//tooltips
	series2.tooltipText = "{valueY}";
	series2.tooltip.pointerOrientation = "vertical";
	series2.tooltip.background.cornerRadius = 20;
	series2.tooltip.background.fillOpacity = 0.5;
	series2.tooltip.label.padding(5,12,5,12);

	// Create a horizontal scrollbar with previe and place it underneath the date axis
	chart2.scrollbarX = new am4charts.XYChartScrollbar();
	chart2.scrollbarX.series.push(series2);
	chart2.scrollbarX.parent = chart2.bottomAxesContainer;
	// chart2.scrollbarX.stroke = am4core.color("red");     работает!!!!)))
	chart2.scrollbarX.fontSize = 14;

	series2.data = [
	{ "date": new Date(2018, 2), "value": 0},
	{ "date": new Date(2018, 3), "value": 35.32},
	{ "date": new Date(2018, 4), "value": 61.41},
	{ "date": new Date(2018, 5), "value": 72.64},
	{ "date": new Date(2018, 6), "value": 76.10},
	{ "date": new Date(2018, 7), "value": 65.17},
	{ "date": new Date(2018, 8), "value": 40.93},
	{ "date": new Date(2018, 9), "value": 67.99},
	{ "date": new Date(2018, 10), "value": 56.59},
	{ "date": new Date(2018, 11), "value": 125.19},
	{ "date": new Date(2018, 12), "value": 118.7},
	{ "date": new Date(2019, 1), "value": 191.7},
	{ "date": new Date(2019, 2), "value": 178.9},
	{ "date": new Date(2019, 3), "value": 204.6},
	{ "date": new Date(2019, 4), "value": 166.7},
	{ "date": new Date(2019, 5), "value": 173.1},
	{ "date": new Date(2019, 6), "value": 178.6},
	{ "date": new Date(2019, 7), "value": 128.9},
	{ "date": new Date(2019, 8), "value": 161.0},
	{ "date": new Date(2019, 9), "value": 159.5},
	{ "date": new Date(2019, 10), "value": 130.9},
	{ "date": new Date(2019, 11), "value": 135.7},
	{ "date": new Date(2019, 12), "value": 120.6},
	{ "date": new Date(2020, 1), "value": 104.8},
	{ "date": new Date(2020, 2), "value": 123.2},
	];

	// Add simple bullet
	var circleBullet2 = series2.bullets.push(new am4charts.CircleBullet());
	circleBullet2.circle.stroke = am4core.color("#fff");
	circleBullet2.circle.strokeWidth = 0.1;
	circleBullet2.tooltipText = "[bold]{value}[/]";
	var bullethover2 = circleBullet2.states.create("hover");
	bullethover2.properties.scale = 1.3;

	// Add legend
	chart2.legend = new am4charts.Legend();
	chart2.legend.useDefaultMarker = true;
	var marker = chart2.legend.markers.template.children.getIndex(0);
	marker.cornerRadius(8, 8, 8, 8);
	marker.width = 20;
	marker.height = 20;

	// Add cursor
	chart2.cursor = new am4charts.XYCursor();
	chart2.cursor.xAxis = dateAxis2;
	chart2.cursor.snapToSeries = series2;

	// Enabling responsive features
//========================================================
chart2.responsive.enabled = true;

chart2.responsive.rules.push({
  relevant: function(target) {
	if (target.pixelWidth <= 485) {
	  return true;
	}
	return false;
	},
  state: function(target, stateId) {
	if (target instanceof am4charts.Chart) {
	  let state = target.states.create(stateId);
	  dateAxis2.renderer.minGridDistance = 40;
	  dateAxis2.renderer.labels.template.fontSize = 15;
	  return state;
	}
	return null;
  }
});