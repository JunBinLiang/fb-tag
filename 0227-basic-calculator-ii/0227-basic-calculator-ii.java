class Solution {
    public int calculate(String s) {
        char a[] = s.toCharArray();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < a.length; i++) {
            if(a[i] == ' ') continue;
            if(a[i] == '+' || a[i] == '-' || a[i] == '*' || a[i] == '/') {
                if(a[i] == '+') list.add(0);
                else if(a[i] == '-') list.add(1);
                else if(a[i] == '*') list.add(2);
                else list.add(3);
            } else {
                int j = i;
                int num = 0;
                while(j < a.length && isdigit(a[j])) {
                    num = num * 10 + (a[j] - '0');
                    j++;
                }
                i = j - 1;
                list.add(num);
            }
        }
        

        return dfs(list, 0, 0);
    }
    
    public boolean isdigit(char c) {
        return c - '0' >= 0 && c - '0' < 10;
    }
    
    public int dfs(List<Integer> list, int idx, int symbol) {
        if(idx == list.size() - 1) {
            if(symbol == 0) return list.get(idx);
            else return -list.get(idx);
        }
        
        if(list.get(idx + 1) == 0 || list.get(idx + 1) == 1) {
            if(symbol == 0) return list.get(idx) + dfs(list, idx + 2, list.get(idx + 1));
            else return -list.get(idx) + dfs(list, idx + 2, list.get(idx + 1));
        } else {
            int i = idx + 1;
            int v = list.get(idx);
            while(i < list.size() && (list.get(i) == 2 || list.get(i) == 3)) {
                if(list.get(i) == 2) {
                    v *= list.get(i + 1); 
                } else {
                    v /= list.get(i + 1);
                }
                i += 2;
            }
            
            int res = (symbol == 0) ? v : -v;
            if(i >= list.size()) {
                
            } else {
                if(symbol == 0) res = v + dfs(list, i + 1, list.get(i));
                else res = -v + dfs(list, i + 1, list.get(i));
            }
            return res;
        }
    } 
    
    
}