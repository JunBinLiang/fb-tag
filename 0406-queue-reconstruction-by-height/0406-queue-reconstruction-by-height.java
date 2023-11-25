class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (x, y) -> {
            if(x[0] == y[0]) {
                return x[1] - y[1];
            }
            return y[0] - x[0];
        });
        
        List<int[]> res = new ArrayList<>();
        for(int i = 0; i < people.length; i++) {
            int j = i;
            while(j < people.length && people[i][0] == people[j][0]) {
                res.add(people[j][1], people[j]);
                j++;
            }
            i = j - 1;
        }
        
        
        for(int i = 0; i < people.length; i++) {
            people[i] = res.get(i);
        }
        return people;
    }
}