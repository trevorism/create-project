package com.trevorism.project.plugin.output

import org.junit.Test

/**
 * @author tbrooks
 */
class RepositoryOutputTest {

    @Test
    public void "repo output"(){
        def repoOutput = new RepositoryOutput()
        assert "repositories {\n\tmavenCentral()\n}\n" == repoOutput.output
    }


}
