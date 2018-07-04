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

package de.tsystems.mms.apm.performancesignature.dynatracesaas;

import de.tsystems.mms.apm.performancesignature.dynatracesaas.model.DynatraceServerConfiguration;
import hudson.Extension;
import jenkins.model.GlobalConfiguration;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.StaplerRequest;

import java.util.ArrayList;
import java.util.List;

@Extension
public class DynatraceGlobalConfiguration extends GlobalConfiguration {
    private List<DynatraceServerConfiguration> configurations = new ArrayList<>();

    public DynatraceGlobalConfiguration() {
        load();
    }

    public static DynatraceGlobalConfiguration get() {
        return GlobalConfiguration.all().get(DynatraceGlobalConfiguration.class);
    }

    @Override
    public boolean configure(final StaplerRequest req, final JSONObject formData) {
        setConfigurations(req.bindJSONToList(DynatraceServerConfiguration.class, formData.get("configurations")));
        save();
        return false;
    }

    public List<DynatraceServerConfiguration> getConfigurations() {
        return configurations;
    }

    public void setConfigurations(final List<DynatraceServerConfiguration> configurations) {
        this.configurations = configurations;
    }
}
