package com.trevorism.project.plugin.output

/**
 * @author tbrooks
 */
class BuildscriptPluginOutput implements Output{

    @Override
    String getOutput() {
        'plugins {\n\tid "com.github.maiflai.scalatest" version "0.10"\n}'
    }
}
