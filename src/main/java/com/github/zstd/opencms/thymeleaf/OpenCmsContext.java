package com.github.zstd.opencms.thymeleaf;

import org.thymeleaf.context.IContext;
import org.thymeleaf.context.VariablesMap;

import java.util.Locale;
import java.util.Map;

public class OpenCmsContext implements IContext {

    private VariablesMap<String, Object> map;

    public OpenCmsContext(Map<String,Object> params) {
        map = new VariablesMap<>();
        map.putAll(params);
    }

    public VariablesMap<String, Object> getVariables() {
        return map;
    }

    public Locale getLocale() {
        // TODO proper locale handling
        return new Locale("EN");
    }

    public void addContextExecutionInfo(String s) {

    }
}
