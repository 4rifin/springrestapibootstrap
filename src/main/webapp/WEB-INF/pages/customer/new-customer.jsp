<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/pages/includes/taglibs.jsp" %>
<%@include file="/WEB-INF/pages/customer/mainHeader.jsp" %>
<body class="bg-img-num1"> 
    <div class="container">
    		<div class="scroll">
                <div class="row">
		            <div class="col-md-12">
		                <ol class="breadcrumb">
		                	<li><a href="<c:url value='/'/>">Home</a></li>     
		                    <li><a href="<c:url value='/'/>">List Customer</a></li>
		                    <li class="active" >New Customer</li>                                        
		                </ol>
		            </div>
		        </div>        
		        <div class="row">
		        </div>
		    </div>        
        <form id="register"  method="post" action="<c:url value='/newCustomer/save'/>">
	 	<c:if test="${message != null}">
		        <div id="messageInfo" class="alert alert-${messageType}">
	                    <strong>Atention!</strong> ${message}
	                    <button type="button" class="close" data-dismiss="alert" onclick="closeMessage();"></button>
	            </div>
	        </c:if>
	        <div class="registration-block">
	            <div class="block block-transparent">
			        <div class="login-block">
			            <div class="block block-transparent">
			                <div class="content controls npt">
			                    <div class="form-row">
			                        <div class="col-md-12">
			                            <div class="input-group">
			                                <div class="input-group-addon">
			                                    <span class="icon-user"></span>
			                                </div>
			                                <input type="text" class="form-control" maxlength="30" placeholder="First Name" name="firstName" required autocomplete="off"/>
			                            </div>
			                        </div>
			                    </div>
			                    <div class="form-row">
			                        <div class="col-md-12">
			                            <div class="input-group">
			                                <div class="input-group-addon">
			                                    <span class="icon-user"></span>
			                                </div>
			                                <input type="text" class="form-control" maxlength="30" placeholder="Last Name" name="lastName"  autocomplete="off"/>
			                            </div>
			                        </div>
			                    </div>
			                    </div>
			                    <div class="form-row">
						            <div class="col-md-12">
						            <input class="btn btn-default btn-block btn-clean" type="submit" value="Save" onclick="return confirm('Do you want save?');return false;">
			                            <!-- <a href="#" class="btn btn-default btn-block btn-clean" onclick="return confirm('Do you want save?');return false;">Simpan</a> -->
			                        </div>
                                </div>
			                
			            </div>
			        </div>
	        	</div>
	        </div>
        </form>
       <%-- <%@include file="/WEB-INF/pages/user/mainFooter.jsp" %> --%>
  </div>
 <script type="text/javascript" >
 function validationRegister(){
	var exec = document.getElementById('register');
			exec.submit();
			return true;
		
	}
 function checkPass(){
	 var password = document.getElementById('password').value
	 var confirmPassword = document.getElementById('confirmPassword').value
		
	 if (password == confirmPassword) {
		    document.getElementById('message').style.color = 'green';
		    document.getElementById('message').innerHTML = 'matching';
		  } else {
		    document.getElementById('message').style.color = 'red';
		    document.getElementById('message').innerHTML = 'not matching';
		  }
 }
 
 function validateEmail(email) {
	  var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	  return re.test(email);
	}

	function checkEmail() {
	  var email = document.getElementById('email').value
	  if (validateEmail(email)) {
		  document.getElementById('messageEmail').style.color = 'green';
		  document.getElementById('messageEmail').innerHTML = 'email is valid';
	  } else {
		  document.getElementById('messageEmail').style.color = 'red';
		  document.getElementById('messageEmail').innerHTML = 'email is not valid';
	  }
	}

 function closeMessage(){
	 document.getElementById('messageInfo').style.display = 'none';
 }
</script>