/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 */

import ClayButton from '@clayui/button';
import ClayIcon from '@clayui/icon';
import DropDownWithSearch, {
	getTranslatedName,
} from 'app-builder-web/js/pages/apps/DropDownWithSearch.es';
import {getItem} from 'app-builder-web/js/utils/client.es';
import React, {useEffect, useRef, useState} from 'react';

const SelectDropdown = ({
	ariaLabelId,
	defaultValue,
	emptyResultMessage,
	endpoint,
	label,
	onSelect,
	selectedValue,
	stateProps,
}) => {
	const [fetchState, setFetchState] = useState({isLoading: true});
	const [items, setItems] = useState([]);

	const selectRef = useRef();

	const doFetch = () => {
		const params = {keywords: '', page: -1, pageSize: -1, sort: ''};

		setFetchState({
			hasError: null,
			isLoading: true,
		});

		getItem(endpoint, params)
			.then((data) => {
				setItems(data.items);
				setFetchState({
					hasError: null,
					isLoading: false,
				});

				if (defaultValue) {
					const defaultItem = data.items.find(
						({id}) => id === defaultValue
					);

					if (defaultItem) {
						onSelect({
							...defaultItem,
							name: getTranslatedName(defaultItem),
						});
					}
				}
			})
			.catch((hasError) => {
				setFetchState({
					hasError,
					isLoading: false,
				});
			});
	};

	useEffect(() => {
		doFetch();
		// eslint-disable-next-line react-hooks/exhaustive-deps
	}, []);

	return (
		<>
			<DropDownWithSearch
				{...fetchState}
				isEmpty={items.length === 0}
				label={label}
				stateProps={stateProps}
				trigger={
					<ClayButton
						aria-labelledby={ariaLabelId}
						className="clearfix w-100"
						displayType="secondary"
						ref={(element) => {
							selectRef.current = element;
						}}
					>
						<span className="float-left">
							{selectedValue || label}
						</span>

						<ClayIcon
							className="dropdown-button-asset float-right"
							symbol="caret-bottom"
						/>
					</ClayButton>
				}
			>
				<DropDownWithSearch.Items
					emptyResultMessage={emptyResultMessage}
					items={items}
					onSelect={onSelect}
				/>
			</DropDownWithSearch>
		</>
	);
};

const SelectFormView = ({objectId, ...otherProps}) => {
	const props = {
		emptyResultMessage: Liferay.Language.get(
			'no-form-views-found-with-this-name-try-searching-again-with-a-different-name'
		),
		endpoint: `/o/data-engine/v2.0/data-definitions/${objectId}/data-layouts`,
		label: Liferay.Language.get('select-form-view'),
		stateProps: {
			emptyProps: {
				label: Liferay.Language.get('there-are-no-form-views-yet'),
			},
			errorProps: {
				label: Liferay.Language.get('failed-to-retrieve-form-views'),
			},
			loadingProps: {
				label: Liferay.Language.get('retrieving-all-form-views'),
			},
		},
		...otherProps,
	};

	return <SelectDropdown {...props} />;
};

const SelectTableView = ({objectId, ...otherProps}) => {
	const props = {
		emptyResultMessage: Liferay.Language.get(
			'no-table-views-found-with-this-name-try-searching-again-with-a-different-name'
		),
		endpoint: `/o/data-engine/v2.0/data-definitions/${objectId}/data-list-views`,
		label: Liferay.Language.get('select-table-view'),
		stateProps: {
			emptyProps: {
				label: Liferay.Language.get('there-are-no-table-views-yet'),
			},
			errorProps: {
				label: Liferay.Language.get('failed-to-retrieve-table-views'),
			},
			loadingProps: {
				label: Liferay.Language.get('retrieving-all-table-views'),
			},
		},
		...otherProps,
	};

	return <SelectDropdown {...props} />;
};

export {SelectFormView, SelectTableView};
export default SelectDropdown;
