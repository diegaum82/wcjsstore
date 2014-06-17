import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_WCJSStoreindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',4,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',4,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("content-type"),'content':("text/html; charset=utf-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("description"),'content':("")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("keywords"),'content':("")],-1)
printHtmlPart(3)
expressionOut.print(request.contextPath)
printHtmlPart(4)
expressionOut.print(request.contextPath)
printHtmlPart(5)
expressionOut.print(request.contextPath)
printHtmlPart(6)
expressionOut.print(request.contextPath)
printHtmlPart(7)
expressionOut.print(request.contextPath)
printHtmlPart(8)
expressionOut.print(request.contextPath)
printHtmlPart(9)
expressionOut.print(request.contextPath)
printHtmlPart(10)
expressionOut.print(request.contextPath)
printHtmlPart(11)
expressionOut.print(request.contextPath)
printHtmlPart(12)
expressionOut.print(request.contextPath)
printHtmlPart(13)
expressionOut.print(request.contextPath)
printHtmlPart(14)
})
invokeTag('captureHead','sitemesh',24,[:],1)
printHtmlPart(15)
createTagBody(1, {->
printHtmlPart(16)
invokeTag('meta','g',124,['name':("app.version")],-1)
printHtmlPart(17)
invokeTag('meta','g',125,['name':("app.grails.version")],-1)
printHtmlPart(18)
expressionOut.print(GroovySystem.getVersion())
printHtmlPart(19)
expressionOut.print(System.getProperty('java.version'))
printHtmlPart(20)
expressionOut.print(grails.util.Environment.reloadingAgentEnabled)
printHtmlPart(21)
expressionOut.print(grailsApplication.controllerClasses.size())
printHtmlPart(22)
expressionOut.print(grailsApplication.domainClasses.size())
printHtmlPart(23)
expressionOut.print(grailsApplication.serviceClasses.size())
printHtmlPart(24)
expressionOut.print(grailsApplication.tagLibClasses.size())
printHtmlPart(25)
for( c in (grailsApplication.controllerClasses.sort { it.fullName }) ) {
printHtmlPart(26)
createTagBody(3, {->
expressionOut.print(c.fullName)
})
invokeTag('link','g',140,['controller':(c.logicalPropertyName)],3)
printHtmlPart(27)
}
printHtmlPart(28)
expressionOut.print(request.contextPath)
printHtmlPart(29)
expressionOut.print(request.contextPath)
printHtmlPart(30)
expressionOut.print(request.contextPath)
printHtmlPart(31)
expressionOut.print(request.contextPath)
printHtmlPart(32)
expressionOut.print(request.contextPath)
printHtmlPart(33)
expressionOut.print(request.contextPath)
printHtmlPart(29)
expressionOut.print(request.contextPath)
printHtmlPart(30)
expressionOut.print(request.contextPath)
printHtmlPart(31)
expressionOut.print(request.contextPath)
printHtmlPart(32)
expressionOut.print(request.contextPath)
printHtmlPart(34)
expressionOut.print(request.contextPath)
printHtmlPart(35)
expressionOut.print(request.contextPath)
printHtmlPart(36)
expressionOut.print(request.contextPath)
printHtmlPart(37)
expressionOut.print(request.contextPath)
printHtmlPart(38)
expressionOut.print(request.contextPath)
printHtmlPart(39)
expressionOut.print(request.contextPath)
printHtmlPart(40)
expressionOut.print(request.contextPath)
printHtmlPart(41)
expressionOut.print(request.contextPath)
printHtmlPart(42)
expressionOut.print(request.contextPath)
printHtmlPart(43)
expressionOut.print(request.contextPath)
printHtmlPart(44)
})
invokeTag('captureBody','sitemesh',454,['class':("homepage")],1)
printHtmlPart(45)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1402596228000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
