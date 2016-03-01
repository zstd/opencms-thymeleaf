package com.github.zstd.opencms.thymeleaf;

import org.opencms.file.CmsFile;
import org.opencms.file.CmsObject;
import org.opencms.main.CmsException;

public class CmsObjectAdapterImpl implements CmsObjectAdapter{

    private CmsObject cmsObject;

    public boolean existsResource(String resourcename) {
        return cmsObject.existsResource(resourcename);
    }

    public CmsFile readFile(String resourcename) {
        try {
            return cmsObject.readFile(resourcename);
        } catch (CmsException e) {
            throw new OpenCmsWrapperException(e);
        }
    }
}
