package org.apache.shardingsphere.proxy.backend.text.sctl.hint.internal.executor;

import org.apache.shardingsphere.infra.transaction.TransactionMetadataHolder;
import org.apache.shardingsphere.proxy.backend.response.header.ResponseHeader;
import org.apache.shardingsphere.proxy.backend.response.header.update.UpdateResponseHeader;
import org.apache.shardingsphere.proxy.backend.text.sctl.hint.internal.command.HintSetTransactionMetadataCommand;

/**
 * Hint set transaction metadata for table command executor.
 */
public class HintSetTransactionMetadataExecutor extends AbstractHintUpdateExecutor<HintSetTransactionMetadataCommand> {

    @Override
    public ResponseHeader execute(HintSetTransactionMetadataCommand command) {
        TransactionMetadataHolder.setMetadata(command.getMetadataKey(), command.getMetadataValue());
        return new UpdateResponseHeader(null);
    }
}
