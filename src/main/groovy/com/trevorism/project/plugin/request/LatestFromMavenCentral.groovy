package com.trevorism.project.plugin.request

import groovy.json.JsonSlurper

/**
 * @author tbrooks
 */
class LatestFromMavenCentral {

    static String getLatestGroovyVersion(){
        try{
            getLatestGroovyAllFromMavenCentral()
        }catch(Exception e){
            return "2.4.12"
        }
    }

    private static getLatestGroovyAllFromMavenCentral() {
        String response = "http://search.maven.org/solrsearch/select?q=g%3A%22org.codehaus.groovy%22%20AND%20a%3A%22groovy-all%22&rows=20&wt=json".toURL().text
        JsonSlurper slurper = new JsonSlurper()
        slurper.parseText(response)["response"]["docs"]["latestVersion"][0]
    }

}
