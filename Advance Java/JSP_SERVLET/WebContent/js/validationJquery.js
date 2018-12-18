$(document).ready(function() {

		$('#submit').click(function(e) {
			var fname = $('#username').val();
			var pass = $('#pass').val();
			var name_regex = /^[a-zA-Z]+$/;
			//if (fname.length == 0 && pass.length == 0 ) {
			//	$('#head').text("* All fields are mandatory *"); // This Segment Displays The Validation Rule For All Fields
			//	$("#username").focus();
			//	return false;
			//} else 
			if (!fname.match(name_regex) || fname.length == 0) {
				$('#p1').text("* For your name please use alphabets only *"); // This Segment Displays The Validation Rule For Name
				$("#username").focus();
				return false;
			}else if(!pass.match(name_regex) || pass.length == 0) {
				$('#p2').text("* For password please use alphabets only *"); // This Segment Displays The Validation Rule For Name
				$("#pass").focus();
				return false;
			}else if($('#file').val() == ''){
				alert("Select Somthing");
				var allowedFiles = [".jpg", ".jpeg", ".png"];
	            var fileUpload = $("#file");
	            var lblError = $("#p3");
	            var regex = new RegExp("([a-zA-Z0-9\s_\\.\-:])+(" + allowedFiles.join('|') + ")$");
	            if (!regex.test(fileUpload.val().toLowerCase())) {
	            	lblError.html("Please upload files having extensions: <b>" + allowedFiles.join(', ') + "</b> only.");
	            	return false;
	            }
	            
	            return false;
			}else if($('#file').val() != ''){
				alert("Select only images");
				var allowedFiles = [".jpg", ".jpeg", ".png"];
	            var fileUpload = $("#file");
	            var lblError = $("#p3");
	            var regex = new RegExp("([a-zA-Z0-9\s_\\.\-:])+(" + allowedFiles.join('|') + ")$");
	            if (regex.test(fileUpload.val().toLowerCase())) {
	            	lblError.html("Please upload files having extensions: <b>" + allowedFiles.join(', ') + "</b> only.");
	            	return true;
	            }
	            
	            return false;
			}
			else {
				return true;
			}
		});
	});