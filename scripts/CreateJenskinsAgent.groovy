import hudson.model.Node.Mode
import hudson.slaves.*
import jenkins.model.Jenkins


// 创建agent
String agentName = "zeyang"
String executorNum = "1"
String agentLabel = "JenkinsPod"

agent_node = new DumbSlave(agentName, "Jenkins pod", "/opt/jenkins", executorNum,              
                               Mode.EXCLUSIVE,   
                               agentLabel,                       
                               new JNLPLauncher(),         
                               RetentionStrategy.INSTANCE) 
Jenkins.instance.addNode(agent_node)

//获取agent的配置
node = Jenkins.instance.getNode(agentName)
computer = node.computer
jenkinsUrl = Jenkins.instance.rootUrl.trim().replaceAll('/$', '') 

return  """{
\"jenkinsUrl\" : \"${jenkinsUrl}\", 
\"jenkinsHome\": \"${node.remoteFS.trim()}\",
\"computerUrl\": \"${computer.url.trim().replaceAll('/$', '') as String}\",
\"computerSecret\": \"${computer.jnlpMac.trim()}\"
}"""
