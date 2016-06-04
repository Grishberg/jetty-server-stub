package services;

import java.rmi.server.UID;
import java.util.Calendar;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by g on 03.06.16.
 */
public class AccountSercviceImpl implements AccountService {
    public static final int TOKEN_DURATION = 3000;
    private Map<String, Long> tokens;

    public AccountSercviceImpl() {
        this.tokens = new ConcurrentHashMap<>();
    }

    @Override
    public String auth(String login, String password) {
        String newToken = UUID.randomUUID().toString();
        tokens.put(newToken, Calendar.getInstance().getTimeInMillis() + TOKEN_DURATION);
        return newToken;
    }

    @Override
    public boolean checkToken(String accessToken) {
        Long tokenTimeStamp = tokens.get(accessToken);
        if (tokenTimeStamp == null) {
            return false;
        }
        return tokenTimeStamp < Calendar.getInstance().getTimeInMillis();
    }
}

