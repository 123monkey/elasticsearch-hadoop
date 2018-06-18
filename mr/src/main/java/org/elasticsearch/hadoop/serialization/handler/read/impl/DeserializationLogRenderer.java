/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.hadoop.serialization.handler.read.impl;

import org.elasticsearch.hadoop.handler.impl.LogRenderer;
import org.elasticsearch.hadoop.serialization.handler.read.DeserializationFailure;
import org.elasticsearch.hadoop.util.FastByteArrayInputStream;

public class DeserializationLogRenderer extends LogRenderer<DeserializationFailure> {
    @Override
    public String convert(DeserializationFailure entry) {
        return String.format(
                "Dropping malformed scroll search hit due to error [%s]:%nEntry Contents:%n%s",
                entry.getException().getMessage(),
                ((FastByteArrayInputStream) entry.getHitContents()).bytes().toString()
        );
    }
}
