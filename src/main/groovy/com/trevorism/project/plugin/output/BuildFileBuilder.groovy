package com.trevorism.project.plugin.output

import com.trevorism.project.plugin.model.Dependency
import com.trevorism.project.plugin.model.ProgrammingLanguage

/**
 * @author tbrooks
 */
class BuildFileBuilder {

    private def pluginOutput = new PluginOutput()
    private def repositoryOutput = new RepositoryOutput()
    private def dependencyOutput = new DependencyOutput()

    BuildFileBuilder plugin(ProgrammingLanguage language){
        pluginOutput.pluginName = language
        return this
    }

    BuildFileBuilder dependency(Dependency dependency){
        dependencyOutput.dependencies << dependency
        return this
    }

    public String build(){

        def stringBuilder = new StringBuilder()
        stringBuilder << "\n"
        stringBuilder << pluginOutput.output
        stringBuilder << "\n"
        stringBuilder << repositoryOutput.output
        stringBuilder << "\n"
        stringBuilder << dependencyOutput.output
        stringBuilder << "\n"
        return stringBuilder.toString()
    }
}