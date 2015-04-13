/*price range*/

 $('#sl2').slider();

	var RGBChange = function() {
	  $('#RGB').css('background', 'rgb('+r.getValue()+','+g.getValue()+','+b.getValue()+')')
	};	
		
/*scroll to top*/

$(document).ready(function(){
	$(function () {
		$.scrollUp({
	        scrollName: 'scrollUp', // Element ID
	        scrollDistance: 300, // Distance from top/bottom before showing element (px)
	        scrollFrom: 'top', // 'top' or 'bottom'
	        scrollSpeed: 300, // Speed back to top (ms)
	        easingType: 'linear', // Scroll to top easing (see http://easings.net/)
	        animation: 'fade', // Fade, slide, none
	        animationSpeed: 200, // Animation in speed (ms)
	        scrollTrigger: false, // Set a custom triggering element. Can be an HTML string or jQuery object
					//scrollTarget: false, // Set a custom target element for scrolling to the top
	        scrollText: '<i class="fa fa-angle-up"></i>', // Text for element, can contain HTML
	        scrollTitle: false, // Set a custom <a> title if required.
	        scrollImg: false, // Set true to use image
	        activeOverlay: false, // Set CSS color to display scrollUp active point, e.g '#00FFFF'
	        zIndex: 2147483647 // Z-Index for the overlay
		});
	});
	//Validate sessión
	if(localStorage['token']){
		$("#menu-session").append('<li><a href="account.html"><i class="fa fa-user"></i>'+localStorage['name']+'</a></li>');
		$("#menu-session").append('<li><a href="cart.html"><i class="fa fa-shopping-cart"></i> Carrito</a></li>');
		var a = $('<a href="">').append('<i class="fa fa-lock"></i> Cerrar Sesión</a></li>');
		a.click(function (event){logout()});		
		$("#menu-session").append($('<li>').append(a));    
	}else{
		$("#menu-session").append('<li><a href="login.html"><i class="fa fa-lock"></i> Iniciar Sesión</a></li>');
	}
	$('.add-to-cart').click(function(){checkLogin()});
    $('.cart').click(function(){checkLogin()});
});

function checkLogin(){
	if(localStorage['token']){
		
	}else{
		showLogin();
	}
}

function logout(){
	//$.post("", {token:localStorage['token']}, function(data){}, 'json');
	localStorage['token']='';
	localStorage['name']='';
	window.location.href = 'index.html';
}

function showLogin(){
	 $( "#dialog" ).dialog({ modal: true, minWidth:400 });	
}

