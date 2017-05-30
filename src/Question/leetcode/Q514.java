package Question.leetcode;

import java.util.HashMap;

/**
 * Created by gump on 2017/5/29.
 */
public class Q514 {

    class Distance{
        Character start;
        Character end;

        public Distance(Character start, Character end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Distance distance = (Distance) o;

            if (start != null ? !start.equals(distance.start) : distance.start != null) return false;
            return end != null ? end.equals(distance.end) : distance.end == null;
        }

        @Override
        public int hashCode() {
            int result = start != null ? start.hashCode() : 0;
            result = 31 * result + (end != null ? end.hashCode() : 0);
            return result;
        }
    }

    public int findRotateSteps(String ring, String key) {
        return dfs(ring,key,0,ring.charAt(0),new HashMap<>());
    }

    private int dfs(String ring, String key, int i, char c, HashMap<Distance, Integer> map) {
        if (i>=ring.length()) return 0;

        Distance d = new Distance(ring.charAt(i),c);
        if (map.containsKey(d)) return map.get(d);

        int result = 1;
        int left = 0 ,right = 0;

        for (int j = i; j < ring.length(); j++) {
            if (ring.charAt(j) == c){
                left = j-i;
            }
        }


        map.put(d,Math.min(left,right));

        if (i<ring.length()-1){
            return result + dfs(ring,key,i+1,ring.charAt(i+1),map);
        }else{
            return result;
        }
    }
}
