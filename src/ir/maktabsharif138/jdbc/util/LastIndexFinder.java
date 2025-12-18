package ir.maktabsharif138.jdbc.util;

import java.io.UnsupportedEncodingException;

@FunctionalInterface
public interface LastIndexFinder {

    int find(String f, String e) throws UnsupportedEncodingException;
}
