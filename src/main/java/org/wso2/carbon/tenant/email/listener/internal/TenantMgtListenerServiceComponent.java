package org.wso2.carbon.tenant.email.listener.internal;

import org.osgi.service.component.annotations.*;
import org.wso2.carbon.identity.event.services.IdentityEventService;
import org.wso2.carbon.tenant.email.listener.CustomEmailTenantMgtListener;
import org.wso2.carbon.registry.core.service.RegistryService;
import org.wso2.carbon.user.core.service.RealmService;
import org.osgi.service.component.ComponentContext;

@Component(
        name = "org.wso2.carbon.tenantemail",
        immediate = true
)
public class TenantMgtListenerServiceComponent {

    @Reference(
            name = "registry.service",
            service = org.wso2.carbon.registry.core.service.RegistryService.class,
            cardinality = ReferenceCardinality.MANDATORY,
            policy = ReferencePolicy.DYNAMIC,
            unbind = "unsetRegistryService"
    )
    protected void setRegistryService(RegistryService registryService) {
        DataHolder.getInstance().setRegistryService(registryService);
    }

    protected void unsetRegistryService(RegistryService registryService) {
        DataHolder.getInstance().setRegistryService(null);
    }

    @Reference(
            name = "user.realmservice.default",
            service = org.wso2.carbon.user.core.service.RealmService.class,
            cardinality = ReferenceCardinality.MANDATORY,
            policy = ReferencePolicy.DYNAMIC,
            unbind = "unsetRealmService"
    )
    protected void setRealmService(RealmService realmService) {
        DataHolder.getInstance().setRealmService(realmService);
    }
    protected void unsetRealmService(RealmService realmService) {
        DataHolder.getInstance().setRealmService(null);
    }

    @Reference(
            name = "identity.event.service",
            service = IdentityEventService.class,
            cardinality = ReferenceCardinality.MANDATORY,
            policy = ReferencePolicy.DYNAMIC,
            unbind = "unsetIdentityEventService"
    )
    protected void setIdentityEventService(IdentityEventService identityEventService) {
        DataHolder.getInstance().setIdentityEventService(identityEventService);
    }

    protected void unsetIdentityEventService(IdentityEventService identityEventService) {
        DataHolder.getInstance().setIdentityEventService(null);
    }

    @Activate
    protected void activate(ComponentContext ctxt) {
        CustomEmailTenantMgtListener customEmailTenantMgtListener = new CustomEmailTenantMgtListener();
        ctxt.getBundleContext()
                .registerService(org.wso2.carbon.stratos.common.listeners.TenantMgtListener.class.getName(),
                        customEmailTenantMgtListener, null);
    }

    protected void deactivate(ComponentContext ctxt) {
    }

}