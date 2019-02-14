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

package com.liferay.layout.page.template.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.layout.page.template.model.LayoutPageTemplateEntry;
import com.liferay.layout.page.template.model.LayoutPageTemplateEntryModel;
import com.liferay.layout.page.template.model.LayoutPageTemplateEntrySoap;

import com.liferay.petra.string.StringBundler;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the LayoutPageTemplateEntry service. Represents a row in the &quot;LayoutPageTemplateEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>LayoutPageTemplateEntryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LayoutPageTemplateEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LayoutPageTemplateEntryImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class LayoutPageTemplateEntryModelImpl extends BaseModelImpl<LayoutPageTemplateEntry>
	implements LayoutPageTemplateEntryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a layout page template entry model instance should use the <code>LayoutPageTemplateEntry</code> interface instead.
	 */
	public static final String TABLE_NAME = "LayoutPageTemplateEntry";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "layoutPageTemplateEntryId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "layoutPageTemplateCollectionId", Types.BIGINT },
			{ "classNameId", Types.BIGINT },
			{ "classTypeId", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "type_", Types.INTEGER },
			{ "previewFileEntryId", Types.BIGINT },
			{ "defaultTemplate", Types.BOOLEAN },
			{ "layoutPrototypeId", Types.BIGINT },
			{ "lastPublishDate", Types.TIMESTAMP },
			{ "plid", Types.BIGINT },
			{ "status", Types.INTEGER },
			{ "statusByUserId", Types.BIGINT },
			{ "statusByUserName", Types.VARCHAR },
			{ "statusDate", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("layoutPageTemplateEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("layoutPageTemplateCollectionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("classNameId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("classTypeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("type_", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("previewFileEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("defaultTemplate", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("layoutPrototypeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("lastPublishDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("plid", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("statusByUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("statusByUserName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("statusDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table LayoutPageTemplateEntry (uuid_ VARCHAR(75) null,layoutPageTemplateEntryId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,layoutPageTemplateCollectionId LONG,classNameId LONG,classTypeId LONG,name VARCHAR(75) null,type_ INTEGER,previewFileEntryId LONG,defaultTemplate BOOLEAN,layoutPrototypeId LONG,lastPublishDate DATE null,plid LONG,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table LayoutPageTemplateEntry";
	public static final String ORDER_BY_JPQL = " ORDER BY layoutPageTemplateEntry.name ASC";
	public static final String ORDER_BY_SQL = " ORDER BY LayoutPageTemplateEntry.name ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.layout.page.template.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.layout.page.template.model.LayoutPageTemplateEntry"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.layout.page.template.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.layout.page.template.model.LayoutPageTemplateEntry"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.layout.page.template.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.layout.page.template.model.LayoutPageTemplateEntry"),
			true);
	public static final long CLASSNAMEID_COLUMN_BITMASK = 1L;
	public static final long CLASSTYPEID_COLUMN_BITMASK = 2L;
	public static final long COMPANYID_COLUMN_BITMASK = 4L;
	public static final long DEFAULTTEMPLATE_COLUMN_BITMASK = 8L;
	public static final long GROUPID_COLUMN_BITMASK = 16L;
	public static final long LAYOUTPAGETEMPLATECOLLECTIONID_COLUMN_BITMASK = 32L;
	public static final long LAYOUTPROTOTYPEID_COLUMN_BITMASK = 64L;
	public static final long NAME_COLUMN_BITMASK = 128L;
	public static final long PLID_COLUMN_BITMASK = 256L;
	public static final long STATUS_COLUMN_BITMASK = 512L;
	public static final long TYPE_COLUMN_BITMASK = 1024L;
	public static final long UUID_COLUMN_BITMASK = 2048L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static LayoutPageTemplateEntry toModel(
		LayoutPageTemplateEntrySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		LayoutPageTemplateEntry model = new LayoutPageTemplateEntryImpl();

		model.setUuid(soapModel.getUuid());
		model.setLayoutPageTemplateEntryId(soapModel.getLayoutPageTemplateEntryId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setLayoutPageTemplateCollectionId(soapModel.getLayoutPageTemplateCollectionId());
		model.setClassNameId(soapModel.getClassNameId());
		model.setClassTypeId(soapModel.getClassTypeId());
		model.setName(soapModel.getName());
		model.setType(soapModel.getType());
		model.setPreviewFileEntryId(soapModel.getPreviewFileEntryId());
		model.setDefaultTemplate(soapModel.isDefaultTemplate());
		model.setLayoutPrototypeId(soapModel.getLayoutPrototypeId());
		model.setLastPublishDate(soapModel.getLastPublishDate());
		model.setPlid(soapModel.getPlid());
		model.setStatus(soapModel.getStatus());
		model.setStatusByUserId(soapModel.getStatusByUserId());
		model.setStatusByUserName(soapModel.getStatusByUserName());
		model.setStatusDate(soapModel.getStatusDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<LayoutPageTemplateEntry> toModels(
		LayoutPageTemplateEntrySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<LayoutPageTemplateEntry> models = new ArrayList<LayoutPageTemplateEntry>(soapModels.length);

		for (LayoutPageTemplateEntrySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.layout.page.template.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.layout.page.template.model.LayoutPageTemplateEntry"));

	public LayoutPageTemplateEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _layoutPageTemplateEntryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLayoutPageTemplateEntryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _layoutPageTemplateEntryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return LayoutPageTemplateEntry.class;
	}

	@Override
	public String getModelClassName() {
		return LayoutPageTemplateEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<LayoutPageTemplateEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<LayoutPageTemplateEntry, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<LayoutPageTemplateEntry, Object> attributeGetterFunction = entry.getValue();

			attributes.put(attributeName,
				attributeGetterFunction.apply((LayoutPageTemplateEntry)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<LayoutPageTemplateEntry, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<LayoutPageTemplateEntry, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((LayoutPageTemplateEntry)this,
					entry.getValue());
			}
		}
	}

	public Map<String, Function<LayoutPageTemplateEntry, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<LayoutPageTemplateEntry, Object>> getAttributeSetterBiConsumers() {
		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<LayoutPageTemplateEntry, Object>> _attributeGetterFunctions;
	private static final Map<String, BiConsumer<LayoutPageTemplateEntry, Object>> _attributeSetterBiConsumers;

	static {
		Map<String, Function<LayoutPageTemplateEntry, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<LayoutPageTemplateEntry, Object>>();
		Map<String, BiConsumer<LayoutPageTemplateEntry, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<LayoutPageTemplateEntry, ?>>();


		attributeGetterFunctions.put("uuid", LayoutPageTemplateEntry::getUuid);
		attributeSetterBiConsumers.put("uuid", (BiConsumer<LayoutPageTemplateEntry, String>)LayoutPageTemplateEntry::setUuid);
		attributeGetterFunctions.put("layoutPageTemplateEntryId", LayoutPageTemplateEntry::getLayoutPageTemplateEntryId);
		attributeSetterBiConsumers.put("layoutPageTemplateEntryId", (BiConsumer<LayoutPageTemplateEntry, Long>)LayoutPageTemplateEntry::setLayoutPageTemplateEntryId);
		attributeGetterFunctions.put("groupId", LayoutPageTemplateEntry::getGroupId);
		attributeSetterBiConsumers.put("groupId", (BiConsumer<LayoutPageTemplateEntry, Long>)LayoutPageTemplateEntry::setGroupId);
		attributeGetterFunctions.put("companyId", LayoutPageTemplateEntry::getCompanyId);
		attributeSetterBiConsumers.put("companyId", (BiConsumer<LayoutPageTemplateEntry, Long>)LayoutPageTemplateEntry::setCompanyId);
		attributeGetterFunctions.put("userId", LayoutPageTemplateEntry::getUserId);
		attributeSetterBiConsumers.put("userId", (BiConsumer<LayoutPageTemplateEntry, Long>)LayoutPageTemplateEntry::setUserId);
		attributeGetterFunctions.put("userName", LayoutPageTemplateEntry::getUserName);
		attributeSetterBiConsumers.put("userName", (BiConsumer<LayoutPageTemplateEntry, String>)LayoutPageTemplateEntry::setUserName);
		attributeGetterFunctions.put("createDate", LayoutPageTemplateEntry::getCreateDate);
		attributeSetterBiConsumers.put("createDate", (BiConsumer<LayoutPageTemplateEntry, Date>)LayoutPageTemplateEntry::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", LayoutPageTemplateEntry::getModifiedDate);
		attributeSetterBiConsumers.put("modifiedDate", (BiConsumer<LayoutPageTemplateEntry, Date>)LayoutPageTemplateEntry::setModifiedDate);
		attributeGetterFunctions.put("layoutPageTemplateCollectionId", LayoutPageTemplateEntry::getLayoutPageTemplateCollectionId);
		attributeSetterBiConsumers.put("layoutPageTemplateCollectionId", (BiConsumer<LayoutPageTemplateEntry, Long>)LayoutPageTemplateEntry::setLayoutPageTemplateCollectionId);
		attributeGetterFunctions.put("classNameId", LayoutPageTemplateEntry::getClassNameId);
		attributeSetterBiConsumers.put("classNameId", (BiConsumer<LayoutPageTemplateEntry, Long>)LayoutPageTemplateEntry::setClassNameId);
		attributeGetterFunctions.put("classTypeId", LayoutPageTemplateEntry::getClassTypeId);
		attributeSetterBiConsumers.put("classTypeId", (BiConsumer<LayoutPageTemplateEntry, Long>)LayoutPageTemplateEntry::setClassTypeId);
		attributeGetterFunctions.put("name", LayoutPageTemplateEntry::getName);
		attributeSetterBiConsumers.put("name", (BiConsumer<LayoutPageTemplateEntry, String>)LayoutPageTemplateEntry::setName);
		attributeGetterFunctions.put("type", LayoutPageTemplateEntry::getType);
		attributeSetterBiConsumers.put("type", (BiConsumer<LayoutPageTemplateEntry, Integer>)LayoutPageTemplateEntry::setType);
		attributeGetterFunctions.put("previewFileEntryId", LayoutPageTemplateEntry::getPreviewFileEntryId);
		attributeSetterBiConsumers.put("previewFileEntryId", (BiConsumer<LayoutPageTemplateEntry, Long>)LayoutPageTemplateEntry::setPreviewFileEntryId);
		attributeGetterFunctions.put("defaultTemplate", LayoutPageTemplateEntry::getDefaultTemplate);
		attributeSetterBiConsumers.put("defaultTemplate", (BiConsumer<LayoutPageTemplateEntry, Boolean>)LayoutPageTemplateEntry::setDefaultTemplate);
		attributeGetterFunctions.put("layoutPrototypeId", LayoutPageTemplateEntry::getLayoutPrototypeId);
		attributeSetterBiConsumers.put("layoutPrototypeId", (BiConsumer<LayoutPageTemplateEntry, Long>)LayoutPageTemplateEntry::setLayoutPrototypeId);
		attributeGetterFunctions.put("lastPublishDate", LayoutPageTemplateEntry::getLastPublishDate);
		attributeSetterBiConsumers.put("lastPublishDate", (BiConsumer<LayoutPageTemplateEntry, Date>)LayoutPageTemplateEntry::setLastPublishDate);
		attributeGetterFunctions.put("plid", LayoutPageTemplateEntry::getPlid);
		attributeSetterBiConsumers.put("plid", (BiConsumer<LayoutPageTemplateEntry, Long>)LayoutPageTemplateEntry::setPlid);
		attributeGetterFunctions.put("status", LayoutPageTemplateEntry::getStatus);
		attributeSetterBiConsumers.put("status", (BiConsumer<LayoutPageTemplateEntry, Integer>)LayoutPageTemplateEntry::setStatus);
		attributeGetterFunctions.put("statusByUserId", LayoutPageTemplateEntry::getStatusByUserId);
		attributeSetterBiConsumers.put("statusByUserId", (BiConsumer<LayoutPageTemplateEntry, Long>)LayoutPageTemplateEntry::setStatusByUserId);
		attributeGetterFunctions.put("statusByUserName", LayoutPageTemplateEntry::getStatusByUserName);
		attributeSetterBiConsumers.put("statusByUserName", (BiConsumer<LayoutPageTemplateEntry, String>)LayoutPageTemplateEntry::setStatusByUserName);
		attributeGetterFunctions.put("statusDate", LayoutPageTemplateEntry::getStatusDate);
		attributeSetterBiConsumers.put("statusDate", (BiConsumer<LayoutPageTemplateEntry, Date>)LayoutPageTemplateEntry::setStatusDate);


		_attributeGetterFunctions = Collections.unmodifiableMap(attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap((Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		_columnBitmask |= UUID_COLUMN_BITMASK;

		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getLayoutPageTemplateEntryId() {
		return _layoutPageTemplateEntryId;
	}

	@Override
	public void setLayoutPageTemplateEntryId(long layoutPageTemplateEntryId) {
		_layoutPageTemplateEntryId = layoutPageTemplateEntryId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getLayoutPageTemplateCollectionId() {
		return _layoutPageTemplateCollectionId;
	}

	@Override
	public void setLayoutPageTemplateCollectionId(
		long layoutPageTemplateCollectionId) {
		_columnBitmask |= LAYOUTPAGETEMPLATECOLLECTIONID_COLUMN_BITMASK;

		if (!_setOriginalLayoutPageTemplateCollectionId) {
			_setOriginalLayoutPageTemplateCollectionId = true;

			_originalLayoutPageTemplateCollectionId = _layoutPageTemplateCollectionId;
		}

		_layoutPageTemplateCollectionId = layoutPageTemplateCollectionId;
	}

	public long getOriginalLayoutPageTemplateCollectionId() {
		return _originalLayoutPageTemplateCollectionId;
	}

	@Override
	public String getClassName() {
		if (getClassNameId() <= 0) {
			return "";
		}

		return PortalUtil.getClassName(getClassNameId());
	}

	@Override
	public void setClassName(String className) {
		long classNameId = 0;

		if (Validator.isNotNull(className)) {
			classNameId = PortalUtil.getClassNameId(className);
		}

		setClassNameId(classNameId);
	}

	@JSON
	@Override
	public long getClassNameId() {
		return _classNameId;
	}

	@Override
	public void setClassNameId(long classNameId) {
		_columnBitmask |= CLASSNAMEID_COLUMN_BITMASK;

		if (!_setOriginalClassNameId) {
			_setOriginalClassNameId = true;

			_originalClassNameId = _classNameId;
		}

		_classNameId = classNameId;
	}

	public long getOriginalClassNameId() {
		return _originalClassNameId;
	}

	@JSON
	@Override
	public long getClassTypeId() {
		return _classTypeId;
	}

	@Override
	public void setClassTypeId(long classTypeId) {
		_columnBitmask |= CLASSTYPEID_COLUMN_BITMASK;

		if (!_setOriginalClassTypeId) {
			_setOriginalClassTypeId = true;

			_originalClassTypeId = _classTypeId;
		}

		_classTypeId = classTypeId;
	}

	public long getOriginalClassTypeId() {
		return _originalClassTypeId;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_columnBitmask = -1L;

		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
	}

	@JSON
	@Override
	public int getType() {
		return _type;
	}

	@Override
	public void setType(int type) {
		_columnBitmask |= TYPE_COLUMN_BITMASK;

		if (!_setOriginalType) {
			_setOriginalType = true;

			_originalType = _type;
		}

		_type = type;
	}

	public int getOriginalType() {
		return _originalType;
	}

	@JSON
	@Override
	public long getPreviewFileEntryId() {
		return _previewFileEntryId;
	}

	@Override
	public void setPreviewFileEntryId(long previewFileEntryId) {
		_previewFileEntryId = previewFileEntryId;
	}

	@JSON
	@Override
	public boolean getDefaultTemplate() {
		return _defaultTemplate;
	}

	@JSON
	@Override
	public boolean isDefaultTemplate() {
		return _defaultTemplate;
	}

	@Override
	public void setDefaultTemplate(boolean defaultTemplate) {
		_columnBitmask |= DEFAULTTEMPLATE_COLUMN_BITMASK;

		if (!_setOriginalDefaultTemplate) {
			_setOriginalDefaultTemplate = true;

			_originalDefaultTemplate = _defaultTemplate;
		}

		_defaultTemplate = defaultTemplate;
	}

	public boolean getOriginalDefaultTemplate() {
		return _originalDefaultTemplate;
	}

	@JSON
	@Override
	public long getLayoutPrototypeId() {
		return _layoutPrototypeId;
	}

	@Override
	public void setLayoutPrototypeId(long layoutPrototypeId) {
		_columnBitmask |= LAYOUTPROTOTYPEID_COLUMN_BITMASK;

		if (!_setOriginalLayoutPrototypeId) {
			_setOriginalLayoutPrototypeId = true;

			_originalLayoutPrototypeId = _layoutPrototypeId;
		}

		_layoutPrototypeId = layoutPrototypeId;
	}

	public long getOriginalLayoutPrototypeId() {
		return _originalLayoutPrototypeId;
	}

	@JSON
	@Override
	public Date getLastPublishDate() {
		return _lastPublishDate;
	}

	@Override
	public void setLastPublishDate(Date lastPublishDate) {
		_lastPublishDate = lastPublishDate;
	}

	@JSON
	@Override
	public long getPlid() {
		return _plid;
	}

	@Override
	public void setPlid(long plid) {
		_columnBitmask |= PLID_COLUMN_BITMASK;

		if (!_setOriginalPlid) {
			_setOriginalPlid = true;

			_originalPlid = _plid;
		}

		_plid = plid;
	}

	public long getOriginalPlid() {
		return _originalPlid;
	}

	@JSON
	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public int getOriginalStatus() {
		return _originalStatus;
	}

	@JSON
	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	@Override
	public String getStatusByUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getStatusByUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
	}

	@JSON
	@Override
	public String getStatusByUserName() {
		if (_statusByUserName == null) {
			return "";
		}
		else {
			return _statusByUserName;
		}
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	@JSON
	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				LayoutPageTemplateEntry.class.getName()), getClassNameId());
	}

	@Override
	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDenied() {
		if (getStatus() == WorkflowConstants.STATUS_DENIED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInactive() {
		if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isIncomplete() {
		if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isScheduled() {
		if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
			return true;
		}
		else {
			return false;
		}
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			LayoutPageTemplateEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public LayoutPageTemplateEntry toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (LayoutPageTemplateEntry)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		LayoutPageTemplateEntryImpl layoutPageTemplateEntryImpl = new LayoutPageTemplateEntryImpl();

		layoutPageTemplateEntryImpl.setUuid(getUuid());
		layoutPageTemplateEntryImpl.setLayoutPageTemplateEntryId(getLayoutPageTemplateEntryId());
		layoutPageTemplateEntryImpl.setGroupId(getGroupId());
		layoutPageTemplateEntryImpl.setCompanyId(getCompanyId());
		layoutPageTemplateEntryImpl.setUserId(getUserId());
		layoutPageTemplateEntryImpl.setUserName(getUserName());
		layoutPageTemplateEntryImpl.setCreateDate(getCreateDate());
		layoutPageTemplateEntryImpl.setModifiedDate(getModifiedDate());
		layoutPageTemplateEntryImpl.setLayoutPageTemplateCollectionId(getLayoutPageTemplateCollectionId());
		layoutPageTemplateEntryImpl.setClassNameId(getClassNameId());
		layoutPageTemplateEntryImpl.setClassTypeId(getClassTypeId());
		layoutPageTemplateEntryImpl.setName(getName());
		layoutPageTemplateEntryImpl.setType(getType());
		layoutPageTemplateEntryImpl.setPreviewFileEntryId(getPreviewFileEntryId());
		layoutPageTemplateEntryImpl.setDefaultTemplate(isDefaultTemplate());
		layoutPageTemplateEntryImpl.setLayoutPrototypeId(getLayoutPrototypeId());
		layoutPageTemplateEntryImpl.setLastPublishDate(getLastPublishDate());
		layoutPageTemplateEntryImpl.setPlid(getPlid());
		layoutPageTemplateEntryImpl.setStatus(getStatus());
		layoutPageTemplateEntryImpl.setStatusByUserId(getStatusByUserId());
		layoutPageTemplateEntryImpl.setStatusByUserName(getStatusByUserName());
		layoutPageTemplateEntryImpl.setStatusDate(getStatusDate());

		layoutPageTemplateEntryImpl.resetOriginalValues();

		return layoutPageTemplateEntryImpl;
	}

	@Override
	public int compareTo(LayoutPageTemplateEntry layoutPageTemplateEntry) {
		int value = 0;

		value = getName().compareTo(layoutPageTemplateEntry.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LayoutPageTemplateEntry)) {
			return false;
		}

		LayoutPageTemplateEntry layoutPageTemplateEntry = (LayoutPageTemplateEntry)obj;

		long primaryKey = layoutPageTemplateEntry.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		LayoutPageTemplateEntryModelImpl layoutPageTemplateEntryModelImpl = this;

		layoutPageTemplateEntryModelImpl._originalUuid = layoutPageTemplateEntryModelImpl._uuid;

		layoutPageTemplateEntryModelImpl._originalGroupId = layoutPageTemplateEntryModelImpl._groupId;

		layoutPageTemplateEntryModelImpl._setOriginalGroupId = false;

		layoutPageTemplateEntryModelImpl._originalCompanyId = layoutPageTemplateEntryModelImpl._companyId;

		layoutPageTemplateEntryModelImpl._setOriginalCompanyId = false;

		layoutPageTemplateEntryModelImpl._setModifiedDate = false;

		layoutPageTemplateEntryModelImpl._originalLayoutPageTemplateCollectionId = layoutPageTemplateEntryModelImpl._layoutPageTemplateCollectionId;

		layoutPageTemplateEntryModelImpl._setOriginalLayoutPageTemplateCollectionId = false;

		layoutPageTemplateEntryModelImpl._originalClassNameId = layoutPageTemplateEntryModelImpl._classNameId;

		layoutPageTemplateEntryModelImpl._setOriginalClassNameId = false;

		layoutPageTemplateEntryModelImpl._originalClassTypeId = layoutPageTemplateEntryModelImpl._classTypeId;

		layoutPageTemplateEntryModelImpl._setOriginalClassTypeId = false;

		layoutPageTemplateEntryModelImpl._originalName = layoutPageTemplateEntryModelImpl._name;

		layoutPageTemplateEntryModelImpl._originalType = layoutPageTemplateEntryModelImpl._type;

		layoutPageTemplateEntryModelImpl._setOriginalType = false;

		layoutPageTemplateEntryModelImpl._originalDefaultTemplate = layoutPageTemplateEntryModelImpl._defaultTemplate;

		layoutPageTemplateEntryModelImpl._setOriginalDefaultTemplate = false;

		layoutPageTemplateEntryModelImpl._originalLayoutPrototypeId = layoutPageTemplateEntryModelImpl._layoutPrototypeId;

		layoutPageTemplateEntryModelImpl._setOriginalLayoutPrototypeId = false;

		layoutPageTemplateEntryModelImpl._originalPlid = layoutPageTemplateEntryModelImpl._plid;

		layoutPageTemplateEntryModelImpl._setOriginalPlid = false;

		layoutPageTemplateEntryModelImpl._originalStatus = layoutPageTemplateEntryModelImpl._status;

		layoutPageTemplateEntryModelImpl._setOriginalStatus = false;

		layoutPageTemplateEntryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<LayoutPageTemplateEntry> toCacheModel() {
		LayoutPageTemplateEntryCacheModel layoutPageTemplateEntryCacheModel = new LayoutPageTemplateEntryCacheModel();

		layoutPageTemplateEntryCacheModel.uuid = getUuid();

		String uuid = layoutPageTemplateEntryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			layoutPageTemplateEntryCacheModel.uuid = null;
		}

		layoutPageTemplateEntryCacheModel.layoutPageTemplateEntryId = getLayoutPageTemplateEntryId();

		layoutPageTemplateEntryCacheModel.groupId = getGroupId();

		layoutPageTemplateEntryCacheModel.companyId = getCompanyId();

		layoutPageTemplateEntryCacheModel.userId = getUserId();

		layoutPageTemplateEntryCacheModel.userName = getUserName();

		String userName = layoutPageTemplateEntryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			layoutPageTemplateEntryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			layoutPageTemplateEntryCacheModel.createDate = createDate.getTime();
		}
		else {
			layoutPageTemplateEntryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			layoutPageTemplateEntryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			layoutPageTemplateEntryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		layoutPageTemplateEntryCacheModel.layoutPageTemplateCollectionId = getLayoutPageTemplateCollectionId();

		layoutPageTemplateEntryCacheModel.classNameId = getClassNameId();

		layoutPageTemplateEntryCacheModel.classTypeId = getClassTypeId();

		layoutPageTemplateEntryCacheModel.name = getName();

		String name = layoutPageTemplateEntryCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			layoutPageTemplateEntryCacheModel.name = null;
		}

		layoutPageTemplateEntryCacheModel.type = getType();

		layoutPageTemplateEntryCacheModel.previewFileEntryId = getPreviewFileEntryId();

		layoutPageTemplateEntryCacheModel.defaultTemplate = isDefaultTemplate();

		layoutPageTemplateEntryCacheModel.layoutPrototypeId = getLayoutPrototypeId();

		Date lastPublishDate = getLastPublishDate();

		if (lastPublishDate != null) {
			layoutPageTemplateEntryCacheModel.lastPublishDate = lastPublishDate.getTime();
		}
		else {
			layoutPageTemplateEntryCacheModel.lastPublishDate = Long.MIN_VALUE;
		}

		layoutPageTemplateEntryCacheModel.plid = getPlid();

		layoutPageTemplateEntryCacheModel.status = getStatus();

		layoutPageTemplateEntryCacheModel.statusByUserId = getStatusByUserId();

		layoutPageTemplateEntryCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = layoutPageTemplateEntryCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			layoutPageTemplateEntryCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			layoutPageTemplateEntryCacheModel.statusDate = statusDate.getTime();
		}
		else {
			layoutPageTemplateEntryCacheModel.statusDate = Long.MIN_VALUE;
		}

		return layoutPageTemplateEntryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<LayoutPageTemplateEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler((4 * attributeGetterFunctions.size()) +
				2);

		sb.append("{");

		for (Map.Entry<String, Function<LayoutPageTemplateEntry, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<LayoutPageTemplateEntry, Object> attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply(
					(LayoutPageTemplateEntry)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<LayoutPageTemplateEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler((5 * attributeGetterFunctions.size()) +
				4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<LayoutPageTemplateEntry, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<LayoutPageTemplateEntry, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply(
					(LayoutPageTemplateEntry)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = LayoutPageTemplateEntry.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			LayoutPageTemplateEntry.class, ModelWrapper.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _layoutPageTemplateEntryId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _layoutPageTemplateCollectionId;
	private long _originalLayoutPageTemplateCollectionId;
	private boolean _setOriginalLayoutPageTemplateCollectionId;
	private long _classNameId;
	private long _originalClassNameId;
	private boolean _setOriginalClassNameId;
	private long _classTypeId;
	private long _originalClassTypeId;
	private boolean _setOriginalClassTypeId;
	private String _name;
	private String _originalName;
	private int _type;
	private int _originalType;
	private boolean _setOriginalType;
	private long _previewFileEntryId;
	private boolean _defaultTemplate;
	private boolean _originalDefaultTemplate;
	private boolean _setOriginalDefaultTemplate;
	private long _layoutPrototypeId;
	private long _originalLayoutPrototypeId;
	private boolean _setOriginalLayoutPrototypeId;
	private Date _lastPublishDate;
	private long _plid;
	private long _originalPlid;
	private boolean _setOriginalPlid;
	private int _status;
	private int _originalStatus;
	private boolean _setOriginalStatus;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private long _columnBitmask;
	private LayoutPageTemplateEntry _escapedModel;
}