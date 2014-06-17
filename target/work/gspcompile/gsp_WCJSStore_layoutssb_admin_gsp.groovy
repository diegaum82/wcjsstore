import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_WCJSStore_layoutssb_admin_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/sb_admin.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'charset':("utf-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1.0")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("description"),'content':("")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("author"),'content':("")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(4)
expressionOut.print(request.contextPath)
printHtmlPart(5)
expressionOut.print(request.contextPath)
printHtmlPart(6)
expressionOut.print(request.contextPath)
printHtmlPart(7)
})
invokeTag('captureHead','sitemesh',17,[:],1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
invokeTag('message','g',132,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(10)
invokeTag('meta','g',136,['name':("app.version")],-1)
printHtmlPart(11)
invokeTag('meta','g',137,['name':("app.grails.version")],-1)
printHtmlPart(12)
expressionOut.print(GroovySystem.getVersion())
printHtmlPart(13)
expressionOut.print(System.getProperty('java.version'))
printHtmlPart(14)
expressionOut.print(grails.util.Environment.reloadingAgentEnabled)
printHtmlPart(15)
expressionOut.print(grailsApplication.controllerClasses.size())
printHtmlPart(16)
expressionOut.print(grailsApplication.domainClasses.size())
printHtmlPart(17)
expressionOut.print(grailsApplication.serviceClasses.size())
printHtmlPart(18)
expressionOut.print(grailsApplication.tagLibClasses.size())
printHtmlPart(19)
for( plugin in (applicationContext.getBean('pluginManager').allPlugins) ) {
printHtmlPart(20)
expressionOut.print(plugin.name)
printHtmlPart(21)
expressionOut.print(plugin.version)
printHtmlPart(22)
}
printHtmlPart(23)
for( c in (grailsApplication.controllerClasses.sort { it.fullName }) ) {
printHtmlPart(24)
createTagBody(3, {->
expressionOut.print(c.fullName)
})
invokeTag('link','g',164,['controller':(c.logicalPropertyName)],3)
printHtmlPart(25)
}
printHtmlPart(26)
expressionOut.print(request.contextPath)
printHtmlPart(27)
expressionOut.print(request.contextPath)
printHtmlPart(28)
})
invokeTag('captureBody','sitemesh',180,[:],1)
printHtmlPart(29)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1402323057000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
