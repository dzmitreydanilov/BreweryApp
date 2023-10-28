import com.ddanilov.convention.configureDetekt
import com.ddanilov.convention.libs
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class DetektConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("io.gitlab.arturbosch.detekt")
            val extension = extensions.getByType<DetektExtension>()
            configureDetekt(extension)

            dependencies {
                "detektPlugins"(libs.findLibrary("detekt-formatting").get())
                "detektPlugins"("ru.kode:detekt-rules-compose:1.3.0")
            }
        }
    }
}
