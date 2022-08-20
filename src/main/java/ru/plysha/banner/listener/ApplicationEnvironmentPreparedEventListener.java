package ru.plysha.banner.listener;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.util.StringUtils;
import ru.plysha.banner.CustomBanner;

public class ApplicationEnvironmentPreparedEventListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    private static final String SPRING_BANNER_NAME = "spring.banner.name";

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        String bannerLogo = event.getEnvironment().getProperty(SPRING_BANNER_NAME);
        if (StringUtils.hasText(bannerLogo)) {
            event.getSpringApplication().setBanner(new CustomBanner());
        }
    }
}
