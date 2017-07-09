package com.trevorism.project.plugin.output

import com.trevorism.project.plugin.model.Plugin
import org.junit.Test

/**
 * @author tbrooks
 */
class PluginOutputTest {

    @Test
    void "blank output"(){
        def pluginOutput = new PluginOutput()
        assert "" == pluginOutput.output
    }

    @Test
    void "output with a name"(){
        def pluginOutput = new PluginOutput()
        pluginOutput.plugins << new Plugin(Plugin.IncludeType.PLUGIN, "java")

        assert "apply plugin: 'java'\n" == pluginOutput.output
    }
}
