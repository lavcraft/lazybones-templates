import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.attribute.PosixFilePermissions

import static java.nio.file.Files.*
import static java.nio.file.Paths.get

def props = [:]

props.group = ask("Define value for 'group' [ru.jeeconf]: ", "ru.jeeconf", "group")
props.version = ask("Define value for 'version' [0.0.1]: ", "0.0.1", "version")
props.dockerHost = "192.168.99.100"
props.projectName = projectDir.name

String mainApplicationFileName = 'Application.groovy'
String rebuildScriptFileName = 'rebuild.sh'
String rebuildScriptFileNamePrefix = 'rebuild'

processTemplates "build.gradle", props
//processTemplates "src/main/resources/bootstrap.yml", props
processTemplates 'Dockerfile', props
processTemplates 'README.md', props
processTemplates mainApplicationFileName, props
processTemplates rebuildScriptFileName, props

String pkgPath = props.group.replace('.' as char, '/' as char)
Path templatePath = templateDir.toPath()
Path projectPath = projectDir.toPath()

Path groovySourceDirWithPackage = get projectPath as String, 'src/main/groovy/', pkgPath
Path destinationAppFilePath = groovySourceDirWithPackage.resolve mainApplicationFileName
Path templateApplicationPath = templatePath.resolve mainApplicationFileName
Path templateRebuildScriptPath = templatePath.resolve rebuildScriptFileName

groovySourceDirWithPackage.toFile() mkdirs()

try {
    move templateApplicationPath, destinationAppFilePath
    Path newRebuildScriptPath = projectPath.parent.resolve rebuildScriptFileNamePrefix+'-'+projectDir.name as String
    if(notExists(newRebuildScriptPath)){
//        createFile newRebuildScriptPath, PosixFilePermissions.asFileAttribute(PosixFilePermissions.fromString("rwxr-xr-x"))
        move templateRebuildScriptPath, newRebuildScriptPath
    }

    Path newSettingsPath = projectPath.parent.resolve('settings.gradle')
    File newSettingsFile = newSettingsPath.toFile()

    if (notExists(newSettingsPath)) {
        newSettingsFile = createFile newSettingsPath toFile()
    }

    def currentConfigDump = newSettingsFile.text

    newSettingsFile.withWriter { writer ->
        currentConfigDump.eachLine { line ->
            if (line.contains('end includes')) {
                writer << "include '${projectDir.name}'"
                writer << '\n'
            }

            writer << line
            writer << '\n'

        }
        writer.close()
    }
} catch (ignored) {
    ignored.printStackTrace()
    println '^'*50
    println 'ignored exception'.center(50,'^')
    println '^'*50
}
