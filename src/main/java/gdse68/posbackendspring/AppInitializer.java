package gdse68.posbackendspring;

import gdse68.posbackendspring.config.WebAppConfig;
import gdse68.posbackendspring.config.WebAppRootConfig;
import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebAppRootConfig.class};} //controller class ekka derectly intact wennathi class

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebAppConfig.class};} //controller class ekk derect intact wenwa

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    } // dispathcher servlet eke mapping eka dann

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) { // maltipart from data ekk save krann floder ekk hadanwa tempary
        registration.setMultipartConfig(new MultipartConfigElement("/tmp"));
    }
}
