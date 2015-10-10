package com.trevorism.project.plugin.output

import com.trevorism.project.plugin.model.Dependency
import org.junit.Test

/**
 * @author tbrooks
 */
class DependencyOutputTest {

    @Test
    public void "blank output"(){
        def outputter = new DependencyOutput()
        assert "dependencies {\n}\n" == outputter.output
    }

    @Test
    public void "output with dependencies"(){
        def outputter = new DependencyOutput()
        outputter.dependencies << new Dependency("compile", "com.trevorism:plugin:1.0")
        outputter.dependencies << new Dependency("blah", ":blah:")

        assert "dependencies {\n\tcompile 'com.trevorism:plugin:1.0'\n\tblah ':blah:'\n}\n" == outputter.output
    }
}
