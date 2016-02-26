/*
 * Copyright 2016 Daniel Nilsson
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.dannil.scbjavaclient.model;

import java.util.Objects;

public class AbstractModel<Y> {

	protected Y value;

	protected AbstractModel() {
		// To enable derived classes to use their default constructor
	}

	protected AbstractModel(Y value) {
		this.value = value;
	}

	public Y getValue() {
		return this.value;
	}

	public void setValue(Y value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof AbstractModel<?>)) {
			return false;
		}

		AbstractModel<?> other = (AbstractModel<?>) obj;
		return Objects.equals(this.value, other.value);
	}

}
