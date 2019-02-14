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

package com.liferay.portal.kernel.model;

import aQute.bnd.annotation.ProviderType;

/**
 * The base model interface for the RecentLayoutBranch service. Represents a row in the &quot;RecentLayoutBranch&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.portal.model.impl.RecentLayoutBranchModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.portal.model.impl.RecentLayoutBranchImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RecentLayoutBranch
 * @generated
 */
@ProviderType
public interface RecentLayoutBranchModel extends BaseModel<RecentLayoutBranch>,
	MVCCModel, ShardedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a recent layout branch model instance should use the {@link RecentLayoutBranch} interface instead.
	 */

	/**
	 * Returns the primary key of this recent layout branch.
	 *
	 * @return the primary key of this recent layout branch
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this recent layout branch.
	 *
	 * @param primaryKey the primary key of this recent layout branch
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this recent layout branch.
	 *
	 * @return the mvcc version of this recent layout branch
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this recent layout branch.
	 *
	 * @param mvccVersion the mvcc version of this recent layout branch
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the recent layout branch ID of this recent layout branch.
	 *
	 * @return the recent layout branch ID of this recent layout branch
	 */
	public long getRecentLayoutBranchId();

	/**
	 * Sets the recent layout branch ID of this recent layout branch.
	 *
	 * @param recentLayoutBranchId the recent layout branch ID of this recent layout branch
	 */
	public void setRecentLayoutBranchId(long recentLayoutBranchId);

	/**
	 * Returns the group ID of this recent layout branch.
	 *
	 * @return the group ID of this recent layout branch
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this recent layout branch.
	 *
	 * @param groupId the group ID of this recent layout branch
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this recent layout branch.
	 *
	 * @return the company ID of this recent layout branch
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this recent layout branch.
	 *
	 * @param companyId the company ID of this recent layout branch
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this recent layout branch.
	 *
	 * @return the user ID of this recent layout branch
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this recent layout branch.
	 *
	 * @param userId the user ID of this recent layout branch
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this recent layout branch.
	 *
	 * @return the user uuid of this recent layout branch
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this recent layout branch.
	 *
	 * @param userUuid the user uuid of this recent layout branch
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the layout branch ID of this recent layout branch.
	 *
	 * @return the layout branch ID of this recent layout branch
	 */
	public long getLayoutBranchId();

	/**
	 * Sets the layout branch ID of this recent layout branch.
	 *
	 * @param layoutBranchId the layout branch ID of this recent layout branch
	 */
	public void setLayoutBranchId(long layoutBranchId);

	/**
	 * Returns the layout set branch ID of this recent layout branch.
	 *
	 * @return the layout set branch ID of this recent layout branch
	 */
	public long getLayoutSetBranchId();

	/**
	 * Sets the layout set branch ID of this recent layout branch.
	 *
	 * @param layoutSetBranchId the layout set branch ID of this recent layout branch
	 */
	public void setLayoutSetBranchId(long layoutSetBranchId);

	/**
	 * Returns the plid of this recent layout branch.
	 *
	 * @return the plid of this recent layout branch
	 */
	public long getPlid();

	/**
	 * Sets the plid of this recent layout branch.
	 *
	 * @param plid the plid of this recent layout branch
	 */
	public void setPlid(long plid);
}