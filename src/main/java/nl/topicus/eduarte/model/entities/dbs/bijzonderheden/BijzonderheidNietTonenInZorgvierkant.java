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
package nl.topicus.eduarte.model.entities.dbs.bijzonderheden;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import nl.topicus.eduarte.model.entities.dbs.NietTonenInZorgvierkant;
import nl.topicus.eduarte.model.entities.personen.Medewerker;

@Entity()
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "Instelling")
public class BijzonderheidNietTonenInZorgvierkant extends NietTonenInZorgvierkant
{
	@Basic(optional = false)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bijzonderheid", nullable = true)
	private Bijzonderheid bijzonderheid;

	public BijzonderheidNietTonenInZorgvierkant()
	{
	}

	public BijzonderheidNietTonenInZorgvierkant(Bijzonderheid bijzonderheid, Medewerker medewerker)
	{
		super(medewerker);
		setBijzonderheid(bijzonderheid);
	}

	public Bijzonderheid getBijzonderheid()
	{
		return bijzonderheid;
	}

	public void setBijzonderheid(Bijzonderheid bijzonderheid)
	{
		this.bijzonderheid = bijzonderheid;
	}
}
