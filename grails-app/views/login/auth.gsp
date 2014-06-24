<head>
<meta name='layout' content='contentLayout' />
<title>Login</title>
</head>

<body>
			<form action='${postUrl}' method='POST' id='loginForm' >
	<div class="body">
		<div>
			<img style="float:right" src="${resource(dir:'images/vindure', file:'table_background_login.gif')}" 
			border="0" alt="Welcome, Please Sign In" title="Welcome, Please Sign In" 
			width="57" height="40">			
			<h1>Welcome, Please Sign In</h1>
		 </div>
		<div class="body-content-div">		
			<g:if test='${flash.message}'>
				<img src="${resource(dir:'images/icons', file:'error.gif')}" border="0" alt="Error" title="Error" width="10" height="10" />
				${flash.message}
			</g:if>
		        			
			<table class="body-content-tab" border="0"  width="100%">		
				<tr>
						<td  width="50%" valign="top"><b>New Customer</b></td>
						<td  width="50%" valign="top"><b>Returning Customer</b></td>
				</tr>
				<tr>
					<td width="50%" height="100%" valign="top" class="msg-box">
						<p>
						I am a new customer.<br/><br/>
						By creating an account at John Sculley Portal you will be able to shop and watch videos faster, be up to date on an order &apos;s status, and keep track of the orders you have previously made.
						</p>
						<p align="right">
							<g:link action="signup"><img src="${resource(dir:'images/en_GB/buttons/',file:'button_continue.gif')}" border="0" alt="Continue" title=" Continue " width="100" height="22"></g:link>					
						</p>
					</td>		           					
					 <td width="50%" height="100%" valign="top" class="msg-box">
						<p>I am a returning customer. If you have already shopped at our store but never registered, please click on the Password Forgotten link below and we'll send you a password.</p>									
						<table border="0" width="100%"  class="body-content-tab">
							<tr>
								<td><b>E-Mail Address:</b></td>
								<td><input type='text' class='text_' name='j_username' id='j_username' />
								</td>										                  		
							</tr>								
							<tr>
								<td><b>Password:</b></td>
								<td><input type='password' class='text_' name='j_password' id='j_password' /></td>
							</tr>
							
							<tr>
							<td colspan="2">
							<label for='remember_me'>Remember me</label>
							<input type='checkbox' class='chk' name='_spring_security_remember_me' id='remember_me' checked='checked' />							
							</tr>
						</table>
						<p><span class="smallText">
							Forgot Password? <g:link action="forgotPassword" controller="register" >Click Here</g:link>
						</span></p>								
						<p align="right">																					
							<input type="image" src="${resource(dir:'images/en_GB/buttons', file:'button_login.gif')}" 
								border="0" alt="Sign In" title="Sign In" >
						</p>							
					</td>
				</tr>
			</table>
		</div>
	</div>						
</form>







</body>
