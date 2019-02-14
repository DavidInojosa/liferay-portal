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

package com.liferay.knowledge.base.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedGroupedModel;

import java.util.Date;

/**
 * The base model interface for the KBTemplate service. Represents a row in the &quot;KBTemplate&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.knowledge.base.model.impl.KBTemplateModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.knowledge.base.model.impl.KBTemplateImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KBTemplate
 * @generated
 */
@ProviderType
public interface KBTemplateModel extends BaseModel<KBTemplate>, ShardedModel,
	StagedGroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a kb template model instance should use the {@link KBTemplate} interface instead.
	 */

	/**
	 * Returns the primary key of this kb template.
	 *
	 * @return the primary key of this kb template
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this kb template.
	 *
	 * @param primaryKey the primary key of this kb template
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this kb template.
	 *
	 * @return the uuid of this kb template
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this kb template.
	 *
	 * @param uuid the uuid of this kb template
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the kb template ID of this kb template.
	 *
	 * @return the kb template ID of this kb template
	 */
	public long getKbTemplateId();

	/**
	 * Sets the kb template ID of this kb template.
	 *
	 * @param kbTemplateId the kb template ID of this kb template
	 */
	public void setKbTemplateId(long kbTemplateId);

	/**
	 * Returns the group ID of this kb template.
	 *
	 * @return the group ID of this kb template
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this kb template.
	 *
	 * @param groupId the group ID of this kb template
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this kb template.
	 *
	 * @return the company ID of this kb template
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this kb template.
	 *
	 * @param companyId the company ID of this kb template
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this kb template.
	 *
	 * @return the user ID of this kb template
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this kb template.
	 *
	 * @param userId the user ID of this kb template
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this kb template.
	 *
	 * @return the user uuid of this kb template
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this kb template.
	 *
	 * @param userUuid the user uuid of this kb template
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this kb template.
	 *
	 * @return the user name of this kb template
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this kb template.
	 *
	 * @param userName the user name of this kb template
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this kb template.
	 *
	 * @return the create date of this kb template
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this kb template.
	 *
	 * @param createDate the create date of this kb template
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this kb template.
	 *
	 * @return the modified date of this kb template
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this kb template.
	 *
	 * @param modifiedDate the modified date of this kb template
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the title of this kb template.
	 *
	 * @return the title of this kb template
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this kb template.
	 *
	 * @param title the title of this kb template
	 */
	public void setTitle(String title);

	/**
	 * Returns the content of this kb template.
	 *
	 * @return the content of this kb template
	 */
	@AutoEscape
	public String getContent();

	/**
	 * Sets the content of this kb template.
	 *
	 * @param content the content of this kb template
	 */
	public void setContent(String content);

	/**
	 * Returns the last publish date of this kb template.
	 *
	 * @return the last publish date of this kb template
	 */
	@Override
	public Date getLastPublishDate();

	/**
	 * Sets the last publish date of this kb template.
	 *
	 * @param lastPublishDate the last publish date of this kb template
	 */
	@Override
	public void setLastPublishDate(Date lastPublishDate);
}