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

package com.liferay.document.library.file.rank.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.document.library.file.rank.model.DLFileRank;
import com.liferay.document.library.file.rank.model.DLFileRankModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.petra.string.StringBundler;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the DLFileRank service. Represents a row in the &quot;DLFileRank&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>DLFileRankModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DLFileRankImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DLFileRankImpl
 * @generated
 */
@ProviderType
public class DLFileRankModelImpl extends BaseModelImpl<DLFileRank>
	implements DLFileRankModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a document library file rank model instance should use the <code>DLFileRank</code> interface instead.
	 */
	public static final String TABLE_NAME = "DLFileRank";
	public static final Object[][] TABLE_COLUMNS = {
			{ "fileRankId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "fileEntryId", Types.BIGINT },
			{ "active_", Types.BOOLEAN }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("fileRankId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("fileEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("active_", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE = "create table DLFileRank (fileRankId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,createDate DATE null,fileEntryId LONG,active_ BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table DLFileRank";
	public static final String ORDER_BY_JPQL = " ORDER BY dlFileRank.createDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY DLFileRank.createDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.document.library.file.rank.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.document.library.file.rank.model.DLFileRank"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.document.library.file.rank.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.document.library.file.rank.model.DLFileRank"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.document.library.file.rank.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.document.library.file.rank.model.DLFileRank"),
			true);
	public static final long ACTIVE_COLUMN_BITMASK = 1L;
	public static final long COMPANYID_COLUMN_BITMASK = 2L;
	public static final long FILEENTRYID_COLUMN_BITMASK = 4L;
	public static final long GROUPID_COLUMN_BITMASK = 8L;
	public static final long USERID_COLUMN_BITMASK = 16L;
	public static final long CREATEDATE_COLUMN_BITMASK = 32L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.document.library.file.rank.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.document.library.file.rank.model.DLFileRank"));

	public DLFileRankModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _fileRankId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFileRankId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _fileRankId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DLFileRank.class;
	}

	@Override
	public String getModelClassName() {
		return DLFileRank.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<DLFileRank, Object>> attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<DLFileRank, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<DLFileRank, Object> attributeGetterFunction = entry.getValue();

			attributes.put(attributeName,
				attributeGetterFunction.apply((DLFileRank)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<DLFileRank, Object>> attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<DLFileRank, Object> attributeSetterBiConsumer = attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((DLFileRank)this,
					entry.getValue());
			}
		}
	}

	public Map<String, Function<DLFileRank, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<DLFileRank, Object>> getAttributeSetterBiConsumers() {
		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<DLFileRank, Object>> _attributeGetterFunctions;
	private static final Map<String, BiConsumer<DLFileRank, Object>> _attributeSetterBiConsumers;

	static {
		Map<String, Function<DLFileRank, Object>> attributeGetterFunctions = new LinkedHashMap<String, Function<DLFileRank, Object>>();
		Map<String, BiConsumer<DLFileRank, ?>> attributeSetterBiConsumers = new LinkedHashMap<String, BiConsumer<DLFileRank, ?>>();


		attributeGetterFunctions.put("fileRankId", DLFileRank::getFileRankId);
		attributeSetterBiConsumers.put("fileRankId", (BiConsumer<DLFileRank, Long>)DLFileRank::setFileRankId);
		attributeGetterFunctions.put("groupId", DLFileRank::getGroupId);
		attributeSetterBiConsumers.put("groupId", (BiConsumer<DLFileRank, Long>)DLFileRank::setGroupId);
		attributeGetterFunctions.put("companyId", DLFileRank::getCompanyId);
		attributeSetterBiConsumers.put("companyId", (BiConsumer<DLFileRank, Long>)DLFileRank::setCompanyId);
		attributeGetterFunctions.put("userId", DLFileRank::getUserId);
		attributeSetterBiConsumers.put("userId", (BiConsumer<DLFileRank, Long>)DLFileRank::setUserId);
		attributeGetterFunctions.put("createDate", DLFileRank::getCreateDate);
		attributeSetterBiConsumers.put("createDate", (BiConsumer<DLFileRank, Date>)DLFileRank::setCreateDate);
		attributeGetterFunctions.put("fileEntryId", DLFileRank::getFileEntryId);
		attributeSetterBiConsumers.put("fileEntryId", (BiConsumer<DLFileRank, Long>)DLFileRank::setFileEntryId);
		attributeGetterFunctions.put("active", DLFileRank::getActive);
		attributeSetterBiConsumers.put("active", (BiConsumer<DLFileRank, Boolean>)DLFileRank::setActive);


		_attributeGetterFunctions = Collections.unmodifiableMap(attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap((Map)attributeSetterBiConsumers);
	}

	@Override
	public long getFileRankId() {
		return _fileRankId;
	}

	@Override
	public void setFileRankId(long fileRankId) {
		_fileRankId = fileRankId;
	}

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

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

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

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_columnBitmask = -1L;

		_createDate = createDate;
	}

	@Override
	public long getFileEntryId() {
		return _fileEntryId;
	}

	@Override
	public void setFileEntryId(long fileEntryId) {
		_columnBitmask |= FILEENTRYID_COLUMN_BITMASK;

		if (!_setOriginalFileEntryId) {
			_setOriginalFileEntryId = true;

			_originalFileEntryId = _fileEntryId;
		}

		_fileEntryId = fileEntryId;
	}

	public long getOriginalFileEntryId() {
		return _originalFileEntryId;
	}

	@Override
	public boolean getActive() {
		return _active;
	}

	@Override
	public boolean isActive() {
		return _active;
	}

	@Override
	public void setActive(boolean active) {
		_columnBitmask |= ACTIVE_COLUMN_BITMASK;

		if (!_setOriginalActive) {
			_setOriginalActive = true;

			_originalActive = _active;
		}

		_active = active;
	}

	public boolean getOriginalActive() {
		return _originalActive;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			DLFileRank.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DLFileRank toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (DLFileRank)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DLFileRankImpl dlFileRankImpl = new DLFileRankImpl();

		dlFileRankImpl.setFileRankId(getFileRankId());
		dlFileRankImpl.setGroupId(getGroupId());
		dlFileRankImpl.setCompanyId(getCompanyId());
		dlFileRankImpl.setUserId(getUserId());
		dlFileRankImpl.setCreateDate(getCreateDate());
		dlFileRankImpl.setFileEntryId(getFileEntryId());
		dlFileRankImpl.setActive(isActive());

		dlFileRankImpl.resetOriginalValues();

		return dlFileRankImpl;
	}

	@Override
	public int compareTo(DLFileRank dlFileRank) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), dlFileRank.getCreateDate());

		value = value * -1;

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

		if (!(obj instanceof DLFileRank)) {
			return false;
		}

		DLFileRank dlFileRank = (DLFileRank)obj;

		long primaryKey = dlFileRank.getPrimaryKey();

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
		DLFileRankModelImpl dlFileRankModelImpl = this;

		dlFileRankModelImpl._originalGroupId = dlFileRankModelImpl._groupId;

		dlFileRankModelImpl._setOriginalGroupId = false;

		dlFileRankModelImpl._originalCompanyId = dlFileRankModelImpl._companyId;

		dlFileRankModelImpl._setOriginalCompanyId = false;

		dlFileRankModelImpl._originalUserId = dlFileRankModelImpl._userId;

		dlFileRankModelImpl._setOriginalUserId = false;

		dlFileRankModelImpl._originalFileEntryId = dlFileRankModelImpl._fileEntryId;

		dlFileRankModelImpl._setOriginalFileEntryId = false;

		dlFileRankModelImpl._originalActive = dlFileRankModelImpl._active;

		dlFileRankModelImpl._setOriginalActive = false;

		dlFileRankModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DLFileRank> toCacheModel() {
		DLFileRankCacheModel dlFileRankCacheModel = new DLFileRankCacheModel();

		dlFileRankCacheModel.fileRankId = getFileRankId();

		dlFileRankCacheModel.groupId = getGroupId();

		dlFileRankCacheModel.companyId = getCompanyId();

		dlFileRankCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			dlFileRankCacheModel.createDate = createDate.getTime();
		}
		else {
			dlFileRankCacheModel.createDate = Long.MIN_VALUE;
		}

		dlFileRankCacheModel.fileEntryId = getFileEntryId();

		dlFileRankCacheModel.active = isActive();

		return dlFileRankCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<DLFileRank, Object>> attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler((4 * attributeGetterFunctions.size()) +
				2);

		sb.append("{");

		for (Map.Entry<String, Function<DLFileRank, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<DLFileRank, Object> attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((DLFileRank)this));
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
		Map<String, Function<DLFileRank, Object>> attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler((5 * attributeGetterFunctions.size()) +
				4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<DLFileRank, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<DLFileRank, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((DLFileRank)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = DLFileRank.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			DLFileRank.class, ModelWrapper.class
		};
	private long _fileRankId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private Date _createDate;
	private long _fileEntryId;
	private long _originalFileEntryId;
	private boolean _setOriginalFileEntryId;
	private boolean _active;
	private boolean _originalActive;
	private boolean _setOriginalActive;
	private long _columnBitmask;
	private DLFileRank _escapedModel;
}