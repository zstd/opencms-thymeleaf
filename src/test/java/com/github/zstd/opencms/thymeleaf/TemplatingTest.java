package com.github.zstd.opencms.thymeleaf;

import com.google.gwt.thirdparty.guava.common.collect.ImmutableMap;
import com.google.gwt.thirdparty.guava.common.io.ByteStreams;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.opencms.file.CmsFile;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.dialect.IDialect;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

public class TemplatingTest {

    private CmsObjectAdapter cmsObjectAdapter;

    @Before
    public void setUp() throws Exception {
        cmsObjectAdapter = Mockito.mock(CmsObjectAdapter.class);
    }

    @Test
    public void testSimple() throws Exception {
        String templateName = "item";
        givenTemplateExists(templateName, getResourceAsBytes("/templates/item.html"));

        Map<String,Object> params = ImmutableMap.<String,Object>of("title","The Title");
        String result = whenGenerateFromTemplate(cmsObjectAdapter, templateName, params);
        System.out.println(result);
        //assertEquals("<div>The Title</div>",result);
    }

    private byte[] getResourceAsBytes(String name) throws IOException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        try(InputStream is = this.getClass().getResourceAsStream(name)) {
            ByteStreams.copy(is,result);
        }
        byte[] array = result.toByteArray();
        System.out.println(new String(array));
        return result.toByteArray();
    }

    private void givenTemplateExists(String templateName, byte[] templateContent) {
        Mockito.when(cmsObjectAdapter.existsResource(templateName)).thenReturn(true);
        Mockito.when(cmsObjectAdapter.readFile(templateName)).thenReturn(new StubCmsFile(templateContent));
    }

    public static String whenGenerateFromTemplate(CmsObjectAdapter cmso,
                                                  String templateName,
                                                  Map<String,Object> params){
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(new VfsTemplateResolver(cmso));
        OpenCmsContext context = new OpenCmsContext(params);
        IDialect dialect = new OpenCmsDialect(cmso);
        templateEngine.setAdditionalDialects(Collections.singleton(dialect));
        return templateEngine.process(templateName, context);
    }

    private static class StubCmsFile extends CmsFile {

        private byte[] content;

        public StubCmsFile(byte[] content) {
            super(null,
            null,
            null,
            0,
            0,
            null,
            null,
            0L,
            null,
            0,
            null,
            0L,
            0L,
            0,
            0,
            0L,
            0,
            content);
            this.content = content;
        }

        @Override
        public byte[] getContents() {
            return content;
        }
    }
}
