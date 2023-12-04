class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        return dfs(expression, 0, expression.length() - 1);
    }
    
    public List<Integer> dfs(String s, int l, int r) {
        List<Integer> list = new ArrayList<>();
        for(int i = l; i <= r; i++) {
            char c = s.charAt(i);
            if(c == '+' || c == '-' || c == '*') {
                List<Integer> left = dfs(s, l, i - 1);
                List<Integer> right = dfs(s, i + 1, r);
                for(int x : left) {
                    for(int y : right) {
                        if(c == '-') {
                            list.add(x - y);
                        }
                        if(c == '+') {
                            list.add(x + y);
                        }
                        if(c == '*') {
                            list.add(x * y);
                        }
                    }
                }
            }
        }
        if(list.size() == 0) {
            list.add(Integer.parseInt(s.substring(l, r + 1)));
        }
        return list;
    }
}