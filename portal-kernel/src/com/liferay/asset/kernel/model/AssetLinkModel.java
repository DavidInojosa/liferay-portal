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

package com.liferay.asset.kernel.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.ShardedModel;

import java.util.Date;

/**
 * The base model interface for the AssetLink service. Represents a row in the &quot;AssetLink&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.portlet.asset.model.impl.AssetLinkModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.portlet.asset.model.impl.AssetLinkImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssetLink
 * @generated
 */
@ProviderType
public interface AssetLinkModel extends BaseModel<AssetLink>, ShardedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a asset link model instance should use the {@link AssetLink} interface instead.
	 */

	/**
	 * Returns the primary key of this asset link.
	 *
	 * @return the primary key of this asset link
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this asset link.
	 *
	 * @param primaryKey the primary key of this asset link
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the link ID of this asset link.
	 *
	 * @return the link ID of this asset link
	 */
	public long getLinkId();

	/**
	 * Sets the link ID of this asset link.
	 *
	 * @param linkId the link ID of this asset link
	 */
	public void setLinkId(long linkId);

	/**
	 * Returns the company ID of this asset link.
	 *
	 * @return the company ID of this asset link
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this asset link.
	 *
	 * @param companyId the company ID of this asset link
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this asset link.
	 *
	 * @return the user ID of this asset link
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this asset link.
	 *
	 * @param userId the user ID of this asset link
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this asset link.
	 *
	 * @return the user uuid of this asset link
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this asset link.
	 *
	 * @param userUuid the user uuid of this asset link
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this asset link.
	 *
	 * @return the user name of this asset link
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this asset link.
	 *
	 * @param userName the user name of this asset link
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this asset link.
	 *
	 * @return the create date of this asset link
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this asset link.
	 *
	 * @param createDate the create date of this asset link
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the entry id1 of this asset link.
	 *
	 * @return the entry id1 of this asset link
	 */
	public long getEntryId1();

	/**
	 * Sets the entry id1 of this asset link.
	 *
	 * @param entryId1 the entry id1 of this asset link
	 */
	public void setEntryId1(long entryId1);

	/**
	 * Returns the entry id2 of this asset link.
	 *
	 * @return the entry id2 of this asset link
	 */
	public long getEntryId2();

	/**
	 * Sets the entry id2 of this asset link.
	 *
	 * @param entryId2 the entry id2 of this asset link
	 */
	public void setEntryId2(long entryId2);

	/**
	 * Returns the type of this asset link.
	 *
	 * @return the type of this asset link
	 */
	public int getType();

	/**
	 * Sets the type of this asset link.
	 *
	 * @param type the type of this asset link
	 */
	public void setType(int type);

	/**
	 * Returns the weight of this asset link.
	 *
	 * @return the weight of this asset link
	 */
	public int getWeight();

	/**
	 * Sets the weight of this asset link.
	 *
	 * @param weight the weight of this asset link
	 */
	public void setWeight(int weight);
}