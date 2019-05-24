package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author heebg
 * @version 1.0 2019-05-18
 */
class LadderResultTest {
    Players players;
    Items items;
    LineResult lineResult;
    LadderResult ladderResult;
    Map<Player, Item> result;

    @BeforeEach
    void setUp() {
        players = Players.newInstance("pobi, hello, mynam, is");
        items = Items.newInstance("pass, 1000, 2000, star",players.size());
        lineResult = LineResult.newInstance(Arrays.asList(3,2,0,1));

        ladderResult = LadderResult.newInstance(players, items, lineResult);
        result = new HashMap<>();
        result.put(Player.newInstance("pobi"), Item.newInstance("star"));
        result.put(Player.newInstance("hello"), Item.newInstance("2000"));
        result.put(Player.newInstance("mynam"), Item.newInstance("pass"));
        result.put(Player.newInstance("is"), Item.newInstance("1000"));
    }

    @Test
    void newBuild() {
        assertThat(ladderResult.getResult()).isEqualTo(result);
    }

    @Test
    void 이름_가져오기() {
        assertThat(ladderResult.findMatchItem("pobi")).isEqualTo("star");
    }

    @Test
    void 이름_전부_가져오기() {
        StringBuilder sb = new StringBuilder();
        sb.append("pobi : star\n");
        sb.append("hello : 2000\n");
        sb.append("mynam : pass\n");
        sb.append("is : 1000");
        assertThat(ladderResult.findMatchItem("all")).isEqualTo(sb.toString());
    }
}