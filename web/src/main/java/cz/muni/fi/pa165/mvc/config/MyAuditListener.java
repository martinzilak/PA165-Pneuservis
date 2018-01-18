package cz.muni.fi.pa165.mvc.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyAuditListener implements ApplicationListener<ApplicationEvent> {
    private static final Logger LOG = LoggerFactory.getLogger("security");

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        LOG.warn(applicationEvent.toString());
    }
}