package ladder.domain.player;

import ladder.domain.exception.PlayerNameLengthException;

public class Player {

    private static final int MINIMUM_NAME_LENGTH = 1;
    private static final int MAXIMUM_NAME_LENGTH = 5;

    private final String name;

    public Player(final String name) {
        validatePlayerName(name);
        this.name = name;
    }

    private void validatePlayerName(final String name) {
        if (name.length() < MINIMUM_NAME_LENGTH || name.length() > MAXIMUM_NAME_LENGTH) {
            throw new PlayerNameLengthException();
        }
    }

    public String getName() {
        return name;
    }
}
