$(document).ready(function(){
	if(localStorage['token'])window.location.href = 'index.html';
});

$(function () {
	$('#button-login').click(function() { 
		var form = document.getElementById("form-login");
		if(form["name"].value&&form["pass"].value){
		    $('.login-danger').hide();
			var name = new RegExp('[A-Za-z0-9]+');
			if (name.test(form["name"].value)) {
				loginUserTest(form);
			}else{
				showLoginError('Los valores ingresados no son validos.');
			}
		}else{
			showLoginError('Los campos no puedes estar vacios');			
		}
	});
	$('#button-register').click(function() { 
		var form = document.getElementById("form-register");
		if(form["name"].value&&form["email"].value&&form["pass"].value){
		    $('.register-danger').hide(); 
            var email = new RegExp('^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,6}$');
			var name = new RegExp('[A-Za-z0-9]+');
			if (email.test(form["email"].value)&&name.test(form["name"].value)) {
				registerUserTest(form);
			}else{
				showRegisterError('Los valores ingresados no son validos.');
			}
		}else{
			showRegisterError('Los campos no puedes estar vacios');
		}
	});
});

function showLoginError(text){
	$('.login-danger').text(text);
	$('.login-danger').show();
}

function showRegisterError(text){
	$('.register-danger').text(text);
    $('.register-danger').show();
}

function loginUser(form){
	$.post(form.action, $('#form-edit').serialize(), function(data){
		if(data.success){
			localStorage['token']=data.token;
			localStorage['name']=data.name;
			window.location.href = 'index.html';
		}else{
			showRegisterError('Cuenta invalida');
		}
	}, 'json');
}
function loginUserTest(form){
	localStorage['token']='434252EFWDFS';
	localStorage['name']='Cesar';
	window.location.href = 'index.html';
}

function registerUser(form){
	$.post(form.action, $('#form-edit').serialize(), function(data){
		if(data.success){
			localStorage['token']=data.token;
			localStorage['name']=data.name;
			window.location.href = 'index.html';
		}else{
			showLoginError('Cuenta invalida');
		}
	}, 'json');
}
function registerUserTest(form){
	localStorage['token']='434252EFWDFS';
	localStorage['name']='Cesar';
	window.location.href = 'index.html';
}