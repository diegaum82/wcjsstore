<script type="text/javascript"> 
$(function() {
<g:if test="${noCustomerEmail}" >
   $('#emailAddress').attr('disabled', true);
</g:if>
<g:else>
$('#emailAddress').removeAttr('disabled');
</g:else>
    $("#cbNoEmail").click(function ( event ) {
   	   if ($("#cbNoEmail").is(':checked')) {
   	        $('#emailAddress').attr('disabled', true);
   	    } else {
   	        $('#emailAddress').removeAttr('disabled');
   	    }         
   	});    
});
</script>

<div >
<h3>Account Information</h3>

<g:if test="${flash.message}" >
<div class="errors">
    ${flash.message}
</div>
</g:if>

<g:hasErrors bean="${addressInstance}">
<div class="errors">
    <g:renderErrors bean="${addressInstance}" as="list" />
</div>
</g:hasErrors>
<g:form action="saveAddress" method="post" >
<table cellpadding="6" >
<tr>
<td class="value ${hasErrors(bean:customerInstance,field:'emailAddress','errors')}">
<label for="emailAddress">Email Address:</label><br />
<input type="text" id="emailAddress" name="emailAddress" class="afld" value="${fieldValue(bean:customerInstance,field:'emailAddress')}"/>
</td>
</tr>

<tr>
<td class="value ${hasErrors(bean:customerInstance,field:'password','errors')}" >
<label for="password">Password:</label><br />
<input type="password" id="password" name="password" class="afld" />
</td><td>
<label for="password2">Confirm Password:</label><br />
<input type="password" id="password2" name="password2" class="afld" />
</td>
</tr>
<tr>
<td>
<label for="country" >Country:</label><br />
<g:select optionKey="id" class="afld"  
 from="${[Country.findByIsoCode2('US'),Country.findByIsoCode2('CA')]}" name="country.id" value="${addressInstance?.country?.id}" 
 onchange="jQuery.ajax({type:'POST',data:'id=' + this.value, url:'/store/store/changeStates',success:function(data,textStatus){jQuery('#states').html(data);},error:function(XMLHttpRequest,textStatus,errorThrown){}});"
/>

</td>
</tr>
<tr>
<td class="value ${hasErrors(bean:addressInstance,field:'firstName','errors')}">
<label for="firstName" >First Name:</label><br />
<input type="text" id="firstName" name="firstName" class="afld" value="${fieldValue(bean:addressInstance,field:'firstName')}"/>
</td>
<td class="value ${hasErrors(bean:addressInstance,field:'lastName','errors')}" >
<label for="lastName">Last Name:</label><br />
<input type="text" id="lastName" name="lastName" class="afld" value="${fieldValue(bean:addressInstance,field:'lastName')}" />
</td>
</tr>
<tr>
<td class="value ${hasErrors(bean:addressInstance,field:'streetAddress','errors')}" >
<label for="streetAddress">Street Address 1:</label><br />
<input type="text" id="streetAddress" name="streetAddress" class="afld" value="${fieldValue(bean:addressInstance,field:'streetAddress')}"/>
</td>
<td>
<label for="streetAddress2">Street Address 2:</label><br />
<input type="text" id="streetAddress2" name="streetAddress2" class="afld" value="${fieldValue(bean:addressInstance,field:'streetAddress2')}"/>
</td>
</tr>
<tr>
<td class="value ${hasErrors(bean:addressInstance,field:'city','errors')}">
<label for="city">City:</label><br />
<input type="text" id="city" name="city" class="afld" value="${fieldValue(bean:addressInstance,field:'city')}"/>
</td>
</tr>
<tr>
<td class="value ${hasErrors(bean:addressInstance,field:'zone','errors')}" id="states">
<g:render template="../store/states" />
</td>
<td align="left"  class="value ${hasErrors(bean:addressInstance,field:'postalCode','errors')}" >
<label for="postalCode" >Postal Code:</label><br />
<input type="text" id="postalCode" name="postalCode" class="afld" value="${addressInstance?.postalCode}" />
</td>
</tr>
<tr>
<td class="value ${hasErrors(bean:customerInstance,field:'telephone','errors')}" >
<label for="telephone">Phone Number:</label><br />
<input type="text" id="telephone" name="telephone" class="afld" value="${fieldValue(bean:customerInstance,field:'telephone')}"/>
</td>
</tr>
<tr><td colspan="2" align="center">
 <input name="createOrder" class="place_order_btn" type="image" src="${resource(dir:'images/global/btns',file:'btn_signUp.gif')}" value="Place Order" />
</td></tr>

</table>
</g:form>
</div>