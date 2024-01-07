/*
 * Copyright 2022 Topicus Onderwijs Eduarte B.V..
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package nl.topicus.eduarte.model.entities.settings;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Houdt per organisatie bij of er gebruik gemaakt wordt van de lokale Vasco
 * token server, en waar je die kan vinden.
 */
@Entity()
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "Instelling")
public class VascoTokensSetting extends OrganisatieSetting<VascoTokensConfiguration> {
	@Embedded
	private VascoTokensConfiguration value;

	public VascoTokensSetting() {
		value = new VascoTokensConfiguration();
	}

	@Override
	public String getOmschrijving() {
		return "Vasco tokens";
	}

	@Override
	public VascoTokensConfiguration getValue() {
		return value;
	}

	@Override
	public void setValue(VascoTokensConfiguration value) {
		this.value = value;
	}
}
