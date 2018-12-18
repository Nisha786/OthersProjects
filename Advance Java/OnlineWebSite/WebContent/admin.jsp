
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
  <meta name="author" content="GeeksLabs">
  <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
  <link rel="shortcut icon" href="imgadmin/favicon.png">

  <title>Login Page</title>

  <!-- Bootstrap CSS -->
  <link href="cssadmin/bootstrap.min.css" rel="stylesheet">
  <!-- bootstrap theme -->
  <link href="cssadmin/bootstrap-theme.css" rel="stylesheet">
  <!--external css-->
  <!-- font icon -->
  <link href="cssadmin/elegant-icons-style.css" rel="stylesheet" />
  <link href="cssadmin/font-awesome.css" rel="stylesheet" />
  <!-- Custom styles -->
  <link href="cssadmin/style.css" rel="stylesheet">
  <link href="cssadmin/style-responsive.css" rel="stylesheet" />

</head>

<body class="login-img3-body">

  <div class="container">

    <form class="login-form" method="post" action="DashboardCtl">
      <div class="login-wrap">
        <p class="login-img"><i class="icon_lock_alt"></i></p>
        <div class="input-group">
          <span class="input-group-addon"><i class="icon_profile"></i></span>
          <input type="email" class="form-control" name="email" placeholder="email">
        </div>
        <div class="input-group">
          <span class="input-group-addon"><i class="icon_key_alt"></i></span>
          <input type="password" class="form-control" name="password" placeholder="Password">
        </div>
<input class="btn btn-primary btn-lg btn-block" type="submit" name="submit" value="Login"> 
      </div>
      <span > <p>${message}</p>
      <c:remove var="message" scope="session" /> </span>
    </form>

  </div>


</body>

</html>
