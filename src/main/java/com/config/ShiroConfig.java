package com.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
@Component
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);
        shiroFilter.setLoginUrl("/login");
        shiroFilter.setFilterChainDefinitions("/welcome=authc\n " +
                "/create=authc\n");
        return shiroFilter;
    }

    @Bean
    public SecurityManager securityManager(Realm realm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);
        return securityManager;
    }

    @Bean
    public Realm realm(DataSource dataSource) {
        JdbcRealm realm = new JdbcRealm();
        realm.setDataSource(dataSource);
        realm.setAuthenticationQuery("select password from users where username=?");
        realm.setUserRolesQuery("select roles.name from users,roles,user_role where " +
                "users.id=user_role.user_id and" +
                " roles.id=user_role.role_id and users.username=?");
        realm.setPermissionsQuery("SELECT permission.name FROM permission ,roles,role_permission " +
                "WHERE roles.id=role_permission.role_id AND " +
                "permission.id=role_permission.permission_id AND roles.name=?");
        realm.setPermissionsLookupEnabled(true);
        return realm;
    }
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }
}
