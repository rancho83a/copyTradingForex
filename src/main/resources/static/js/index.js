$(document).ready(function() {

	//Billboard index_slider
	$('.jsIndexSlider').slick({
		slidesToShow:3,
		arrows:false,
		centerMode: true,
		autoplay: true,
		autoplaySpeed: 0,
		speed: 5000,
		infinite:true,
		variableWidth: true,		
	});

	//Billboard slider
	$('.jsBillboardSlider').slick({
		arrows:false,
		fade:true,
		autoplay: true,
		autoplaySpeed: 2500,
		speed:3000,
		pauseOnHover:false,
		pauseOnFocus:false,		
	});

	//Awards slider
	$('.jsAwards').slick({
		arrows:false,
		fade:true,
		autoplay: true,
		autoplaySpeed: 2500,
		speed:2000,
		pauseOnHover:false,
		pauseOnFocus:false,
	});

	//Testimonials' slider
	$('.jsTestimonials').slick({
		dots:true,
		arrows:false,
		speed:1000,
		slidesToShow:1,		
	});

	// Parallax effect for main heading
	var scene = document.getElementById('scene');
	var parallaxInstance = new Parallax(scene,{
		relativeInput: true,
		// hoverOnly:true
		pointerEvents:true,
	});

	// counter section
	jQuery(document).ready(function($) {
            $('.counter').counterUp({
                delay: 10,
                time: 2000
            });
        });
	

})
