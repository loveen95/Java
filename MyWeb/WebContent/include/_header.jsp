<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-idth, initial-scale=1">
   

    <title>Welcome to MyWorld</title>

    <!-- Bootstrap Core CSS -->
    <link href="/MyWeb/css/bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/MyWeb/css/business-casual.css" rel="stylesheet">

    <!-- Fonts -->  <!-- 구글이 제공하는 폰트 -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
	
	 <!-- jQuery --> <!-- 외부에 있는 js파일을 가져옴 -->
    <script src="/MyWeb/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/MyWeb/js/bootstrap.min.js"></script>

    <!-- Script to Activate the Carousel -->
    <script>
    $('.carousel').carousel({
        interval: 2000 //changes the speed
    })
    </script>

    
    
</head>



</head>
<body>
<!-- header -->
	
		
    
    <nav class="navbar navbar-default" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                
                <a class="navbar-brand" href="/hong">My First Web</a>
            </div>
     
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                	
                    <li>
                        <a href="/MyWeb/index.do">HOME</a>
                    </li>
                    <li>
                        <a href="/MyWeb/member.do">Member</a>
                    </li>
                    <li>
                        <a href="/MyWeb/board/list.board">BOARD</a>
                    </li>
                  
                       
                        <!-- 세션이 존재하는 경우 logout과 mypage가 출력						                        
                        	 -->
                    <c:choose>
									<c:when test="${sessionScope.user_id == null }"> 
									<li> 
                        				<a href ="/MyWeb/user/user_login.jsp">LOGIN</a>
                        			</li>
                        		
									<li> 
                        				<a href ="/MyWeb/user/join.jsp" style="color:red">JOIN</a>
                        			</li>
                        			</c:when>
                        			<c:when test="${sessionScope.user_id != null }"> 
									<li> 
                        				<a href ="/MyWeb/user/user_logout.jsp" >LOGOUT</a>
                        			</li>
                        			</c:when>
                        			<c:otherwise>
                        				<li> 
                        				<a href ="/MyWeb/user/user_mypage.jsp" style="color:red">MyPage</a>
                        				</li>
                        			</c:otherwise>
                        				                        	 
                        	  </c:choose>
                        
                </ul>
            </div>
            
            
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
 	<!-- end header -->
 
 

</body>
</html>

