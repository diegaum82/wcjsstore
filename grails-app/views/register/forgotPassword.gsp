<%@ page contentType="text/html;charset=UTF-8" %>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <meta name="layout" content="contentLayout" />
   <title>John Sculley Portal Forgot Password</title>
  </head>
  <body>
    
    
      <g:form action="resetPassword" method="post" >
	<div class="body">
		<div class="body-header">
			<img style="float:right" src="${resource(dir:'images/vindure', file:'table_background_password_forgotten.gif')}" 
			border="0" alt="I've Forgotten My Password!" title="I've Forgotten My Password!" width="57" height="40">
			I've Forgotten My Password!
		 </div>
		<div class="body-content-div">		
		  <g:if test="${flash.message}">
			<div class="errors">
			<img src="${resource(dir:'images/icons', file:'error.gif')}" border="0" alt="Error" title="Error" width="10" height="10" />
			${flash.message}
			</div>
			</g:if>			
			<br/>
			<div class="msg-box">	
				<p>If you've forgotten your password, enter your e-mail address below and we'll send you an e-mail message containing your new password.</p>
				<b>E-Mail Address:</b> 
				
				<input type="text" id="emailAddress" name="emailAddress" value="${params.emailAddress}"/>

			</div>
		</div>
	</div>						
	<div class="tile">
			<div class="left"><div class="right"><div class="bottom"><div class="bottom-left"><div class="bottom-right"><div class="top"><div class="top-left"><div class="top-right">
				<div class="button-tile">
					<input src="${resource(dir:'images/en_GB/buttons',file:'button_continue.gif')}" 
						border="0" alt="Continue" style="float:right" type="image" title="Continue" />
					<g:link controller="login" >
						<img src="${resource(dir:'images/en_GB/buttons',file:'button_back.gif')}" border="0" alt="Back" title="Back" width="100" height="22">
					</g:link>
				</div>
			</div></div></div></div></div></div></div></div>
	</div> 	
</g:form> 
   
  </body>
</html>
