package com.trevorism.project.plugin.output

import com.trevorism.project.plugin.model.ProgrammingLanguage
import org.junit.Test

/**
 * @author tbrooks
 */
class PluginOutputTest {

    @Test
    public void "blank output"(){
        def pluginOutput = new PluginOutput()
        assert "apply plugin: ''\n" == pluginOutput.output
    }

    @Test
    public void "output with a name"(){
        def pluginOutput = new PluginOutput()
        pluginOutput.pluginName = ProgrammingLanguage.JAVA

        assert "apply plugin: 'java'\n" == pluginOutput.output
    }
}
