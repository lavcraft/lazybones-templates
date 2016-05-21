def props = [:]

props.group = ask("Define value for 'group' [ru.jeeconf]: ", "ru.joker", "group")
props.version = '0.0.1'
props.dockerHost = "192.168.99.100"
props.projectName = props.group.split('\\.').last()
props.dns = "172.17.42.1"

//processTemplates "build.gradle", props
processTemplates "docker-compose.yml", props
processTemplates "settings.gradle", props
