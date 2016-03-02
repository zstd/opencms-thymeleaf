<%@ page pageEncoding="UTF-8" %>
<%@ page import="com.github.zstd.opencms.thymeleaf.CmsObjectAdapter,
				 com.github.zstd.opencms.thymeleaf.CmsObjectAdapterImpl,
				 com.github.zstd.opencms.thymeleaf.OpenCmsContext,
				 com.github.zstd.opencms.thymeleaf.VfsTemplateResolver" %>
<%@ page import="org.opencms.file.CmsObject" %>
<%@ page import="org.opencms.jsp.CmsJspActionElement" %>
<%@ page import="org.thymeleaf.TemplateEngine" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%
    String templateName = "/system/modules/com.github.zstd.opencms.thymeleaf/thymeleaf/simple-template.html";
    CmsJspActionElement cms = new CmsJspActionElement(pageContext, request, response);
    CmsObject cmso = cms.getCmsObject();
    CmsObjectAdapter cmsoAdapter = new CmsObjectAdapterImpl(cmso);
    TemplateEngine templateEngine = new TemplateEngine();
    templateEngine.setTemplateResolver(new VfsTemplateResolver(cmsoAdapter));
    Map<String,Object> params = new HashMap<String, Object>();
    params.put("title","The Title");
    OpenCmsContext context = new OpenCmsContext(params);
    out.print(templateEngine.process(templateName,context));
%>

