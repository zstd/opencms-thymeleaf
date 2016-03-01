<%@ page pageEncoding="UTF-8" %>
<%-- include necessary imports --%>
<%@ page import="com.github.zstd.opencms.thymeleaf.*,
				 org.opencms.file.CmsObject,
				 org.opencms.jsp.CmsJspActionElement,
				 org.thymeleaf.TemplateEngine" %>
<%
    String templateName = "simple-template";
    CmsJspActionElement cms = new CmsJspActionElement(pageContext, request, response);
    CmsObject cmso = cms.getCmsObject();
    TemplateEngine templateEngine = new TemplateEngine();
    templateEngine.setTemplateResolver(new VfsTemplateResolver(cmso));
    OpenCmsContext context = new OpenCmsContext();
    out.print(templateEngine.process(templateName,context));
%>

