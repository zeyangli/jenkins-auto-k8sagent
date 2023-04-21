import groovy.text.SimpleTemplateEngine
import java.security.MessageDigest
import java.util.regex.Matcher
import java.util.regex.Pattern

if(!binding.hasVariable('agent_name')) {
    //binding doesn't exist so set a default
    agent_name = 'myagent'
}
//type check user defined parameters/bindings
if(!(agent_name instanceof String)) {
    throw new Exception('PARAMETER ERROR: agent_name must be a string.')
}

//script bindings
jenkins = Jenkins.instance
node = jenkins.getNode(agent_name)
computer = node.computer
launcher = node.launcher

String checksum( def input ) {
    MessageDigest.getInstance('SHA-256').digest(input.bytes).encodeHex().toString()
}

String getJenkinsUrl() {
    jenkins.rootUrl.trim().replaceAll('/$', '') as String
}

Map scriptBinding = [
    jenkins_url: getJenkinsUrl(),
    jenkins_home: node.remoteFS.trim(),
    computer_url: computer.url.trim().replaceAll('/$', '') as String,
    computer_secret: computer.jnlpMac.trim(),
    java_opts: (launcher.vmargs)?:"",
    jnlp_jar_sha: checksum("${getJenkinsUrl()}/jnlpJars/slave.jar".toURL())
]


println(scriptBinding)