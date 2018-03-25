package org.wso2.carbon.tenant.email.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.identity.core.util.IdentityUtil;
import org.wso2.carbon.identity.event.IdentityEventConstants;
import org.wso2.carbon.identity.event.IdentityEventException;
import org.wso2.carbon.identity.event.event.Event;
import org.wso2.carbon.identity.recovery.IdentityRecoveryConstants;
import org.wso2.carbon.stratos.common.beans.TenantInfoBean;
import org.wso2.carbon.stratos.common.exception.StratosException;
import org.wso2.carbon.stratos.common.listeners.TenantMgtListener;
import org.wso2.carbon.tenant.email.listener.internal.DataHolder;
import org.wso2.carbon.user.api.UserStoreException;
import org.wso2.carbon.user.api.UserStoreManager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;


public class CustomEmailTenantMgtListener implements TenantMgtListener {

    private static Log log = LogFactory.getLog(CustomEmailTenantMgtListener.class);

    public void onTenantCreate(TenantInfoBean tenantInfoBean) throws StratosException {

        //Check if email sending is enabled
        if (tenantInfoBean.getTenantDomain().contains("wso2")) {
            String tenantAdminEmail = tenantInfoBean.getEmail();
            String tenantDomainName = tenantInfoBean.getTenantDomain();
            log.info("Send an email to the tenant admin"+tenantAdminEmail);
        } else {
            log.info("Illegal tenant domain created "+tenantInfoBean.getTenantDomain());
        }
    }

    public void onTenantUpdate(TenantInfoBean tenantInfoBean) throws StratosException {

    }

    public void onTenantDelete(int i) {

    }

    public void onTenantRename(int i, String s, String s1) throws StratosException {

    }

    public void onTenantInitialActivation(int i) throws StratosException {

    }

    public void onTenantActivation(int i) throws StratosException {

    }

    public void onTenantDeactivation(int i) throws StratosException {

    }

    public void onSubscriptionPlanChange(int i, String s, String s1) throws StratosException {

    }

    public int getListenerOrder() {

        //Setting the priority to last to provide time for other onTenantCreation calls
        return 8000;
    }

    public void onPreDelete(int i) throws StratosException {

    }



}
