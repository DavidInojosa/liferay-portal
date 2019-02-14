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

package com.liferay.opensocial.service.base;

import com.liferay.opensocial.model.Gadget;
import com.liferay.opensocial.service.GadgetService;
import com.liferay.opensocial.service.persistence.GadgetPersistence;
import com.liferay.opensocial.service.persistence.OAuthConsumerPersistence;
import com.liferay.opensocial.service.persistence.OAuthTokenPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.PortletPersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the gadget remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.opensocial.service.impl.GadgetServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.opensocial.service.impl.GadgetServiceImpl
 * @generated
 */
public abstract class GadgetServiceBaseImpl extends BaseServiceImpl
	implements GadgetService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>GadgetService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.opensocial.service.GadgetServiceUtil</code>.
	 */

	/**
	 * Returns the gadget local service.
	 *
	 * @return the gadget local service
	 */
	public com.liferay.opensocial.service.GadgetLocalService getGadgetLocalService() {
		return gadgetLocalService;
	}

	/**
	 * Sets the gadget local service.
	 *
	 * @param gadgetLocalService the gadget local service
	 */
	public void setGadgetLocalService(
		com.liferay.opensocial.service.GadgetLocalService gadgetLocalService) {
		this.gadgetLocalService = gadgetLocalService;
	}

	/**
	 * Returns the gadget remote service.
	 *
	 * @return the gadget remote service
	 */
	public GadgetService getGadgetService() {
		return gadgetService;
	}

	/**
	 * Sets the gadget remote service.
	 *
	 * @param gadgetService the gadget remote service
	 */
	public void setGadgetService(GadgetService gadgetService) {
		this.gadgetService = gadgetService;
	}

	/**
	 * Returns the gadget persistence.
	 *
	 * @return the gadget persistence
	 */
	public GadgetPersistence getGadgetPersistence() {
		return gadgetPersistence;
	}

	/**
	 * Sets the gadget persistence.
	 *
	 * @param gadgetPersistence the gadget persistence
	 */
	public void setGadgetPersistence(GadgetPersistence gadgetPersistence) {
		this.gadgetPersistence = gadgetPersistence;
	}

	/**
	 * Returns the o auth consumer local service.
	 *
	 * @return the o auth consumer local service
	 */
	public com.liferay.opensocial.service.OAuthConsumerLocalService getOAuthConsumerLocalService() {
		return oAuthConsumerLocalService;
	}

	/**
	 * Sets the o auth consumer local service.
	 *
	 * @param oAuthConsumerLocalService the o auth consumer local service
	 */
	public void setOAuthConsumerLocalService(
		com.liferay.opensocial.service.OAuthConsumerLocalService oAuthConsumerLocalService) {
		this.oAuthConsumerLocalService = oAuthConsumerLocalService;
	}

	/**
	 * Returns the o auth consumer persistence.
	 *
	 * @return the o auth consumer persistence
	 */
	public OAuthConsumerPersistence getOAuthConsumerPersistence() {
		return oAuthConsumerPersistence;
	}

	/**
	 * Sets the o auth consumer persistence.
	 *
	 * @param oAuthConsumerPersistence the o auth consumer persistence
	 */
	public void setOAuthConsumerPersistence(
		OAuthConsumerPersistence oAuthConsumerPersistence) {
		this.oAuthConsumerPersistence = oAuthConsumerPersistence;
	}

	/**
	 * Returns the o auth token local service.
	 *
	 * @return the o auth token local service
	 */
	public com.liferay.opensocial.service.OAuthTokenLocalService getOAuthTokenLocalService() {
		return oAuthTokenLocalService;
	}

	/**
	 * Sets the o auth token local service.
	 *
	 * @param oAuthTokenLocalService the o auth token local service
	 */
	public void setOAuthTokenLocalService(
		com.liferay.opensocial.service.OAuthTokenLocalService oAuthTokenLocalService) {
		this.oAuthTokenLocalService = oAuthTokenLocalService;
	}

	/**
	 * Returns the o auth token persistence.
	 *
	 * @return the o auth token persistence
	 */
	public OAuthTokenPersistence getOAuthTokenPersistence() {
		return oAuthTokenPersistence;
	}

	/**
	 * Sets the o auth token persistence.
	 *
	 * @param oAuthTokenPersistence the o auth token persistence
	 */
	public void setOAuthTokenPersistence(
		OAuthTokenPersistence oAuthTokenPersistence) {
		this.oAuthTokenPersistence = oAuthTokenPersistence;
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
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name remote service.
	 *
	 * @return the class name remote service
	 */
	public com.liferay.portal.kernel.service.ClassNameService getClassNameService() {
		return classNameService;
	}

	/**
	 * Sets the class name remote service.
	 *
	 * @param classNameService the class name remote service
	 */
	public void setClassNameService(
		com.liferay.portal.kernel.service.ClassNameService classNameService) {
		this.classNameService = classNameService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the portlet local service.
	 *
	 * @return the portlet local service
	 */
	public com.liferay.portal.kernel.service.PortletLocalService getPortletLocalService() {
		return portletLocalService;
	}

	/**
	 * Sets the portlet local service.
	 *
	 * @param portletLocalService the portlet local service
	 */
	public void setPortletLocalService(
		com.liferay.portal.kernel.service.PortletLocalService portletLocalService) {
		this.portletLocalService = portletLocalService;
	}

	/**
	 * Returns the portlet remote service.
	 *
	 * @return the portlet remote service
	 */
	public com.liferay.portal.kernel.service.PortletService getPortletService() {
		return portletService;
	}

	/**
	 * Sets the portlet remote service.
	 *
	 * @param portletService the portlet remote service
	 */
	public void setPortletService(
		com.liferay.portal.kernel.service.PortletService portletService) {
		this.portletService = portletService;
	}

	/**
	 * Returns the portlet persistence.
	 *
	 * @return the portlet persistence
	 */
	public PortletPersistence getPortletPersistence() {
		return portletPersistence;
	}

	/**
	 * Sets the portlet persistence.
	 *
	 * @param portletPersistence the portlet persistence
	 */
	public void setPortletPersistence(PortletPersistence portletPersistence) {
		this.portletPersistence = portletPersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.kernel.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.kernel.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
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
		return GadgetService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Gadget.class;
	}

	protected String getModelClassName() {
		return Gadget.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = gadgetPersistence.getDataSource();

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

	@BeanReference(type = com.liferay.opensocial.service.GadgetLocalService.class)
	protected com.liferay.opensocial.service.GadgetLocalService gadgetLocalService;
	@BeanReference(type = GadgetService.class)
	protected GadgetService gadgetService;
	@BeanReference(type = GadgetPersistence.class)
	protected GadgetPersistence gadgetPersistence;
	@BeanReference(type = com.liferay.opensocial.service.OAuthConsumerLocalService.class)
	protected com.liferay.opensocial.service.OAuthConsumerLocalService oAuthConsumerLocalService;
	@BeanReference(type = OAuthConsumerPersistence.class)
	protected OAuthConsumerPersistence oAuthConsumerPersistence;
	@BeanReference(type = com.liferay.opensocial.service.OAuthTokenLocalService.class)
	protected com.liferay.opensocial.service.OAuthTokenLocalService oAuthTokenLocalService;
	@BeanReference(type = OAuthTokenPersistence.class)
	protected OAuthTokenPersistence oAuthTokenPersistence;
	@BeanReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@BeanReference(type = com.liferay.portal.kernel.service.ClassNameService.class)
	protected com.liferay.portal.kernel.service.ClassNameService classNameService;
	@BeanReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@BeanReference(type = com.liferay.portal.kernel.service.PortletLocalService.class)
	protected com.liferay.portal.kernel.service.PortletLocalService portletLocalService;
	@BeanReference(type = com.liferay.portal.kernel.service.PortletService.class)
	protected com.liferay.portal.kernel.service.PortletService portletService;
	@BeanReference(type = PortletPersistence.class)
	protected PortletPersistence portletPersistence;
	@BeanReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.kernel.service.UserService.class)
	protected com.liferay.portal.kernel.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
}