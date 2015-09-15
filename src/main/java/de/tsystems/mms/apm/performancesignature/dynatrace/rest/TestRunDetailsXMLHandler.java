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

package de.tsystems.mms.apm.performancesignature.dynatrace.rest;

import de.tsystems.mms.apm.performancesignature.dynatrace.model.TestResult;
import de.tsystems.mms.apm.performancesignature.dynatrace.model.TestRun;
import de.tsystems.mms.apm.performancesignature.dynatrace.model.TestRunMeasure;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.CharArrayWriter;

/**
 * Created by rapi on 27.10.2014.
 */

public class TestRunDetailsXMLHandler extends DefaultHandler {
    private final CharArrayWriter contents = new CharArrayWriter();
    private TestRun testRun;
    private TestResult testResult;
    private TestRunMeasure measure;

    public TestRun getParsedObjects() {
        return this.testRun;
    }

    public void startElement(final String namespaceURI, final String localName, final String qName, final Attributes attr) {
        if (localName.equals("testRun")) {
            testRun = new TestRun(attr);
        } else if (localName.equals("testResult")) {
            testResult = new TestResult(attr);
        } else if (localName.equals("measure")) {
            measure = new TestRunMeasure(attr);
        }
        this.contents.reset();
    }

    public void endElement(final String uri, final String localName, final String qName) {
        if (localName.equals("testResult")) {
            testRun.addTestResults(testResult);
        } else if (localName.equals("measure")) {
            testResult.addTestRunMeasure(measure);
        }
    }

    public void characters(final char[] ch, final int start, final int length) throws SAXException {
        this.contents.write(ch, start, length);
    }
}
