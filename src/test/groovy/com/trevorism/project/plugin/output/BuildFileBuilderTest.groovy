package com.trevorism.project.plugin.output

import com.trevorism.project.plugin.model.Dependency
import com.trevorism.project.plugin.model.Plugin
import org.junit.Test

/**
 * @author tbrooks
 */
class BuildFileBuilderTest {

    @Test
    void "build with empty builder"() {
        def builder = new BuildFileBuilder()
        String buildFileText = builder.build()

        assert buildFileText.contains("repositories {\n\tmavenCentral()\n}")
        assert buildFileText.contains("dependencies {\n}")
    }

    @Test
    void "build with java"() {
        def builder = new BuildFileBuilder().plugin(new Plugin(Plugin.IncludeType.PLUGIN, "java"))
        String buildFileText = builder.build()

        assert buildFileText.contains("apply plugin: 'java'")
    }

    @Test
    void "build with dependency"() {
        def builder = new BuildFileBuilder().dependency(new Dependency("compile", ":com.trevorism:"))
        String buildFileText = builder.build()

        assert buildFileText.contains("dependencies {\n\tcompile ':com.trevorism:'\n}")
    }

}
