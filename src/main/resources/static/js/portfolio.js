$(document).ready(function() {

	$(window).resize(resize);
    resize();

	//anti-jump
	$('.button').click(function(e) {
		e.preventDefault();
	});

	//Popup
	$('.jsSeeDynamic').click(function() {
		$('.jsPopupDyn').bPopup({
			speed: 450,
		});
	});

	$('.jsSeeBalanced').click(function() {
		$('.jsPopupBal').bPopup({
			speed: 450,
		});
	});

	// FOR portfolios statement pages
	$('.jsPopupDynstat').bPopup({speed: 450,});
	$('.jsPopupBalstat').bPopup({speed: 450,});

	// not allowed in mobile version
	$('.jsNoMobile').click(function() {
		$('.jsPopupNomob').bPopup({
			speed: 450,
			autoClose: 5000,
		});
	});	
});

function resize() {
    if ($(window).width() < 992) {
    	$("a.jsDyn").removeClass('jsSeeDynamic').addClass('jsNoMobile');
    	$("a.jsBal").removeClass('jsSeeBalanced').addClass('jsNoMobile');
    }
    else{
    	$("a.jsDyn").removeClass('jsNoMobile').addClass('jsSeeDynamic');
    	$("a.jsBal").removeClass('jsNoMobile').addClass('jsSeeBalanced');
    }
}
