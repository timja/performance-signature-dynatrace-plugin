/*
 * Copyright (c) 2014 T-Systems Multimedia Solutions GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.tsystems.mms.apm.performancesignature.dynatracesaas.rest;

import org.apache.commons.lang.StringUtils;

public class Pair {
    private String name;
    private String value;

    public Pair(String name, String value) {
        setName(name);
        setValue(value);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (StringUtils.isNotBlank(name)) {
            this.name = name;
        }
    }

    public String getValue() {
        return this.value;
    }

    private void setValue(String value) {
        if (StringUtils.isNotBlank(value)) {
            this.value = value;
        }
    }
}
