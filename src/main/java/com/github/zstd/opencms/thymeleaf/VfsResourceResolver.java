package com.github.zstd.opencms.thymeleaf;

import org.opencms.file.CmsFile;
import org.opencms.file.CmsObject;
import org.opencms.main.CmsException;
import org.thymeleaf.TemplateProcessingParameters;
import org.thymeleaf.resourceresolver.IResourceResolver;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class VfsResourceResolver implements IResourceResolver {

    private VfsTemplateResolver vfsTemplateResolver;
    private CmsObject cmsObject;

    public VfsResourceResolver(CmsObject cmsObject, VfsTemplateResolver vfsTemplateResolver) {
        this.vfsTemplateResolver = vfsTemplateResolver;
        this.cmsObject = cmsObject;
    }

    public String getName() {
        return null;
    }

    public InputStream getResourceAsStream(TemplateProcessingParameters templateProcessingParameters,
                                           String resourceName) {
        String fullPath = getFullPath(resourceName);
        if(cmsObject.existsResource(fullPath)) {
            try {
                CmsFile file = cmsObject.readFile(fullPath);
                // TODO does it make sense?
                return new BufferedInputStream(new ByteArrayInputStream(file.getContents()));
            } catch (CmsException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private String getFullPath(String resourceName) {
        return resourceName;
    }
}
