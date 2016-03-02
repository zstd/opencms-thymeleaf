package com.github.zstd.opencms.thymeleaf;

import org.thymeleaf.exceptions.ConfigurationException;
import org.thymeleaf.resourceresolver.IResourceResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

public class VfsTemplateResolver extends TemplateResolver {

    private CmsObjectAdapter cmsObject;

    public VfsTemplateResolver(CmsObjectAdapter cmsObject) {
        super();
        super.setResourceResolver(new VfsResourceResolver(cmsObject,this));
    }

    /**
     * <p>
     *   This method <b>should not be called</b>,
     *   because the resource resolver is fixed to be {@link VfsResourceResolver}.
     *   Every execution of this method will result in an exception.
     * </p>
     * <p>
     *   If you need to select a different resource resolver, use the {@link TemplateResolver}
     *   class instead.
     * </p>
     *
     * @param resourceResolver the new resource resolver
     */
    @Override
    public void setResourceResolver(final IResourceResolver resourceResolver) {
        throw new ConfigurationException(
                "Cannot set a resource resolver on " + this.getClass().getName() + ". If " +
                        "you want to set your own resource resolver, use " + TemplateResolver.class.getName() +
                        "instead");
    }
}
