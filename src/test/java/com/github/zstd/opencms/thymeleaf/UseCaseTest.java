package com.github.zstd.opencms.thymeleaf;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.thymeleaf.TemplateEngine;

import java.util.Collections;
import java.util.Map;

public class UseCaseTest {

    private CmsObjectAdapter cmsObjectAdapter;

    @Before
    public void setUp() throws Exception {
        cmsObjectAdapter = Mockito.mock(CmsObjectAdapter.class);

    }

    @Test
    public void testSimple() throws Exception {
        generateFromTemplate(cmsObjectAdapter,"test", Collections.emptyMap(),"templates");

    }

    public static String generateFromTemplate(CmsObjectAdapter cmso,
                                              String templateName,
                                              Map params,
                                              String templateCatalogLocation){
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(new VfsTemplateResolver(cmso));
        OpenCmsContext context = new OpenCmsContext();
        return templateEngine.process(templateName,context);
    }
}
