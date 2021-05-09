package org.apache.shardingsphere.proxy.backend.text.sctl.hint.internal.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.shardingsphere.proxy.backend.text.sctl.hint.internal.HintCommand;

/**
 * Hint add transaction metadata for database command.
 *
 * <p>
 * example: sctl:hint SetTransactionMetadata xx=yy.
 * xx: metadata key.
 * yy: metadata value.
 * </p>
 */
@Getter
@AllArgsConstructor
public class HintSetTransactionMetadataCommand implements HintCommand {

    private final String metadataKey;

    private final String metadataValue;
}
