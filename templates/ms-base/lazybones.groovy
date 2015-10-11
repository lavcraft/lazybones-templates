def props = [:]

props.group = ask("Define value for 'group' [ru.joker]: ", "ru.joker", "group")
props.version = ask("Define value for 'version' [0.0.1]: ", "0.0.1", "version")
props.dockerHost = ask("Define value for 'docker_host' [192.168.99.100]: ", "192.168.99.100", "dockerHost")
props.projectName = props.group.split('\\.').last()

processTemplates "build.gradle", props
processTemplates "docker-compose.yml", props
processTemplates "settings.gradle", props