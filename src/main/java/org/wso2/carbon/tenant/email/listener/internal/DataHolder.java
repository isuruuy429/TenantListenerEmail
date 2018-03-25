package org.wso2.carbon.tenant.email.listener.internal;

import org.wso2.carbon.identity.event.services.IdentityEventService;
import org.wso2.carbon.registry.core.service.RegistryService;
import org.wso2.carbon.user.core.service.RealmService;

public class DataHolder {

    private RegistryService registryService;
    private RealmService realmService;
    private IdentityEventService identityEventService;

    private static DataHolder instance = new DataHolder();

    public static DataHolder getInstance() {
        return instance;
    }

    public IdentityEventService getIdentityEventService() {
        return identityEventService;
    }

    public void setIdentityEventService(IdentityEventService identityEventService) {
        this.identityEventService = identityEventService;
    }

    public RegistryService getRegistryService() {
        return registryService;
    }

    public void setRegistryService(RegistryService registryService) {
        this.registryService = registryService;
    }

    public RealmService getRealmService() {
        return realmService;
    }

    public void setRealmService(RealmService realmService) {
        this.realmService = realmService;
    }

}
