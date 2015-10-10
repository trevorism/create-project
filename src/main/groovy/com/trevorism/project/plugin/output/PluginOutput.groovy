package com.trevorism.project.plugin.output

import com.trevorism.project.plugin.model.ProgrammingLanguage


/**
 * @author tbrooks
 */
class PluginOutput implements Output {
    ProgrammingLanguage pluginName

    @Override
    String getOutput() {
        "apply plugin: '${pluginName?.name()?.toLowerCase() ?: ""}'\n"
    }
}
