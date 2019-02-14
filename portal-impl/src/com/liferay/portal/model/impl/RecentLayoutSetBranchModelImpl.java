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

package com.liferay.portal.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.petra.string.StringBundler;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.RecentLayoutSetBranch;
import com.liferay.portal.kernel.model.RecentLayoutSetBranchModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the RecentLayoutSetBranch service. Represents a row in the &quot;RecentLayoutSetBranch&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>RecentLayoutSetBranchModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link RecentLayoutSetBranchImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RecentLayoutSetBranchImpl
 * @generated
 */
@ProviderType
public class RecentLayoutSetBranchModelImpl extends BaseModelImpl<RecentLayoutSetBranch>
	implements RecentLayoutSetBranchModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a recent layout set branch model instance should use the <code>RecentLayoutSetBranch</code> interface instead.
	 */
	public static final String TABLE_NAME = "RecentLayoutSetBranch";
	public static final Object[][] TABLE_COLUMNS = {
			{ "mvccVersion", Types.BIGINT },
			{ "recentLayoutSetBranchId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "layoutSetBranchId", Types.BIGINT },
			{ "layoutSetId", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("recentLayoutSetBranchId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("layoutSetBranchId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("layoutSetId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table RecentLayoutSetBranch (mvccVersion LONG default 0 not null,recentLayoutSetBranchId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,layoutSetBranchId LONG,layoutSetId LONG)";
	public static final String TABLE_SQL_DROP = "drop table RecentLayoutSetBranch";
	public static final String ORDER_BY_JPQL = " ORDER BY recentLayoutSetBranch.recentLayoutSetBranchId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY RecentLayoutSetBranch.recentLayoutSetBranchId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portal.kernel.model.RecentLayoutSetBranch"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portal.kernel.model.RecentLayoutSetBranch"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.liferay.portal.kernel.model.RecentLayoutSetBranch"),
			true);
	public static final long GROUPID_COLUMN_BITMASK = 1L;
	public static final long LAYOUTSETBRANCHID_COLUMN_BITMASK = 2L;
	public static final long LAYOUTSETID_COLUMN_BITMASK = 4L;
	public static final long USERID_COLUMN_BITMASK = 8L;
	public static final long RECENTLAYOUTSETBRANCHID_COLUMN_BITMASK = 16L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portal.kernel.model.RecentLayoutSetBranch"));

	public RecentLayoutSetBranchModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _recentLayoutSetBranchId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRecentLayoutSetBranchId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _recentLayoutSetBranchId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return RecentLayoutSetBranch.class;
	}

	@Override
	public String getModelClassName() {
		return RecentLayoutSetBranch.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<RecentLayoutSetBranch, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<RecentLayoutSetBranch, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<RecentLayoutSetBranch, Object> attributeGetterFunction = entry.getValue();

			attributes.put(attributeName,
				attributeGetterFunction.apply((RecentLayoutSetBranch)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<RecentLayoutSetBranch, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<RecentLayoutSetBranch, Object> attributeSetterBiConsumer = attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((RecentLayoutSetBranch)this,
					entry.getValue());
			}
		}
	}

	public Map<String, Function<RecentLayoutSetBranch, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<RecentLayoutSetBranch, Object>> getAttributeSetterBiConsumers() {
		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<RecentLayoutSetBranch, Object>> _attributeGetterFunctions;
	private static final Map<String, BiConsumer<RecentLayoutSetBranch, Object>> _attributeSetterBiConsumers;

	static {
		Map<String, Function<RecentLayoutSetBranch, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<RecentLayoutSetBranch, Object>>();
		Map<String, BiConsumer<RecentLayoutSetBranch, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<RecentLayoutSetBranch, ?>>();


		attributeGetterFunctions.put("mvccVersion", RecentLayoutSetBranch::getMvccVersion);
		attributeSetterBiConsumers.put("mvccVersion", (BiConsumer<RecentLayoutSetBranch, Long>)RecentLayoutSetBranch::setMvccVersion);
		attributeGetterFunctions.put("recentLayoutSetBranchId", RecentLayoutSetBranch::getRecentLayoutSetBranchId);
		attributeSetterBiConsumers.put("recentLayoutSetBranchId", (BiConsumer<RecentLayoutSetBranch, Long>)RecentLayoutSetBranch::setRecentLayoutSetBranchId);
		attributeGetterFunctions.put("groupId", RecentLayoutSetBranch::getGroupId);
		attributeSetterBiConsumers.put("groupId", (BiConsumer<RecentLayoutSetBranch, Long>)RecentLayoutSetBranch::setGroupId);
		attributeGetterFunctions.put("companyId", RecentLayoutSetBranch::getCompanyId);
		attributeSetterBiConsumers.put("companyId", (BiConsumer<RecentLayoutSetBranch, Long>)RecentLayoutSetBranch::setCompanyId);
		attributeGetterFunctions.put("userId", RecentLayoutSetBranch::getUserId);
		attributeSetterBiConsumers.put("userId", (BiConsumer<RecentLayoutSetBranch, Long>)RecentLayoutSetBranch::setUserId);
		attributeGetterFunctions.put("layoutSetBranchId", RecentLayoutSetBranch::getLayoutSetBranchId);
		attributeSetterBiConsumers.put("layoutSetBranchId", (BiConsumer<RecentLayoutSetBranch, Long>)RecentLayoutSetBranch::setLayoutSetBranchId);
		attributeGetterFunctions.put("layoutSetId", RecentLayoutSetBranch::getLayoutSetId);
		attributeSetterBiConsumers.put("layoutSetId", (BiConsumer<RecentLayoutSetBranch, Long>)RecentLayoutSetBranch::setLayoutSetId);


		_attributeGetterFunctions = Collections.unmodifiableMap(attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap((Map)attributeSetterBiConsumers);
	}

	@Override
	public long getMvccVersion() {
		return _mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	@Override
	public long getRecentLayoutSetBranchId() {
		return _recentLayoutSetBranchId;
	}

	@Override
	public void setRecentLayoutSetBranchId(long recentLayoutSetBranchId) {
		_recentLayoutSetBranchId = recentLayoutSetBranchId;
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
		_companyId = companyId;
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
	public long getLayoutSetBranchId() {
		return _layoutSetBranchId;
	}

	@Override
	public void setLayoutSetBranchId(long layoutSetBranchId) {
		_columnBitmask |= LAYOUTSETBRANCHID_COLUMN_BITMASK;

		if (!_setOriginalLayoutSetBranchId) {
			_setOriginalLayoutSetBranchId = true;

			_originalLayoutSetBranchId = _layoutSetBranchId;
		}

		_layoutSetBranchId = layoutSetBranchId;
	}

	public long getOriginalLayoutSetBranchId() {
		return _originalLayoutSetBranchId;
	}

	@Override
	public long getLayoutSetId() {
		return _layoutSetId;
	}

	@Override
	public void setLayoutSetId(long layoutSetId) {
		_columnBitmask |= LAYOUTSETID_COLUMN_BITMASK;

		if (!_setOriginalLayoutSetId) {
			_setOriginalLayoutSetId = true;

			_originalLayoutSetId = _layoutSetId;
		}

		_layoutSetId = layoutSetId;
	}

	public long getOriginalLayoutSetId() {
		return _originalLayoutSetId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			RecentLayoutSetBranch.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public RecentLayoutSetBranch toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (RecentLayoutSetBranch)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		RecentLayoutSetBranchImpl recentLayoutSetBranchImpl = new RecentLayoutSetBranchImpl();

		recentLayoutSetBranchImpl.setMvccVersion(getMvccVersion());
		recentLayoutSetBranchImpl.setRecentLayoutSetBranchId(getRecentLayoutSetBranchId());
		recentLayoutSetBranchImpl.setGroupId(getGroupId());
		recentLayoutSetBranchImpl.setCompanyId(getCompanyId());
		recentLayoutSetBranchImpl.setUserId(getUserId());
		recentLayoutSetBranchImpl.setLayoutSetBranchId(getLayoutSetBranchId());
		recentLayoutSetBranchImpl.setLayoutSetId(getLayoutSetId());

		recentLayoutSetBranchImpl.resetOriginalValues();

		return recentLayoutSetBranchImpl;
	}

	@Override
	public int compareTo(RecentLayoutSetBranch recentLayoutSetBranch) {
		long primaryKey = recentLayoutSetBranch.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RecentLayoutSetBranch)) {
			return false;
		}

		RecentLayoutSetBranch recentLayoutSetBranch = (RecentLayoutSetBranch)obj;

		long primaryKey = recentLayoutSetBranch.getPrimaryKey();

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
		RecentLayoutSetBranchModelImpl recentLayoutSetBranchModelImpl = this;

		recentLayoutSetBranchModelImpl._originalGroupId = recentLayoutSetBranchModelImpl._groupId;

		recentLayoutSetBranchModelImpl._setOriginalGroupId = false;

		recentLayoutSetBranchModelImpl._originalUserId = recentLayoutSetBranchModelImpl._userId;

		recentLayoutSetBranchModelImpl._setOriginalUserId = false;

		recentLayoutSetBranchModelImpl._originalLayoutSetBranchId = recentLayoutSetBranchModelImpl._layoutSetBranchId;

		recentLayoutSetBranchModelImpl._setOriginalLayoutSetBranchId = false;

		recentLayoutSetBranchModelImpl._originalLayoutSetId = recentLayoutSetBranchModelImpl._layoutSetId;

		recentLayoutSetBranchModelImpl._setOriginalLayoutSetId = false;

		recentLayoutSetBranchModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<RecentLayoutSetBranch> toCacheModel() {
		RecentLayoutSetBranchCacheModel recentLayoutSetBranchCacheModel = new RecentLayoutSetBranchCacheModel();

		recentLayoutSetBranchCacheModel.mvccVersion = getMvccVersion();

		recentLayoutSetBranchCacheModel.recentLayoutSetBranchId = getRecentLayoutSetBranchId();

		recentLayoutSetBranchCacheModel.groupId = getGroupId();

		recentLayoutSetBranchCacheModel.companyId = getCompanyId();

		recentLayoutSetBranchCacheModel.userId = getUserId();

		recentLayoutSetBranchCacheModel.layoutSetBranchId = getLayoutSetBranchId();

		recentLayoutSetBranchCacheModel.layoutSetId = getLayoutSetId();

		return recentLayoutSetBranchCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<RecentLayoutSetBranch, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler((4 * attributeGetterFunctions.size()) +
				2);

		sb.append("{");

		for (Map.Entry<String, Function<RecentLayoutSetBranch, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<RecentLayoutSetBranch, Object> attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((RecentLayoutSetBranch)this));
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
		Map<String, Function<RecentLayoutSetBranch, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler((5 * attributeGetterFunctions.size()) +
				4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<RecentLayoutSetBranch, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<RecentLayoutSetBranch, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((RecentLayoutSetBranch)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = RecentLayoutSetBranch.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			RecentLayoutSetBranch.class, ModelWrapper.class
		};
	private long _mvccVersion;
	private long _recentLayoutSetBranchId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private long _layoutSetBranchId;
	private long _originalLayoutSetBranchId;
	private boolean _setOriginalLayoutSetBranchId;
	private long _layoutSetId;
	private long _originalLayoutSetId;
	private boolean _setOriginalLayoutSetId;
	private long _columnBitmask;
	private RecentLayoutSetBranch _escapedModel;
}