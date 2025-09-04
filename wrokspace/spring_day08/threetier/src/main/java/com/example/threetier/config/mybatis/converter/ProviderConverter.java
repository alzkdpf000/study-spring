package com.example.threetier.config.mybatis.converter;

import com.example.threetier.common.enumeration.Provider;
import com.example.threetier.common.enumeration.Status;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProviderConverter implements Converter<String, Provider> {

    @Override
    public Provider convert(String source) {
        return Provider.getProviderFromValue(source);
    }
}
