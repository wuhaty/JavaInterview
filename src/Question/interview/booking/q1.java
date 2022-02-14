package Question.interview.booking;

import java.util.*;

public class q1 {

    static class HotelWithId{
        int hotelId;
        int score;

        public HotelWithId(int h,int s){
            this.hotelId = h;
            this.score = s;
        }
    }

    public static List<Integer> awardTopKHotels(String positiveKeywords, String negativeKeywords, List<Integer> hotelIds, List<String> reviews, int k) {
        // Write your code here
        List<Integer> res = new ArrayList<>(k);
        Set<String> posWord = new HashSet<>();
        Set<String> negWord = new HashSet<>();

        for (String s : positiveKeywords.split(" ")) {
            posWord.add(s.toLowerCase());
        }

        for (String s : negativeKeywords.split(" ")) {
            negWord.add(s.toLowerCase());
        }

        Map<Integer,HotelWithId> m = new HashMap<>();
        PriorityQueue<HotelWithId> q = new PriorityQueue<>((h1,h2) ->
                h1.score == h2.score? h2.hotelId - h1.hotelId: h1.score - h2.score);

        Iterator<Integer> idItor = hotelIds.iterator();
        Iterator<String> reviewItor = reviews.iterator();

        while (idItor.hasNext() && reviewItor.hasNext()){
            int hotelId = idItor.next();
            String review = reviewItor.next();
            review = review.replaceAll(",.", "").toLowerCase();
            HotelWithId hId = m.getOrDefault(hotelId, new HotelWithId(hotelId,0));

            for (String s:review.split(" ")) {
                if (posWord.contains(s)){
                    hId.score += 3;
                }else if(negWord.contains(s)){
                    hId.score -= 1;
                }
            }

            m.put(hotelId, hId);
        }

        for (HotelWithId hotelWithId : m.values()) {
            if(q.size() < k){
                q.offer(hotelWithId);
            }else{
                if(hotelWithId.score < q.peek().score) continue;
                q.poll();
                q.offer(hotelWithId);
            }
        }

        while(!q.isEmpty()){
            res.add(0, q.poll().hotelId);
        }

        return res;
    }
}
