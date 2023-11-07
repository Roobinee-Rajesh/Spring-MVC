<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous" defer></script>
<style>
.error {
    color: red;
}
</style>
</head>
<body>

<form action="home" method="POST" modelAttribute="user">
<div class="container w-75 pt-4">
<h2 class="text-center d-flex justify-content-center">Login</h2>
  <div class="mb-6">
    <label for="email" class="form-label">Email address</label>
    <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp">
  </div>
  <div class="mb-3">
    <label for="password" class="form-label">Password</label>
    <input type="password" class="form-control" id="password" name="password">
  </div>
  <%
  if(request.getAttribute("error")!=null){
  out.print("<p class='error'>Invalid!</p>");
  }
  %>

  <button type="submit" class="btn btn-primary">Submit</button>
  <div>
</form>
<br/>
<p>Dont have an account?<a href="register/registerForm">Register</a></p>

</body>
</html>
