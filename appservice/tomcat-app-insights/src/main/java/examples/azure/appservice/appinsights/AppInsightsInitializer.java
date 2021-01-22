package examples.azure.appservice.appinsights;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.Set;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * A ServletContainerInitializer that will put the app-insights.jar at
 * the correct location.
 *
 * Note for this to properly work, first deploy the application (this example
 * uses the default deploy for this). This will put the JAR file where it needs
 * to be. Then update the app settings to include the Java agent and the 
 * instrumentation key. And then deploy the application again (this example uses
 * the app-insights profile to both update the application settings and redeploy
 * the application).
 * 
 * Note this example is for Linux App Service plans only.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class AppInsightsInitializer implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> set, ServletContext context) throws ServletException {
        try (InputStream input = context.getResource(
                "/WEB-INF/agent/app-insights.jar").openStream()) {
            context.log("Copying Application Insights agent JAR to correct location");
            Path output = Paths.get("/home/site/deployments/tools/app-insights.jar");
            Files.copy(input, output, REPLACE_EXISTING);
        } catch (Exception e) {
            context.log("Unable to copy the Application Insights agent JAR to the correct location", e);
        }
    }
}
