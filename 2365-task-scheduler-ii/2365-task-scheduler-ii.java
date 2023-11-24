class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        long day = 0;
        Map<Integer, Long> map = new HashMap<>();
        for(int i = 0; i < tasks.length; i++) {
            if(!map.containsKey(tasks[i])) {
                day++;
                map.put(tasks[i], day);
            } else {
                long pre = map.get(tasks[i]);
                day = Math.max(day + 1, pre + space + 1);
                map.put(tasks[i], day);
            }
        }
        return day;
    }
}