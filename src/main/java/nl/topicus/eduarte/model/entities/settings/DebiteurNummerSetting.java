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
 * Setting om per organisatie financieel-gerelateerde zaken in te stellen.
 */
@Entity()
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "Instelling")
public class DebiteurNummerSetting extends OrganisatieSetting<DebiteurNummerConfiguration> {
	@Embedded
	private DebiteurNummerConfiguration value;

	public DebiteurNummerSetting() {
		value = new DebiteurNummerConfiguration();
	}

	@Override
	public String getOmschrijving() {
		return "Nummeringsinstellingen";
	}

	@Override
	public DebiteurNummerConfiguration getValue() {
		return value;
	}

	@Override
	public void setValue(DebiteurNummerConfiguration value) {
		this.value = value;
	}
}
