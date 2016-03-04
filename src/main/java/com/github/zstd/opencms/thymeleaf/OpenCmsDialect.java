package com.github.zstd.opencms.thymeleaf;

import org.thymeleaf.dialect.AbstractDialect;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;


public class OpenCmsDialect extends AbstractDialect {

    public static final String DEFAULT_PREFIX = "opencms";

    // know execution attributes
    public static final String EXEC_ATTR_CMSO = "openCmsObject";

    private String prefix;
    private CmsObjectAdapter cmsObjectAdapter;

    public OpenCmsDialect(String prefix, CmsObjectAdapter cmsObjectAdapter) {
        Objects.requireNonNull(prefix);
        Objects.requireNonNull(cmsObjectAdapter);
        this.prefix = prefix;
        this.cmsObjectAdapter = cmsObjectAdapter;
    }

    public OpenCmsDialect(CmsObjectAdapter cmsObjectAdapter) {
        this(DEFAULT_PREFIX, cmsObjectAdapter);
    }

    @Override
    public String getPrefix() {
        return prefix;
    }

    @Override
    public Map<String, Object> getExecutionAttributes() {
        return Collections.<String,Object>singletonMap(EXEC_ATTR_CMSO,cmsObjectAdapter);
    }
}
