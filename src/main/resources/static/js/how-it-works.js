$(document).ready(function() {

	//Testimonials' slider
	$('.jsTestimonials').slick({
		dots:true,
		arrows:false,
		speed:1000,
		slidesToShow:1,	
		autoplay:true,
			
	});

	// fancyBox
	$('.jsFancybox').fancybox();

//================================= CANVAS =========================================================================
	//white arc for canvas already drawn
	var canvas = document.getElementById('duga');
		var ctx = canvas.getContext('2d');
		var pi = Math.PI;

		ctx.lineWidth = 3;
		ctx.strokeStyle = 'white';
		ctx.fillStyle = 'blue';
		ctx.arc(75, 75, 70, 3*pi/2, 3*pi/2-0.000001, false);
		ctx.stroke();

	//when canvas appeares on the screen, 'var = startTime' gets a value to start
	// run = function (to draw the arc)
  	var offset = window.innerHeight - 50;
		$(window).scroll(function(){
				var scrolltop = $(this).scrollTop();
				$('.canvass').each(function(){
			 		if(scrolltop >= $(this).offset().top - offset) {
 			 	// $(this).addClass('do_canvas');
 			 	// $(this).attr('id', 'newID');
 			 	startTime = new Date().getTime();
 			 run();
		 		 }
			});
	});

	// CANVAS drawing begins
	var canvas = document.getElementById('duga');
      var context = canvas.getContext('2d');
      var x = canvas.width /2;     //center of the canvas
      var y = canvas.height / 2;
      var radius = 70;
      var counterClockwise = false;

      //canvas drawing function
      var run = function() {
        var time = (new Date().getTime()- startTime)/ duration;
        var startAngle = 3*Math.PI/2;
        var endAngle = 5.2*Math.PI/2;
        context.lineWidth = 3;
        context.strokeStyle = 'rgba(3,20,48,1)';
        if(time < 1) {requestAnimationFrame(run);
          endAngle = startAngle +(endAngle - startAngle)* time;
        }

        // context.clearRect(0, 0, 600, 300);

        context.beginPath();
        context.arc(x, y, radius, startAngle, endAngle, counterClockwise);
        context.stroke();
        // context.transform(1, 1, 1, 1, 1, 1);
       
        };

      var duration = 1000;
      
//================================= CANVAS ENDS =========================================================================




      
});// the end of document ready function




