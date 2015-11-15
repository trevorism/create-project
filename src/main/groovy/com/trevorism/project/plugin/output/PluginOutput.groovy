package com.trevorism.project.plugin.output
import com.trevorism.project.plugin.model.Plugin

/**
 * @author tbrooks
 */
class PluginOutput implements Output {

    List<Plugin> plugins = []

    @Override
    String getOutput() {
        def stringBuilder = new StringBuilder()

        plugins.each{
            stringBuilder << "$it\n"
        }
        return stringBuilder.toString()
    }
}
