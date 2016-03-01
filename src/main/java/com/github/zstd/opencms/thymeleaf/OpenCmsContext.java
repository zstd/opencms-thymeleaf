package com.github.zstd.opencms.thymeleaf;

import org.thymeleaf.context.IContext;
import org.thymeleaf.context.VariablesMap;

import java.util.Locale;

public class OpenCmsContext implements IContext {
    public VariablesMap<String, Object> getVariables() {
        return new VariablesMap<String, Object>();
    }

    public Locale getLocale() {
        return null;
    }

    public void addContextExecutionInfo(String s) {

    }
}
