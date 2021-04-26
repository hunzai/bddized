package com.bddized.framework;

import java.io.IOException;

public interface InterfaceResponseCode {
    int getResponseCode(String url) throws IOException;
}
