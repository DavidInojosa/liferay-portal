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

package com.liferay.oauth2.provider.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.oauth2.provider.model.OAuth2Authorization;
import com.liferay.oauth2.provider.service.OAuth2AuthorizationLocalServiceUtil;

/**
 * The extended model base implementation for the OAuth2Authorization service. Represents a row in the &quot;OAuth2Authorization&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link OAuth2AuthorizationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OAuth2AuthorizationImpl
 * @see OAuth2Authorization
 * @generated
 */
@ProviderType
public abstract class OAuth2AuthorizationBaseImpl
	extends OAuth2AuthorizationModelImpl implements OAuth2Authorization {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a o auth2 authorization model instance should use the <code>OAuth2Authorization</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			OAuth2AuthorizationLocalServiceUtil.addOAuth2Authorization(this);
		}
		else {
			OAuth2AuthorizationLocalServiceUtil.updateOAuth2Authorization(this);
		}
	}
}