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
package nl.topicus.eduarte.model.entities.onderwijsproduct;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.UniqueConstraint;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import nl.topicus.eduarte.model.entities.organisatie.InstellingEntiteit;

/**
 * Koppeltabel tussen onderwijsproduct en verbruiksmiddel
 * 
 */
@Entity()
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "Instelling")
@jakarta.persistence.Table(name = "OndProdVerbruiksmiddel", uniqueConstraints = {@UniqueConstraint(columnNames = {
	"onderwijsproduct", "verbruiksmiddel"})})
public class OnderwijsproductVerbruiksmiddel extends InstellingEntiteit
{
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false, name = "onderwijsproduct")
	private Onderwijsproduct onderwijsproduct;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false, name = "verbruiksmiddel")
	private Verbruiksmiddel verbruiksmiddel;

	/**
	 * Optioneel het aantal van het gebruiksmiddel dat benodigd is.
	 */
	@Column(nullable = true)
	private Integer aantal;

	public OnderwijsproductVerbruiksmiddel()
	{
	}

	public Onderwijsproduct getOnderwijsproduct()
	{
		return onderwijsproduct;
	}

	public void setOnderwijsproduct(Onderwijsproduct onderwijsproduct)
	{
		this.onderwijsproduct = onderwijsproduct;
	}

	public Integer getAantal()
	{
		return aantal;
	}

	public void setAantal(Integer aantal)
	{
		this.aantal = aantal;
	}

	public Verbruiksmiddel getVerbruiksmiddel()
	{
		return verbruiksmiddel;
	}

	public void setVerbruiksmiddel(Verbruiksmiddel verbruiksmiddel)
	{
		this.verbruiksmiddel = verbruiksmiddel;
	}

}
