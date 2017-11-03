package net.samhouse;

import org.apache.commons.lang3.StringUtils;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicLong;

public class UniqueID {
    private static final String _DELIMITER = ":";
    private static final String _process_prefix;

    static {
        String hexIp = "";
        try {
            String ip = Inet4Address.getLocalHost().getHostAddress();
            if (StringUtils.isNotBlank(ip)) {
                for (String part : ip.split("\\.")) {
                    hexIp += String.format("%02x", Integer.parseInt(part));
                }
            }
        }
        catch (UnknownHostException e) {
            System.out.println("Got unknown host exception: " + e.getMessage());
        }
        _process_prefix = hexIp + _DELIMITER +
                Long.toHexString(System.currentTimeMillis()) + _DELIMITER;
    }

    private UniqueID() {
    }

    private static AtomicLong _nextThreadId = new AtomicLong(0);

    private static final ThreadLocal<String> _thread_prefix = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return _process_prefix + Long.toHexString(_nextThreadId.getAndIncrement())
                    + _DELIMITER;
        }
    };

    private static final ThreadLocal<Long> _counter = new ThreadLocal<Long>() {
        @Override
        protected Long initialValue() {
            return 0L;
        }
    };

    public static String getNewId() {
        long oldCounter = _counter.get();
        _counter.set(oldCounter + 1);

        String newID = _thread_prefix.get() + Long.toHexString(oldCounter);
        return newID;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            String id = getNewId();
            System.out.println("request id is: " + id);
        }
    }
}
