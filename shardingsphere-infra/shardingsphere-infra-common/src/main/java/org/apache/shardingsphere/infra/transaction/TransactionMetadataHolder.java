/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.infra.transaction;

import com.google.common.collect.Maps;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * Transaction metadata holder.
 *
 * <p>Manage transaction's metadata in current thread.</p>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TransactionMetadataHolder {

    private static final ThreadLocal<Map<String, String>> TRANSACTION_METADATA = ThreadLocal.withInitial(Maps::newConcurrentMap);

    /**
     * Get transaction metadata by key in current thread.
     *
     * @param key metadata key.
     * @return metadata value.
     */
    public static String getMetadata(final String key) {
        return TRANSACTION_METADATA.get().get(key);
    }

    /**
     * Set transaction metadata in current thread.
     *
     * @param key metadata key.
     * @param value metadata value.
     */
    public static void setMetadata(final String key, final String value) {
        TRANSACTION_METADATA.get().put(key, value);
    }

    /**
     * Cleanup transaction metadata.
     */
    public static void clear() {
        TRANSACTION_METADATA.remove();
    }
}
