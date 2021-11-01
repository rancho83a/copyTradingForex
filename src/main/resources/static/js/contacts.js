$(document).ready(function() {

	// fancyBox
	// $('.jsFancybox').fancybox();

	$('.jsTestimonials').slick({
		dots:true,
		arrows:false,
		speed:3000,
		slidesToShow:1,	
		autoplay:true,			
	});

	//anti-jump
	$('.button').click(function(e) {
		e.preventDefault();
	});

	//Popup
	$('.write_us').submit(function(e) {
	    
	   // 	e.preventDefault();
	    	
	    	$('.jsPopupThanks').bPopup({
		    	// easing:'easeOutBack', //uses jQuery easing plugin
		    	autoClose: 3000, //Auto closes after 3000ms/3sec
		    	speed: 450,
		    	// transition: 'slideDown'
		    });
	    });
	      
});// the end of document ready function
