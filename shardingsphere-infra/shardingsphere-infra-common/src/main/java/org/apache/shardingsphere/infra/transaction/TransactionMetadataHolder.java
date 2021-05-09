package org.apache.shardingsphere.infra.transaction;

import com.google.common.collect.Maps;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * Transaction metadata holder
 *
 * <p>transaction's metadata in current thread.</p>
 * @author maojiaxing 2021/5/9
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TransactionMetadataHolder {

    private static final ThreadLocal<Map<String, String>> TRANSACTION_METADATA = ThreadLocal.withInitial(Maps::newConcurrentMap);

    public static String getMetadata(String key) {
        return TRANSACTION_METADATA.get().get(key);
    }

    public static void setMetadata(String key, String value) {
        TRANSACTION_METADATA.get().put(key, value);
    }

    public static void clear() {
        TRANSACTION_METADATA.remove();
    }
}
