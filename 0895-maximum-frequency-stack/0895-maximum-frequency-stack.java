class FreqStack {
    Map<Integer, Integer> map;
    List<Stack<Integer>> stks;
    int index = 0;
    public FreqStack() {
        map = new HashMap<>();
        stks = new ArrayList<>();
        stks.add(new Stack<>());
    }
    
    public void push(int val) {
        if(map.containsKey(val)) {
            int cnt = map.get(val);
            while(stks.size() <= cnt + 1) stks.add(new Stack<>());
            map.put(val, cnt + 1);
            stks.get(cnt + 1).push(val);
            index = Math.max(index, cnt + 1);
        } else {
            if(stks.size() == 1) {
                stks.add(new Stack<>());
            }
            map.put(val, 1);
            stks.get(1).push(val);
            index = Math.max(index, 1);
        }
    }
    
    public int pop() {
        int res = 0;
        while(true) {
            Stack<Integer> stk = stks.get(index);
            if(stk.size() == 0) index--;
            else {
                int val = stk.pop();
                res = val;
                int cnt = map.get(val);
                if(cnt == 1) {
                    map.remove(val);
                } else {
                    map.put(val, cnt - 1);
                }
                break;
            }
        }   
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */