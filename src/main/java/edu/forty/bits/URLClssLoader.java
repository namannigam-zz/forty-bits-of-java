package com.stackoverflow.nullpointer;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class URLClssLoader {

    public static void main(String[] args) throws ClassNotFoundException, MalformedURLException {
        URLClassLoader urlLoader = (URLClassLoader) ClassLoader.getPlatformClassLoader();
        for (URL u : urlLoader.getURLs()) {
            System.out.println("*************** url=" + u);
        }
        // Constructing a URL form the path to JAR
        URL u = new URL("file:/C:/Users/SomeUser/Projects/MyTool/plugins/myNodes/myOwn-nodes-1.6.jar");

        // Creating an instance of URLClassloader using the above URL and parent classloader
        ClassLoader loader = URLClassLoader.newInstance(new URL[]{u}, URLClssLoader.class.getClassLoader());

        // Returns the class object
        Class<?> yourMainClass = Class.forName("URLClssLoader", true, loader);

    }
}