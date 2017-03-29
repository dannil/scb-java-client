/*
 * Copyright 2016 Daniel Nilsson
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under
 * the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.github.dannil.scbjavaclient.format.json;

/**
 * <p>Interface for JSON response format. All implementing classes should specify an
 * instance variable which contains the JSON which should be operated on by the
 * methods.</p>
 *
 * @deprecated This interface did not serve a useful purpose. No replacement exists.
 *
 * @since 0.1.0
 */
@Deprecated
public interface IJsonResponseFormat {

    /**
     * <p>Checks if the JSON is formatted as the specified format.</p>
     *
     * @deprecated This method put too much of a constraint on the implementing class. No
     *             replacement exists.
     *
     * @return true if the JSON is formatted as the implementing format
     */
    @Deprecated
    boolean isFormatted();

}
