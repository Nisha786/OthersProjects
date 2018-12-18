$(document).ready(function() {
	$('#submit').click(function(e) {
		if($('#bannerimg').val() == ''){
			
			var allowedFiles = [".jpg", ".jpeg", ".png"];
            var fileUpload = $("#bannerimg");
            var lblError = $("#p3");
            var regex = new RegExp("([a-zA-Z0-9\s_\\.\-:])+(" + allowedFiles.join('|') + ")$");
            if (!regex.test(fileUpload.val().toLowerCase())) {
            	lblError.html("Please upload files having extensions: <b>" + allowedFiles.join(', ') + "</b> only.");
            	return false;
            }
            
            return false;
		}else if($('#bannerimg').val() != ''){
			
			var allowedFiles = [".jpg", ".jpeg", ".png"];
            var fileUpload = $("#bannerimg");
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
	