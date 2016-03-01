package com.github.zstd.opencms.thymeleaf;

import org.opencms.file.CmsFile;
import org.thymeleaf.TemplateProcessingParameters;
import org.thymeleaf.resourceresolver.IResourceResolver;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class VfsResourceResolver implements IResourceResolver {

    private VfsTemplateResolver vfsTemplateResolver;
    private CmsObjectAdapter cmsObject;

    public VfsResourceResolver(CmsObjectAdapter cmsObject, VfsTemplateResolver vfsTemplateResolver) {
        this.vfsTemplateResolver = vfsTemplateResolver;
        this.cmsObject = cmsObject;
    }

    public String getName() {
        return null;
    }

    public InputStream getResourceAsStream(TemplateProcessingParameters templateProcessingParameters,
                                           String resourceName) {
        String fullPath = getFullPath(resourceName);
        if (cmsObject.existsResource(fullPath)) {
            CmsFile file = cmsObject.readFile(fullPath);
            // TODO does it make sense?
            return new BufferedInputStream(new ByteArrayInputStream(file.getContents()));
        } else {
            throw new OpenCmsThymeleafException(String.format("Template resource [%s] does not exist", resourceName));
        }
    }

    private String getFullPath(String resourceName) {
        return resourceName;
    }
}
