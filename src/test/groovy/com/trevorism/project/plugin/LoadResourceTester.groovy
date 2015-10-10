package com.trevorism.project.plugin

import org.junit.Test

/**
 * @author tbrooks
 */
class LoadResourceTester {

    @Test
    public void loadResource(){
        String mainText = LoadResourceTester.class.getClassLoader().getResourceAsStream("java/Hello.java").text
        println mainText
    }
}
