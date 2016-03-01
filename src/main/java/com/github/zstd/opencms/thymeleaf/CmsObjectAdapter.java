package com.github.zstd.opencms.thymeleaf;

import org.opencms.file.CmsFile;

public interface CmsObjectAdapter {
    boolean existsResource(String resourcename);
    CmsFile readFile(String resourcename);
}
