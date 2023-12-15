package menu.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecommendResult {

    private HashMap<Coach, List<Menu>> results;

    public RecommendResult(HashMap<Coach, List<Menu>> results) {
        this.results = results;
    }

    public Map<Coach, List<Menu>> getResults() {
        return Collections.unmodifiableMap(results);
    }

    public boolean contains(Coach coach, Menu menu){
        return results.get(coach).contains(menu);
    }

}
