package com.trevorism.project.plugin.output

import com.trevorism.project.plugin.model.Dependency

/**
 * @author tbrooks
 */

class DependencyOutput implements Output{

    List<Dependency> dependencies = []

    @Override
    String getOutput() {
        def stringBuilder = new StringBuilder()

        stringBuilder << "dependencies {\n"
        dependencies.each{
            stringBuilder << "\t$it\n"
        }
        stringBuilder << "}\n"

        return stringBuilder.toString()
    }
}
