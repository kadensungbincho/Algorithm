package com.company;

import java.util.*;

import static java.util.stream.Collectors.toMap;

public class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> playsPerGenres = new HashMap<>();
        HashMap<String, int[][]> top2InEachGenres = new HashMap<>();
        for(int i=0; i<genres.length; i++) {
            playsPerGenres.put(genres[i], playsPerGenres.getOrDefault(genres[i], 0) + plays[i]);
            if(!top2InEachGenres.containsKey(genres[i])) {
                top2InEachGenres.put(genres[i], new int[][] {{i, plays[i]}, {-1, 0}});
            } else {
                if(top2InEachGenres.get(genres[i])[0][1] < plays[i]) {
                    top2InEachGenres.get(genres[i])[1] = top2InEachGenres.get(genres[i])[0];
                    top2InEachGenres.get(genres[i])[0] = new int[] {i, plays[i]};
                } else if(top2InEachGenres.get(genres[i])[1][1] < plays[i]) {
                    top2InEachGenres.get(genres[i])[1] = new int[] {i, plays[i]};
                }
            }
        }
        Map<String, Integer> sorted = playsPerGenres.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));
        for(String genre : sorted.keySet()) {
            for(int[] music : top2InEachGenres.get(genre)) {
                if (music[0] >= 0) {
                    answer.add(music[0]);
                }
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
