package edu.forty.bits.module;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class SomeProviderImpl implements SomeProvider {
    @Override
    public ResourceBundle getBundle(String baseName, Locale locale) {
        return new ResourceBundle() {
            @Override
            protected Object handleGetObject(String key) {
                return null;
            }

            @Override
            public Enumeration<String> getKeys() {
                return null;
            }
        };
    }
}