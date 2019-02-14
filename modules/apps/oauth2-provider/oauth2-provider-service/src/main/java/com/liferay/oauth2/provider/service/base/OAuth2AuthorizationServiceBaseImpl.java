/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.oauth2.provider.service.base;

import com.liferay.oauth2.provider.model.OAuth2Authorization;
import com.liferay.oauth2.provider.service.OAuth2AuthorizationService;
import com.liferay.oauth2.provider.service.persistence.OAuth2AuthorizationPersistence;
import com.liferay.oauth2.provider.service.persistence.OAuth2ScopeGrantFinder;
import com.liferay.oauth2.provider.service.persistence.OAuth2ScopeGrantPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the o auth2 authorization remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.oauth2.provider.service.impl.OAuth2AuthorizationServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.oauth2.provider.service.impl.OAuth2AuthorizationServiceImpl
 * @generated
 */
public abstract class OAuth2AuthorizationServiceBaseImpl extends BaseServiceImpl
	implements OAuth2AuthorizationService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>OAuth2AuthorizationService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.oauth2.provider.service.OAuth2AuthorizationServiceUtil</code>.
	 */

	/**
	 * Returns the o auth2 authorization local service.
	 *
	 * @return the o auth2 authorization local service
	 */
	public com.liferay.oauth2.provider.service.OAuth2AuthorizationLocalService getOAuth2AuthorizationLocalService() {
		return oAuth2AuthorizationLocalService;
	}

	/**
	 * Sets the o auth2 authorization local service.
	 *
	 * @param oAuth2AuthorizationLocalService the o auth2 authorization local service
	 */
	public void setOAuth2AuthorizationLocalService(
		com.liferay.oauth2.provider.service.OAuth2AuthorizationLocalService oAuth2AuthorizationLocalService) {
		this.oAuth2AuthorizationLocalService = oAuth2AuthorizationLocalService;
	}

	/**
	 * Returns the o auth2 authorization remote service.
	 *
	 * @return the o auth2 authorization remote service
	 */
	public OAuth2AuthorizationService getOAuth2AuthorizationService() {
		return oAuth2AuthorizationService;
	}

	/**
	 * Sets the o auth2 authorization remote service.
	 *
	 * @param oAuth2AuthorizationService the o auth2 authorization remote service
	 */
	public void setOAuth2AuthorizationService(
		OAuth2AuthorizationService oAuth2AuthorizationService) {
		this.oAuth2AuthorizationService = oAuth2AuthorizationService;
	}

	/**
	 * Returns the o auth2 authorization persistence.
	 *
	 * @return the o auth2 authorization persistence
	 */
	public OAuth2AuthorizationPersistence getOAuth2AuthorizationPersistence() {
		return oAuth2AuthorizationPersistence;
	}

	/**
	 * Sets the o auth2 authorization persistence.
	 *
	 * @param oAuth2AuthorizationPersistence the o auth2 authorization persistence
	 */
	public void setOAuth2AuthorizationPersistence(
		OAuth2AuthorizationPersistence oAuth2AuthorizationPersistence) {
		this.oAuth2AuthorizationPersistence = oAuth2AuthorizationPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the o auth2 scope grant local service.
	 *
	 * @return the o auth2 scope grant local service
	 */
	public com.liferay.oauth2.provider.service.OAuth2ScopeGrantLocalService getOAuth2ScopeGrantLocalService() {
		return oAuth2ScopeGrantLocalService;
	}

	/**
	 * Sets the o auth2 scope grant local service.
	 *
	 * @param oAuth2ScopeGrantLocalService the o auth2 scope grant local service
	 */
	public void setOAuth2ScopeGrantLocalService(
		com.liferay.oauth2.provider.service.OAuth2ScopeGrantLocalService oAuth2ScopeGrantLocalService) {
		this.oAuth2ScopeGrantLocalService = oAuth2ScopeGrantLocalService;
	}

	/**
	 * Returns the o auth2 scope grant persistence.
	 *
	 * @return the o auth2 scope grant persistence
	 */
	public OAuth2ScopeGrantPersistence getOAuth2ScopeGrantPersistence() {
		return oAuth2ScopeGrantPersistence;
	}

	/**
	 * Sets the o auth2 scope grant persistence.
	 *
	 * @param oAuth2ScopeGrantPersistence the o auth2 scope grant persistence
	 */
	public void setOAuth2ScopeGrantPersistence(
		OAuth2ScopeGrantPersistence oAuth2ScopeGrantPersistence) {
		this.oAuth2ScopeGrantPersistence = oAuth2ScopeGrantPersistence;
	}

	/**
	 * Returns the o auth2 scope grant finder.
	 *
	 * @return the o auth2 scope grant finder
	 */
	public OAuth2ScopeGrantFinder getOAuth2ScopeGrantFinder() {
		return oAuth2ScopeGrantFinder;
	}

	/**
	 * Sets the o auth2 scope grant finder.
	 *
	 * @param oAuth2ScopeGrantFinder the o auth2 scope grant finder
	 */
	public void setOAuth2ScopeGrantFinder(
		OAuth2ScopeGrantFinder oAuth2ScopeGrantFinder) {
		this.oAuth2ScopeGrantFinder = oAuth2ScopeGrantFinder;
	}

	public void afterPropertiesSet() {
	}

	public void destroy() {
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return OAuth2AuthorizationService.class.getName();
	}

	protected Class<?> getModelClass() {
		return OAuth2Authorization.class;
	}

	protected String getModelClassName() {
		return OAuth2Authorization.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = oAuth2AuthorizationPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.liferay.oauth2.provider.service.OAuth2AuthorizationLocalService.class)
	protected com.liferay.oauth2.provider.service.OAuth2AuthorizationLocalService oAuth2AuthorizationLocalService;
	@BeanReference(type = OAuth2AuthorizationService.class)
	protected OAuth2AuthorizationService oAuth2AuthorizationService;
	@BeanReference(type = OAuth2AuthorizationPersistence.class)
	protected OAuth2AuthorizationPersistence oAuth2AuthorizationPersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.oauth2.provider.service.OAuth2ScopeGrantLocalService.class)
	protected com.liferay.oauth2.provider.service.OAuth2ScopeGrantLocalService oAuth2ScopeGrantLocalService;
	@BeanReference(type = OAuth2ScopeGrantPersistence.class)
	protected OAuth2ScopeGrantPersistence oAuth2ScopeGrantPersistence;
	@BeanReference(type = OAuth2ScopeGrantFinder.class)
	protected OAuth2ScopeGrantFinder oAuth2ScopeGrantFinder;
}