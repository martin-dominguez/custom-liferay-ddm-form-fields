package com.liferay.lfrsales.dynamic.data.mapping.form.field.type.userdata.field;

import com.liferay.dynamic.data.mapping.annotations.DDMForm;
import com.liferay.dynamic.data.mapping.annotations.DDMFormField;
import com.liferay.dynamic.data.mapping.annotations.DDMFormLayout;
import com.liferay.dynamic.data.mapping.annotations.DDMFormLayoutColumn;
import com.liferay.dynamic.data.mapping.annotations.DDMFormLayoutPage;
import com.liferay.dynamic.data.mapping.annotations.DDMFormLayoutRow;
import com.liferay.dynamic.data.mapping.annotations.DDMFormRule;
import com.liferay.dynamic.data.mapping.form.field.type.DefaultDDMFormFieldTypeSettings;
import com.liferay.dynamic.data.mapping.model.DDMFormFieldValidation;

@DDMForm(
	rules = {
		@DDMFormRule(
			actions = {
				"setVisible('repeatable', TRUE)",
				"setVisible('required', TRUE)", 
				"setVisible('showLabel', TRUE)",
				"setVisible('validation', TRUE)"
			},
			condition = "equals(getValue('hideField'), FALSE)"
		),
		@DDMFormRule(
			actions = {
				"setValue('repeatable', FALSE)",
				"setValue('required', FALSE)", 
				"setValue('showLabel', TRUE)",
				"setVisible('repeatable', FALSE)",
				"setVisible('required', FALSE)",
				"setVisible('showLabel', FALSE)",
				"setVisible('validation', FALSE)"
			},
			condition = "equals(getValue('hideField'), TRUE)"
		),
		@DDMFormRule(
			actions = {
				"setValidationDataType('validation', getValue('dataType'))",
				"setValidationFieldName('validation', getValue('name'))"
			},
			condition = "TRUE"
		)
	}
)
@DDMFormLayout(
	paginationMode = com.liferay.dynamic.data.mapping.model.DDMFormLayout.TABBED_MODE,
	value = {
		@DDMFormLayoutPage(
			title = "%basic",
			value = {
				@DDMFormLayoutRow(
					{
						@DDMFormLayoutColumn(
							size = 12,
							value = {
								"label", "userDataField", "required", "tip"
							}
						)
					}
				)
			}
		),
		@DDMFormLayoutPage(
			title = "%advanced",
			value = {
				@DDMFormLayoutRow(
					{
						@DDMFormLayoutColumn(
							size = 12,
							value = {
								"dataType", "name", 
								"hideField", "repeatable",
								"showLabel", "type", 
								"validation", "visibilityExpression" 
							}
						)
					}
				)
			}
		)
	}
)
public interface UserDataFieldDDMFormFieldTypeSettings extends DefaultDDMFormFieldTypeSettings {

	@DDMFormField(
		label = "%user-data-field",
		optionLabels = {
			"%full-name", "%first-name", "%middle-name", "%last-name",
			"%birthday", "%job-title", "%email", "%phone", "%address",
			"%street1", "%street2", "%street3", "%city", "%country-code",
			"%country-name", "%region-code", "%region-code", "%postal-code"
		},
		optionValues = {
			"getFullName", "getFirstName", "getMiddleName", "getLastName",
			"getDateOfBirth", "getJobTitle", "getEmailAddress", "getPhones",
			"getAddresses", "getStreet1", "getStreet2", "getStreet3", "getCity",
			"getCountryId", "getCountryName", "getRegionId", "getRegionCode",
			"getPostalCode"
		},
		predefinedValue = "full-name", required = true, type = "select"
	)
	public String userDataField();
	
	@DDMFormField(
		label = "%hide-field",
		properties = {
			"showAsSwitcher=true",
			"tooltip=%the-user-filling-the-form-will-not-be-able-to-see-this-field"
		}
	)
	public boolean hideField();
	
	@DDMFormField(
		dataType = "string", label = "%validation", type = "validation"
	)
	@Override
	public DDMFormFieldValidation validation();

}
