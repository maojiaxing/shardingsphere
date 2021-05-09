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

package org.apache.shardingsphere.proxy.backend.text.sctl.hint.internal;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.shardingsphere.proxy.backend.communication.jdbc.connection.BackendConnection;
import org.apache.shardingsphere.proxy.backend.text.sctl.hint.internal.command.*;
import org.apache.shardingsphere.proxy.backend.text.sctl.hint.internal.executor.*;

/**
 * Hint command executor factory.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class HintCommandExecutorFactory {
    
    /**
     * Create hint command executor instance.
     *
     * @param hintCommand hint command
     * @param backendConnection backend connection
     * @param sql SQL
     * @return hint command executor
     */
    public static HintCommandExecutor newInstance(final HintCommand hintCommand, final BackendConnection backendConnection, final String sql) {
        if (hintCommand instanceof HintSetPrimaryOnlyCommand) {
            return new HintSetPrimaryOnlyExecutor();
        }
        if (hintCommand instanceof HintSetDatabaseShardingValueCommand) {
            return new HintSetDatabaseShardingValueExecutor();
        }
        if (hintCommand instanceof HintAddDatabaseShardingValueCommand) {
            return new HintAddDatabaseShardingValueExecutor();
        }
        if (hintCommand instanceof HintAddTableShardingValueCommand) {
            return new HintAddTableShardingValueExecutor();
        }
        if (hintCommand instanceof HintClearCommand) {
            return new HintClearExecutor();
        }
        if (hintCommand instanceof HintShowStatusCommand) {
            return new HintShowStatusExecutor();
        }
        if (hintCommand instanceof HintShowTableStatusCommand) {
            return new HintShowTableStatusExecutor(backendConnection);
        }
        if (hintCommand instanceof HintSetTransactionMetadataCommand) {
            return new HintSetTransactionMetadataExecutor();
        }
        return new HintErrorParameterExecutor(sql);
    }
}
