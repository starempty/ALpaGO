import java.util.;
class Solution {
    public int[] solution(String[] info, String[] query) {
        MapString, ListInteger hm = new HashMapString, ListInteger();
        int[][][][] set = new int[4][3][3][3];
        String[] tmp = new String[4];
        for(String inf  info){
            StringTokenizer st = new StringTokenizer(inf);
            for(int i = 0; i  4; i++){
                tmp[i] = st.nextToken();
            }
            int score = Integer.parseInt(st.nextToken());
            for(int bit = 0; bit = 15; bit++){
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i  4; i++){
                    if((bit & (1i))  0){
                        sb.append(-);
                    }else{
                        sb.append(tmp[i]);
                    }
                }
                String key = sb.toString();
                if(!hm.containsKey(key)){
                    hm.put(key, new ArrayListInteger());
                }
                hm.get(key).add(score);
                Collections.sort(hm.get(key));
            }
        }
        int[] answer = new int[query.length];
        int idx = 0;
        for(String q  query){
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(q);
            for(int i = 0; i  3; i++){
                sb.append(st.nextToken());
                st.nextToken();
            }
            sb.append(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            String key = sb.toString();
            System.out.println(key);
            ListInteger list = hm.get(key);
            int l = 0, r = list.size();
            int m = (l+r)2;
            while(l  r){
                 if(list.get(m)  score){
                     l = m+1;
                 }else{
                     r = m-1; 
                 }
                 ==이 제일 근접
                if(list.get(m) = score){
                    r = m;
                }else{
                    l = m+1;
                }
                 =이 제일 근접, +1
                
                m = (l+r)2;
            }
            answer[idx++] = list.size()-l;
        }
        
        return answer;
    }
}