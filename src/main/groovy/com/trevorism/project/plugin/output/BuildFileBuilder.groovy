package com.trevorism.project.plugin.output

import com.trevorism.project.plugin.model.Dependency
import com.trevorism.project.plugin.model.Plugin

/**
 * @author tbrooks
 */
class BuildFileBuilder {

    private def pluginOutput = new PluginOutput()
    private def repositoryOutput = new RepositoryOutput()
    private def dependencyOutput = new DependencyOutput()
    private def buildscriptPluginOutput = new BuildscriptPluginOutput()
    private boolean useBuildscriptPluginOutput = false

    BuildFileBuilder buildscriptPlugin(){
        useBuildscriptPluginOutput = true
        return this
    }

    BuildFileBuilder plugin(Plugin plugin){
        pluginOutput.plugins << plugin
        return this
    }

    BuildFileBuilder dependency(Dependency dependency){
        dependencyOutput.dependencies << dependency
        return this
    }

    public String build(){

        def stringBuilder = new StringBuilder()
        if(useBuildscriptPluginOutput) {
            stringBuilder << "\n"
            stringBuilder << buildscriptPluginOutput.output
        }
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
