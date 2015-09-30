def props = [:]
props.group = ask("Define value for 'group' [ru.joker]: ", "ru.joker", "group")
props.version = ask("Define value for 'version' [0.1]: ", "0.0.1", "version")

processTemplates "build.gradle", props