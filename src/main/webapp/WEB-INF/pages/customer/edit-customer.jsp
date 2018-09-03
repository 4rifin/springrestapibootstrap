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
		                    <li class="active" >Edit Customer</li>                                        
		                </ol>
		            </div>
		        </div>        
		        <div class="row">
		        </div>
		    </div>        
        <form id="register"  method="post" action="<c:url value='/editCustomer/edit/${customer.id}'/>">
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
			                                <input type="hidden" class="form-control" placeholder="First Name" name="id" value="${customer.id}" />
			                                <input type="text" maxlength="30" class="form-control" placeholder="First Name" maxlength="30" name="firstName" value="${customer.firstName}" required autocomplete="off"/>
			                            </div>
			                        </div>
			                    </div>
			                    <div class="form-row">
			                        <div class="col-md-12">
			                            <div class="input-group">
			                                <div class="input-group-addon">
			                                    <span class="icon-user"></span>
			                                </div>
			                                <input type="text" maxlength="30" class="form-control" placeholder="Last Name" maxlength="30" name="lastName" value="${customer.lastName}" autocomplete="off"/>
			                            </div>
			                            <span id='messageEmail'></span>
			                        </div>
			                    </div>
			                    </div>
			                    <div class="form-row">
						            <div class="col-md-12">
						            <input class="btn btn-default btn-block btn-clean" type="submit" value="Edit" onclick="return confirm('Do you want edit?');return false;">
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

 function closeMessage(){
	 document.getElementById('messageInfo').style.display = 'none';
 }
</script>