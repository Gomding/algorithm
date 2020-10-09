package Programmers;

import java.util.*;

public class MusicAlbum {

    public static void main(String[] args) {
        String[] genres1 = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays1 = {500, 600, 150, 800, 2500};

        System.out.println(Arrays.toString(solution(genres1, plays1)));

    }

    public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        int size = genres.length;

        Map<String, Integer> genreMap = new HashMap<>();
        Map<String, Integer> chkMap = new HashMap<>();
        List<Song> songList = new ArrayList<>();
        List<Integer> bestAlbum = new ArrayList<>();


        for (int i = 0; i < size; i++) {
            int idx = i;
            String genre = genres[i];
            int play = plays[i];

            songList.add(new Song(idx, genre, play));

            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        Collections.sort(songList, new Comparator<Song>() {

            @Override
            public int compare(Song o1, Song o2) {
                if (o1.genre.equals(o2.genre)) {
                    return o1.compareTo(o2);
                }else {
                    return -(genreMap.get(o1.genre) - genreMap.get(o2.genre));
                }
            }
        });

        for (Song song : songList) {
            if (!chkMap.containsKey(song.genre)) {
                chkMap.put(song.genre, 1);
                bestAlbum.add(song.idx);
            } else {
                int cnt = chkMap.get(song.genre);

                if(cnt >= 2) continue;
                else {
                    chkMap.put(song.genre, 2);
                    bestAlbum.add(song.idx);
                }
            }
        }

        int bestAlbum_size = bestAlbum.size();

        answer = new int[bestAlbum_size];

        for (int j = 0; j < bestAlbum_size; j++) {
            answer[j] = bestAlbum.get(j);
        }

        return answer;
    }

    public static class Song implements Comparable<Song> {
        int idx;
        String genre;
        int play;

        public Song(int idx, String genre, int play) {
            this.idx = idx;
            this.genre = genre;
            this.play = play;
        }


        @Override
        public int compareTo(Song o) {
            if (this.play == o.play) {
                return this.idx - o.idx;
            }else {
                return -(this.play - o.play);
            }
        }
    }

}
