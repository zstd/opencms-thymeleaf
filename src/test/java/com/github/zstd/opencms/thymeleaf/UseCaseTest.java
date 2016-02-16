package com.github.zstd.opencms.thymeleaf;

import org.opencms.file.CmsObject;
import org.thymeleaf.TemplateEngine;

import java.util.Map;

public class UseCaseTest {

    public static String generateFromTemplate(CmsObject cmso,
                                              String templateName,
                                              Map params,
                                              String templateCatalogLocation){
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(new VfsTemplateResolver());
        OpenCmsContext context = new OpenCmsContext();
        return templateEngine.process(templateName,context);
    }
}
