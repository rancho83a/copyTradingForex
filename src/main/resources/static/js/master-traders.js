$(document).ready(function() {

	// fancyBox
	// $('.jsFancybox').fancybox();

	//Testimonials' slider
	$('.jsTestimonials').slick({
		dots:true,
		arrows:false,
		speed:1000,
		slidesToShow:1,	
		autoplay:true,			
	});

	$('.jsTestimonials_2').slick({
		dots:true,
		arrows:false,
		speed:1000,
		slidesToShow:1,	
		autoplay:true,			
	});

	//Master slider
	$('.jsMasterSlider').slick({
		dots:false,
		arrows:false,
		speed:2000,
		slidesToShow:1,	
		autoplay:true,
		fade: true,			
	});
      
});// the end of document ready function
