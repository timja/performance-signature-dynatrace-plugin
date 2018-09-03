/*
 * Copyright (c) 2014-2018 T-Systems Multimedia Solutions GmbH
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

package de.tsystems.mms.apm.performancesignature.dynatracesaas.model;

import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.List;

public class Specification {
    @SerializedName("lowerLimit")
    private Double lowerLimit;
    @SerializedName("upperLimit")
    private Double upperLimit;
    @SerializedName("timeseries")
    private List<SpecificationTM> timeseries = null;

    /**
     * No args constructor for use in serialization
     */
    public Specification() {
    }

    public Specification(Double lowerLimit, Double upperLimit, List<SpecificationTM> timeseries) {
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
        this.timeseries = timeseries;
    }

    public Double getLowerLimit() {
        if (lowerLimit == null) return 1D;
        return lowerLimit;
    }

    public void setLowerLimit(Double lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    public Double getUpperLimit() {
        if (upperLimit == null) return 4D;
        return upperLimit;
    }

    public void setUpperLimit(Double upperLimit) {
        this.upperLimit = upperLimit;
    }

    public List<SpecificationTM> getTimeseries() {
        return timeseries;
    }

    public void setTimeseries(List<SpecificationTM> timeseries) {
        this.timeseries = timeseries;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("lowerLimit", lowerLimit).append("upperLimit", upperLimit).append("timeseries", timeseries).toString();
    }
}
