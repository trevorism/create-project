package com.trevorism.project.plugin.model

import groovy.transform.Immutable

/**
 * @author tbrooks
 */
@Immutable
class Plugin {

    enum IncludeType{
        FROM, PLUGIN
    }

    IncludeType includeType
    String pluginName

    @Override
    String toString() {
        return "apply ${includeType.toString().toLowerCase()}: '$pluginName'"
    }
}
