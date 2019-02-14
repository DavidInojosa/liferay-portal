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
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.CompanyModel;
import com.liferay.portal.kernel.model.CompanySoap;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Company service. Represents a row in the &quot;Company&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>CompanyModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CompanyImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CompanyImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class CompanyModelImpl extends BaseModelImpl<Company>
	implements CompanyModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a company model instance should use the <code>Company</code> interface instead.
	 */
	public static final String TABLE_NAME = "Company";
	public static final Object[][] TABLE_COLUMNS = {
			{ "mvccVersion", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "accountId", Types.BIGINT },
			{ "webId", Types.VARCHAR },
			{ "key_", Types.CLOB },
			{ "mx", Types.VARCHAR },
			{ "homeURL", Types.VARCHAR },
			{ "logoId", Types.BIGINT },
			{ "system", Types.BOOLEAN },
			{ "maxUsers", Types.INTEGER },
			{ "active_", Types.BOOLEAN }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("accountId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("webId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("key_", Types.CLOB);
		TABLE_COLUMNS_MAP.put("mx", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("homeURL", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("logoId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("system", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("maxUsers", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("active_", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE = "create table Company (mvccVersion LONG default 0 not null,companyId LONG not null primary key,accountId LONG,webId VARCHAR(75) null,key_ TEXT null,mx VARCHAR(200) null,homeURL STRING null,logoId LONG,system BOOLEAN,maxUsers INTEGER,active_ BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table Company";
	public static final String ORDER_BY_JPQL = " ORDER BY company.companyId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Company.companyId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portal.kernel.model.Company"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portal.kernel.model.Company"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.liferay.portal.kernel.model.Company"),
			true);
	public static final long LOGOID_COLUMN_BITMASK = 1L;
	public static final long MX_COLUMN_BITMASK = 2L;
	public static final long SYSTEM_COLUMN_BITMASK = 4L;
	public static final long WEBID_COLUMN_BITMASK = 8L;
	public static final long COMPANYID_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Company toModel(CompanySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Company model = new CompanyImpl();

		model.setMvccVersion(soapModel.getMvccVersion());
		model.setCompanyId(soapModel.getCompanyId());
		model.setAccountId(soapModel.getAccountId());
		model.setWebId(soapModel.getWebId());
		model.setKey(soapModel.getKey());
		model.setMx(soapModel.getMx());
		model.setHomeURL(soapModel.getHomeURL());
		model.setLogoId(soapModel.getLogoId());
		model.setSystem(soapModel.isSystem());
		model.setMaxUsers(soapModel.getMaxUsers());
		model.setActive(soapModel.isActive());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Company> toModels(CompanySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Company> models = new ArrayList<Company>(soapModels.length);

		for (CompanySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portal.kernel.model.Company"));

	public CompanyModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _companyId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCompanyId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _companyId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Company.class;
	}

	@Override
	public String getModelClassName() {
		return Company.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Company, Object>> attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Company, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<Company, Object> attributeGetterFunction = entry.getValue();

			attributes.put(attributeName,
				attributeGetterFunction.apply((Company)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Company, Object>> attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Company, Object> attributeSetterBiConsumer = attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((Company)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Company, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Company, Object>> getAttributeSetterBiConsumers() {
		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<Company, Object>> _attributeGetterFunctions;
	private static final Map<String, BiConsumer<Company, Object>> _attributeSetterBiConsumers;

	static {
		Map<String, Function<Company, Object>> attributeGetterFunctions = new LinkedHashMap<String, Function<Company, Object>>();
		Map<String, BiConsumer<Company, ?>> attributeSetterBiConsumers = new LinkedHashMap<String, BiConsumer<Company, ?>>();


		attributeGetterFunctions.put("mvccVersion", Company::getMvccVersion);
		attributeSetterBiConsumers.put("mvccVersion", (BiConsumer<Company, Long>)Company::setMvccVersion);
		attributeGetterFunctions.put("companyId", Company::getCompanyId);
		attributeSetterBiConsumers.put("companyId", (BiConsumer<Company, Long>)Company::setCompanyId);
		attributeGetterFunctions.put("accountId", Company::getAccountId);
		attributeSetterBiConsumers.put("accountId", (BiConsumer<Company, Long>)Company::setAccountId);
		attributeGetterFunctions.put("webId", Company::getWebId);
		attributeSetterBiConsumers.put("webId", (BiConsumer<Company, String>)Company::setWebId);
		attributeGetterFunctions.put("key", Company::getKey);
		attributeSetterBiConsumers.put("key", (BiConsumer<Company, String>)Company::setKey);
		attributeGetterFunctions.put("mx", Company::getMx);
		attributeSetterBiConsumers.put("mx", (BiConsumer<Company, String>)Company::setMx);
		attributeGetterFunctions.put("homeURL", Company::getHomeURL);
		attributeSetterBiConsumers.put("homeURL", (BiConsumer<Company, String>)Company::setHomeURL);
		attributeGetterFunctions.put("logoId", Company::getLogoId);
		attributeSetterBiConsumers.put("logoId", (BiConsumer<Company, Long>)Company::setLogoId);
		attributeGetterFunctions.put("system", Company::getSystem);
		attributeSetterBiConsumers.put("system", (BiConsumer<Company, Boolean>)Company::setSystem);
		attributeGetterFunctions.put("maxUsers", Company::getMaxUsers);
		attributeSetterBiConsumers.put("maxUsers", (BiConsumer<Company, Integer>)Company::setMaxUsers);
		attributeGetterFunctions.put("active", Company::getActive);
		attributeSetterBiConsumers.put("active", (BiConsumer<Company, Boolean>)Company::setActive);


		_attributeGetterFunctions = Collections.unmodifiableMap(attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap((Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getMvccVersion() {
		return _mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getAccountId() {
		return _accountId;
	}

	@Override
	public void setAccountId(long accountId) {
		_accountId = accountId;
	}

	@JSON
	@Override
	public String getWebId() {
		if (_webId == null) {
			return "";
		}
		else {
			return _webId;
		}
	}

	@Override
	public void setWebId(String webId) {
		_columnBitmask |= WEBID_COLUMN_BITMASK;

		if (_originalWebId == null) {
			_originalWebId = _webId;
		}

		_webId = webId;
	}

	public String getOriginalWebId() {
		return GetterUtil.getString(_originalWebId);
	}

	@JSON
	@Override
	public String getKey() {
		if (_key == null) {
			return "";
		}
		else {
			return _key;
		}
	}

	@Override
	public void setKey(String key) {
		_key = key;
	}

	@JSON
	@Override
	public String getMx() {
		if (_mx == null) {
			return "";
		}
		else {
			return _mx;
		}
	}

	@Override
	public void setMx(String mx) {
		_columnBitmask |= MX_COLUMN_BITMASK;

		if (_originalMx == null) {
			_originalMx = _mx;
		}

		_mx = mx;
	}

	public String getOriginalMx() {
		return GetterUtil.getString(_originalMx);
	}

	@JSON
	@Override
	public String getHomeURL() {
		if (_homeURL == null) {
			return "";
		}
		else {
			return _homeURL;
		}
	}

	@Override
	public void setHomeURL(String homeURL) {
		_homeURL = homeURL;
	}

	@JSON
	@Override
	public long getLogoId() {
		return _logoId;
	}

	@Override
	public void setLogoId(long logoId) {
		_columnBitmask |= LOGOID_COLUMN_BITMASK;

		if (!_setOriginalLogoId) {
			_setOriginalLogoId = true;

			_originalLogoId = _logoId;
		}

		_logoId = logoId;
	}

	public long getOriginalLogoId() {
		return _originalLogoId;
	}

	@JSON
	@Override
	public boolean getSystem() {
		return _system;
	}

	@JSON
	@Override
	public boolean isSystem() {
		return _system;
	}

	@Override
	public void setSystem(boolean system) {
		_columnBitmask |= SYSTEM_COLUMN_BITMASK;

		if (!_setOriginalSystem) {
			_setOriginalSystem = true;

			_originalSystem = _system;
		}

		_system = system;
	}

	public boolean getOriginalSystem() {
		return _originalSystem;
	}

	@JSON
	@Override
	public int getMaxUsers() {
		return _maxUsers;
	}

	@Override
	public void setMaxUsers(int maxUsers) {
		_maxUsers = maxUsers;
	}

	@JSON
	@Override
	public boolean getActive() {
		return _active;
	}

	@JSON
	@Override
	public boolean isActive() {
		return _active;
	}

	@Override
	public void setActive(boolean active) {
		_active = active;
	}

	public CompanyImpl.CompanySecurityBag getCompanySecurityBag() {
		return null;
	}

	public void setCompanySecurityBag(
		CompanyImpl.CompanySecurityBag companySecurityBag) {
	}

	public java.security.Key getKeyObj() {
		return null;
	}

	public void setKeyObj(java.security.Key keyObj) {
	}

	public String getVirtualHostname() {
		return null;
	}

	public void setVirtualHostname(String virtualHostname) {
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Company.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Company toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Company)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CompanyImpl companyImpl = new CompanyImpl();

		companyImpl.setMvccVersion(getMvccVersion());
		companyImpl.setCompanyId(getCompanyId());
		companyImpl.setAccountId(getAccountId());
		companyImpl.setWebId(getWebId());
		companyImpl.setKey(getKey());
		companyImpl.setMx(getMx());
		companyImpl.setHomeURL(getHomeURL());
		companyImpl.setLogoId(getLogoId());
		companyImpl.setSystem(isSystem());
		companyImpl.setMaxUsers(getMaxUsers());
		companyImpl.setActive(isActive());

		companyImpl.resetOriginalValues();

		return companyImpl;
	}

	@Override
	public int compareTo(Company company) {
		long primaryKey = company.getPrimaryKey();

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

		if (!(obj instanceof Company)) {
			return false;
		}

		Company company = (Company)obj;

		long primaryKey = company.getPrimaryKey();

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
		CompanyModelImpl companyModelImpl = this;

		companyModelImpl._originalWebId = companyModelImpl._webId;

		companyModelImpl._originalMx = companyModelImpl._mx;

		companyModelImpl._originalLogoId = companyModelImpl._logoId;

		companyModelImpl._setOriginalLogoId = false;

		companyModelImpl._originalSystem = companyModelImpl._system;

		companyModelImpl._setOriginalSystem = false;

		setCompanySecurityBag(null);

		setKeyObj(null);

		setVirtualHostname(null);

		companyModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Company> toCacheModel() {
		CompanyCacheModel companyCacheModel = new CompanyCacheModel();

		companyCacheModel.mvccVersion = getMvccVersion();

		companyCacheModel.companyId = getCompanyId();

		companyCacheModel.accountId = getAccountId();

		companyCacheModel.webId = getWebId();

		String webId = companyCacheModel.webId;

		if ((webId != null) && (webId.length() == 0)) {
			companyCacheModel.webId = null;
		}

		companyCacheModel.key = getKey();

		String key = companyCacheModel.key;

		if ((key != null) && (key.length() == 0)) {
			companyCacheModel.key = null;
		}

		companyCacheModel.mx = getMx();

		String mx = companyCacheModel.mx;

		if ((mx != null) && (mx.length() == 0)) {
			companyCacheModel.mx = null;
		}

		companyCacheModel.homeURL = getHomeURL();

		String homeURL = companyCacheModel.homeURL;

		if ((homeURL != null) && (homeURL.length() == 0)) {
			companyCacheModel.homeURL = null;
		}

		companyCacheModel.logoId = getLogoId();

		companyCacheModel.system = isSystem();

		companyCacheModel.maxUsers = getMaxUsers();

		companyCacheModel.active = isActive();

		companyCacheModel._companySecurityBag = getCompanySecurityBag();

		companyCacheModel._keyObj = getKeyObj();

		companyCacheModel._virtualHostname = getVirtualHostname();

		return companyCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Company, Object>> attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler((4 * attributeGetterFunctions.size()) +
				2);

		sb.append("{");

		for (Map.Entry<String, Function<Company, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<Company, Object> attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Company)this));
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
		Map<String, Function<Company, Object>> attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler((5 * attributeGetterFunctions.size()) +
				4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Company, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<Company, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Company)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Company.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Company.class, ModelWrapper.class
		};
	private long _mvccVersion;
	private long _companyId;
	private long _accountId;
	private String _webId;
	private String _originalWebId;
	private String _key;
	private String _mx;
	private String _originalMx;
	private String _homeURL;
	private long _logoId;
	private long _originalLogoId;
	private boolean _setOriginalLogoId;
	private boolean _system;
	private boolean _originalSystem;
	private boolean _setOriginalSystem;
	private int _maxUsers;
	private boolean _active;
	private long _columnBitmask;
	private Company _escapedModel;
}