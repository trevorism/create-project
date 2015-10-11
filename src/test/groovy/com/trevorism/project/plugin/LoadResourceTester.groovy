package com.trevorism.project.plugin

import org.junit.Test

/**
 * @author tbrooks
 */
class LoadResourceTester {

    @Test
    public void loadMainResource(){
        String mainText = LoadResourceTester.class.getClassLoader().getResourceAsStream("java/HelloJava.java").text
        assert mainText.length() > 0
    }

    @Test
    public void loadTestResource(){
        String mainText = LoadResourceTester.class.getClassLoader().getResourceAsStream("java/HelloJavaTest.java").text
        assert mainText.length() > 0
    }

    @Test
    public void loadMissingResource(){
        def missingResource = LoadResourceTester.class.getClassLoader().getResourceAsStream("java/Hello")
        assert missingResource == null
    }
}
