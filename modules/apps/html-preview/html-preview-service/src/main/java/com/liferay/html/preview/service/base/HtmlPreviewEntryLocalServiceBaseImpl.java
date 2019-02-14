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

package com.liferay.html.preview.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.html.preview.model.HtmlPreviewEntry;
import com.liferay.html.preview.service.HtmlPreviewEntryLocalService;
import com.liferay.html.preview.service.persistence.HtmlPreviewEntryPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the html preview entry local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.html.preview.service.impl.HtmlPreviewEntryLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.html.preview.service.impl.HtmlPreviewEntryLocalServiceImpl
 * @generated
 */
@ProviderType
public abstract class HtmlPreviewEntryLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements HtmlPreviewEntryLocalService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>HtmlPreviewEntryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.html.preview.service.HtmlPreviewEntryLocalServiceUtil</code>.
	 */

	/**
	 * Adds the html preview entry to the database. Also notifies the appropriate model listeners.
	 *
	 * @param htmlPreviewEntry the html preview entry
	 * @return the html preview entry that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public HtmlPreviewEntry addHtmlPreviewEntry(
		HtmlPreviewEntry htmlPreviewEntry) {
		htmlPreviewEntry.setNew(true);

		return htmlPreviewEntryPersistence.update(htmlPreviewEntry);
	}

	/**
	 * Creates a new html preview entry with the primary key. Does not add the html preview entry to the database.
	 *
	 * @param htmlPreviewEntryId the primary key for the new html preview entry
	 * @return the new html preview entry
	 */
	@Override
	@Transactional(enabled = false)
	public HtmlPreviewEntry createHtmlPreviewEntry(long htmlPreviewEntryId) {
		return htmlPreviewEntryPersistence.create(htmlPreviewEntryId);
	}

	/**
	 * Deletes the html preview entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param htmlPreviewEntryId the primary key of the html preview entry
	 * @return the html preview entry that was removed
	 * @throws PortalException if a html preview entry with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public HtmlPreviewEntry deleteHtmlPreviewEntry(long htmlPreviewEntryId)
		throws PortalException {
		return htmlPreviewEntryPersistence.remove(htmlPreviewEntryId);
	}

	/**
	 * Deletes the html preview entry from the database. Also notifies the appropriate model listeners.
	 *
	 * @param htmlPreviewEntry the html preview entry
	 * @return the html preview entry that was removed
	 * @throws PortalException
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public HtmlPreviewEntry deleteHtmlPreviewEntry(
		HtmlPreviewEntry htmlPreviewEntry) throws PortalException {
		return htmlPreviewEntryPersistence.remove(htmlPreviewEntry);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(HtmlPreviewEntry.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return htmlPreviewEntryPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.html.preview.model.impl.HtmlPreviewEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return htmlPreviewEntryPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.html.preview.model.impl.HtmlPreviewEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return htmlPreviewEntryPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return htmlPreviewEntryPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return htmlPreviewEntryPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public HtmlPreviewEntry fetchHtmlPreviewEntry(long htmlPreviewEntryId) {
		return htmlPreviewEntryPersistence.fetchByPrimaryKey(htmlPreviewEntryId);
	}

	/**
	 * Returns the html preview entry with the primary key.
	 *
	 * @param htmlPreviewEntryId the primary key of the html preview entry
	 * @return the html preview entry
	 * @throws PortalException if a html preview entry with the primary key could not be found
	 */
	@Override
	public HtmlPreviewEntry getHtmlPreviewEntry(long htmlPreviewEntryId)
		throws PortalException {
		return htmlPreviewEntryPersistence.findByPrimaryKey(htmlPreviewEntryId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(htmlPreviewEntryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(HtmlPreviewEntry.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("htmlPreviewEntryId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(htmlPreviewEntryLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(HtmlPreviewEntry.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"htmlPreviewEntryId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(htmlPreviewEntryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(HtmlPreviewEntry.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("htmlPreviewEntryId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return htmlPreviewEntryLocalService.deleteHtmlPreviewEntry((HtmlPreviewEntry)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return htmlPreviewEntryPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the html preview entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.html.preview.model.impl.HtmlPreviewEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of html preview entries
	 * @param end the upper bound of the range of html preview entries (not inclusive)
	 * @return the range of html preview entries
	 */
	@Override
	public List<HtmlPreviewEntry> getHtmlPreviewEntries(int start, int end) {
		return htmlPreviewEntryPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of html preview entries.
	 *
	 * @return the number of html preview entries
	 */
	@Override
	public int getHtmlPreviewEntriesCount() {
		return htmlPreviewEntryPersistence.countAll();
	}

	/**
	 * Updates the html preview entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param htmlPreviewEntry the html preview entry
	 * @return the html preview entry that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public HtmlPreviewEntry updateHtmlPreviewEntry(
		HtmlPreviewEntry htmlPreviewEntry) {
		return htmlPreviewEntryPersistence.update(htmlPreviewEntry);
	}

	/**
	 * Returns the html preview entry local service.
	 *
	 * @return the html preview entry local service
	 */
	public HtmlPreviewEntryLocalService getHtmlPreviewEntryLocalService() {
		return htmlPreviewEntryLocalService;
	}

	/**
	 * Sets the html preview entry local service.
	 *
	 * @param htmlPreviewEntryLocalService the html preview entry local service
	 */
	public void setHtmlPreviewEntryLocalService(
		HtmlPreviewEntryLocalService htmlPreviewEntryLocalService) {
		this.htmlPreviewEntryLocalService = htmlPreviewEntryLocalService;
	}

	/**
	 * Returns the html preview entry persistence.
	 *
	 * @return the html preview entry persistence
	 */
	public HtmlPreviewEntryPersistence getHtmlPreviewEntryPersistence() {
		return htmlPreviewEntryPersistence;
	}

	/**
	 * Sets the html preview entry persistence.
	 *
	 * @param htmlPreviewEntryPersistence the html preview entry persistence
	 */
	public void setHtmlPreviewEntryPersistence(
		HtmlPreviewEntryPersistence htmlPreviewEntryPersistence) {
		this.htmlPreviewEntryPersistence = htmlPreviewEntryPersistence;
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
		persistedModelLocalServiceRegistry.register("com.liferay.html.preview.model.HtmlPreviewEntry",
			htmlPreviewEntryLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.liferay.html.preview.model.HtmlPreviewEntry");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return HtmlPreviewEntryLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return HtmlPreviewEntry.class;
	}

	protected String getModelClassName() {
		return HtmlPreviewEntry.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = htmlPreviewEntryPersistence.getDataSource();

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

	@BeanReference(type = HtmlPreviewEntryLocalService.class)
	protected HtmlPreviewEntryLocalService htmlPreviewEntryLocalService;
	@BeanReference(type = HtmlPreviewEntryPersistence.class)
	protected HtmlPreviewEntryPersistence htmlPreviewEntryPersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}