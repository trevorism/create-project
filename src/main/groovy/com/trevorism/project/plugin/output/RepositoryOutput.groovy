package com.trevorism.project.plugin.output

/**
 * @author tbrooks
 */
class RepositoryOutput implements Output {

    @Override
    String getOutput() {
        def stringBuilder = new StringBuilder()

        stringBuilder << "repositories {\n"
        stringBuilder << "\tmavenCentral()\n"
        stringBuilder << "}\n"

        return stringBuilder.toString()
    }
}
